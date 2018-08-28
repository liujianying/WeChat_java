package com.tencent.mm.plugin.appbrand.s.c;

import com.tencent.rtmp.TXLiveConstants;

public class b extends Exception {
    public int gDF;

    public b() {
        this.gDF = TXLiveConstants.PUSH_EVT_PUSH_BEGIN;
    }

    public b(String str) {
        super(str);
        this.gDF = TXLiveConstants.PUSH_EVT_PUSH_BEGIN;
    }

    public b(int i, Throwable th) {
        super(th);
        this.gDF = i;
    }
}
