package com.tencent.mm.plugin.voip_cs.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$4 extends BroadcastReceiver {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$4(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
        if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
            VoipCSMainUI.e(this.oYm).bPd = false;
        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
            VoipCSMainUI.e(this.oYm).bPd = false;
            if (!VoipCSMainUI.f(this.oYm).bKY() && b.bMw().oXs == 2) {
                VoipCSMainUI.f(this.oYm).bME();
            }
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
            VoipCSMainUI.e(this.oYm).bPd = true;
            if (!VoipCSMainUI.f(this.oYm).bKY()) {
                VoipCSMainUI.f(this.oYm).stopRing();
            }
        }
    }
}
