package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.n.c.a;

class o$1 implements b<WxaAttributes> {
    final /* synthetic */ a frB;
    final /* synthetic */ o frC;

    o$1(o oVar, a aVar) {
        this.frC = oVar;
        this.frB = aVar;
    }

    public final /* synthetic */ void e(int i, Object obj) {
        WxaAttributes wxaAttributes = (WxaAttributes) obj;
        if (this.frB != null) {
            this.frB.b(wxaAttributes);
        }
    }
}
