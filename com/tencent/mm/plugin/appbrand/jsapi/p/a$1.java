package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.page.p.e;

class a$1 implements e {
    final /* synthetic */ a gcK;

    a$1(a aVar) {
        this.gcK = aVar;
    }

    public final void onDestroy() {
        a.a(this.gcK).cleanup();
    }
}
