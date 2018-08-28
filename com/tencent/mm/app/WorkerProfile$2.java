package com.tencent.mm.app;

import com.tencent.mm.g.a.pc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.contact.e;

class WorkerProfile$2 extends c<pc> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$2(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = pc.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        pc pcVar = (pc) bVar;
        e.a(pcVar.bZW.intent, pcVar.bZW.username);
        return false;
    }
}
