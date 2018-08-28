package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.ui.m$a;

class CollectMainUI$16 implements m$a {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$16(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final void aCb() {
        Intent intent = new Intent();
        intent.setClass(this.hYN.mController.tml, CollectCreateQRCodeUI.class);
        intent.putExtra("key_currency_unit", this.hYN.hYi);
        this.hYN.startActivityForResult(intent, 4096);
    }
}
