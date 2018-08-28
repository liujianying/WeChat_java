package com.tencent.mm.plugin.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends BroadcastReceiver {
    final /* synthetic */ b hsX;

    b$2(b bVar) {
        this.hsX = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
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
                b.b(this.hsX, true);
                break;
            case true:
                b.b(this.hsX, false);
                break;
            case true:
                b.c(this.hsX, true);
                break;
            case true:
                b.c(this.hsX, false);
                break;
        }
        if (!b.j(this.hsX) || b.k(this.hsX)) {
            if (b.l(this.hsX) != null) {
                au.Em();
                ah.M(b.l(this.hsX));
                b.b(this.hsX, null);
            }
            b.m(this.hsX);
            return;
        }
        x.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
        if (b.l(this.hsX) == null) {
            b.b(this.hsX, new 1(this));
            au.Em().h(b.l(this.hsX), 300000);
        }
    }
}
