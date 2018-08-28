package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class f {
    private static long sEe = 125829120;
    private static long sEf = 314572800;
    al bAZ = new al(new 1(this), true);
    boolean iXC = false;
    private boolean initialized = false;
    private long sEg = 0;
    private long sEh = 0;
    private String sEi = null;
    private j sEj;

    public f(j jVar) {
        this.sEj = jVar;
    }

    public final void cT(String str, int i) {
        if (!bi.oW(str)) {
            if (!str.equals(this.sEi)) {
                stop();
            }
            x.i("MicroMsg.TrafficStatistic", "pack size: " + i);
            x.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[]{Long.valueOf(sEe)});
            sEe = Math.max((long) (i * 4), sEe);
            sEe = Math.min(sEf, sEe);
            x.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[]{Long.valueOf(sEe)});
            if (!this.initialized) {
                if (this.sEj.mContext != null) {
                    this.iXC = ao.isWifi(this.sEj.mContext);
                }
                this.bAZ.J(30000, 30000);
                this.initialized = true;
                this.sEi = str;
            }
        }
    }

    public final void stop() {
        a(true);
        this.bAZ.SO();
        this.initialized = false;
    }

    /* renamed from: lb */
    final void a(boolean z) {
        long j = 0;
        if (z || this.sEg + this.sEh >= 524288) {
            if (this.sEg + this.sEh > 0) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
                intent.putExtra("intent_extra_flow_stat_upstream", this.sEg);
                intent.putExtra("intent_extra_flow_stat_downstream", this.sEh);
                if (this.sEj.mContext != null) {
                    this.iXC = ao.isWifi(this.sEj.mContext);
                }
                intent.putExtra("intent_extra_flow_stat_is_wifi", this.iXC);
                if (this.sEj.mContext != null) {
                    this.sEj.mContext.sendBroadcast(intent, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
                }
            }
            if (bi.oW(this.sEi)) {
                x.e("MicroMsg.TrafficStatistic", "traffic is null!");
            } else {
                long u = i.u(this.sEi, this.sEg, this.sEh);
                this.sEg = 0;
                this.sEh = 0;
                j = u;
            }
            if (j >= sEe && this.sEj.nPm == 2) {
                x.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
                this.sEj.cancel();
            }
        }
    }

    public static boolean VS(String str) {
        if (i.VU(str) <= sEe) {
            return false;
        }
        x.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
        return true;
    }
}
