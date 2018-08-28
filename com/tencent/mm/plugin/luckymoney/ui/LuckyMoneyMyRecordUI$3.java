package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyMyRecordUI$3 implements OnItemClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI kVL;

    LuckyMoneyMyRecordUI$3(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.kVL = luckyMoneyMyRecordUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 3;
        int i3 = (int) j;
        h.mEJ.h(11701, Integer.valueOf(LuckyMoneyMyRecordUI.e(this.kVL)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
        if (i3 >= 0 && i3 < LuckyMoneyMyRecordUI.f(this.kVL).getCount()) {
            i sm = LuckyMoneyMyRecordUI.f(this.kVL).sm(i3);
            if (sm != null && !bi.oW(sm.kLZ)) {
                Intent intent = new Intent();
                if (sm.kQd == 2) {
                    x.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                    intent.setClass(this.kVL.mController.tml, LuckyMoneyBusiDetailUI.class);
                } else {
                    x.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
                    intent.setClass(this.kVL.mController.tml, LuckyMoneyDetailUI.class);
                }
                intent.putExtra("key_sendid", sm.kLZ);
                if (LuckyMoneyMyRecordUI.a(this.kVL) != 1) {
                    i2 = 1;
                }
                intent.putExtra("key_jump_from", i2);
                this.kVL.startActivity(intent);
            }
        }
    }
}
