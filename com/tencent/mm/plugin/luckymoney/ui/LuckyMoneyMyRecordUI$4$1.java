package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.4;
import com.tencent.mm.ui.base.h.c;

class LuckyMoneyMyRecordUI$4$1 implements c {
    final /* synthetic */ int kVN;
    final /* synthetic */ 4 kVO;

    LuckyMoneyMyRecordUI$4$1(4 4, int i) {
        this.kVO = 4;
        this.kVN = i;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                i sm = LuckyMoneyMyRecordUI.f(this.kVO.kVL).sm(this.kVN);
                if (sm != null) {
                    LuckyMoneyMyRecordUI.b(this.kVO.kVL, this.kVN);
                    LuckyMoneyMyRecordUI.a(this.kVO.kVL, sm, this.kVN);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
