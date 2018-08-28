package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;

class WalletPayUI$28 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;
    final /* synthetic */ CheckedTextView pgZ;
    final /* synthetic */ CheckedTextView pha;

    WalletPayUI$28(WalletPayUI walletPayUI, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.pgT = walletPayUI;
        this.pgZ = checkedTextView;
        this.pha = checkedTextView2;
    }

    public final void onClick(View view) {
        this.pgZ.setChecked(true);
        this.pha.setChecked(false);
        WalletPayUI.a(this.pgT, false);
        WalletPayUI.e(this.pgT);
    }
}
