package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.x;

class ar$6 implements Runnable {
    final /* synthetic */ ar nrO;
    final /* synthetic */ ay nrQ;
    final /* synthetic */ boolean nrR;

    ar$6(ar arVar, ay ayVar, boolean z) {
        this.nrO = arVar;
        this.nrQ = ayVar;
        this.nrR = z;
    }

    public final void run() {
        n Nl = af.byo().Nl(this.nrQ.bKW);
        this.nrQ.nsF = Nl != null ? Nl.field_userName : "";
        x.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[]{Boolean.valueOf(this.nrR), this.nrQ});
        if (this.nrR) {
            this.nrO.nrK.offerFirst(this.nrQ);
        } else {
            this.nrO.nrK.offerLast(this.nrQ);
        }
        this.nrO.nrL.put(this.nrQ.elz, this.nrQ);
    }
}
