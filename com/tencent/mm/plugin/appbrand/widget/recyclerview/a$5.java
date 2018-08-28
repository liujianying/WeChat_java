package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnLongClickListener;

class a$5 implements OnLongClickListener {
    final /* synthetic */ t Oc;
    final /* synthetic */ a gPS;
    final /* synthetic */ int gPT;

    a$5(a aVar, t tVar, int i) {
        this.gPS = aVar;
        this.Oc = tVar;
        this.gPT = i;
    }

    public final boolean onLongClick(View view) {
        if (a.c(this.gPS) == null) {
            return false;
        }
        c c = a.c(this.gPS);
        View view2 = this.Oc.SU;
        long j = this.Oc.SW;
        return c.aqE();
    }
}
