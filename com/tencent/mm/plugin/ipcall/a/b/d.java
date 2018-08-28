package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements a {
    public SensorController hlW = new SensorController(ad.getContext());
    public az hma = new az(ad.getContext());
    public long hmb = -1;
    private boolean hmg = false;
    public a kqu = null;

    public final void dK(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.hmg + " tick:" + bi.bI(this.hmb) + "  lt:" + this.hmb);
        if (this.hmg) {
            if (z) {
                z2 = false;
            }
            this.hmg = z2;
        } else if (z || this.hmb == -1 || bi.bI(this.hmb) <= 400) {
            this.hmg = false;
            x.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[]{Boolean.valueOf(z)});
            new al(new 2(this, z), false).J(50, 50);
        } else {
            this.hmg = true;
        }
    }
}
