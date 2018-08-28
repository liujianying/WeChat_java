package com.tencent.mm.plugin.wallet.bind.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardManageUI$5 implements Runnable {
    final /* synthetic */ sy hYO;
    final /* synthetic */ WalletBankcardManageUI pdm;

    WalletBankcardManageUI$5(WalletBankcardManageUI walletBankcardManageUI, sy syVar) {
        this.pdm = walletBankcardManageUI;
        this.hYO = syVar;
    }

    public final void run() {
        if (bi.oW(this.hYO.cdP.cdQ)) {
            x.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
        } else {
            e.a((TextView) this.pdm.findViewById(f.banner_tips), this.hYO.cdP.cdQ, this.hYO.cdP.content, this.hYO.cdP.url);
        }
    }
}
