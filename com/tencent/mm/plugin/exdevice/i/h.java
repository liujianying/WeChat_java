package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends ae {
    private f isP;
    private a izE;

    public h(f fVar) {
        this.isP = fVar;
    }

    public final boolean a(m mVar, d dVar) {
        this.izE = new a(this.isP, dVar);
        x.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[]{Boolean.valueOf(this.izE.b(mVar))});
        return this.izE.b(mVar);
    }
}
