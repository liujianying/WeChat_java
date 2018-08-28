package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ij;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    public int bJr;
    public int bJs;
    private b diG;
    private e diJ;
    public boolean mFP = false;

    public f(int i, String str, int i2, int i3) {
        a aVar = new a();
        aVar.dIG = new ij();
        aVar.dIH = new ik();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.dIF = 1061;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ij ijVar = (ij) this.diG.dID.dIL;
        ijVar.hcE = i;
        ijVar.rjy = str;
        ijVar.otY = 1;
        this.bJr = i2;
        this.bJs = i3;
        x.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        ij ijVar = (ij) ((b) qVar).dID.dIL;
        if (ijVar.hcE >= 0 && ijVar.rjy != null && ijVar.rjy.length() > 0) {
            return l.b.dJm;
        }
        x.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + ijVar.hcE + ", Barcode = %s" + ijVar.rjy);
        return l.b.dJn;
    }

    public final ik bsb() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (ik) this.diG.dIE.dIL;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1061;
    }
}
