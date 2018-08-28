package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k {
    private final b diG;
    private e diJ;
    public byte[] iiN = null;
    private String iiO;

    public m(String str, byte[] bArr) {
        a aVar = new a();
        aVar.dIG = new ade();
        aVar.dIH = new adf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        aVar.dIF = 299;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iiN = bArr;
        this.iiO = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i2 + "   errCode:" + i3);
        adf adf = (adf) ((b) qVar).dIE.dIL;
        if (adf.rcU != null) {
            this.iiN = ab.a(adf.rcU);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 299;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        ade ade = (ade) this.diG.dID.dIL;
        if (this.iiN != null) {
            ade.rcT = ab.O(this.iiN);
        } else {
            ade.rcT = new bhy();
        }
        ade.rem = this.iiO;
        return a(eVar, this.diG, this);
    }

    public final adf aEP() {
        return (adf) this.diG.dIE.dIL;
    }
}
