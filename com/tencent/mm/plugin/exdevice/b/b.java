package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bk.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends d {
    public b(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        x.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    public final void b(int i, String str, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + i + "errMsg = " + str);
        com.tencent.mm.plugin.exdevice.e.b bVar = new com.tencent.mm.plugin.exdevice.e.b();
        bVar.ixj = X(i, str);
        bVar.iwQ = com.tencent.mm.bk.b.bi(bArr);
        this.isE = bVar;
        this.isC = (short) 20001;
    }

    protected final a ao(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
            return null;
        }
        a aVar = new com.tencent.mm.plugin.exdevice.e.a();
        try {
            aVar.aG(bArr);
            this.isF = aVar;
            x.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + aVar.iwJ + " DeviceName = " + aVar.hbP + " Language = " + aVar.iwP + " TimeZone = " + aVar.iwO);
            return aVar;
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", e, "", new Object[0]);
            return null;
        }
    }
}
