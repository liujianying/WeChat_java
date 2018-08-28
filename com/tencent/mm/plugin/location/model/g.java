package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    public final b diG;
    private e diJ;
    private byte[] kCG;
    String kCH;

    public g(float f, float f2, int i, int i2, int i3, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new afb();
        aVar.dIH = new afc();
        aVar.uri = "/cgi-bin/micromsg-bin/getlocimg";
        aVar.dIF = 648;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        afb afb = (afb) this.diG.dID.dIL;
        afb.iwP = str2;
        if (bi.fU(ad.getContext())) {
            afb.rJk = 1;
        } else {
            afb.rJk = 0;
        }
        afb.rms = f;
        afb.rmr = f2;
        afb.rJl = i;
        x.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        while (i2 * i3 > 270000) {
            i2 = (int) (((double) i2) / 1.2d);
            i3 = (int) (((double) i3) / 1.2d);
        }
        x.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), afb.iwP});
        afb.Height = i3;
        afb.Width = i2;
        this.kCH = str;
    }

    public final int getType() {
        return 648;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        try {
            this.kCG = ((afc) ((b) qVar).dIE.dIL).rcn.siK.lR;
            com.tencent.mm.a.e.b(this.kCH, this.kCG, this.kCG.length);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGetLocImg", e, "", new Object[0]);
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
