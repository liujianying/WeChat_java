package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.ui.MMActivity.a;

class a$2 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ a fPi;

    a$2(a aVar, l lVar, int i) {
        this.fPi = aVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        this.fCl.E(this.doP, this.fPi.f("ok", null));
    }
}
