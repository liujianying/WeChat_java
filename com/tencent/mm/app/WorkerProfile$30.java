package com.tencent.mm.app;

import com.tencent.mm.g.a.il;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WorkerProfile$30 extends c<il> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$30(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = il.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        il ilVar = (il) bVar;
        String str = ilVar.bRT.imagePath;
        String str2 = ilVar.bRT.toUser;
        boolean booleanValue = ilVar.bRT.bRU.booleanValue();
        int i = ilVar.bRT.bRV;
        if (ilVar.bRT.bRW.booleanValue()) {
            au.Em().H(new 1(this, i, str, str2, booleanValue));
        }
        return false;
    }
}
