package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.storage.bd;

class al$1 implements a {
    final /* synthetic */ long ibH;
    final /* synthetic */ al tSY;

    al$1(al alVar, long j) {
        this.tSY = alVar;
        this.ibH = j;
    }

    public final boolean Ks() {
        return false;
    }

    public final boolean Kr() {
        au.HU();
        bd dW = c.FT().dW(this.ibH);
        dW.cmz();
        b.ehL.a(dW, true);
        au.HU();
        c.FT().a(this.ibH, dW);
        return false;
    }
}
