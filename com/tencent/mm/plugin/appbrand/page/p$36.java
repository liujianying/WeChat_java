package com.tencent.mm.plugin.appbrand.page;

import android.view.View;

class p$36 implements Runnable {
    final /* synthetic */ p gnH;
    final /* synthetic */ int gnR;
    final /* synthetic */ int nef;
    final /* synthetic */ View val$view;

    p$36(p pVar, View view, int i, int i2) {
        this.gnH = pVar;
        this.val$view = view;
        this.gnR = i;
        this.nef = i2;
    }

    public final void run() {
        this.val$view.scrollTo(this.gnR, this.nef);
    }
}
