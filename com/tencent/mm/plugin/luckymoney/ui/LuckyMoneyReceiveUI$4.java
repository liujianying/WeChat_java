package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyReceiveUI$4 implements OnClickListener {
    final /* synthetic */ LuckyMoneyReceiveUI kXr;
    final /* synthetic */ boolean kXs;

    LuckyMoneyReceiveUI$4(LuckyMoneyReceiveUI luckyMoneyReceiveUI, boolean z) {
        this.kXr = luckyMoneyReceiveUI;
        this.kXs = z;
    }

    public final void onClick(View view) {
        if (this.kXs) {
            h.mEJ.h(11701, new Object[]{Integer.valueOf(6), Integer.valueOf(LuckyMoneyReceiveUI.so(LuckyMoneyReceiveUI.d(this.kXr).kPI)), Integer.valueOf(LuckyMoneyReceiveUI.e(this.kXr)), Integer.valueOf(0), Integer.valueOf(1)});
        }
        Intent intent = new Intent();
        intent.setClass(this.kXr.mController.tml, LuckyMoneyDetailUI.class);
        intent.putExtra("key_native_url", LuckyMoneyReceiveUI.d(this.kXr).ceR);
        intent.putExtra("key_sendid", LuckyMoneyReceiveUI.d(this.kXr).kLZ);
        this.kXr.startActivity(intent);
        this.kXr.finish();
    }
}
