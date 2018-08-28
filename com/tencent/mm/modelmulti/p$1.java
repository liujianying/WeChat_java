package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.mm.sdk.platformtools.x;

class p$1 implements IAutoUnlockCallback {
    final /* synthetic */ p eay;

    p$1(p pVar) {
        this.eay = pVar;
    }

    public final void autoUnlockCallback() {
        x.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", new Object[]{p.a(this.eay)});
        p.b(p.a(this.eay));
    }
}
