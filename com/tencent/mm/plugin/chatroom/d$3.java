package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.b.b;

class d$3 extends c<jx> {
    final /* synthetic */ d hKI;

    d$3(d dVar) {
        this.hKI = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, l lVar, b bVar) {
        jx jxVar = (jx) bVar;
        jxVar.bUa.errCode = i;
        return jxVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jx jxVar = (jx) bVar;
        if (jxVar.bTZ.bTN) {
            c.k(jxVar);
        } else {
            l(jxVar);
        }
        return false;
    }

    public final /* synthetic */ l b(b bVar) {
        jx jxVar = (jx) bVar;
        return new g(jxVar.bTZ.chatroomName, jxVar.bTZ.bUb, jxVar.bTZ.scene);
    }

    public final int aAu() {
        return 179;
    }
}
