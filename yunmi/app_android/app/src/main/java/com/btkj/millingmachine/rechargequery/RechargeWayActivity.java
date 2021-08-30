package com.btkj.millingmachine.rechargequery;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import com.btkj.millingmachine.R;
import com.btkj.millingmachine.databinding.ActivityRechargeWayBinding;
import com.btkj.millingmachine.homepage.BaseActivity;
import com.btkj.millingmachine.model.aliwxpay.AliWxPayModel;
import com.btkj.millingmachine.model.config.Config;
import com.btkj.millingmachine.model.config.ConfigModel;
import com.btkj.millingmachine.model.vippay.VipPayModel;
import com.btkj.millingmachine.network.GsonUtils;
import com.btkj.millingmachine.network.Customize;
import com.btkj.millingmachine.util.API;
import com.btkj.millingmachine.util.SoundPlayUtils;
import com.btkj.millingmachine.util.TimeFinishInterface;
import com.btkj.millingmachine.util.Utils;
import com.btkj.millingmachine.viewutils.QRCodeUtil;
import com.btkj.millingmachine.viewutils.SharePref;
import com.btkj.millingmachine.viewutils.TimeCount;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import org.apache.http.Header;
import java.util.HashMap;
import java.util.Map;
/**
 * created by xuedi on 2019/5/4
 */
