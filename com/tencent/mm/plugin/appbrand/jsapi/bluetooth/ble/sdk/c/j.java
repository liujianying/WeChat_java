package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c;

public enum j {
    OK(0, ""),
    FAIL(-1, "fail"),
    BLE_NO_INIT(10000, "fail:not init"),
    BLE_NOT_AVAILABLE(10001, "fail:not available"),
    BLE_NO_DEVICE(10002, "fail:no device"),
    BLE_CONNECTION_FAIL(10003, "fail:connection fail"),
    BLE_NO_SERVICE(10004, "fail:no service"),
    BLE_NO_CHARACTERISTIC(10005, "fail:no characteristic"),
    BLE_NO_CONNECTION(10006, "fail:no connection"),
    BLE_PROPERTY_NOT_SUPPORT(10007, "fail:property not support"),
    BLE_SYSTEM_ERROR(10008, "fail:system error"),
    BLE_SYSTEM_NOT_SUPPORT(10009, "fail:system not support"),
    BLE_NO_DESCRIPTOR(10008, "fail:no descriptor"),
    BLE_SET_DESCRIPTOR_FAIL(10008, "fail:fail to set descriptor"),
    BLE_WRITE_DESCRIPTOR_FAIL(10008, "fail:fail to write descriptor"),
    BLE_OPERATE_TIME_OUT(10012, "fail:operate time out"),
    BLE_ALREADY_CONNECT(-1, "fail:already connect");
    
    public String Yy;
    public int errCode;

    private j(int i, String str) {
        this.errCode = i;
        this.Yy = str;
    }

    public final String toString() {
        return "Result{errCode=" + this.errCode + ", errMsg='" + this.Yy + '\'' + '}';
    }
}
