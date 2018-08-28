package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public class j$b extends e implements c {
    public ew qWr = new ew();

    public final int G(byte[] bArr) {
        this.qWr = (ew) new ew().aG(bArr);
        x.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[]{Integer.valueOf(this.qWr.rfn), this.qWr.rfo, this.qWr.rfp});
        return this.qWr.rfn;
    }

    public final int getCmdId() {
        return BaseReportManager.MAX_READ_COUNT;
    }
}
