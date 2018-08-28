package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

class WorkerProfile$7 extends c<ir> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$7(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = ir.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ir irVar = (ir) bVar;
        Context context = irVar.bSe.context;
        if (context == null) {
            context = ad.getContext();
        }
        irVar.bSf.bSi = g.a(context, irVar.bSe.appId, irVar.bSe.bSg, irVar.bSe.showType, irVar.bSe.bSh, irVar.bSe.bJx);
        return false;
    }
}
