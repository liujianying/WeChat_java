package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyBusiReceiveUI$4 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiReceiveUI kUO;

    LuckyMoneyBusiReceiveUI$4(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        this.kUO = luckyMoneyBusiReceiveUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
        if (LuckyMoneyBusiReceiveUI.f(this.kUO).isChecked()) {
            h.mEJ.h(13050, new Object[]{Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.kUO)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(this.kUO).kQN});
        } else {
            h.mEJ.h(13050, new Object[]{Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.kUO)), Integer.valueOf(2), ""});
        }
        LuckyMoneyBusiReceiveUI.i(this.kUO);
    }
}
