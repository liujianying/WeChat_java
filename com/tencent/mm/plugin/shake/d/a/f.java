package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.protocal.c.bmo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class f extends e {
    private final b diG;
    private e diJ;

    public f(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int WU;
        int i4 = 1;
        super(j);
        a aVar = new a();
        aVar.dIG = new bmn();
        aVar.dIH = new bmo();
        aVar.uri = "/cgi-bin/micromsg-bin/shakemusic";
        this.diG = aVar.KT();
        bmn bmn = (bmn) this.diG.dID.dIL;
        bmn.rtW = new bhy().bq(bArr);
        bmn.skI = i2;
        bmn.rgC = z ? 1 : 0;
        bmn.skJ = (float) i;
        bmn.rth = ab.bU(ad.getContext()) ? 1 : 2;
        bmn.rdn = i3;
        try {
            au.HU();
            f = bi.getFloat((String) c.DT().get(aa.a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            try {
                au.HU();
                f2 = bi.getFloat((String) c.DT().get(aa.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
                try {
                    au.HU();
                    WU = bi.WU((String) c.DT().get(aa.a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                f2 = 0.0f;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        bmn.rms = f;
        bmn.skK = f2;
        bmn.rKg = com.tencent.mm.an.c.Qh() ? 0 : 1;
        if (!com.tencent.mm.an.c.Qg()) {
            i4 = 0;
        }
        bmn.rKh = i4;
        o.a(2014, bmn.skK, bmn.rms, WU);
        WU = 0;
        bmn.rms = f;
        bmn.skK = f2;
        if (com.tencent.mm.an.c.Qh()) {
        }
        bmn.rKg = com.tencent.mm.an.c.Qh() ? 0 : 1;
        if (com.tencent.mm.an.c.Qg()) {
            i4 = 0;
        }
        bmn.rKh = i4;
        o.a(2014, bmn.skK, bmn.rms, WU);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bmn bmn = (bmn) this.diG.dID.dIL;
        x.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(bmn.skI), Integer.valueOf(bmn.rtW.siI), Integer.valueOf(bmn.rgC), Float.valueOf(bmn.skJ), Integer.valueOf(bmn.rth), Integer.valueOf(bmn.rdn));
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bmn bmn = (bmn) this.diG.dID.dIL;
        x.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bmn.skI), Integer.valueOf(((bmo) this.diG.dIE.dIL).rgC));
        if (i2 == 0 && i3 == 0 && r1.rgC == 1) {
            this.mYF = true;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final bhp bvf() {
        return (bmo) this.diG.dIE.dIL;
    }

    public final int getType() {
        return 367;
    }
}
