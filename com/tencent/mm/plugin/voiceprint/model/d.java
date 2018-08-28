package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajl;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private final b diG;
    private e diJ;
    String oER = "";
    int oES = 0;
    String oET = "";

    public d(int i, String str) {
        a aVar = new a();
        aVar.dIG = new ajl();
        aVar.dIH = new ajm();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        aVar.dIF = 611;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ajl ajl = (ajl) this.diG.dID.dIL;
        x.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(i), str});
        ajl.rMp = i;
        ajl.rMq = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 611;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ajm ajm = (ajm) ((b) qVar).dIE.dIL;
        if (i2 == 0 || i3 == 0) {
            if (ajm.rMr != null) {
                this.oER = new String(ajm.rMr.sio.siK.lR);
                this.oES = ajm.rMr.shi;
                x.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[]{Integer.valueOf(this.oES), this.oER});
            } else {
                x.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
