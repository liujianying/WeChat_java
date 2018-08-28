package com.tencent.mm.plugin.hp.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.a;

class a$2 extends BroadcastReceiver {
    final /* synthetic */ Runnable gna;
    final /* synthetic */ a kmX;
    final /* synthetic */ long kmY = 6000;

    a$2(a aVar, Runnable runnable) {
        this.kmX = aVar;
        this.gna = runnable;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
            a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen off now, send message now", new Object[0]);
            this.kmX.handler.postDelayed(this.gna, this.kmY);
            return;
        }
        a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch screen on, remove pending runnable and receive", new Object[0]);
        this.kmX.handler.removeCallbacks(this.gna);
        context.unregisterReceiver(this);
    }
}
