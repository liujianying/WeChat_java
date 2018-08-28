package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;

class ag$3 implements a {
    final /* synthetic */ ag tRZ;

    ag$3(ag agVar) {
        this.tRZ = agVar;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            eVar.keepSignalling();
        }
    }
}
