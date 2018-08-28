package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyBusiDetailUI$5 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiDetailUI kUw;
    final /* synthetic */ f kUy;

    LuckyMoneyBusiDetailUI$5(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI, f fVar) {
        this.kUw = luckyMoneyBusiDetailUI;
        this.kUy = fVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(LuckyMoneyBusiDetailUI.sk(this.kUy.kQd)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
        o.a(this.kUw, 1, false);
    }
}
