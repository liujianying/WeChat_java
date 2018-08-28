package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletLqtCheckPwdInputDialogUI$3 implements OnCancelListener {
    final /* synthetic */ WalletLqtCheckPwdInputDialogUI paT;

    WalletLqtCheckPwdInputDialogUI$3(WalletLqtCheckPwdInputDialogUI walletLqtCheckPwdInputDialogUI) {
        this.paT = walletLqtCheckPwdInputDialogUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
        WalletLqtCheckPwdInputDialogUI.a(this.paT).dismiss();
        this.paT.finish();
    }
}
