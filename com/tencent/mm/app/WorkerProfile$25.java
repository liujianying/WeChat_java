package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;

class WorkerProfile$25 implements a {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$25(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
    }

    public final void bc(Context context) {
        MMAppMgr.h(context, true);
    }

    public final boolean vx() {
        if (!(d.qVQ || com.tencent.mm.bg.d.Us("whatsnew"))) {
            x.i("MicroMsg.MMAppMgr", "plugin cannot load");
        }
        return false;
    }

    public final void h(Context context, boolean z) {
        MMAppMgr.h(context, z);
    }
}
