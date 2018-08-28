package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class d$5 implements Runnable {
    final /* synthetic */ d itl;
    final /* synthetic */ String itp;
    final /* synthetic */ boolean itq;

    d$5(d dVar, String str, boolean z) {
        this.itl = dVar;
        this.itp = str;
        this.itq = z;
    }

    public final void run() {
        if (d.a(this.itl) == null) {
            d.a(this.itl, new c());
            d.a(this.itl).iyE = new 1(this);
            d.a(this.itl).dd(ad.getContext());
            synchronized (d.b(this.itl)) {
                try {
                    d.b(this.itl).wait();
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.ExdeviceConnectManager", "mSyncLock.wait failed!!!, %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectManager", e, "", new Object[0]);
                }
            }
            return;
        }
        e.aHw().an(this.itp, this.itq);
    }

    public final String toString() {
        return super.toString() + "|ranging";
    }
}
