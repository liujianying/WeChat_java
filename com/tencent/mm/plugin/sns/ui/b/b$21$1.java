package com.tencent.mm.plugin.sns.ui.b;

import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.b.b.21;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.storage.av;

class b$21$1 implements Runnable {
    final /* synthetic */ ate nmM;
    final /* synthetic */ ak olh;
    final /* synthetic */ n oli;
    final /* synthetic */ bsu olj;
    final /* synthetic */ boolean olk;
    final /* synthetic */ 21 oll;

    b$21$1(21 21, ate ate, ak akVar, n nVar, bsu bsu, boolean z) {
        this.oll = 21;
        this.nmM = ate;
        this.olh = akVar;
        this.oli = nVar;
        this.olj = bsu;
        this.olk = z;
    }

    public final void run() {
        if (af.byl().u(this.nmM)) {
            this.olh.neL.aO(null, false);
            g byl = af.byl();
            n nVar = this.oli;
            ate ate = this.nmM;
            a aVar = this.olh.neL;
            int hashCode = this.oll.olf.activity.hashCode();
            int i = this.olh.position;
            av clY = av.clY();
            clY.time = this.olj.lOH;
            byl.a(nVar, ate, aVar, hashCode, i, clY, this.olk);
            this.olh.nEI.setVisibility(0);
            this.olh.nRD.setVisibility(8);
            this.olh.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this.oll.olf.activity, i.shortvideo_play_btn));
        }
    }
}
