package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.t;

class i$2 implements Runnable {
    final /* synthetic */ i gHa;

    i$2(i iVar) {
        this.gHa = iVar;
    }

    public final void run() {
        if (i.a(this.gHa).isRunning()) {
            View b = i.b(this.gHa);
            if (b != null) {
                b.scrollTo(0, 0);
                if (i.c(this.gHa) != 0) {
                    t tVar = i.a(this.gHa).gns;
                    if (tVar != null) {
                        b = tVar.getView();
                        if (b != null) {
                            b.scrollBy(b.getScrollX(), -i.c(this.gHa));
                        }
                    }
                }
                i.d(this.gHa);
            }
        }
    }
}
