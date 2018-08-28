package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.l;

class a$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ a fXC;

    a$1(a aVar, l lVar, int i) {
        this.fXC = aVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void run() {
        a aVar = this.fXC;
        l lVar = this.fCl;
        int i = this.doP;
        b ib = u.Hx().ib(lVar.hashCode() + "toast_name");
        if (ib != null) {
            View view = (View) ib.get("toast_view", null);
            if (view != null) {
                view.setVisibility(8);
                lVar.E(i, aVar.f("ok", null));
                return;
            }
        }
        lVar.E(i, aVar.f("fail", null));
    }
}
