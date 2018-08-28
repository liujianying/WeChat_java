package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.p.10;

class p$10$4 implements c {
    final /* synthetic */ 10 tJn;

    p$10$4(10 10) {
        this.tJn = 10;
    }

    public final void ju(int i) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                h.mEJ.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3)});
                intent.putExtra("key_username", this.tJn.tJl.getTalkerUserName());
                intent.putExtra("key_way", 0);
                intent.putExtra("pay_channel", 11);
                d.b(p.e(this.tJn.tJl).tTq.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearSendUI", intent);
                return;
            case 1:
                h.mEJ.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
                intent.putExtra("key_way", 0);
                intent.putExtra("key_type", 0);
                intent.putExtra("key_from", 1);
                intent.putExtra("key_username", this.tJn.tJl.getTalkerUserName());
                intent.putExtra("pay_channel", 11);
                d.b(p.e(this.tJn.tJl).tTq.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                return;
            default:
                return;
        }
    }
}
