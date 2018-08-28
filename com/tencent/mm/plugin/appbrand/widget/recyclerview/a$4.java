package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;

class a$4 implements OnClickListener {
    final /* synthetic */ t Oc;
    final /* synthetic */ a gPS;
    final /* synthetic */ int gPT;

    a$4(a aVar, t tVar, int i) {
        this.gPS = aVar;
        this.Oc = tVar;
        this.gPT = i;
    }

    public final void onClick(View view) {
        if (a.b(this.gPS) != null) {
            b b = a.b(this.gPS);
            View view2 = this.Oc.SU;
            int i = this.gPT;
            long j = this.Oc.SW;
            b.ms(i);
        }
    }
}
