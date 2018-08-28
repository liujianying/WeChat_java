package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.i.b.a;
import com.tencent.mm.plugin.appbrand.l;
import java.util.Map;

class f$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ f fWP;

    f$1(f fVar, l lVar, int i) {
        this.fWP = fVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(int i, String str, Map<String, Object> map) {
        switch (i) {
            case 1:
                this.fCl.E(this.doP, this.fWP.f("ok", map));
                return;
            default:
                this.fCl.E(this.doP, this.fWP.f("fail:" + str, null));
                return;
        }
    }
}
