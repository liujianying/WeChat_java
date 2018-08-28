package com.tencent.mm.ak;

import android.net.TrafficStats;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b dTu;

    b$1(b bVar) {
        this.dTu = bVar;
    }

    public final boolean vD() {
        long uidRxBytes = TrafficStats.getUidRxBytes(this.dTu.dTp);
        long uidTxBytes = TrafficStats.getUidTxBytes(this.dTu.dTp);
        long j = (uidRxBytes - this.dTu.dTn) + (uidTxBytes - this.dTu.dTo);
        x.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + (j / 1024));
        if (j <= 20480) {
            this.dTu.dTm = false;
            this.dTu.start();
        } else {
            this.dTu.dTn = uidRxBytes;
            this.dTu.dTo = uidTxBytes;
            this.dTu.dTr.J(1000, 1000);
        }
        return true;
    }
}
