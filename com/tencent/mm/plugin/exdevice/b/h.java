package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.n;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends j {
    public h(int i, int i2, long j) {
        n nVar = new n();
        nVar.ixh = new c();
        nVar.ixl = i;
        nVar.ixm = i2;
        this.isE = nVar;
        this.hjj = j;
        this.isC = (short) 30002;
    }

    public final byte[] aGC() {
        byte[] bArr = null;
        try {
            return this.isE.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            return bArr;
        }
    }

    public final int aGE() {
        n nVar = (n) this.isE;
        if (nVar != null) {
            return nVar.ixl;
        }
        x.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
        return -1;
    }
}
