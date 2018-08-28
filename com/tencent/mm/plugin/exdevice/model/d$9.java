package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class d$9 implements a {
    final /* synthetic */ d itl;
    final /* synthetic */ String its;
    final /* synthetic */ long itt;
    final /* synthetic */ int itu;

    d$9(d dVar, long j, String str, int i) {
        this.itl = dVar;
        this.itt = j;
        this.its = str;
        this.itu = i;
    }

    public final boolean vD() {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{this.its, Long.valueOf(this.itt), Integer.valueOf(this.itu), Integer.valueOf(u.aHF().cM(this.itt))});
        if (u.aHF().cM(this.itt) != 2) {
            ad.aHp();
            e.bj(this.its, 2);
        }
        d.d(this.itl).remove(Long.valueOf(this.itt));
        return false;
    }
}
