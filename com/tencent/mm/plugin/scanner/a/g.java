package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.il;
import com.tencent.mm.protocal.c.im;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private int dHI;
    public b diG;
    private e diJ;
    private int djw = 1;
    private byte[] mFL;
    private int mFO;
    private int offset;

    public g(byte[] bArr, int i, int i2) {
        this.mFL = bArr;
        this.djw = 1;
        this.dHI = i;
        this.offset = 0;
        this.mFO = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new il();
        aVar.dIH = new im();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
        aVar.dIF = 1062;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        il ilVar = (il) this.diG.dID.dIL;
        ilVar.rjz = ((int) bi.VF()) & Integer.MAX_VALUE;
        ilVar.rjA = new bhy().bq(this.mFL);
        ilVar.rjB = this.dHI;
        ilVar.rjC = this.offset;
        if (this.offset + this.mFL.length < this.dHI) {
            ilVar.rgC = 0;
        } else {
            ilVar.rgC = 1;
        }
        ilVar.rjD = this.djw;
        ilVar.rjE = this.mFO;
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        il ilVar = (il) ((b) qVar).dID.dIL;
        if (ilVar.rjz > 0 && ilVar.rjD >= 0 && ilVar.rjA != null && ilVar.rjA.siI > 0 && ilVar.rjB > 0 && ilVar.rjC >= 0 && ilVar.rjC + ilVar.rjA.siI <= ilVar.rjB) {
            return l.b.dJm;
        }
        x.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", new Object[]{Integer.valueOf(ilVar.rjD), Integer.valueOf(ilVar.rjB), Integer.valueOf(ilVar.rjC)});
        if (ilVar.rjA != null) {
            x.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", new Object[]{Integer.valueOf(ilVar.rjA.siI)});
        }
        return l.b.dJn;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1062;
    }
}
