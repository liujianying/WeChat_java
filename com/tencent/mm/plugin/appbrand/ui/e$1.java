package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;

class e$1 implements Runnable {
    final /* synthetic */ e gvv;

    e$1(e eVar) {
        this.gvv = eVar;
    }

    public final void run() {
        e eVar = this.gvv;
        if (eVar.getParent() instanceof ViewGroup) {
            eVar.animate().alpha(0.0f).withEndAction(new 2(this, eVar, (ViewGroup) eVar.getParent())).withStartAction(new 1(this)).start();
        }
    }
}
