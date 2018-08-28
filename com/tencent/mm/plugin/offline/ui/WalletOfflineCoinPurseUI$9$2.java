package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.9;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$9$2 implements a {
    final /* synthetic */ 9 lMr;

    WalletOfflineCoinPurseUI$9$2(9 9) {
        this.lMr = 9;
    }

    public final boolean a(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
        if (i == 2) {
            this.lMr.lMe.a(new f("reward"), false, false);
        } else if (i == 0 && z) {
            this.lMr.lMe.a(new f("reward"), false, false);
        } else if (WalletOfflineCoinPurseUI.o(this.lMr.lMe) != null) {
            WalletOfflineCoinPurseUI.o(this.lMr.lMe).dismiss();
        }
        return true;
    }
}
