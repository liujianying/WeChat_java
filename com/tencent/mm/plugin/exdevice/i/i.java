package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends ae {
    private a izD;
    private g izF;

    public i(int i) {
        this.izF = new g(i);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.aHF().cR(this.izF.hjj)) {
            this.izD = new a(this.izF, dVar);
            return this.izD.b(mVar);
        }
        x.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.izF.hjj)});
        return true;
    }
}
