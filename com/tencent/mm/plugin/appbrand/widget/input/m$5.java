package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;

class m$5 implements Runnable {
    final /* synthetic */ p fGY;

    m$5(p pVar) {
        this.fGY = pVar;
    }

    public final void run() {
        m.apt().remove(this.fGY);
    }
}
