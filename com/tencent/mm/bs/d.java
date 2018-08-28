package com.tencent.mm.bs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.bs.b.b;
import com.tencent.mm.sdk.platformtools.x;

final class d extends BroadcastReceiver {
    a<Boolean> sNL;
    a<Boolean> sNM;

    d(Context context) {
        boolean z = false;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this, intentFilter);
        String str = "charging";
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        }
        this.sNL = new a(str, Boolean.valueOf(z));
        this.sNM = new a("interactive", Boolean.valueOf(((PowerManager) context.getSystemService("power")).isScreenOn()));
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            b bVar = null;
            boolean z = true;
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        z = true;
                        break;
                    }
                    break;
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        z = true;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        z = false;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    this.sNM.set(Boolean.valueOf(true));
                    bVar = this.sNM;
                    break;
                case true:
                    this.sNM.set(Boolean.valueOf(false));
                    bVar = this.sNM;
                    break;
                case true:
                    this.sNL.set(Boolean.valueOf(true));
                    bVar = this.sNL;
                    break;
                case true:
                    this.sNL.set(Boolean.valueOf(false));
                    bVar = this.sNL;
                    break;
            }
            if (bVar != null) {
                x.i("MicroMsg.SystemStatus", "System status changed: %s = %s", bVar.name(), bVar.get().toString());
            }
        }
    }
}
