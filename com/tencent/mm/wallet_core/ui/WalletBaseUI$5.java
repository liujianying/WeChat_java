package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;

class WalletBaseUI$5 implements OnClickListener {
    final /* synthetic */ WalletBaseUI uYT;

    WalletBaseUI$5(WalletBaseUI walletBaseUI) {
        this.uYT = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        View findFocus = WalletBaseUI.a(this.uYT) == null ? null : WalletBaseUI.b(this.uYT).findFocus();
        if (findFocus != null && (findFocus instanceof EditText)) {
            this.uYT.showVKB();
        }
    }
}
