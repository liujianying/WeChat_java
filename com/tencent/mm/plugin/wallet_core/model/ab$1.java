package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

class ab$1 implements a {
    final /* synthetic */ int pri;
    final /* synthetic */ long prk;
    final /* synthetic */ long prl;
    final /* synthetic */ Bankcard prm;

    ab$1(long j, long j2, int i, Bankcard bankcard) {
        this.prk = j;
        this.prl = j2;
        this.pri = i;
        this.prm = bankcard;
    }

    public final void R(Map<String, Object> map) {
        if (map != null) {
            long a = bi.a((Long) map.get("wallet_balance_version"), -1);
            long a2 = bi.a((Long) map.get("wallet_balance_last_update_time"), -1);
            if (a2 < 0 || a < 0 || a2 + this.prk > bi.VG() || this.prl >= a) {
                e.a(new c("wallet_balance_version", Long.valueOf(this.prl)), new c("wallet_balance_last_update_time", Long.valueOf(bi.VG())), new c("wallet_balance", Double.valueOf(((double) this.pri) / 100.0d)));
                this.prm.plV = ((double) this.pri) / 100.0d;
                return;
            }
            x.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
        }
    }
}
