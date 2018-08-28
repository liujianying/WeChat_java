package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dz;
import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.platformtools.x;
import java.text.DecimalFormat;

public final class b extends l implements k {
    public static int iii = 6;
    public static int iij = 7;
    public static int iik = 10;
    private final com.tencent.mm.ab.b diG;
    private e doG;
    private String iil;
    private tq iim;

    public b(String str, tq tqVar) {
        a aVar = new a();
        aVar.dIG = new dz();
        aVar.dIH = new ea();
        aVar.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        aVar.dIF = 830;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iil = str;
        this.iim = tqVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 830;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        dz dzVar = (dz) this.diG.dID.dIL;
        dzVar.rem = this.iil;
        tq tqVar = new tq();
        tqVar.jTh = this.iim.jTh;
        tqVar.rxo = this.iim.rxo;
        tqVar.rxn = new DecimalFormat("0.00").format(Float.valueOf(this.iim.rxn));
        dzVar.ren = tqVar;
        return a(eVar, this.diG, this);
    }

    public final ea aEJ() {
        return (ea) this.diG.dIE.dIL;
    }
}
