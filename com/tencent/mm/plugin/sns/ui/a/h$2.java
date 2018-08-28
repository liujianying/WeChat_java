package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.bi;

class h$2 implements f {
    final /* synthetic */ int eaH;
    final /* synthetic */ ak nUY;
    final /* synthetic */ long nVa;
    final /* synthetic */ boolean nje;
    final /* synthetic */ av okj;
    final /* synthetic */ h okk;

    h$2(h hVar, av avVar, long j, boolean z, int i, ak akVar) {
        this.okk = hVar;
        this.okj = avVar;
        this.nVa = j;
        this.nje = z;
        this.eaH = i;
        this.nUY = akVar;
    }

    public final void b(b bVar, long j) {
        if (this.okj != null && this.okj.obV != null && this.okj.obV.nLJ != null) {
            int bvL = (int) bVar.bvL();
            this.okj.obV.nLJ.b(this.nVa, bi.VG(), this.nje);
            this.okj.obV.nLJ.d(this.nVa, bvL, this.nje);
            this.okj.obV.nLJ.z(this.nVa, this.nVa + ((long) this.eaH));
            this.nUY.neL.setOnDecodeDurationListener(null);
        }
    }
}
