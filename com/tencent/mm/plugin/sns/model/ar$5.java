package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.bi;

class ar$5 implements Runnable {
    final /* synthetic */ Object[] dPE;
    final /* synthetic */ ar nrO;
    final /* synthetic */ String nrP;

    public ar$5(ar arVar, String str, Object[] objArr) {
        this.nrO = arVar;
        this.nrP = str;
        this.dPE = objArr;
    }

    public final void run() {
        o.Tb().k(this.nrP, this.dPE);
        if (this.nrO.nrJ != null && bi.fS(this.nrO.nrJ.elz, this.nrP)) {
            ar.a(this.nrO);
        }
        this.nrO.nrK.remove((ay) this.nrO.nrL.get(this.nrP));
    }
}
