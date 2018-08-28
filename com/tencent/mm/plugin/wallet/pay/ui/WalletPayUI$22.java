package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.ui.widget.a.c;

class WalletPayUI$22 implements OnCheckedChangeListener {
    final /* synthetic */ WalletPayUI pgT;
    final /* synthetic */ c pgW;

    WalletPayUI$22(WalletPayUI walletPayUI, c cVar) {
        this.pgT = walletPayUI;
        this.pgW = cVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Button button = this.pgW.getButton(-2);
        if (z) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }
}
