package com.tencent.mm.app;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.b.e;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$28 implements Runnable {
    final /* synthetic */ byte[] bAa;
    final /* synthetic */ WorkerProfile bzO;
    final /* synthetic */ int bzZ;

    WorkerProfile$28(WorkerProfile workerProfile, int i, byte[] bArr) {
        this.bzO = workerProfile;
        this.bzZ = i;
        this.bAa = bArr;
    }

    public final void run() {
        if (!au.HM()) {
            x.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + this.bzZ);
            au.DF().a(new e(this.bAa, this.bzZ), 0);
        }
    }
}
