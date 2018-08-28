package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
    private b diG;
    private e diJ;
    public mc hUC;

    public n(int i, com.tencent.mm.bk.b bVar, String str) {
        a aVar = new a();
        aVar.dIG = new mb();
        aVar.dIH = new mc();
        aVar.dIF = 1317;
        aVar.uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        mb mbVar = (mb) this.diG.dID.dIL;
        mbVar.amount = i;
        mbVar.rpW = 1;
        mbVar.hUM = str;
        mbVar.rpU = null;
        mbVar.rpV = bVar;
        x.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final int getType() {
        return 1317;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.hUC = (mc) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[]{Integer.valueOf(this.hUC.hUm), this.hUC.hUn, Integer.valueOf(this.hUC.rpW)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
