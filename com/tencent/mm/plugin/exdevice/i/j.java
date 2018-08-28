package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends ae {
    private a izG;
    private h izH;

    public j(int i, int i2, long j) {
        this.izH = new h(i, i2, j);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.aHF().cR(this.izH.hjj)) {
            this.izG = new b(this.izH, dVar);
            return this.izG.b(mVar);
        }
        x.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.izH.hjj)});
        return true;
    }
}
