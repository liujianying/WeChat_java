package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;

class d$1 implements Runnable {
    final /* synthetic */ d gzH;
    final /* synthetic */ View val$view;

    d$1(d dVar, View view) {
        this.gzH = dVar;
        this.val$view = view;
    }

    public final void run() {
        this.val$view.setVisibility(8);
    }
}
