package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.4;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.d;

class LuckyMoneyIndexUI$4$1 implements d {
    final /* synthetic */ 4 kVt;

    LuckyMoneyIndexUI$4$1(4 4) {
        this.kVt = 4;
    }

    public final void bx(int i, int i2) {
        int i3 = 1;
        switch (i2) {
            case 1:
                h.mEJ.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6)});
                break;
            default:
                h.mEJ.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5)});
                i3 = 2;
                break;
        }
        Intent intent = new Intent();
        intent.setClass(this.kVt.kVs.mController.tml, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", i3);
        this.kVt.kVs.startActivity(intent);
    }
}
