package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bk.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import junit.framework.Assert;

public final class i extends j {
    public i(byte[] bArr, int i, long j) {
        h hVar = new h();
        hVar.ixh = new c();
        hVar.hbs = new b(bArr);
        hVar.hcE = i;
        this.isE = hVar;
        this.hjj = j;
        this.isC = (short) 30001;
    }

    public final byte[] aGC() {
        Assert.assertNotNull(this.isE);
        try {
            return this.isE.toByteArray();
        } catch (IOException e) {
            x.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
