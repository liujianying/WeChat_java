package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.bg.d.a;
import com.tencent.mm.ui.chatting.b.b.h;

class n$1 implements a {
    final /* synthetic */ com.tencent.mm.ui.chatting.c.a tIQ;

    n$1(com.tencent.mm.ui.chatting.c.a aVar) {
        this.tIQ = aVar;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        h hVar = (h) this.tIQ.O(h.class);
        if (-1 == i2 && hVar != null && hVar.cuS()) {
            hVar.cuQ();
        }
    }
}
