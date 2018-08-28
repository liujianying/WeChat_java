package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.id_verify.a;

class WalletBankcardIdUI$8 implements OnClickListener {
    final /* synthetic */ WalletBankcardIdUI psW;

    WalletBankcardIdUI$8(WalletBankcardIdUI walletBankcardIdUI) {
        this.psW = walletBankcardIdUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((a) this.psW.cDK()).c(this.psW, 0);
        this.psW.finish();
    }
}
