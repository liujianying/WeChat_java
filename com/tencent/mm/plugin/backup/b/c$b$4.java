package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import junit.framework.Assert;

class c$b$4 implements Runnable {
    final /* synthetic */ b gSD;

    c$b$4(b bVar) {
        this.gSD = bVar;
    }

    public final String toString() {
        return this.gSD.TAG + ".sendTag";
    }

    public final void run() {
        Assert.assertTrue(toString() + ", check running. ", this.gSD.ftu);
        int i;
        e aqP;
        switch (d.aqS()) {
            case 1:
                x.i(this.gSD.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[]{Integer.valueOf(this.gSD.gSo.gSi.aqP().gRD), Long.valueOf(this.gSD.gRJ), Long.valueOf(this.gSD.gRK), Integer.valueOf(this.gSD.gSw.size()), this.gSD.bgn, this.gSD.gSv, Long.valueOf(bi.bH(this.gSD.gSz))});
                if (this.gSD.gSo.gSi.aqP().gRD < this.gSD.gRH + 1) {
                    i = this.gSD.gSo.gSi.aqP().gRE;
                    aqP = this.gSD.gSo.gSi.aqP();
                    if (this.gSD.gRH + 1 <= i) {
                        i = this.gSD.gRH + 1;
                    }
                    aqP.gRD = i;
                    this.gSD.gSo.gSh.mw(this.gSD.gSo.gSi.aqP().gRC);
                    break;
                }
                break;
            case 21:
            case 22:
                x.i(this.gSD.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[]{Integer.valueOf(this.gSD.gSo.gSi.aqP().gRD), Long.valueOf(this.gSD.gRJ), Long.valueOf(this.gSD.gRK), Integer.valueOf(this.gSD.gSw.size()), this.gSD.bgn, this.gSD.gSv, Long.valueOf(bi.bH(this.gSD.gSz))});
                if (this.gSD.gSo.gSi.aqP().gRD < this.gSD.gRH + 1) {
                    i = this.gSD.gSo.gSi.aqP().gRE;
                    aqP = this.gSD.gSo.gSi.aqP();
                    if (this.gSD.gRH + 1 <= i) {
                        i = this.gSD.gRH + 1;
                    }
                    aqP.gRD = i;
                    this.gSD.gSo.gSh.mw(this.gSD.gSo.gSi.aqP().gRC);
                    break;
                }
                break;
        }
        boolean z = this.gSD.gRH == this.gSD.gSo.gSi.aqP().gRE + -1;
        ae aeVar = new ae(!z);
        new com.tencent.mm.plugin.backup.f.d(this.gSD.talker, this.gSD.gRJ, this.gSD.gRK, this.gSD.gSv, this.gSD.bgn, new LinkedList(this.gSD.gSw), new 1(this, z, aeVar)).ass();
        if (z) {
            x.w(this.gSD.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[]{Integer.valueOf(this.gSD.gRH), Integer.valueOf(this.gSD.gSo.gSi.aqP().gRE - 1)});
            aeVar.block();
        }
        this.gSD.ftu = false;
    }
}
