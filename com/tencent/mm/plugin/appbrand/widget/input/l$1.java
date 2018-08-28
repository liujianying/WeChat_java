package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class l$1 implements Runnable {
    final /* synthetic */ l gHn;

    l$1(l lVar) {
        this.gHn = lVar;
    }

    public final void run() {
        int i = 0;
        x.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[]{l.b(this.gHn).getClass().getSimpleName()});
        if (l.b(this.gHn) != null) {
            while (i < this.gHn.getChildCount()) {
                View childAt = this.gHn.getChildAt(i);
                if (!(childAt == null || childAt == l.c(this.gHn) || childAt == l.b(this.gHn))) {
                    l.bX(childAt);
                }
                i++;
            }
        }
    }
}
