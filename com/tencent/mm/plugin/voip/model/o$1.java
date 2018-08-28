package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.sdk.platformtools.ad;

class o$1 extends BroadcastReceiver {
    final /* synthetic */ o oMC;

    o$1(o oVar) {
        this.oMC = oVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
        if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
            o.a(this.oMC, false);
        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
            o.a(this.oMC, false);
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            o.a(this.oMC, true);
            if (!b.yU(o.a(this.oMC).mState) && !o.b(this.oMC)) {
                i.bJI().stopRing();
            }
        }
    }
}
