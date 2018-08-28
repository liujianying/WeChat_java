package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;

class m$4 implements Runnable {
    final /* synthetic */ p fGY;
    final /* synthetic */ z gHx;

    m$4(p pVar, z zVar) {
        this.fGY = pVar;
        this.gHx = zVar;
    }

    public final void run() {
        m.apt().put(this.fGY, this.gHx);
    }
}
