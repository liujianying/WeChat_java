package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.tq;
import com.tencent.mm.plugin.exdevice.model.af.1;
import com.tencent.mm.plugin.exdevice.model.i.a;
import com.tencent.mm.sdk.platformtools.x;

class af$1$1 implements a {
    final /* synthetic */ tq iwC;
    final /* synthetic */ 1 iwD;

    af$1$1(1 1, tq tqVar) {
        this.iwD = 1;
        this.iwC = tqVar;
    }

    public final void ew(boolean z) {
        if (z) {
            af.am(this.iwC.cfq.byN, true);
            return;
        }
        x.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[]{this.iwC.cfq.byN, this.iwC.cfq.bKv});
        af.am(this.iwC.cfq.byN, false);
    }
}
