package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.e.b;
import android.support.v7.widget.RecyclerView.t;

class RecyclerView$f implements b {
    final /* synthetic */ RecyclerView RQ;

    private RecyclerView$f(RecyclerView recyclerView) {
        this.RQ = recyclerView;
    }

    /* synthetic */ RecyclerView$f(RecyclerView recyclerView, byte b) {
        this(recyclerView);
    }

    public final void l(t tVar) {
        tVar.T(true);
        if (tVar.SZ != null && tVar.Ta == null) {
            tVar.SZ = null;
        }
        tVar.Ta = null;
        if (!t.w(tVar) && !RecyclerView.c(this.RQ, tVar.SU) && tVar.gu()) {
            this.RQ.removeDetachedView(tVar.SU, false);
        }
    }
}
