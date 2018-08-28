package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class LuckyMoneyPrepareUI$15 implements OnClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$15(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setClass(this.kWX.mController.tml, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", 1);
        this.kWX.startActivity(intent);
    }
}
