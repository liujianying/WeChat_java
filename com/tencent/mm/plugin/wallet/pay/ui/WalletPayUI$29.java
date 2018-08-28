package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;

class WalletPayUI$29 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;
    final /* synthetic */ CheckedTextView pgZ;
    final /* synthetic */ CheckedTextView pha;

    WalletPayUI$29(WalletPayUI walletPayUI, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.pgT = walletPayUI;
        this.pgZ = checkedTextView;
        this.pha = checkedTextView2;
    }

    public final void onClick(View view) {
        this.pgZ.setChecked(false);
        this.pha.setChecked(true);
        WalletPayUI.a(this.pgT, true);
        WalletPayUI.e(this.pgT);
    }
}
