package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.byv;
import com.tencent.mm.protocal.c.byw;
import com.tencent.mm.protocal.c.cak;

public final class a extends n<byv, byw> {
    String TAG = "MicroMsg.NetSceneVoipAck";

    public a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new byv();
        aVar.dIH = new byw();
        aVar.uri = "/cgi-bin/micromsg-bin/voipack";
        aVar.dIF = 305;
        aVar.dII = 123;
        aVar.dIJ = 1000000123;
        this.diG = aVar.KT();
        byv byv = (byv) this.diG.dID.dIL;
        byv.rxG = i;
        byv.rxH = j;
        byv.suN = i2;
        if (i2 != 1) {
            byv.suJ = 0;
            return;
        }
        byv.suM = str;
        cak cak = new cak();
        cak.hcE = 2;
        bhy bhy = new bhy();
        bhy.bq(bArr);
        cak.rfy = bhy;
        byv.suK = cak;
        cak = new cak();
        cak.hcE = 3;
        bhy = new bhy();
        bhy.bq(bArr2);
        cak.rfy = bhy;
        byv.suL = cak;
        byv.suO = System.currentTimeMillis();
        byv.suJ = 1;
    }

    public final int getType() {
        return 305;
    }

    public final e bLm() {
        return new 1(this);
    }
}
