package com.tencent.mm.as;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private final b diG;
    private e diJ;
    public String ede;
    public String edf;
    public byte[] edg;

    public a() {
        this(q.GF(), bi.f((Integer) g.Ei().DT().get(66561, null)), 0);
    }

    public a(String str, int i) {
        this(str, i, 0);
    }

    public a(String str, int i, int i2) {
        this.diJ = null;
        this.ede = null;
        this.edf = null;
        this.edg = null;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new agy();
        aVar.dIH = new agz();
        aVar.uri = "/cgi-bin/micromsg-bin/getqrcode";
        aVar.dIF = 168;
        aVar.dII = 67;
        aVar.dIJ = 1000000067;
        this.diG = aVar.KT();
        agy agy = (agy) this.diG.dID.dIL;
        agy.rvi = ab.oT(str);
        agy.rKl = i;
        agy.qZc = i2;
        x.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 168;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i2 + " errCode" + i3);
        if (i2 == 0 && i3 == 0) {
            agz agz = (agz) this.diG.dIE.dIL;
            String a = ab.a(((agy) this.diG.dID.dIL).rvi);
            this.edg = ab.a(agz.rKm, new byte[0]);
            this.ede = agz.rKn;
            x.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[]{this.ede, agz.rKo, agz.rKp});
            if (q.GF().equals(a)) {
                String str2 = agz.rKo;
                a = (String) g.Ei().DT().get(66563, "");
                if (!(str2 == null || a.equals(str2))) {
                    g.Ei().DT().set(66563, str2);
                    this.edf = agz.rKp;
                }
                g.Ei().DT().set(66561, Integer.valueOf(agz.rKl));
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
