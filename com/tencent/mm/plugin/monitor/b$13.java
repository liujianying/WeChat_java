package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class b$13 extends BroadcastReceiver {
    final /* synthetic */ b lsb;

    b$13(b bVar) {
        this.lsb = bVar;
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
            case 505380757:
                if (action.equals("android.intent.action.TIME_SET")) {
                    z = true;
                    break;
                }
                break;
            case 1019184907:
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    z = true;
                    break;
                }
                break;
            case 1041332296:
                if (action.equals("android.intent.action.DATE_CHANGED")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                b.a(this.lsb, true);
                break;
            case true:
                b.a(this.lsb, false);
                break;
            case true:
                b.b(this.lsb, true);
                break;
            case true:
                b.b(this.lsb, false);
                break;
            case true:
            case true:
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder Action time change");
                HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_DAY_RECEIVER);
                return;
        }
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]";
        Object[] objArr = new Object[5];
        objArr[0] = action;
        objArr[1] = Boolean.valueOf(b.j(this.lsb));
        objArr[2] = Boolean.valueOf(b.k(this.lsb));
        objArr[3] = Long.valueOf(b.l(this.lsb));
        if (b.m(this.lsb) == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[4] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (b.m(this.lsb) == null && b.k(this.lsb) && !b.j(this.lsb)) {
            if (System.currentTimeMillis() - b.l(this.lsb) < b.n(this.lsb) * 60000) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[]{Long.valueOf(b.n(this.lsb))});
                return;
            }
            b.a(this.lsb, new 2(this, new 1(this)));
            g.Em().h(b.m(this.lsb), b.p(this.lsb) * 60000);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[]{Long.valueOf(b.p(this.lsb))});
        } else if (b.m(this.lsb) != null) {
            g.Em().cil().removeCallbacks(b.m(this.lsb));
            b.a(this.lsb, null);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[]{b.o(this.lsb)});
        } else if (b.o(this.lsb) != null) {
            b.o(this.lsb).dZm = true;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[]{b.o(this.lsb)});
            b.a(this.lsb, null);
        }
    }
}
