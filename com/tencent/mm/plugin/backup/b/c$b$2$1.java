package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b.2;
import com.tencent.mm.plugin.backup.f.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class c$b$2$1 implements Runnable {
    final /* synthetic */ c gSE;
    final /* synthetic */ long gSF;
    final /* synthetic */ 2 gSG;

    c$b$2$1(2 2, c cVar, long j) {
        this.gSG = 2;
        this.gSE = cVar;
        this.gSF = j;
    }

    public final String toString() {
        return this.gSG.gSD.TAG + ".sendFile";
    }

    public final void run() {
        Assert.assertTrue(toString() + ", check running. ", this.gSG.gSD.ftu);
        long VF = bi.VF();
        this.gSE.ass();
        long VF2 = bi.VF();
        x.i(this.gSG.gSD.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", Integer.valueOf(this.gSE.asz()), Long.valueOf(VF2 - this.gSF), Long.valueOf(VF2 - VF), this.gSE.gXK.hcI);
    }
}
