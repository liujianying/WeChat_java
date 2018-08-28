package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$8 implements a {
    final /* synthetic */ d itl;
    final /* synthetic */ String its;
    final /* synthetic */ long itt;
    final /* synthetic */ int itu;

    d$8(d dVar, long j, String str, int i) {
        this.itl = dVar;
        this.itt = j;
        this.its = str;
        this.itu = i;
    }

    public final boolean vD() {
        int cM = u.aHF().cM(this.itt);
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{this.its, Long.valueOf(this.itt), Integer.valueOf(this.itu), Integer.valueOf(cM)});
        d.cB(this.itt);
        d.c(this.itl).remove(Long.valueOf(this.itt));
        return false;
    }
}
