package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class WalletLqtDetailUI$7 implements a<Void, bdo> {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$7(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        bdo bdo = (bdo) obj;
        if (bdo != null) {
            x.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", new Object[]{Integer.valueOf(bdo.rtK), Boolean.valueOf(bdo.sfN)});
            WalletLqtDetailUI.a(this.pbs, bdo);
            WalletLqtDetailUI.b(this.pbs);
        } else {
            x.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
        }
        if (WalletLqtDetailUI.a(this.pbs) != null) {
            WalletLqtDetailUI.a(this.pbs).dismiss();
        }
        return uQG;
    }
}
