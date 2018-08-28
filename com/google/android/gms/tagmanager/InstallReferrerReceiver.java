package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    protected final void aG(String str) {
        l.bx(str);
    }

    protected final Class<? extends CampaignTrackingService> mC() {
        return InstallReferrerService.class;
    }
}
