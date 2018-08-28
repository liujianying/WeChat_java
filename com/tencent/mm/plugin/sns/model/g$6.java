package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.g.b;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.x;

class g$6 implements Runnable {
    final /* synthetic */ ate nmM;
    final /* synthetic */ g nnr;
    final /* synthetic */ int nns;
    final /* synthetic */ String nny;
    final /* synthetic */ String nnz;

    g$6(g gVar, int i, ate ate, String str, String str2) {
        this.nnr = gVar;
        this.nns = i;
        this.nmM = ate;
        this.nny = str;
        this.nnz = str2;
    }

    public final void run() {
        while (g.e(this.nnr).size() >= 60) {
            this.nnr.nnp.remove(((b) g.e(this.nnr).removeFirst()).aAL);
        }
        x.i("MicroMsg.LazyerImageLoader2", "add loaderlist size:" + g.e(this.nnr).size());
        b bVar = new b(this.nnr, i.aE(this.nns, this.nmM.ksA), this.nny + this.nnz, this.nny, this.nmM, this.nns);
        if (g.f(this.nnr).bb(bVar.aAL)) {
            this.nnr.nnp.remove(bVar.aAL);
        } else {
            g.e(this.nnr).add(bVar);
        }
        g.g(this.nnr);
    }
}
