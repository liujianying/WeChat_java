package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.as.b;

class RecyclerView$4 implements b {
    final /* synthetic */ RecyclerView RQ;

    RecyclerView$4(RecyclerView recyclerView) {
        this.RQ = recyclerView;
    }

    public final void a(t tVar, c cVar, c cVar2) {
        this.RQ.QN.p(tVar);
        RecyclerView.a(this.RQ, tVar, cVar, cVar2);
    }

    public final void b(t tVar, c cVar, c cVar2) {
        RecyclerView.b(this.RQ, tVar, cVar, cVar2);
    }

    public final void c(t tVar, c cVar, c cVar2) {
        tVar.T(false);
        if (RecyclerView.f(this.RQ)) {
            if (this.RQ.Rr.a(tVar, tVar, cVar, cVar2)) {
                RecyclerView.g(this.RQ);
            }
        } else if (this.RQ.Rr.f(tVar, cVar, cVar2)) {
            RecyclerView.g(this.RQ);
        }
    }

    public final void i(t tVar) {
        this.RQ.QV.a(tVar.SU, this.RQ.QN);
    }
}
