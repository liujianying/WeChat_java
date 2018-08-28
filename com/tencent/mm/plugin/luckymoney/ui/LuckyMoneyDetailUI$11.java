package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyDetailUI$11 implements OnClickListener {
    final /* synthetic */ f kUy;
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$11(LuckyMoneyDetailUI luckyMoneyDetailUI, f fVar) {
        this.kVo = luckyMoneyDetailUI;
        this.kUy = fVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.sl(this.kUy.kQd)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
        o.a(this.kVo, 1, false);
    }
}
