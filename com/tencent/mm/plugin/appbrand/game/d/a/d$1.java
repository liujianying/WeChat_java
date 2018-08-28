package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;

class d$1 implements Runnable {
    final /* synthetic */ l fCl;
    final /* synthetic */ d fCo;

    d$1(d dVar, l lVar) {
        this.fCo = dVar;
        this.fCl = lVar;
    }

    public final void run() {
        p d = d.d(this.fCl);
        if (d != null) {
            a bH = a.bH(d.getContentView());
            if (bH != null) {
                bH.hide();
            }
        }
    }
}
