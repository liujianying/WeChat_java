package com.tencent.mm.plugin.account.ui;

class RegSetInfoUI$14 implements Runnable {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$14(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final void run() {
        RegSetInfoUI.a(this.eWJ).clearFocus();
        RegSetInfoUI.a(this.eWJ).requestFocus();
    }
}
