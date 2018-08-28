package com.tencent.mm.plugin.luckymoney.ui;

class LuckyMoneyAutoScrollView$1 implements Runnable {
    final /* synthetic */ LuckyMoneyAutoScrollView kUf;

    LuckyMoneyAutoScrollView$1(LuckyMoneyAutoScrollView luckyMoneyAutoScrollView) {
        this.kUf = luckyMoneyAutoScrollView;
    }

    public final void run() {
        LuckyMoneyAutoScrollView.a(this.kUf).bbl();
        LuckyMoneyAutoScrollView.b(this.kUf).bbl();
        LuckyMoneyAutoScrollView.c(this.kUf).bbl();
    }
}
