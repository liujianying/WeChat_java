package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.aq.l;
import com.tencent.mm.g.a.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

final class b extends c<af> {
    b() {
        this.sFo = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            x.f("MicroMsg.QQMail.EventListener", "not bind qq event");
        } else if (afVar.bHo.bHq == 0) {
            try {
                au.HU();
                com.tencent.mm.model.c.DT().set(17, Integer.valueOf(2));
                int GQ = q.GQ() | 1;
                au.HU();
                com.tencent.mm.model.c.DT().set(34, Integer.valueOf(GQ));
                au.HU();
                com.tencent.mm.model.c.FQ().b(new l("", "", "", "", "", "", "", "", GQ, "", ""));
                w.boy();
                x.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QQMail.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
