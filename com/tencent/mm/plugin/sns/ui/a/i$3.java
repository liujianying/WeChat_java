package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.bi;

class i$3 implements f {
    final /* synthetic */ c nMg;
    final /* synthetic */ long nVa;
    final /* synthetic */ av okj;
    final /* synthetic */ i okq;

    i$3(i iVar, av avVar, long j, c cVar) {
        this.okq = iVar;
        this.okj = avVar;
        this.nVa = j;
        this.nMg = cVar;
    }

    public final void b(b bVar, long j) {
        if (this.okj != null && this.okj.obV != null && this.okj.obV.nLJ != null) {
            int bvL = (int) bVar.bvL();
            this.okj.obV.nLJ.b(this.nVa, bi.VG(), false);
            this.okj.obV.nLJ.d(this.nVa, bvL, false);
            this.okj.obV.nLJ.z(this.nVa, this.nVa);
            this.nMg.ojH.neL.setOnDecodeDurationListener(null);
        }
    }
}
