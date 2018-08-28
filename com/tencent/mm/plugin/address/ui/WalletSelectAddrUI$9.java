package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.g.a.ju;

class WalletSelectAddrUI$9 implements Runnable {
    final /* synthetic */ WalletSelectAddrUI fae;
    final /* synthetic */ ju fah;

    WalletSelectAddrUI$9(WalletSelectAddrUI walletSelectAddrUI, ju juVar) {
        this.fae = walletSelectAddrUI;
        this.fah = juVar;
    }

    public final void run() {
        WalletSelectAddrUI.j(this.fae).post(new 1(this));
    }
}
