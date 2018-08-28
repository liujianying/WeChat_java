package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.ui.e.1;

class e$1$2 implements Runnable {
    final /* synthetic */ 1 gvw;
    final /* synthetic */ View gvx;
    final /* synthetic */ ViewGroup gvy;

    e$1$2(1 1, View view, ViewGroup viewGroup) {
        this.gvw = 1;
        this.gvx = view;
        this.gvy = viewGroup;
    }

    public final void run() {
        this.gvx.setVisibility(8);
        this.gvy.removeView(this.gvx);
    }
}
