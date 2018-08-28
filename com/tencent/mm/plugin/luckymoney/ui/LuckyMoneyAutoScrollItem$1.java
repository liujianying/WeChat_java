package com.tencent.mm.plugin.luckymoney.ui;

class LuckyMoneyAutoScrollItem$1 implements Runnable {
    final /* synthetic */ long kTM;
    final /* synthetic */ LuckyMoneyAutoScrollItem kTN;

    LuckyMoneyAutoScrollItem$1(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem, long j) {
        this.kTN = luckyMoneyAutoScrollItem;
        this.kTM = j;
    }

    public final void run() {
        LuckyMoneyAutoScrollItem.a(this.kTN, new 1(this, this.kTM).start());
    }
}
