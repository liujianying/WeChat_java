package com.tencent.mm.plugin.appbrand.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends BroadcastReceiver {
    final String fjA = "reason";
    final String fjB = "homekey";
    final /* synthetic */ d fjC;

    d$1(d dVar) {
        this.fjC = dVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("reason");
            if (stringExtra != null) {
                x.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", intent.getAction(), stringExtra);
                if (stringExtra.equals("homekey")) {
                    this.fjC.acz();
                }
            }
        }
    }
}
