package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private final q dJM = new a();
    e diJ;
    String oER = "";
    int oES = 0;
    private String oET = "";

    public g(String str) {
        a aVar = (a) this.dJM.KV();
        x.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(73), str});
        aVar.dBS.rMp = 73;
        aVar.dBS.rMq = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final int getType() {
        return 616;
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final void a(l.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ay.b bVar = (ay.b) qVar.Id();
        if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.KV().qWA.ver)});
            au.Em().H(new 1(this, r0));
        } else if (i2 == 0 || i3 == 0) {
            if (bVar.dBT.rMr != null) {
                this.oER = new String(bVar.dBT.rMr.sio.siK.lR);
                this.oES = bVar.dBT.rMr.shi;
                x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[]{Integer.valueOf(this.oES), this.oET, this.oER});
            } else {
                x.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
            }
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
