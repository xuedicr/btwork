package com.botann.driverclient.model.chongdian;

import java.io.Serializable;

/**
 * created by xuedi on 2019/7/3
 */
public class ChongdianzhuangInfoModer implements Serializable {
    private String msg;
    private boolean success;
    private int code;
    private ChongdianZhuangInforContent content;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ChongdianZhuangInforContent getContent() {
        return content;
    }

    public void setContent(ChongdianZhuangInforContent content) {
        this.content = content;
    }
}
