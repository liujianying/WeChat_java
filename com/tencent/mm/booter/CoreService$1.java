package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.ab.b;

class CoreService$1 implements b {
    final /* synthetic */ CoreService cWM;

    CoreService$1(CoreService coreService) {
        this.cWM = coreService;
    }

    public final void prepare() {
        MMReceivers$AlarmReceiver.bk(this.cWM.getApplicationContext());
    }

    public final void cancel() {
        MMReceivers$AlarmReceiver.bl(this.cWM.getApplicationContext());
    }
}
