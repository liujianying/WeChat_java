package com.tencent.mm.plugin.luckymoney.ui;

class LuckyMoneyAutoScrollView$2 implements Runnable {
    final /* synthetic */ LuckyMoneyAutoScrollView kUf;

    LuckyMoneyAutoScrollView$2(LuckyMoneyAutoScrollView luckyMoneyAutoScrollView) {
        this.kUf = luckyMoneyAutoScrollView;
    }

    public final void run() {
        LuckyMoneyAutoScrollView.a(this.kUf).setVisibility(8);
        LuckyMoneyAutoScrollView.b(this.kUf).setVisibility(8);
        LuckyMoneyAutoScrollView.c(this.kUf).setVisibility(8);
        LuckyMoneyAutoScrollView.d(this.kUf).setVisibility(0);
        LuckyMoneyAutoScrollView.e(this.kUf).setVisibility(0);
        LuckyMoneyAutoScrollView.f(this.kUf).setVisibility(0);
        if (LuckyMoneyAutoScrollView.g(this.kUf) != null) {
            LuckyMoneyAutoScrollView.g(this.kUf).bbn();
        }
    }
}
