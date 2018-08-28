package com.tencent.tencentmap.mapsdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tencentmap.mapsdk.a.ef.a;

final class ei extends BroadcastReceiver {
    private /* synthetic */ ef a;

    ei(ef efVar) {
        this.a = efVar;
    }

    public final void onReceive(Context context, Intent intent) {
        fx.a("AccessSchedulerTrigger", "onAccessSchedulerTriggered by timer, curTime:" + System.currentTimeMillis());
        el.a().a(new a(this.a, (byte) 0));
    }
}
