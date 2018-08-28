package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.al;

public final class e {
    String appId;
    int bGF;
    int cbu;
    public al eOf;
    int fBA;
    int fBB;
    public int fBz;

    public e(String str, int i) {
        this.fBz = Math.max(1, i);
        this.appId = str;
        g pY = a.pY(str);
        if (pY != null && pY.fcu != null) {
            this.cbu = pY.fcu.frm.fii;
            this.bGF = pY.fcu.frm.fih + 1;
        }
    }
}