public class RechargeWayActivity extends BaseActivity implements View.OnClickListener, TimeFinishInterface {
    private ActivityRechargeWayBinding binding;
    private String phone, money, carid, code;
    private boolean isCard;
    private TimeCount timeCount;
    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recharge_way);
        money = getIntent().getStringExtra("money");
        carid = getIntent().getStringExtra("carid");
        isCard = getIntent().getBooleanExtra("isCard", false);
        phone = getIntent().getStringExtra("phone");
        code = getIntent().getStringExtra("code");
        binding.bottomBack.imgBack.setOnClickListener(this);
        loadQrcode(1);
        loadQrcode(0);
        SoundPlayUtils.play(2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        timeCount = new TimeCount(60000, 1000, binding.includeHeader.tvTime, this);
        timeCount.start();
    }

    //加载支付宝二维码
    private void loadQrcode(final int type) {
        /**
         mode[string]	是	充值模式，卡片0，手机号1
         type[string]	是	充值方式，微信0，支付宝1
         deviceId[int]	是	设备id
         amount[int]	是	分
         icCardChipId[string]		mode=0必填
         phone[string]		mode=1必填
         */
        String url = API.BASE_URL + API.RECHARGE;
        RequestParams requestParams = new RequestParams();
        Map<String, String> map = new HashMap<>();
        if (isCard) {
            map.put("mode", String.valueOf(0));
            map.put("icCardChipId", carid);
        } else {
            map.put("mode", String.valueOf(1));
            map.put("phone", phone);
            map.put("code", code);
        }
        map.put("deviceId", String.valueOf(SharePref.get(this, "id", 0)));
        map.put("type", String.valueOf(type));
        map.put("amount", String.valueOf(Integer.parseInt(money)*100));
        requestParams.add(Customize.SIGN, Customize.getRequestParams(map, requestParams));
        AsyncHttpClient httpClient = new AsyncHttpClient();
        PersistentCookieStore cookieStore = new PersistentCookieStore(this);
        httpClient.setCookieStore(cookieStore);
        Utils.log(url + "\n" + requestParams);
        httpClient.post(url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody);
                Utils.log(json);
                AliWxPayModel aliWxPayModel = GsonUtils.getInstance().fromJson(json, AliWxPayModel.class);
                if (aliWxPayModel.isSuccess()) {
                    refreshQRCode(aliWxPayModel.getData().getBody(), type, aliWxPayModel.getData().getSerialNo());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                Utils.toast(RechargeWayActivity.this, "网络请求异常");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }
    }

    private String serialAli;
    private String serialWxi;
    private Runnable alipayrunnable = new Runnable() {
        @Override
        public void run() {
            cycleAliPayRequest(serialAli);
        }
    };
    private Runnable wxpayrunnable = new Runnable() {
        @Override
        public void run() {
            cycleWxiPayRequest(serialWxi);
        }
    };

    private void refreshQRCode(String str, int type, String serialNo) {
        if (str == null || str.isEmpty()) {
            Toast.makeText(getApplicationContext(), "二维码内容为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        Bitmap image = QRCodeUtil.qrCodeImageWithStr(str);
        if (image != null) {
            switch (type) {
                case 1:
                    binding.imgAli.setImageBitmap(image);
                    cycleAliPayRequest(serialNo);
                    break;
                case 0:
                    binding.imgWx.setImageBitmap(image);
                    cycleWxiPayRequest(serialNo);
                    break;
                default:
                    break;
            }
        }
    }

    private Handler handler = new Handler();

    //微信订单查询
    private void cycleWxiPayRequest(final String serialNo) {
        String url = API.BASE_URL + API.SERINO_REQUEST;
        RequestParams requestParams = new RequestParams();
        Map<String, String> map = new HashMap<>();
        /**
         * type[short]	是	0消费，1充值
         * deviceId[int]	是	设备id
         * serialNo[string]	是	充值或消费流水号
         */
        map.put("type", "1");
        map.put("deviceId", String.valueOf(SharePref.get(RechargeWayActivity.this, "id", 0)));
        map.put("serialNo", serialNo);
        requestParams.add(Customize.SIGN, Customize.getRequestParams(map, requestParams));
        Utils.logserial(url + "\n" + requestParams);
        AsyncHttpClient httpClient = new AsyncHttpClient();
        PersistentCookieStore cookieStore = new PersistentCookieStore(this);
        httpClient.setCookieStore(cookieStore);
        httpClient.post(url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody);
                VipPayModel vipPayModel = GsonUtils.getInstance().fromJson(json, VipPayModel.class);
                Utils.logserial(json + "serialNoOut:" + serialNo);
                if (vipPayModel.isSuccess()) {
                    topayResult(vipPayModel.getData().getAmount(), vipPayModel.getData().getBalance());
                } else {
                    serialWxi = serialNo;
                    handler.postDelayed(wxpayrunnable, 500);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }

    //阿里订单查询
    private void cycleAliPayRequest(final String serialNo) {
        String url = API.BASE_URL + API.SERINO_REQUEST;
        RequestParams requestParams = new RequestParams();
        Map<String, String> map = new HashMap<>();
        /**
         * type[short]	是	0消费，1充值
         * deviceId[int]	是	设备id
         * serialNo[string]	是	充值或消费流水号
         */
        map.put("type", "1");
        map.put("deviceId", String.valueOf(SharePref.get(RechargeWayActivity.this, "id", 0)));
        map.put("serialNo", serialNo);
        requestParams.add(Customize.SIGN, Customize.getRequestParams(map, requestParams));
        Utils.logserial(url + "\n" + requestParams);
        AsyncHttpClient httpClient = new AsyncHttpClient();
        PersistentCookieStore cookieStore = new PersistentCookieStore(this);
        httpClient.setCookieStore(cookieStore);
        httpClient.post(url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody);
                VipPayModel vipPayModel = GsonUtils.getInstance().fromJson(json, VipPayModel.class);
                Utils.logserial(json + "serialNoOut:" + serialNo);
                if (vipPayModel.isSuccess()) {
                    topayResult(vipPayModel.getData().getAmount(), vipPayModel.getData().getBalance());
                } else {
                    serialAli = serialNo;
                    handler.postDelayed(alipayrunnable, 500);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }

    private void topayResult(String amount, String money) {
        Intent intent = new Intent(this, RechargeFinishActivity.class);
        intent.putExtra("amount", amount);
        intent.putExtra("money", money);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        timeCount.cancel();
        clearHandler();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timeCount.cancel();
        clearHandler();
    }

    @Override
    public void timeFinish() {
        Utils.toMain(this);
    }

    private void clearHandler(){
        handler.removeCallbacksAndMessages(null);
    }

    //初始化头部和底部
    @Override
    public void initHeaderBottom() {
        ConfigModel configModel = GsonUtils.getInstance().fromJson((String) SharePref.get(this, "config", ""), ConfigModel.class);
        Config config = configModel.getData();
        if (config != null){
            if (config.getIsShowDeviceLogo() == 0) {
                Utils.Glide(this, config.getDeviceLogoImgUrl(), binding.includeHeader.imgTopIcon);
            }
            Utils.Glide(this, config.getLogoImgUrl(), binding.layoutBottom.imgLogoBottom);
            binding.layoutBottom.tvTitle.setText(config.getLogoTitle());
            binding.layoutBottom.tvPhone.setText("客服电话："+config.getServiceCall());
        }
    }
}
