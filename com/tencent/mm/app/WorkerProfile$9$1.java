package com.tencent.mm.app;

import com.tencent.mm.app.WorkerProfile.9;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.k;

class WorkerProfile$9$1 implements Runnable {
    final /* synthetic */ int bzP;
    final /* synthetic */ boolean bzQ;
    final /* synthetic */ 9 bzR;

    WorkerProfile$9$1(9 9, int i, boolean z) {
        this.bzR = 9;
        this.bzP = i;
        this.bzQ = z;
    }

    public final void run() {
        au.DF().a(new k(this.bzP, this.bzQ), 0);
    }
}
