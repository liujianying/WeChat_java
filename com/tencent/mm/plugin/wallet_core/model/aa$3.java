package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

class aa$3 implements a {
    final /* synthetic */ aa prd;
    final /* synthetic */ Map prf;
    final /* synthetic */ long prg;
    final /* synthetic */ long prh;
    final /* synthetic */ int pri;
    final /* synthetic */ int prj;

    aa$3(aa aaVar, long j, long j2, int i, int i2, Map map) {
        this.prd = aaVar;
        this.prg = j;
        this.prh = j2;
        this.pri = i;
        this.prj = i2;
        this.prf = map;
    }

    public final void R(Map<String, Object> map) {
        if (map != null) {
            long a = bi.a((Long) map.get("wallet_balance_version"), -1);
            long a2 = bi.a((Long) map.get("wallet_balance_last_update_time"), -1);
            if (a2 < 0 || a < 0 || a2 + this.prg > bi.VG() || this.prh >= a) {
                e.a(new c[]{new c("wallet_balance_version", Long.valueOf(this.prh)), new c("wallet_balance_last_update_time", Long.valueOf(bi.VG())), new c("wallet_balance", Double.valueOf(((double) this.pri) / 100.0d))});
                aa.d(this.prj, this.prf);
                return;
            }
            x.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
        }
    }
}
