package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.plugin.chatroom.d.i;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.b.b;

class d$2 extends c<jy> {
    final /* synthetic */ d hKI;

    d$2(d dVar) {
        this.hKI = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, l lVar, b bVar) {
        return (jy) bVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jy jyVar = (jy) bVar;
        if (jyVar.bUc.bTN) {
            c.k(jyVar);
        } else {
            l(jyVar);
        }
        return false;
    }

    public final /* synthetic */ l b(b bVar) {
        jy jyVar = (jy) bVar;
        return new i(jyVar.bUc.chatroomName, jyVar.bUc.bUd);
    }

    public final int aAu() {
        return 551;
    }
}
