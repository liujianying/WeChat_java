package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.i.b.a;
import com.tencent.mm.plugin.appbrand.l;
import java.util.Map;

class d$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ d fWN;

    d$1(d dVar, l lVar, int i) {
        this.fWN = dVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(int i, String str, Map<String, Object> map) {
        switch (i) {
            case 1:
                this.fCl.E(this.doP, this.fWN.f("ok", null));
                return;
            case 2:
                this.fCl.E(this.doP, this.fWN.f("fail:" + str, null));
                return;
            case 3:
                this.fCl.E(this.doP, this.fWN.f("cancel", null));
                return;
            default:
                return;
        }
    }
}
