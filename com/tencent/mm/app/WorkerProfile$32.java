package com.tencent.mm.app;

import com.tencent.mm.g.a.sn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$32 extends c<sn> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$32(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = sn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WorkerProfile", "upload sql file");
        com.tencent.mm.model.d.b.JG().jf(com.tencent.mm.model.d.b.jd(com.tencent.mm.model.d.b.dFe + "MMSQL.trace"));
        return false;
    }
}
