package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.qs;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<qs> {
    public n() {
        this.sFo = qs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qs qsVar = (qs) bVar;
        if (qsVar instanceof qs) {
            qsVar.cbl.bJm = a.a(qsVar.cbk.cbo, qsVar.cbk.url, qsVar.cbk.cbn);
            return true;
        }
        x.f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
        return false;
    }
}
