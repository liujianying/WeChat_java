package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e doG;
    private long ihD = 0;
    private byte[] iiD = null;
    private String iiF;
    private int iis;
    int pNI = -1;
    boolean pNJ = true;

    public b(int i, String str, byte[] bArr, int i2, long j) {
        a aVar = new a();
        aVar.dIG = new bjd();
        aVar.dIH = new bje();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        aVar.dIF = 234;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iis = i;
        this.iiF = str;
        this.iiD = bArr;
        this.pNI = i2;
        this.ihD = j;
    }

    public final int getType() {
        return 234;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        bjd bjd = (bjd) this.diG.dID.dIL;
        if (bi.bC(this.iiD)) {
            bjd.rHj = new bhy();
            this.pNJ = true;
        } else {
            bjd.rHj = ab.O(this.iiD);
            this.pNJ = false;
            bjd.rHm = this.ihD;
        }
        x.d("MicroMsg.emoji.NetSceneSearchEmotion", bjd.rHj == null ? "Buf is NULL" : bjd.rHj.toString());
        bjd.rgA = this.iis;
        bjd.rHk = this.iiF;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.doG.a(i2, i3, str, this);
    }

    public final bje bTD() {
        return this.diG == null ? null : (bje) this.diG.dIE.dIL;
    }
}
