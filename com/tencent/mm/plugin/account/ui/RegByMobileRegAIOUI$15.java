package com.tencent.mm.plugin.account.ui;

class RegByMobileRegAIOUI$15 implements Runnable {
    final /* synthetic */ int aEe;
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$15(RegByMobileRegAIOUI regByMobileRegAIOUI, int i) {
        this.eVb = regByMobileRegAIOUI;
        this.aEe = i;
    }

    public final void run() {
        RegByMobileRegAIOUI.w(this.eVb).smoothScrollBy(0, this.aEe);
    }
}
