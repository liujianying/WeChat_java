package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.i.b.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

class h$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ h fWS;

    h$1(h hVar, l lVar, int i) {
        this.fWS = hVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(int i, String str, Map<String, Object> map) {
        switch (i) {
            case 1:
                this.fCl.E(this.doP, this.fWS.f("ok", null));
                return;
            case 2:
                if (bi.oW(str)) {
                    this.fCl.E(this.doP, this.fWS.f("fail", null));
                    return;
                }
                this.fCl.E(this.doP, this.fWS.f(String.format("fail %s", new Object[]{str}), null));
                return;
            default:
                this.fCl.E(this.doP, this.fWS.f("cancel", null));
                return;
        }
    }
}
