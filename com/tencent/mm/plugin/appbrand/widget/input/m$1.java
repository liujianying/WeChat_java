package com.tencent.mm.plugin.appbrand.widget.input;

import java.lang.ref.WeakReference;

class m$1 implements Runnable {
    final /* synthetic */ int fQL;
    final /* synthetic */ y gHv;

    m$1(int i, y yVar) {
        this.fQL = i;
        this.gHv = yVar;
    }

    public final void run() {
        m.ajb().put(Integer.valueOf(this.fQL), new WeakReference(this.gHv));
    }
}
