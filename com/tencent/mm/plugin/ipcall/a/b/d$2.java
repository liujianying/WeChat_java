package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements a {
    final /* synthetic */ d kqv;
    final /* synthetic */ boolean kqw;

    d$2(d dVar, boolean z) {
        this.kqv = dVar;
        this.kqw = z;
    }

    public final boolean vD() {
        if (this.kqw) {
            x.i("MicroMsg.IPCallSensorManager", "light screen");
            if (this.kqv.kqu != null) {
                this.kqv.kqu.fU(false);
            }
        } else {
            x.i("MicroMsg.IPCallSensorManager", "off screen");
            if (this.kqv.kqu != null) {
                this.kqv.kqu.fU(true);
            }
        }
        return false;
    }
}
