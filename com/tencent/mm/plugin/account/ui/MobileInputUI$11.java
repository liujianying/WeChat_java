package com.tencent.mm.plugin.account.ui;

class MobileInputUI$11 implements Runnable {
    final /* synthetic */ int aEe;
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$11(MobileInputUI mobileInputUI, int i) {
        this.eTe = mobileInputUI;
        this.aEe = i;
    }

    public final void run() {
        MobileInputUI.h(this.eTe).smoothScrollBy(0, this.aEe);
    }
}
