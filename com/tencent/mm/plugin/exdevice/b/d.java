package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bk.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends c {
    protected a isF = null;
    private short isG = (short) -1;
    private short isH = (short) -1;

    protected abstract a ao(byte[] bArr);

    public d(long j, int i, int i2, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        this.hjj = j;
        this.isG = (short) i2;
        this.isH = (short) i;
        ao(bArr);
    }

    public final short aGA() {
        return this.isG;
    }

    public final short aGB() {
        return this.isH;
    }

    public final a aGD() {
        return this.isF;
    }

    public final byte[] aGC() {
        try {
            return this.isE.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e, "", new Object[0]);
            return null;
        }
    }
}
