package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyBusiDetailUI$6 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiDetailUI kUw;
    final /* synthetic */ f kUy;

    LuckyMoneyBusiDetailUI$6(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI, f fVar) {
        this.kUw = luckyMoneyBusiDetailUI;
        this.kUy = fVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(LuckyMoneyBusiDetailUI.sk(this.kUy.kQd)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
        Intent intent = new Intent();
        intent.setClass(this.kUw.mController.tml, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", 2);
        this.kUw.startActivity(intent);
    }
}
