package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class LuckyMoneyMyRecordUI$4 implements OnItemLongClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI kVL;

    LuckyMoneyMyRecordUI$4(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.kVL = luckyMoneyMyRecordUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i > 0 && i <= LuckyMoneyMyRecordUI.f(this.kVL).getCount()) {
            h.a(this.kVL, this.kVL.getResources().getString(i.lucky_money_list_delete_record), null, this.kVL.getResources().getString(i.app_delete), new 1(this, i - 1));
        }
        return true;
    }
}
