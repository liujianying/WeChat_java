package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SnsAdNativeLandingPagesUI$9 extends BroadcastReceiver {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$9(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void onReceive(Context context, Intent intent) {
        SnsAdNativeLandingPagesUI.b(this.nSR);
    }
}
