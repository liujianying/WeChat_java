package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;

class d$9 extends BroadcastReceiver {
    final /* synthetic */ d iam;

    d$9(d dVar) {
        this.iam = dVar;
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
                d.b(this.iam, true);
                break;
            case true:
                d.b(this.iam, false);
                break;
            case true:
                d.c(this.iam, true);
                break;
            case true:
                d.c(this.iam, false);
                break;
        }
        x.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", new Object[]{action, Boolean.valueOf(d.i(this.iam)), Boolean.valueOf(d.j(this.iam))});
        if (d.h(this.iam) && d.k(this.iam) == null && d.j(this.iam) && !d.i(this.iam)) {
            if (System.currentTimeMillis() - d.l(this.iam) < 86400000) {
                x.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                return;
            }
            z = d.m(this.iam) < 10;
            d.a(this.iam, new 2(this, z, new 1(this, z)));
            au.Em().h(d.k(this.iam), d.g(this.iam));
            x.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
            h.mEJ.h(11098, new Object[]{Integer.valueOf(10009), this.iam.hZW.format(new Date())});
        } else if (d.k(this.iam) != null) {
            au.Em().cil().removeCallbacks(d.k(this.iam));
            d.a(this.iam, null);
            x.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
            h.mEJ.h(11098, new Object[]{Integer.valueOf(10010), this.iam.hZW.format(new Date())});
        } else if (d.o(this.iam)) {
            this.iam.aCD();
            d.d(this.iam, false);
        }
    }
}
