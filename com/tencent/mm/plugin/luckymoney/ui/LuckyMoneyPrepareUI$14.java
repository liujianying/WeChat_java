package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;

class LuckyMoneyPrepareUI$14 implements Runnable {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$14(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setClass(this.kWX.mController.tml, LuckyMoneyIndexUI.class);
        intent.addFlags(67108864);
        this.kWX.mController.tml.startActivity(intent);
        this.kWX.finish();
    }
}
