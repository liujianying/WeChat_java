package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.sdk.platformtools.x;

class aw$5 implements Runnable {
    final /* synthetic */ aw nsc;
    final /* synthetic */ atf nse;
    final /* synthetic */ int nsk;
    final /* synthetic */ String nsl;
    final /* synthetic */ boolean nsm;
    final /* synthetic */ int nsn;

    aw$5(aw awVar, int i, String str, boolean z, atf atf, int i2) {
        this.nsc = awVar;
        this.nsk = i;
        this.nsl = str;
        this.nsm = z;
        this.nse = atf;
        this.nsn = i2;
    }

    public final void run() {
        if (af.bxX()) {
            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            return;
        }
        z zVar = new z(this.nsk, this.nsl, this.nsm, this.nsn);
        af.byn().du(this.nsk, zVar.hashCode());
        g.Ek();
        g.Eh().dpP.a(zVar, 0);
    }
}
