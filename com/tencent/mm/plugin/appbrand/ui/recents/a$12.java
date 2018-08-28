package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class a$12 implements a {
    final /* synthetic */ a gyS;

    a$12(a aVar) {
        this.gyS = aVar;
    }

    public final void a(String str, l lVar) {
        if (!"single".equals(str)) {
            return;
        }
        if (3 == lVar.fBN || 2 == lVar.fBN) {
            this.gyS.runOnUiThread(new 1(this));
            a.a(this.gyS, true, Long.MAX_VALUE, false);
        }
    }
}
