package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.g.a.a.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;

class b$a$1 extends c<lw> {
    final /* synthetic */ a qCc;

    b$a$1(a aVar) {
        this.qCc = aVar;
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (g.Eg().Dx()) {
            g.Eg();
            if (!com.tencent.mm.kernel.a.Dr()) {
                long VE = bi.VE();
                long a = bi.a((Long) g.Ei().DT().get(aa.a.sRH, null), 0);
                if (a != 0 && a < VE) {
                    p.atx();
                }
            }
        }
        return false;
    }
}
