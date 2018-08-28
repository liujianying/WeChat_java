package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.g.a.rl;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<rl> {
    public n() {
        this.sFo = rl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rl rlVar = (rl) bVar;
        switch (rlVar.cci.opType) {
            case 0:
                a Lk = com.tencent.mm.plugin.shake.e.c.Lk(rlVar.cci.cck);
                if (Lk != null) {
                    rlVar.ccj.bWx = com.tencent.mm.plugin.shake.e.c.a(rlVar.cci.context, Lk);
                    rlVar.ccj.bOX = m.eq(Lk.field_thumburl, "@B");
                    rlVar.ccj.bJm = true;
                    break;
                }
                x.w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", new Object[]{rlVar.cci.cck});
                rlVar.ccj.bJm = false;
                break;
        }
        return false;
    }
}
