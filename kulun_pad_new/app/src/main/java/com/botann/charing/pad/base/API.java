package com.botann.charing.pad.base;


/**
 * Created by liushanguo on 2017/5/18.
 */

public class API {

    /**************      Server    ********************/
    //服务器
    public static String BASE_URL                                                 = Constants.appBaseURL+Constants.serverType;

    // 47.98.179.228->app.botann.com
//    public static String NEW_BASE_URL = "https://ttgg.botann.com/pay";
//    public static String NEW_BASE_URL = "http://192.168.20.125:9001";
    public static String NEW_BASE_URL = "http://47.98.183.212:9011/pay";
    // "http://47.98.183.212:9011/pay/app"

    public static String URL_LOGIN                                            = "/login"; // 登录
    public static String URL_STATIONS                                         = "/getExchangeSite";
    public static String URL_EXCHANGE_CONFIRM_CHECK                           = "/exchange_record/consumetest2";
    public static String URL_EXCHANGE_CONFIRM_PAY                             = "/exchange_record/sureConsume2";
    public static String URL_EXCHANGE_RECORDS                                 = "/exchange_record/list";
    public static String URL_DRIVER_INFO                                      = "/information";
    public static String URL_ACCOUNT_RECHARGE                                 = "/alipayRecharge"; //充值
    public static String URL_EXCHANGE_LINE                                    = "/exchange_line/list"; //排队列表
    public static String URL_ADD_EXCHANGE_LINE                                = "/exchange_line/line"; // 去排队
    public static String URL_CANCEL_EXCHANGE_LINE                             = "/exchange_line/cancelLine"; // 取消排队
    public static String URL_PAY_RECORDS                                      = "/recharge_record/list"; // 充值记录
    public static String URL_PAY_RESULT                                       = "/queryResult";
    public static String URL_APP_DOWNLOAD_URL                                 = "/app/apkInfo/getApkInfo";
    //carid new add
    public static String URL_CARID_INFO                                       = "/exchange/getCarInfoByPlateNumber"; //用车牌获取详细用户信息
    public static String URL_CARID_QUEUE                                      = "/exchange_line/lineByPlateNumber"; //用车牌排队
    public static String URL_CARINFO_BYACCOUNT                                = "/exchange/getCarInfoByAccount";  //用账户获取信息
    public static String URL_CARID_EXIST                                      = "/car/isExistedCar"; //查看车牌是否存在
    public static String URL_REPAIR_ADD                                       = "/repair/add";  //维修界面提交
    public static String URL_REPAIR_LIST                                      = "/repair/list";  //维修记录日期查询
    public static String URL_REPAIR_CONFIRM                                   = "/repair/confirm"; //维修提交
    public static String URL_LIGHTER                                          = "/batteryBargeRecord/saveTransfer";      //电池驳运的接口名称
    public static String URL_LIGHTER_LIST                                     = "/batteryBargeRecord/list";        //电池驳运列表接口
    public static String URL_UPDATE_RECEIVER                                  = "/batteryBargeRecord/updateReceive";  //电池驳运接收
    public static String URL_UPDATE_TRANSFER                                  = "/batteryBargeRecord/updateTransfer"; //电池驳运修改
    public static String URL_CARPLATE_QUEUE                                   = "/exchange_line/lineByPlateNumberFix"; //直接用车牌排队
    public static String URL_ACTIVITY_LIST                                    = "/activity/list";  //优惠活动列表
    public static String URL_ACTIVITY_DETAIL                                  = "/activity/getDetail";  //活动内容详情
    public static String GET_ACCOUNT_BYPLATE                                  = "/exchange/getAccountByPlateNumber"; //通过车牌获取绑定的账号
}
