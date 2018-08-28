package com.tencent.mm.wallet_core.ui;

import android.view.View;

class WalletBaseUI$2 implements Runnable {
    final /* synthetic */ View kwh;
    final /* synthetic */ int mwk;
    final /* synthetic */ WalletBaseUI uYT;

    WalletBaseUI$2(WalletBaseUI walletBaseUI, View view, int i) {
        this.uYT = walletBaseUI;
        this.kwh = view;
        this.mwk = i;
    }

    public final void run() {
        this.kwh.scrollBy(0, this.mwk);
    }
}
