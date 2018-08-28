package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.aq.l;
import com.tencent.mm.g.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

final class a extends c<af> {
    a() {
        this.sFo = af.class.getName().hashCode();
    }

    private boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            x.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
        } else if (afVar.bHo.bHq == 0) {
            try {
                int GQ = q.GQ() | 262144;
                g.Ei().DT().set(34, Integer.valueOf(GQ));
                bay bay = new bay();
                bay.raB = 262144;
                bay.sdm = 1;
                ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(39, bay));
                ((i) g.l(i.class)).FQ().b(new l("", "", "", "", "", "", "", "", GQ, "", ""));
                g.b(new com.tencent.mm.plugin.readerapp.c.g.a() {
                    public final void bpQ() {
                    }
                });
                g.Ei().DT().set(40, Integer.valueOf(q.GL() & -33));
                ((i) g.l(i.class)).FQ().b(new com.tencent.mm.aq.g(21, 2));
                x.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
