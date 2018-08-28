package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

class WalletECardElementInputUI$1 implements OnClickListener {
    final /* synthetic */ WalletECardElementInputUI pCt;

    WalletECardElementInputUI$1(WalletECardElementInputUI walletECardElementInputUI) {
        this.pCt = walletECardElementInputUI;
    }

    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_support_bankcard", this.pCt.sy.getInt("key_support_bankcard", 3));
        bundle.putInt("key_bind_scene", this.pCt.sy.getInt("key_bind_scene", -1));
        if (!bi.oW(WalletECardElementInputUI.a(this.pCt).getText())) {
            bundle.putString("key_bank_type", WalletECardElementInputUI.b(this.pCt).lMV);
            bundle.putInt("key_bankcard_type", WalletECardElementInputUI.b(this.pCt).pnt);
        }
        c af = a.af(this.pCt);
        if (af != null) {
            af.a(this.pCt, WalletCardSelectUI.class, bundle, 1);
        }
    }
}
