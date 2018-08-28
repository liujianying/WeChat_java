package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

final class k$d implements Runnable {
    final /* synthetic */ k isL;
    private long isO = -1;

    public k$d(k kVar, long j) {
        this.isL = kVar;
        Assert.assertTrue(j >= 0);
        this.isO = j;
    }

    public final void run() {
        x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[]{Long.valueOf(this.isO)});
        k.a(this.isL).obtainMessage(0, Long.valueOf(this.isO)).sendToTarget();
    }
}
