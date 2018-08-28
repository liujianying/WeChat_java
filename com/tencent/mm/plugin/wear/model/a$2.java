package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;

class a$2 extends c {
    final /* synthetic */ a pIV;

    a$2(a aVar) {
        this.pIV = aVar;
    }

    protected final void send() {
        if (this.pIV.pIM.bSr() != null) {
            this.pIV.pIM.bSr().bSx();
        }
        r.b(20009, null, false);
        r.b(20017, null, false);
    }

    public final String getName() {
        return "SyncFileTask";
    }
}
