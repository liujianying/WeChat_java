package com.tencent.mm.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$1 extends a {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$1(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
    }

    public final void ev(int i) {
        if ((i == 4 || i == 6) && au.HX() && g.Eg().dpD && !au.Dr()) {
            x.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
            au.DF().a(new i(), 0);
        }
    }
}
