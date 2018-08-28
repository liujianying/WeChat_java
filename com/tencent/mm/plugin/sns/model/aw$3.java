package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.aw.a;
import com.tencent.mm.sdk.platformtools.x;

class aw$3 implements Runnable {
    final /* synthetic */ boolean dSv;
    final /* synthetic */ aw nsc;
    final /* synthetic */ int nsd;

    aw$3(aw awVar, int i, boolean z) {
        this.nsc = awVar;
        this.nsd = i;
        this.dSv = z;
    }

    public final void run() {
        if (af.bxX()) {
            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            return;
        }
        for (a aVar : aw.c(this.nsc)) {
            if (aVar != null) {
                aVar.Q(this.nsd, this.dSv);
            }
        }
    }
}
