package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

class k$5 extends an {
    final /* synthetic */ k gAU;
    final /* synthetic */ d gAV;

    k$5(k kVar, d dVar) {
        this.gAU = kVar;
        this.gAV = dVar;
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        z.e(this.gAV.gzj, 1.0f);
        z.f(this.gAV.gzj, 1.0f);
        z.d(this.gAV.gzj, 1.0f);
        this.gAV.gzj.setVisibility(8);
        this.gAU.k(this.gAV);
        this.gAU.gAM.remove(this.gAV);
        k.a(this.gAU);
    }
}
