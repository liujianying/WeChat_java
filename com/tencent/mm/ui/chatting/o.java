package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.s.b;

public final class o {
    public a bAG;
    public long[] tIX = null;

    public o(a aVar, long[] jArr) {
        this.bAG = aVar;
        this.tIX = jArr;
        this.bAG.tTq.removeAllOptionMenu();
        this.bAG.tTq.addTextOptionMenu$7df2a0ca(2, this.bAG.tTq.getMMResources().getString(R.l.biz_report_confirm), new 1(this), null, b.tmX);
        g gVar = (g) this.bAG.O(g.class);
        gVar.c(new 2(this, gVar));
    }
}
