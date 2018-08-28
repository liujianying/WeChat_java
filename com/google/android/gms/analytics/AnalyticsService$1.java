package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.ah;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.q;

class AnalyticsService$1 implements ah {
    final /* synthetic */ q aEA;
    final /* synthetic */ f aEB;
    final /* synthetic */ AnalyticsService aEC;
    final /* synthetic */ int aEz;

    AnalyticsService$1(AnalyticsService analyticsService, int i, q qVar, f fVar) {
        this.aEC = analyticsService;
        this.aEz = i;
        this.aEA = qVar;
        this.aEB = fVar;
    }

    public final void mB() {
        AnalyticsService.a(this.aEC).post(new 1(this));
    }
}
