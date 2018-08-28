package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.pluginsdk.o.b;

class g$2 implements Runnable {
    final /* synthetic */ g ltV;
    final /* synthetic */ b ltW;
    final /* synthetic */ String ltX;

    g$2(g gVar, b bVar, String str) {
        this.ltV = gVar;
        this.ltW = bVar;
        this.ltX = str;
    }

    public final void run() {
        this.ltW.SF(this.ltX);
    }
}
