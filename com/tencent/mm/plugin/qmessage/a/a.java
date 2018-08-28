package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.aq.l;
import com.tencent.mm.g.a.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

final class a extends c<af> {
    a() {
        this.sFo = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            x.f("MicroMsg.QMsg.EventListener", "not bind qq event");
        } else if (afVar.bHo.bHq == 0) {
            try {
                int GQ = q.GQ() | 32;
                au.HU();
                com.tencent.mm.model.c.DT().set(34, Integer.valueOf(GQ));
                au.HU();
                com.tencent.mm.model.c.FQ().b(new l("", "", "", "", "", "", "", "", GQ, "", ""));
                g.boe();
                x.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QMsg.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
