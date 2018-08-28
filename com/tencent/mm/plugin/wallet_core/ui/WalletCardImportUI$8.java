package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckedTextView;

class WalletCardImportUI$8 implements OnItemClickListener {
    final /* synthetic */ WalletCardImportUI puv;

    WalletCardImportUI$8(WalletCardImportUI walletCardImportUI) {
        this.puv = walletCardImportUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.puv.dismissDialog(1);
        int intValue = ((Integer) WalletCardImportUI.c(this.puv).bOF().get(i)).intValue();
        if (WalletCardImportUI.f(this.puv) != intValue) {
            WalletCardImportUI.a(this.puv, intValue);
            WalletCardImportUI.g(this.puv).setText(((CheckedTextView) view).getText().toString());
            WalletCardImportUI.c(WalletCardImportUI.h(this.puv), WalletCardImportUI.f(this.puv));
            WalletCardImportUI.h(this.puv).bqn();
            WalletCardImportUI.i(this.puv);
        }
    }
}
