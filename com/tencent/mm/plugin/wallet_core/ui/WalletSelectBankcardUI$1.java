package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletSelectBankcardUI$1 implements a {
    final /* synthetic */ WalletSelectBankcardUI pym;

    WalletSelectBankcardUI$1(WalletSelectBankcardUI walletSelectBankcardUI) {
        this.pym = walletSelectBankcardUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
        e.bE(this.pym, this.pym.getString(i.wallet_bankcard_detail_bankphone_number));
    }
}
