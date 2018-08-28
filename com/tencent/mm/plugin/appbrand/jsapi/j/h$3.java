package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.picker.a;

class h$3 implements Runnable {
    final /* synthetic */ h fXq;
    final /* synthetic */ a fXt;

    h$3(h hVar, a aVar) {
        this.fXq = hVar;
        this.fXt = aVar;
    }

    public final void run() {
        if (this.fXt.getPicker() != null && (this.fXt.getPicker() instanceof View)) {
            ((View) this.fXt.getPicker()).requestLayout();
        }
    }
}
