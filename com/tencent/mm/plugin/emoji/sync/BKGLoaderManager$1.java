package com.tencent.mm.plugin.emoji.sync;

import android.net.TrafficStats;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class BKGLoaderManager$1 implements a {
    final /* synthetic */ BKGLoaderManager ijK;

    BKGLoaderManager$1(BKGLoaderManager bKGLoaderManager) {
        this.ijK = bKGLoaderManager;
    }

    public final boolean vD() {
        if (this.ijK.ijs || this.ijK.ijt || this.ijK.iju) {
            long uidTxBytes = TrafficStats.getUidTxBytes(this.ijK.dTp);
            long uidRxBytes = TrafficStats.getUidRxBytes(this.ijK.dTp);
            long j = (uidTxBytes - this.ijK.ijF) + (uidRxBytes - this.ijK.ijG);
            x.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j / 1024));
            if (j <= 20480) {
                this.ijK.aEV();
            } else {
                this.ijK.ijF = uidTxBytes;
                this.ijK.ijG = uidRxBytes;
                this.ijK.ijH.J(1000, 1000);
            }
        }
        return false;
    }
}
