package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.e.a.a;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class WalletBankCardSelectUI$3 implements a {
    final /* synthetic */ WalletBankCardSelectUI psM;

    WalletBankCardSelectUI$3(WalletBankCardSelectUI walletBankCardSelectUI) {
        this.psM = walletBankCardSelectUI;
    }

    public final void T(Map<String, e> map) {
        x.i("WalletBankCardSelectUI", "get logo callback: %s", new Object[]{Integer.valueOf(map.size())});
        WalletBankCardSelectUI.a(this.psM, map);
    }
}
