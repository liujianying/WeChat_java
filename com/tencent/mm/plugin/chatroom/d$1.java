package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.plugin.chatroom.d.e;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.b.b;

class d$1 extends c<jv> {
    final /* synthetic */ d hKI;

    d$1(d dVar) {
        this.hKI = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, l lVar, b bVar) {
        return (jv) bVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jv jvVar = (jv) bVar;
        if (jvVar.bTL.bTN) {
            c.k(jvVar);
        } else {
            l(jvVar);
        }
        return false;
    }

    public final /* synthetic */ l b(b bVar) {
        return new e(((jv) bVar).bTL.bTM);
    }

    public final int aAu() {
        return 181;
    }
}
