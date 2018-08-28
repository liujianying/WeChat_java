package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.i.b.a;
import com.tencent.mm.plugin.appbrand.l;
import java.util.Map;

class c$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ c fWM;

    c$1(c cVar, l lVar, int i) {
        this.fWM = cVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(int i, String str, Map<String, Object> map) {
        switch (i) {
            case 1:
                this.fCl.E(this.doP, this.fWM.f("ok", null));
                return;
            default:
                this.fCl.E(this.doP, this.fWM.f("fail", null));
                return;
        }
    }
}
