package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;

class LuckyMoneyMyRecordUI$8 implements OnItemClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI kVL;
    final /* synthetic */ LuckyMoneyMyRecordUI$a kVP;

    LuckyMoneyMyRecordUI$8(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, LuckyMoneyMyRecordUI$a luckyMoneyMyRecordUI$a) {
        this.kVL = luckyMoneyMyRecordUI;
        this.kVP = luckyMoneyMyRecordUI$a;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kVL.dismissDialog(1);
        String jl = this.kVP.getItem(i);
        this.kVP.atr = i;
        if (!jl.equals(LuckyMoneyMyRecordUI.j(this.kVL))) {
            LuckyMoneyMyRecordUI.a(this.kVL, jl);
            LuckyMoneyMyRecordUI.k(this.kVL).setText(this.kVL.getString(i.lucky_money_record_year_title, new Object[]{LuckyMoneyMyRecordUI.j(this.kVL)}));
            LuckyMoneyMyRecordUI.l(this.kVL);
            LuckyMoneyMyRecordUI.m(this.kVL).clear();
            LuckyMoneyMyRecordUI.n(this.kVL).clear();
            LuckyMoneyMyRecordUI.d(this.kVL);
        }
        h.mEJ.h(11701, new Object[]{Integer.valueOf(LuckyMoneyMyRecordUI.e(this.kVL)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), jl});
    }
}
