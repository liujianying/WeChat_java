package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.sdk.platformtools.bi;

public enum a {
    RELEASE(0),
    DEVELOP(1),
    TRIAL(2);
    
    public final int fmv;

    private a(int i) {
        this.fmv = i;
    }

    public static a a(String str, a aVar) {
        if (bi.oW(str)) {
            return aVar;
        }
        for (a aVar2 : values()) {
            if (aVar2.name().toLowerCase().equals(str)) {
                return aVar2;
            }
        }
        return aVar;
    }

    public static a kO(int i) {
        for (a aVar : values()) {
            if (aVar.fmv == i) {
                return aVar;
            }
        }
        return RELEASE;
    }
}
