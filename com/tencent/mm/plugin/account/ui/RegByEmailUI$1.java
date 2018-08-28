package com.tencent.mm.plugin.account.ui;

class RegByEmailUI$1 implements Runnable {
    final /* synthetic */ RegByEmailUI eUG;

    RegByEmailUI$1(RegByEmailUI regByEmailUI) {
        this.eUG = regByEmailUI;
    }

    public final void run() {
        RegByEmailUI.a(this.eUG).requestFocus();
    }
}
