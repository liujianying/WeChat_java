package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.a;
import com.tinkerboots.sdk.b.c.b;

class c$b$1 extends BroadcastReceiver {
    final /* synthetic */ c$a vGn;
    final /* synthetic */ b vGo;

    c$b$1(b bVar, c$a c_a) {
        this.vGo = bVar;
        this.vGn = c_a;
    }

    public final void onReceive(Context context, Intent intent) {
        a.i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[]{intent == null ? "" : intent.getAction()});
        if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
            context.unregisterReceiver(this);
            if (this.vGn != null) {
                this.vGn.acA();
            }
        }
    }
}
