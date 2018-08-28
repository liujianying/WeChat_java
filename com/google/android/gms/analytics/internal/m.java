package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.c.ah;
import com.google.android.gms.common.internal.w;

public final class m extends o {
    final w aFJ;

    public m(q qVar, r rVar) {
        super(qVar);
        w.ah(rVar);
        this.aFJ = rVar.c(qVar);
    }

    public final long a(s sVar) {
        np();
        w.ah(sVar);
        q.nx();
        long d = this.aFJ.d(sVar);
        if (d == 0) {
            this.aFJ.c(sVar);
        }
        return d;
    }

    public final void a(ah ahVar) {
        np();
        this.aFn.ns().d(new 4(this, ahVar));
    }

    public final void c(final c cVar) {
        w.ah(cVar);
        np();
        e("Hit delivery requested", cVar);
        this.aFn.ns().d(new Runnable() {
            public final void run() {
                m.this.aFJ.c(cVar);
            }
        });
    }

    protected final void mE() {
        this.aFJ.nq();
    }

    public final void ni() {
        np();
        Context context = this.aFn.mContext;
        if (AnalyticsReceiver.aa(context) && AnalyticsService.ab(context)) {
            Intent intent = new Intent(context, AnalyticsService.class);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        }
        a(null);
    }

    public final void nj() {
        np();
        ah.nx();
        this.aFJ.nj();
    }

    final void nk() {
        q.nx();
        w wVar = this.aFJ;
        q.nx();
        wVar.aGO = wVar.aFn.aFC.currentTimeMillis();
    }

    final void onServiceConnected() {
        q.nx();
        this.aFJ.onServiceConnected();
    }
}
