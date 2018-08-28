package com.tencent.mm.pluginsdk;

import com.tencent.mm.sdk.platformtools.x;

public final class r {
    private static boolean qyn = false;
    public String mTag = "";
    public boolean qym = false;

    public r(String str) {
        this.mTag = str;
    }

    public static void cbl() {
        qyn = true;
    }

    public final boolean cE(String str) {
        if (qyn) {
            x.i("MicroMsg.SplashOptimizing", "[%s], check cancel", this.mTag);
            return false;
        } else if (!this.qym) {
            return false;
        } else {
            x.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", this.mTag, str);
            return true;
        }
    }
}
