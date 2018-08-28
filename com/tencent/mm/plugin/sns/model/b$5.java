package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.storage.av;

class b$5 implements Runnable {
    final /* synthetic */ b nmL;
    final /* synthetic */ ate nmM;
    final /* synthetic */ int nmN;
    final /* synthetic */ e nmO;
    final /* synthetic */ av nmP;

    b$5(b bVar, ate ate, int i, e eVar, av avVar) {
        this.nmL = bVar;
        this.nmM = ate;
        this.nmN = i;
        this.nmO = eVar;
        this.nmP = avVar;
    }

    public final void run() {
        av.Mu(this.nmM.ksA);
        b.a(this.nmL, this.nmM, this.nmN, this.nmO, this.nmP, null, null);
    }
}
