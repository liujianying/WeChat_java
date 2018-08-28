package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.f;

class CampaignTrackingService$3 implements Runnable {
    final /* synthetic */ f aEB;
    final /* synthetic */ CampaignTrackingService aEF;
    final /* synthetic */ int aEz;

    CampaignTrackingService$3(CampaignTrackingService campaignTrackingService, int i, f fVar) {
        this.aEF = campaignTrackingService;
        this.aEz = i;
        this.aEB = fVar;
    }

    public final void run() {
        boolean stopSelfResult = this.aEF.stopSelfResult(this.aEz);
        if (stopSelfResult) {
            this.aEB.d("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
        }
    }
}
