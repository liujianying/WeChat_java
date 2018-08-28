package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardDetailUI$6 implements OnClickListener {
    final /* synthetic */ WalletBankcardDetailUI pcX;

    WalletBankcardDetailUI$6(WalletBankcardDetailUI walletBankcardDetailUI) {
        this.pcX = walletBankcardDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((b) g.l(b.class)).h(this.pcX, 1);
        e.He(1);
    }
}
