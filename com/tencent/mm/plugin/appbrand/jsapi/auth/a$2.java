package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.e$b;

class a$2 extends e$b {
    final /* synthetic */ String bAj;
    final /* synthetic */ a fJn;

    a$2(a aVar, String str) {
        this.fJn = aVar;
        this.bAj = str;
    }

    public final void onDestroy() {
        a.a(this.fJn);
        synchronized (a.acl()) {
            a.acl().remove(this.bAj);
        }
    }
}
