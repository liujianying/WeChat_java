package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.ay;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bmr;
import com.tencent.mm.protocal.c.bms;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class g extends e {
    private final b diG;
    private e diJ;

    public g(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int i4 = 1;
        int i5 = 0;
        super(j);
        a aVar = new a();
        aVar.dIG = new bmr();
        aVar.dIH = new bms();
        aVar.uri = "/cgi-bin/micromsg-bin/shaketv";
        aVar.dIF = ay.CTRL_INDEX;
        aVar.dII = i5;
        aVar.dIJ = i5;
        this.diG = aVar.KT();
        bmr bmr = (bmr) this.diG.dID.dIL;
        bmr.rtW = new bhy().bq(bArr);
        bmr.skI = i2;
        bmr.rgC = z ? 1 : i5;
        bmr.skJ = (float) i;
        if (!ab.bU(ad.getContext())) {
            i4 = 2;
        }
        bmr.rth = i4;
        bmr.rdn = i3;
        try {
            au.HU();
            f = bi.getFloat((String) c.DT().get(aa.a.sPK, null), 0.0f);
            try {
                au.HU();
                float f3 = bi.getFloat((String) c.DT().get(aa.a.sPL, null), 0.0f);
                try {
                    au.HU();
                    i5 = bi.WU((String) c.DT().get(aa.a.sSf, null));
                    f2 = f3;
                } catch (Exception e) {
                    f2 = f3;
                }
            } catch (Exception e2) {
                f2 = 0.0f;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        bmr.rms = f;
        bmr.skK = f2;
        o.a(2009, bmr.skK, bmr.rms, i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bmr bmr = (bmr) this.diG.dID.dIL;
        x.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[]{Integer.valueOf(bmr.skI), Integer.valueOf(bmr.rtW.siI), Integer.valueOf(bmr.rgC), Float.valueOf(bmr.skJ), Integer.valueOf(bmr.rth), Integer.valueOf(bmr.rdn)});
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bmr bmr = (bmr) this.diG.dID.dIL;
        x.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bmr.skI), Integer.valueOf(((bms) this.diG.dIE.dIL).rgC)});
        if (i2 == 0 && i3 == 0 && r1.rgC == 1) {
            this.mYF = true;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final bhp bvf() {
        return (bms) this.diG.dIE.dIL;
    }

    public final int getType() {
        return ay.CTRL_INDEX;
    }
}
