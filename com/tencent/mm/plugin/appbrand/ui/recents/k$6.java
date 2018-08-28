package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;

class k$6 extends an {
    final /* synthetic */ k gAU;
    final /* synthetic */ a$d gAV;

    k$6(k kVar, a$d a_d) {
        this.gAU = kVar;
        this.gAV = a_d;
    }

    public final void p(View view) {
        this.gAU.z(this.gAV);
    }

    public final void q(View view) {
        z.c(view, 0.0f);
        z.d(view, 1.0f);
        this.gAU.k(this.gAV);
        this.gAU.gAO.remove(this.gAV);
        k.a(this.gAU);
    }
}
