package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.rv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class al$2 extends c<rv> {
    final /* synthetic */ al tSY;

    al$2(al alVar) {
        this.tSY = alVar;
        this.sFo = rv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rv rvVar = (rv) bVar;
        if (rvVar instanceof rv) {
            String str = rvVar.ccL.id;
            int i = rvVar.ccL.ret;
            new ag().postDelayed(new 1(this, i, str), (long) (i == 5 ? 2000 : 0));
        }
        return false;
    }
}
