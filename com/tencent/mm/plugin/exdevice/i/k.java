package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends ae implements e {
    private int iis = -1;
    private String ius = null;
    private String iut = null;
    private String izI = null;

    public k(String str, String str2, String str3, int i) {
        this.ius = str;
        this.izI = str2;
        this.iut = str3;
        this.iis = i;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        au.DF().b(1090, this);
    }

    public final boolean a(m mVar, d dVar) {
        x.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "excute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.ius + ",deviceType=" + this.izI + ",deviceId=" + this.iut + ",reqType=" + this.iis);
        au.DF().a(1090, this);
        au.DF().a(new s(this.ius, this.izI, this.iut, this.iis), 0);
        return false;
    }
}
