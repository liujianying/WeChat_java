package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.storage.av;

class b$6 implements Runnable {
    final /* synthetic */ b nmL;
    final /* synthetic */ ate nmM;
    final /* synthetic */ int nmN = 8;
    final /* synthetic */ e nmO;
    final /* synthetic */ av nmP;
    final /* synthetic */ String nmQ;
    final /* synthetic */ String nmR;

    b$6(b bVar, ate ate, e eVar, av avVar, String str, String str2) {
        this.nmL = bVar;
        this.nmM = ate;
        this.nmO = eVar;
        this.nmP = avVar;
        this.nmQ = str;
        this.nmR = str2;
    }

    public final void run() {
        av.Mu(this.nmM.ksA);
        b.a(this.nmL, this.nmM, this.nmN, this.nmO, this.nmP, this.nmQ, this.nmR);
    }
}
