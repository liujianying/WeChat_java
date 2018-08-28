package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.byz;
import com.tencent.mm.protocal.c.bza;
import com.tencent.mm.protocal.c.cak;

public final class b extends n<byz, bza> {
    String TAG = "MicroMsg.NetSceneVoipAnswer";

    public b(int i, int i2, int i3, byte[] bArr, byte[] bArr2, long j, boolean z, boolean z2) {
        a aVar = new a();
        aVar.dIG = new byz();
        aVar.dIH = new bza();
        aVar.uri = "/cgi-bin/micromsg-bin/voipanswer";
        aVar.dIF = 172;
        aVar.dII = 65;
        aVar.dIJ = 1000000065;
        this.diG = aVar.KT();
        byz byz = (byz) this.diG.dID.dIL;
        byz.suY = i;
        byz.rxG = i3;
        byz.rth = i2;
        cak cak = new cak();
        cak.hcE = 2;
        bhy bhy = new bhy();
        bhy.bq(bArr);
        cak.rfy = bhy;
        byz.suK = cak;
        cak = new cak();
        cak.hcE = 3;
        bhy = new bhy();
        bhy.bq(bArr2);
        cak.rfy = bhy;
        byz.suL = cak;
        byz.rxH = j;
        if (z2) {
            byz.suZ = z ? 1 : 0;
        }
        byz.suO = System.currentTimeMillis();
    }

    public final int getType() {
        return 172;
    }

    public final e bLm() {
        return new 1(this);
    }
}
