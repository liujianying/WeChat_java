package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e.b;

class ag$1 implements b {
    final /* synthetic */ ag prO;

    ag$1(ag agVar) {
        this.prO = agVar;
    }

    public final void bU(Object obj) {
        if (obj == null || !(obj instanceof Double)) {
            x.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
            if (this.prO.paw != null) {
                this.prO.paw.plV = -1.0d;
                return;
            }
            return;
        }
        if (((Double) obj).doubleValue() < 0.0d) {
            x.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[]{bi.cjd().toString()});
        }
        if (this.prO.paw != null) {
            this.prO.paw.plV = ((Double) obj).doubleValue();
        }
    }
}
