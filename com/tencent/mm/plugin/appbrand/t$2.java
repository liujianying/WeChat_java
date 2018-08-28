package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.ui.l.a;

class t$2 implements Runnable {
    final /* synthetic */ g fel;
    final /* synthetic */ Bitmap fem;

    t$2(g gVar, Bitmap bitmap) {
        this.fel = gVar;
        this.fem = bitmap;
    }

    public final void run() {
        a.a(this.fel, this.fem);
        g gVar = this.fel;
        gVar.fct.aea();
        gVar.reload();
    }
}
