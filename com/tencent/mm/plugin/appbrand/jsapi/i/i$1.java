package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.i.b.b;
import com.tencent.mm.plugin.appbrand.l;
import java.util.HashMap;
import java.util.Map;

class i$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ i fWT;

    i$1(i iVar, l lVar, int i) {
        this.fWT = iVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void f(boolean z, String str) {
        if (z) {
            Map hashMap = new HashMap(1);
            hashMap.put("token", str);
            this.fCl.E(this.doP, this.fWT.f("ok", hashMap));
            return;
        }
        this.fCl.E(this.doP, this.fWT.f("fail", null));
    }
}
