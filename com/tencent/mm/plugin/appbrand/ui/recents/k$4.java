package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

class k$4 extends an {
    final /* synthetic */ ai Od;
    final /* synthetic */ k gAU;
    final /* synthetic */ d gAV;

    k$4(k kVar, d dVar, ai aiVar) {
        this.gAU = kVar;
        this.gAV = dVar;
        this.Od = aiVar;
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        this.Od.a(null);
        this.gAU.k(this.gAV);
        this.gAU.gAK.remove(this.gAV);
        k.a(this.gAU);
    }

    public final void ar(View view) {
        if (view != null) {
            z.c(view, 0.0f);
            z.d(view, 1.0f);
        }
    }
}
