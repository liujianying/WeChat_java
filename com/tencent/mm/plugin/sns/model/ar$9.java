package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.la;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class ar$9 extends c<la> {
    final /* synthetic */ ar nrO;

    ar$9(ar arVar) {
        this.nrO = arVar;
        this.sFo = la.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        la laVar = (la) bVar;
        if (this.nrO.nrJ != null && bi.fS(this.nrO.nrJ.elz, laVar.bVm.mediaId)) {
            if (laVar.bVm.retCode != 0) {
                this.nrO.byU();
            } else if (laVar.bVm.bOh == 4 || laVar.bVm.bOh == 6) {
                ar.a(this.nrO);
            }
        }
        return false;
    }
}
