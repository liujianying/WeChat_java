package com.tencent.mm.plugin.record.b;

import com.tencent.mm.g.a.fz;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class k$c implements Runnable {
    private g mrL;
    final /* synthetic */ k msk;

    public k$c(k kVar, g gVar) {
        this.msk = kVar;
        this.mrL = gVar;
    }

    public final void run() {
        Iterator it = this.mrL.field_dataProto.rBI.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String c;
            vx vxVar = (vx) it.next();
            fz fzVar = new fz();
            fzVar.bOL.type = 2;
            fzVar.bOL.bON = vxVar;
            a.sFg.m(fzVar);
            x.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[]{vxVar.jdM, Integer.valueOf(vxVar.bjS)});
            if (!bi.oW(fzVar.bOM.path)) {
                c = h.c(vxVar, this.mrL.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[]{fzVar.bOM.path, c});
                if (!fzVar.bOM.path.equals(c)) {
                    j.q(fzVar.bOM.path, c, false);
                }
            }
            if (!bi.oW(fzVar.bOM.bOX)) {
                c = h.f(vxVar, this.mrL.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[]{fzVar.bOM.bOX, c});
                if (!fzVar.bOM.bOX.equals(c)) {
                    j.q(fzVar.bOM.bOX, c, false);
                }
            }
            if (vxVar.bjS == 3) {
                x.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
                vxVar.UG("");
                vxVar.UF("");
                vxVar.UE("");
                vxVar.UD("");
            }
            if (!bi.oW(vxVar.rzo) || !bi.oW(vxVar.dwE)) {
                z = true;
            }
        }
        if (z) {
            au.DF().a(new a(this.mrL), 0);
            return;
        }
        this.msk.c(this.mrL.field_msgId, this.mrL.field_localId, com.tencent.mm.y.g.a.a(h.a(this.mrL.field_title, this.mrL.field_desc, this.mrL.field_dataProto), null, null));
        this.msk.mrO = false;
        this.msk.a(null);
    }
}
