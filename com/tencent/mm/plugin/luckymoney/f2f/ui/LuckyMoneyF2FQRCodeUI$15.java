package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;

class LuckyMoneyF2FQRCodeUI$15 implements OnClickListener {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$15(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.kOv, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_from", 2);
        this.kOv.startActivity(intent);
    }
}
