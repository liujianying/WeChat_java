package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ah;

class h$4 implements Runnable {
    final /* synthetic */ String bAd;
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ g iVs;
    final /* synthetic */ vx jam;

    h$4(String str, g gVar, vx vxVar, Runnable runnable) {
        this.bAd = str;
        this.iVs = gVar;
        this.jam = vxVar;
        this.bzs = runnable;
    }

    public final void run() {
        h.a(this.bAd, this.iVs, this.jam);
        ah.A(this.bzs);
    }

    public final String toString() {
        return super.toString() + "|sendFavFile";
    }
}
