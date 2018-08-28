package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements c, com.tencent.mm.plugin.zero.b.b {
    private bu qxB;
    private p qxC;

    public final p PM() {
        g.Ek();
        g.Eg().Ds();
        if (this.qxC == null) {
            this.qxC = new p();
        }
        return this.qxC;
    }

    public final bu cbe() {
        g.Ek();
        g.Eg().Ds();
        if (this.qxB == null) {
            this.qxB = new bu(new a() {
                public final boolean IQ() {
                    return b.this.PM().eaw == null;
                }
            });
        }
        return this.qxB;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
        if (this.qxC != null) {
            p pVar = this.qxC;
            x.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[]{Integer.valueOf(pVar.eat.size()), Integer.valueOf(pVar.eau.size()), pVar.eaw});
            pVar.eat.clear();
            pVar.eau.clear();
        }
        if (this.qxB != null) {
            this.qxB.IL();
        }
    }
}
