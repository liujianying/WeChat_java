package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.aq.p;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bw;

public final class d implements c, i {
    ah lbT;
    br lbU;
    be lbV;
    aj lbW;
    p lbX;
    bm lbY;
    am lbZ;
    au lca;
    as lcb;
    bb lcc;
    bp lcd;
    bw lce;

    public final /* synthetic */ g FQ() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lbX;
    }

    public final /* synthetic */ ay FR() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lbT;
    }

    public final /* synthetic */ k FS() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lbU;
    }

    public final /* synthetic */ az FW() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lbW;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.i FZ() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lbY;
    }

    public final /* synthetic */ b Gx() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lbZ;
    }

    public final /* synthetic */ j bcU() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lcd;
    }

    public final /* synthetic */ e bcV() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lcc;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.c bcW() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lcb;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.d bcX() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lca;
    }

    public final /* synthetic */ f bcY() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.lbV;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
    }

    public final void onAccountRelease() {
        if (this.lbT != null) {
            ah ahVar = this.lbT;
            ahVar.tas.clear();
            ahVar.tat.clear();
        }
        if (this.lbX != null) {
            p pVar = this.lbX;
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(681, pVar);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(806, pVar);
        }
    }
}
