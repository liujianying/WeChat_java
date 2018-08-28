package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;

class GcmBroadcastReceiver$1 implements Runnable {
    final /* synthetic */ a khf;
    final /* synthetic */ GcmBroadcastReceiver khg;

    GcmBroadcastReceiver$1(GcmBroadcastReceiver gcmBroadcastReceiver, a aVar) {
        this.khg = gcmBroadcastReceiver;
        this.khf = aVar;
    }

    public final void run() {
        x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired reNewalRegistting start ");
        f.mDy.a(452, 43, 1, false);
        this.khf.aVI();
    }
}
