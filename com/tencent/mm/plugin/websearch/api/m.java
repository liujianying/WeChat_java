package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asl;
import com.tencent.mm.protocal.c.asm;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k {
    public int bWo;
    private b dZf;
    private e diJ;
    public int iPZ;
    public String kJG;
    public asm pLm;
    private int pLn;
    public int scene;

    public m(int i, int i2, int i3, int i4, String str, long j, String str2) {
        this.scene = i;
        this.pLn = i3;
        this.bWo = i4;
        this.iPZ = i2;
        this.kJG = str2;
        x.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.dIF = 1048;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchguide";
        aVar.dIG = new asl();
        aVar.dIH = new asm();
        this.dZf = aVar.KT();
        asl asl = (asl) this.dZf.dID.dIL;
        asl.otY = i;
        asl.rUH = i3;
        asl.rUI = p.JU();
        asl.rUJ = i2;
        asl.iwP = str;
        asl.rUK = j;
    }

    public final int getType() {
        return 1048;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.pLm = (asm) this.dZf.dIE.dIL;
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
