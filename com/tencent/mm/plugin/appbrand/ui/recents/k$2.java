package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;

class k$2 extends an {
    final /* synthetic */ t Oc;
    final /* synthetic */ ai Od;
    final /* synthetic */ k gAU;

    k$2(k kVar, t tVar, ai aiVar) {
        this.gAU = kVar;
        this.Oc = tVar;
        this.Od = aiVar;
    }

    public final void p(View view) {
        ((RecentsRecyclerView) view.getParent()).bP(view);
        this.gAU.z(this.Oc);
    }

    public final void q(View view) {
        if (view != null) {
            ((RecentsRecyclerView) view.getParent()).bQ(view);
            this.Od.a(null);
            z.c(view, 0.0f);
            this.gAU.k(this.Oc);
            this.gAU.gAG.remove(this.Oc);
            k.a(this.gAU);
        }
    }

    public final void ar(View view) {
        if (view != null) {
            z.c(view, 0.0f);
            z.d(view, 1.0f);
        }
    }
}
