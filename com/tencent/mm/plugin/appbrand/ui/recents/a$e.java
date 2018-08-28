package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

final class a$e extends k implements Runnable {
    final /* synthetic */ a gyS;

    private a$e(a aVar) {
        this.gyS = aVar;
    }

    /* synthetic */ a$e(a aVar, byte b) {
        this(aVar);
    }

    public final void e(RecyclerView recyclerView, int i) {
        a.a(this.gyS, i == 2);
        if (i == 0) {
            this.gyS.u(this);
        }
    }

    public final void run() {
        if (a.g(this.gyS) != null && a.n(this.gyS) != null && a.b(this.gyS) != null && a.x(this.gyS) != null) {
            int fi = a.n(this.gyS).fi();
            int fj = a.n(this.gyS).fj();
            for (int i = fi; i <= fj; i++) {
                RecyclerView$t bk = a.g(this.gyS).bk(i);
                if (bk instanceof d) {
                    com.tencent.mm.plugin.appbrand.appusage.k aof = ((d) bk).aof();
                    if (aof != null) {
                        a.x(this.gyS).b((d) bk, aof.fmb);
                    }
                }
            }
        }
    }
}
