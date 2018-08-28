package com.tencent.mm.app;

import android.content.Intent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;

class WorkerProfile$3 extends c<com.tencent.mm.g.a.c> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$3(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = com.tencent.mm.g.a.c.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.g.a.c cVar = (com.tencent.mm.g.a.c) bVar;
        MMActivity mMActivity = cVar.bGb.bGc;
        w.a(mMActivity, cVar.bGb.errType, cVar.bGb.errCode, new Intent().setClass(mMActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), null);
        return false;
    }
}
