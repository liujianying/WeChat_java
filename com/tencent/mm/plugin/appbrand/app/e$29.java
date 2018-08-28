package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class e$29 implements a {
    final /* synthetic */ e ffn;

    e$29(e eVar) {
        this.ffn = eVar;
    }

    public final void a(String str, l lVar) {
        if (str != null && str.length() > 0 && "event_updated".equals(str)) {
            e.abp();
            e.abq();
            e.abr();
        }
    }
}
