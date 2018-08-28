package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    long beginTime;
    long btT;
    boolean ceW;
    long ejJ;
    long ejK;
    long endTime;
    int rtType;

    public h(int i, boolean z, long j) {
        this.rtType = i;
        this.ceW = z;
        this.ejJ = j;
        this.ejK = 0;
    }

    public final void Sa() {
        if (this.ejK == 0) {
            this.beginTime = bi.VF();
            this.btT = bi.VG();
        }
        this.ejK++;
    }

    public final void bz(long j) {
        if (this.ejJ == 0) {
            this.ejJ = j;
        }
        this.btT = bi.VG() - this.btT;
        this.endTime = bi.VF();
        x.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.ejJ + " Count:" + this.ejK + " type:" + this.rtType);
        WatchDogPushReceiver.a(this);
    }
}
