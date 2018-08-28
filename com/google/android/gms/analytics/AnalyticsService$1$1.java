package com.google.android.gms.analytics;

import com.google.android.gms.analytics.AnalyticsService.1;
import com.google.android.gms.common.internal.f;

class AnalyticsService$1$1 implements Runnable {
    final /* synthetic */ 1 aED;

    AnalyticsService$1$1(1 1) {
        this.aED = 1;
    }

    public final void run() {
        if (!this.aED.aEC.stopSelfResult(this.aED.aEz)) {
            return;
        }
        if (f.aNr) {
            this.aED.aEB.aO("Device AnalyticsService processed last dispatch request");
        } else {
            this.aED.aEB.aO("Local AnalyticsService processed last dispatch request");
        }
    }
}
