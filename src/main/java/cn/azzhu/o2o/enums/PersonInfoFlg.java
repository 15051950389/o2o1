package cn.azzhu.o2o.enums;

import sun.awt.CustomCursor;

public enum  PersonInfoFlg {
    CUSTOMER(0,"普通用户"),SHOPOEMPLOYEE(1,"店主");
    private int code;
    private String msg;
    PersonInfoFlg(){}

    PersonInfoFlg(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
