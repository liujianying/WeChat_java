package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;

class ag$4 implements a {
    final /* synthetic */ ag tRZ;

    ag$4(ag agVar) {
        this.tRZ = agVar;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            eVar.stopSignalling();
        }
    }
}
