package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private final g heR = new g();
    public final h heS = new h();

    public final boolean ab(byte[] bArr) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            return false;
        }
        a aVar = new a(bArr.length);
        aVar.N(bArr, bArr.length);
        boolean a = this.heR.a(aVar);
        if (a) {
            a = this.heS.a(aVar);
            if (a) {
                return a;
            }
            x.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            return a;
        }
        x.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        return a;
    }
}
