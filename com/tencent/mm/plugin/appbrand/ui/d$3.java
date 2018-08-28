package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;

class d$3 implements Runnable {
    final /* synthetic */ d guW;

    d$3(d dVar) {
        this.guW = dVar;
    }

    public final void run() {
        this.guW.setVisibility(8);
        if (this.guW.getParent() != null) {
            ((ViewGroup) this.guW.getParent()).removeView(this.guW);
        }
    }
}
