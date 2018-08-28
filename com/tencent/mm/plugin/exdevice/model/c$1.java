package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    private long dJH = 10;
    final /* synthetic */ c itb;

    c$1(c cVar) {
        this.itb = cVar;
    }

    public final boolean vD() {
        if (this.itb.isY == null) {
            long j = this.dJH;
            this.dJH = j - 1;
            if (j > 0) {
                return true;
            }
        }
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", new Object[]{Long.valueOf(this.dJH)});
        if (this.dJH > 0) {
            this.itb.aGK();
        }
        return false;
    }
}
