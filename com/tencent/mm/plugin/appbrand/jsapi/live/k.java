package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.rtmp.TXLiveBase;

public final class k {
    private static boolean fRU;

    public static void aje() {
        if (!fRU) {
            TXLiveBase.setLogLevel(1);
            TXLiveBase.setConsoleEnabled(false);
            TXLiveBase.setListener(new 1());
            fRU = true;
        }
    }
}
