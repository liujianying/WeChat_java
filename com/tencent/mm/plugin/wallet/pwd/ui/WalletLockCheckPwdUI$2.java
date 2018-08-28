package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletLockCheckPwdUI$2 implements OnClickListener {
    final /* synthetic */ WalletLockCheckPwdUI phU;

    WalletLockCheckPwdUI$2(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        this.phU = walletLockCheckPwdUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
        WalletLockCheckPwdUI.a(this.phU);
    }
}
