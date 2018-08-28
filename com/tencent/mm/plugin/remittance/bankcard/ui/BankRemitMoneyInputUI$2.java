package com.tencent.mm.plugin.remittance.bankcard.ui;

class BankRemitMoneyInputUI$2 implements Runnable {
    final /* synthetic */ BankRemitMoneyInputUI mwj;
    final /* synthetic */ int mwk;

    BankRemitMoneyInputUI$2(BankRemitMoneyInputUI bankRemitMoneyInputUI, int i) {
        this.mwj = bankRemitMoneyInputUI;
        this.mwk = i;
    }

    public final void run() {
        BankRemitMoneyInputUI.g(this.mwj).scrollBy(0, this.mwk);
    }
}
