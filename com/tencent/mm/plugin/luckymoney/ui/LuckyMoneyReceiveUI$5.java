package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyReceiveUI$5 implements OnClickListener {
    final /* synthetic */ LuckyMoneyReceiveUI kXr;

    LuckyMoneyReceiveUI$5(LuckyMoneyReceiveUI luckyMoneyReceiveUI) {
        this.kXr = luckyMoneyReceiveUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.kXr.mController.tml, LuckyMoneyDetailUI.class);
        intent.putExtra("key_native_url", LuckyMoneyReceiveUI.d(this.kXr).ceR);
        intent.putExtra("key_sendid", LuckyMoneyReceiveUI.d(this.kXr).kLZ);
        this.kXr.startActivity(intent);
        this.kXr.finish();
    }
}
