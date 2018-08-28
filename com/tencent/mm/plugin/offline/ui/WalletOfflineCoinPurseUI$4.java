package com.tencent.mm.plugin.offline.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletOfflineCoinPurseUI$4 implements Runnable {
    final /* synthetic */ sy hYO;
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$4(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, sy syVar) {
        this.lMe = walletOfflineCoinPurseUI;
        this.hYO = syVar;
    }

    public final void run() {
        if (bi.oW(this.hYO.cdP.cdQ)) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
        } else {
            e.a((TextView) this.lMe.findViewById(f.banner_tips), this.hYO.cdP.cdQ, this.hYO.cdP.content, this.hYO.cdP.url);
        }
    }
}
