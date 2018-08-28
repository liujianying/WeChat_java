package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.ui.MMActivity.a;

class al$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ al fGk;

    al$1(al alVar, l lVar, int i) {
        this.fGk = alVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fGk.hashCode() & 65535)) {
            this.fCl.E(this.doP, this.fGk.f("ok", null));
        }
    }
}
