package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;

class m$2 implements Runnable {
    final /* synthetic */ String etb;
    final /* synthetic */ p fJO;
    final /* synthetic */ Integer gHw;

    m$2(p pVar, String str, Integer num) {
        this.fJO = pVar;
        this.etb = str;
        this.gHw = num;
    }

    public final void run() {
        z zVar = (z) m.apt().get(this.fJO);
        if (zVar != null) {
            y lY = m.lY(zVar.getInputId());
            if (lY != null) {
                lY.updateValue(this.etb, this.gHw);
            }
        }
    }
}
