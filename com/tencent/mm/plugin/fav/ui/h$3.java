package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ah;

class h$3 implements Runnable {
    final /* synthetic */ String bAd;
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ vx jam;
    final /* synthetic */ Context val$context;

    public h$3(vx vxVar, Context context, String str, Runnable runnable) {
        this.jam = vxVar;
        this.val$context = context;
        this.bAd = str;
        this.bzs = runnable;
    }

    public final void run() {
        if (this.jam.bjS == 15) {
            h.a(this.val$context, this.bAd, this.jam);
        } else {
            h.b(this.val$context, this.bAd, this.jam);
        }
        ah.A(this.bzs);
    }

    public final String toString() {
        return super.toString() + "|sendFavVideo";
    }
}
