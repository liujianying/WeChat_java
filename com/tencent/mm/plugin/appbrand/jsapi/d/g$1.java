package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import com.tencent.mm.plugin.appbrand.widget.input.f;
import com.tencent.mm.plugin.appbrand.widget.input.h.a;
import com.tencent.mm.plugin.appbrand.widget.input.m;

class g$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ int fQL;
    final /* synthetic */ h fQU;
    final /* synthetic */ g fQV;

    g$1(g gVar, int i, h hVar, p pVar, int i2) {
        this.fQV = gVar;
        this.fQL = i;
        this.fQU = hVar;
        this.fJO = pVar;
        this.doP = i2;
    }

    public final void run() {
        Object obj;
        com.tencent.mm.plugin.appbrand.widget.input.h apn = a.apn();
        int i = this.fQL;
        h hVar = this.fQU;
        c cVar = (c) apn.gGJ.get(i);
        if (cVar != null) {
            if (hVar.gLA != null) {
                cVar.wh(hVar.gLA);
            }
            cVar.a(hVar);
            View aph = cVar.aph();
            if (aph != null) {
                p pVar = (p) cVar.gGm.get();
                if (!(pVar == null || pVar.gns == null)) {
                    f fVar = pVar.gnr;
                    if (fVar != null) {
                        Rect api = cVar.api();
                        fVar.b(pVar.gns, aph, api.width(), api.height(), api.left, api.top);
                    }
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.fJO.E(this.doP, this.fQV.f("ok", null));
        } else if (m.a(this.fQU, this.fQL)) {
            this.fJO.E(this.doP, this.fQV.f("ok", null));
        } else {
            this.fJO.E(this.doP, this.fQV.f("fail", null));
        }
    }
}
