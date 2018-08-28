package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.b.b;

class d$4 extends c<kc> {
    final /* synthetic */ d hKI;

    d$4(d dVar) {
        this.hKI = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, l lVar, b bVar) {
        kc kcVar = (kc) bVar;
        kcVar.bUt.errCode = i;
        return kcVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        kc kcVar = (kc) bVar;
        if (kcVar.bUs.bTN) {
            c.k(kcVar);
        } else {
            l(kcVar);
        }
        return false;
    }

    public final /* synthetic */ l b(b bVar) {
        kc kcVar = (kc) bVar;
        return new com.tencent.mm.plugin.chatroom.d.l(kcVar.bUs.bUu, kcVar.bUs.chatroomName);
    }

    public final int aAu() {
        return 700;
    }
}
