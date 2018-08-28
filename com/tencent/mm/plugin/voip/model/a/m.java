package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.caw;
import com.tencent.mm.protocal.c.cax;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends n<caw, cax> {
    public m(int i, bzu bzu, byte[] bArr, long j, int i2) {
        a aVar = new a();
        aVar.dIG = new caw();
        aVar.dIH = new cax();
        aVar.uri = "/cgi-bin/micromsg-bin/voipsync";
        aVar.dIF = 174;
        aVar.dII = 62;
        aVar.dIJ = 1000000062;
        this.diG = aVar.KT();
        caw caw = (caw) this.diG.dID.dIL;
        caw.rxG = i;
        caw.sxh = bzu;
        caw.rxH = j;
        caw.seC = q.GF();
        caw.rnx = i2;
        caw.rny = new bhy().bq(bArr);
        caw.suO = System.currentTimeMillis();
        x.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + caw.suO);
    }

    public final int getType() {
        return 174;
    }

    public final int bLo() {
        return ((caw) this.diG.dID.dIL).rnx;
    }

    public final e bLm() {
        return new 1(this);
    }
}
