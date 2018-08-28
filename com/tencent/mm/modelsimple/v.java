package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class v extends l implements k {
    public long bJC = -1;
    public b diG;
    private e diJ;
    private final long egp = 60000;
    private Runnable egq;
    public int errCode;
    public int errType;

    public v(float f, float f2, long j) {
        bbd bbd = new bbd();
        bbd.rmr = f;
        bbd.rms = f2;
        bbd.ryY = 1;
        bbd.ryV = 0;
        a(bbd, 1, -10000.0f, -10000.0f);
        this.bJC = j;
    }

    public v(bim bim) {
        a aVar = new a();
        aVar.dIG = bim;
        aVar.dIH = new bin();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.dIF = 424;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public v(bbd bbd, float f, float f2) {
        a(bbd, 0, f, f2);
    }

    private void a(bbd bbd, int i, float f, float f2) {
        a aVar = new a();
        aVar.dIG = new bim();
        aVar.dIH = new bin();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.dIF = 424;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bim bim = (bim) this.diG.dID.dIL;
        bim.sja = bbd;
        bim.otY = i;
        bim.sjb = f;
        bim.sjc = f2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        if (((bim) ((b) qVar).dID.dIL).sja != null) {
            return l.b.dJm;
        }
        x.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
        return l.b.dJn;
    }

    public final bin Ru() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (bin) this.diG.dIE.dIL;
    }

    protected final int Cc() {
        return 10;
    }

    protected final void a(l.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        x.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[]{Ru().rjF});
        if (this.egq != null) {
            this.egq.run();
        }
    }

    public final int getType() {
        return 424;
    }

    public static String mY(String str) {
        Map z = bl.z(str, "streetview");
        if (z == null) {
            return null;
        }
        return (String) z.get(".streetview.link");
    }
}
