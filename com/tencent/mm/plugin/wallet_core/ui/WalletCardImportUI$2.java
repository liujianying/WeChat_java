package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.a;

class WalletCardImportUI$2 implements OnClickListener {
    final /* synthetic */ WalletCardImportUI puv;

    WalletCardImportUI$2(WalletCardImportUI walletCardImportUI) {
        this.puv = walletCardImportUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_support_bankcard", this.puv.sy.getInt("key_support_bankcard", 3));
        bundle.putString("key_bank_type", WalletCardImportUI.c(this.puv).lMV);
        bundle.putInt("key_bankcard_type", WalletCardImportUI.c(this.puv).pnt);
        a.af(this.puv).a(this.puv, WalletCardSelectUI.class, bundle, 1);
    }
}
