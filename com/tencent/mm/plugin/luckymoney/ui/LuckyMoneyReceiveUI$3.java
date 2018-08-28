package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyReceiveUI$3 implements OnClickListener {
    final /* synthetic */ LuckyMoneyReceiveUI kXr;

    LuckyMoneyReceiveUI$3(LuckyMoneyReceiveUI luckyMoneyReceiveUI) {
        this.kXr = luckyMoneyReceiveUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(LuckyMoneyReceiveUI.so(LuckyMoneyReceiveUI.d(this.kXr).kPI)), Integer.valueOf(LuckyMoneyReceiveUI.e(this.kXr)), Integer.valueOf(0), Integer.valueOf(2)});
        LuckyMoneyReceiveUI luckyMoneyReceiveUI = this.kXr;
        luckyMoneyReceiveUI.b(new ad(luckyMoneyReceiveUI.kRG.msgType, luckyMoneyReceiveUI.kRG.bxk, luckyMoneyReceiveUI.kRG.kLZ, luckyMoneyReceiveUI.kRG.ceR, o.baX(), q.GH(), luckyMoneyReceiveUI.getIntent().getStringExtra("key_username"), "v1.0", luckyMoneyReceiveUI.kRG.kRC), false);
        o.b(luckyMoneyReceiveUI.kMG);
    }
}
