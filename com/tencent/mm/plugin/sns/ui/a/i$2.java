package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ui.av;

class i$2 implements e {
    final /* synthetic */ long nVa;
    final /* synthetic */ av okj;
    final /* synthetic */ i okq;

    i$2(i iVar, av avVar, long j) {
        this.okq = iVar;
        this.okj = avVar;
        this.nVa = j;
    }

    public final void d(b bVar, int i) {
        if (i != -1 && this.okj != null && this.okj.obV != null && this.okj.obV.nLJ != null) {
            this.okj.obV.nLJ.o(this.nVa, false);
        }
    }
}
