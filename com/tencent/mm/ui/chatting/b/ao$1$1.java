package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.chatting.b.ao.1;
import com.tencent.mm.ui.chatting.b.b.g;

class ao$1$1 implements OnClickListener {
    final /* synthetic */ long tTk;
    final /* synthetic */ 1 tTl;

    ao$1$1(1 1, long j) {
        this.tTl = 1;
        this.tTk = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        au.HU();
        if (c.FT().P(au.getNotification().xQ(), this.tTk)) {
            int ctI = ((g) this.tTl.tTj.bAG.O(g.class)).ctI();
            int count = ((g) this.tTl.tTj.bAG.O(g.class)).getCount();
            au.HU();
            ctI = c.FT().c(au.getNotification().xQ(), this.tTk, ctI - count);
            if (ctI >= 0 && count > ctI) {
                this.tTl.tTj.bAG.EV(ctI);
            }
        }
    }
}
