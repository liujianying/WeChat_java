package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.plugin.chatroom.d.f;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.b.b;

class d$5 extends c<jw> {
    final /* synthetic */ d hKI;

    d$5(d dVar) {
        this.hKI = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, l lVar, b bVar) {
        jw jwVar = (jw) bVar;
        f fVar = (f) lVar;
        jwVar.bTP.bTS = fVar.bTS;
        jwVar.bTP.bTT = fVar.bTT;
        jwVar.bTP.bTU = fVar.bTU;
        jwVar.bTP.bTV = fVar.hKV;
        jwVar.bTP.bTY = fVar.bTY;
        jwVar.bTP.bTW = fVar.bTW;
        jwVar.bTP.bTX = fVar.bTX;
        return jwVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jw jwVar = (jw) bVar;
        if (jwVar.bTO.bTN) {
            c.k(jwVar);
        } else {
            l(jwVar);
        }
        return false;
    }

    public final /* synthetic */ l b(b bVar) {
        jw jwVar = (jw) bVar;
        return new f(jwVar.bTO.bTQ, jwVar.bTO.bTR);
    }

    public final int aAu() {
        return 119;
    }
}
