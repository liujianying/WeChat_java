package com.tencent.mm.plugin.account.ui;

class RegSetInfoUI$12 implements Runnable {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$12(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final void run() {
        RegSetInfoUI.i(this.eWJ).requestFocus();
        RegSetInfoUI.b(this.eWJ).clearFocus();
    }
}
