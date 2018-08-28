package com.tencent.mm.plugin.luckymoney.ui;

import android.os.CountDownTimer;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.1;

class LuckyMoneyAutoScrollItem$1$1 extends CountDownTimer {
    final /* synthetic */ 1 kTO;

    LuckyMoneyAutoScrollItem$1$1(1 1, long j) {
        this.kTO = 1;
        super(j, 50);
    }

    public final void onTick(long j) {
        this.kTO.kTN.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(this.kTO.kTN));
    }

    public final void onFinish() {
        if (this.kTO.kTN.kTK != null) {
            this.kTO.kTN.kTK.bbm();
        }
    }
}
