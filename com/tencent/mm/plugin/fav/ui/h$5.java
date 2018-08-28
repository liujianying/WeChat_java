package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;

class h$5 implements Runnable {
    final /* synthetic */ String bAd;
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ String dUN;
    final /* synthetic */ int fXT;
    final /* synthetic */ String jan;
    final /* synthetic */ String jao;
    final /* synthetic */ Context val$context;

    public h$5(Context context, String str, String str2, String str3, int i, String str4, Runnable runnable) {
        this.val$context = context;
        this.bAd = str;
        this.jan = str2;
        this.dUN = str3;
        this.fXT = i;
        this.jao = str4;
        this.bzs = runnable;
    }

    public final void run() {
        Context context = this.val$context;
        String str = this.bAd;
        String str2 = this.jan;
        String str3 = this.dUN;
        int i = this.fXT;
        String str4 = this.jao;
        b bVar = new b(str2);
        if (bVar.exists()) {
            b bVar2 = new b(str3);
            x.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[]{bVar.cBX().toString(), bVar2.cBX().toString()});
            g.bcT().a(context, str, bVar.cBX().toString(), str3, 1, i, str4);
        }
        ah.A(this.bzs);
    }

    public final String toString() {
        return super.toString() + "|sendFavVideo";
    }
}
