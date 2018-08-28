package com.tencent.mm.plugin.account.ui;

class LoginUI$11 implements Runnable {
    final /* synthetic */ int aEe;
    final /* synthetic */ LoginUI eSk;

    LoginUI$11(LoginUI loginUI, int i) {
        this.eSk = loginUI;
        this.aEe = i;
    }

    public final void run() {
        LoginUI.h(this.eSk).smoothScrollBy(0, this.aEe);
    }
}
