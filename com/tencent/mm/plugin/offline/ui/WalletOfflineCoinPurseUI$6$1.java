package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.6;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$6$1 implements a {
    final /* synthetic */ 6 lMn;

    WalletOfflineCoinPurseUI$6$1(6 6) {
        this.lMn = 6;
    }

    public final boolean a(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
        if (i == 2) {
            this.lMn.lMe.a(new f("collect"), false, false);
        } else if (i == 0 && z) {
            this.lMn.lMe.a(new f("collect"), false, false);
        } else if (WalletOfflineCoinPurseUI.o(this.lMn.lMe) != null) {
            WalletOfflineCoinPurseUI.o(this.lMn.lMe).dismiss();
        }
        return true;
    }
}
