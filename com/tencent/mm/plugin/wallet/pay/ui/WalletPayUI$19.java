package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class WalletPayUI$19 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;
    final /* synthetic */ CheckBox pgV;

    WalletPayUI$19(WalletPayUI walletPayUI, CheckBox checkBox) {
        this.pgT = walletPayUI;
        this.pgV = checkBox;
    }

    public final void onClick(View view) {
        this.pgV.setChecked(!this.pgV.isChecked());
    }
}
