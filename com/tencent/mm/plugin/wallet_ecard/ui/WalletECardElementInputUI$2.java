package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletECardElementInputUI$2 implements OnClickListener {
    final /* synthetic */ WalletECardElementInputUI pCt;

    WalletECardElementInputUI$2(WalletECardElementInputUI walletECardElementInputUI) {
        this.pCt = walletECardElementInputUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", new Object[]{WalletECardElementInputUI.b(this.pCt).lMV});
        this.pCt.cDL().m(new Object[]{WalletECardElementInputUI.b(this.pCt)});
    }
}
