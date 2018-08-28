package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.f;

class CampaignTrackingService$1 implements Runnable {
    final /* synthetic */ f aEB;
    final /* synthetic */ Handler aEE;
    final /* synthetic */ CampaignTrackingService aEF;
    final /* synthetic */ int aEz;

    CampaignTrackingService$1(CampaignTrackingService campaignTrackingService, f fVar, Handler handler, int i) {
        this.aEF = campaignTrackingService;
        this.aEB = fVar;
        this.aEE = handler;
        this.aEz = i;
    }

    public final void run() {
        this.aEF.a(this.aEB, this.aEE, this.aEz);
    }
}
