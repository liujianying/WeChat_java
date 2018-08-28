package com.tencent.mm.plugin.appbrand.launching;

public enum ad$a {
    Ok,
    Fail,
    Timeout,
    CgiFail,
    ResponseInvalid,
    AwaitFail;

    public static ad$a ld(int i) {
        if (i < 0) {
            return null;
        }
        for (ad$a ad_a : values()) {
            if (ad_a.ordinal() == i) {
                return ad_a;
            }
        }
        return null;
    }
}
