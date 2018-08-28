package com.tencent.mm.app;

import com.tencent.mm.g.a.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WorkerProfile$21 extends c<d> {
    final /* synthetic */ WorkerProfile bzO;
    Runnable bzT;

    WorkerProfile$21(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.bzT = new 1(this);
        this.sFo = d.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((d) bVar).bGd.bGe && au.HX()) {
            au.Em().H(this.bzT);
        }
        return false;
    }
}
