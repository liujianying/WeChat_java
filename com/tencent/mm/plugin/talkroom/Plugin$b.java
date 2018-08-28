package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.rn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$b extends c<rn> {
    private Plugin$b() {
        this.sFo = rn.class.getName().hashCode();
    }

    /* synthetic */ Plugin$b(byte b) {
        this();
        this.sFo = rn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rn rnVar = (rn) bVar;
        if (rnVar != null) {
            if (!(rnVar instanceof rn)) {
                x.f("MicroMsg.TalkRoomServerListener", "mismatch %s", rnVar.getClass().getName());
            } else if (rnVar.ccn.ccq) {
                com.tencent.mm.plugin.talkroom.model.b.bGT().aZL();
                return true;
            } else if (!(!rnVar.ccn.ccp || rnVar.cco == null || com.tencent.mm.plugin.talkroom.model.b.bGT() == null)) {
                rnVar.cco.ccr = com.tencent.mm.plugin.talkroom.model.b.bGT().owU;
                return true;
            }
        }
        return false;
    }
}
