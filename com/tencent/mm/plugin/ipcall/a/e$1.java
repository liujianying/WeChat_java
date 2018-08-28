package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends c<bc> {
    final /* synthetic */ e koq;

    e$1(e eVar) {
        this.koq = eVar;
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.bIB.bIC == 39) {
            x.i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
            byte[] f = e.f(bcVar.bIB.filePath, 0, -1);
            if (f != null) {
                this.koq.az(f);
            } else {
                x.e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
            }
        }
        return false;
    }
}
