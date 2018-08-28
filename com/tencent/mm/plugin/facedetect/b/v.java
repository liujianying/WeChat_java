package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends p implements k, b {
    private final q dJM = new h();
    private long iML = -1;
    private byte[] iMM = null;

    public final long aJp() {
        return this.iML;
    }

    public final byte[] aJq() {
        return this.iMM;
    }

    public v(int i) {
        a aVar = (a) this.dJM.KV();
        aVar.iMp.rFO = p.iMG;
        aVar.iMp.hcE = 1;
        aVar.iMp.otY = i;
    }

    final int g(e eVar) {
        return a(eVar, this.dJM, this);
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final void a(l.a aVar) {
    }

    public final int getType() {
        return 733;
    }

    public final void c(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0) {
            i.b bVar = (i.b) qVar.Id();
            this.iML = bVar.iMq.rFP;
            if (bVar.iMq.rFQ != null) {
                this.iMM = bVar.iMq.rFQ.lR;
            }
            if (bVar.iMq.rFS != null) {
                byte[] bArr;
                byte[] bArr2;
                if (bVar.iMq.rFS.roF == null || bVar.iMq.rFS.roF.siI <= 0) {
                    bArr = null;
                } else {
                    x.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[]{Integer.valueOf(bVar.iMq.rFS.roF.siI)});
                    bArr = ab.a(bVar.iMq.rFS.roF);
                }
                if (bVar.iMq.rFS.roG == null || bVar.iMq.rFS.roG.siI <= 0) {
                    bArr2 = null;
                } else {
                    x.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[]{Integer.valueOf(bVar.iMq.rFS.roG.siI)});
                    bArr2 = ab.a(bVar.iMq.rFS.roG);
                }
                g.NE().a(bVar.iMq.rFS.roC, bVar.iMq.rFS.roD, bVar.iMq.rFS.roE, bArr, bArr2, bVar.iMq.rFS.roH);
            }
            String str2 = "MicroMsg.NetSceneGetBioConfigRsa";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.iML);
            objArr[1] = Integer.valueOf(this.iMM == null ? 0 : this.iMM.length);
            x.i(str2, str3, objArr);
        }
        this.diJ.a(i, i2, str, this);
    }

    final void AQ(String str) {
        ((a) this.dJM.KV()).iMp.rFO = str;
    }

    protected final avt g(q qVar) {
        return ((i.b) qVar.Id()).iMq.rFR;
    }
}
