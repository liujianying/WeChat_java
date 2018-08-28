package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.protocal.c.cai;
import com.tencent.mm.protocal.c.caj;
import com.tencent.mm.protocal.c.cal;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends n<cai, caj> {
    public h(int i, long j, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        a aVar = new a();
        aVar.dIG = new cai();
        aVar.dIH = new caj();
        aVar.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        aVar.dIF = 678;
        aVar.dII = d.CTRL_INDEX;
        aVar.dIJ = 1000000240;
        this.diG = aVar.KT();
        cai cai = (cai) this.diG.dID.dIL;
        cai.rxG = i;
        cai.rxH = j;
        cai.seq = i2;
        cai.swG = i3;
        cai.swH = i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            cal cal = new cal();
            int i8 = i6 + 1;
            cal.swR = iArr[i6];
            i6 = i8 + 1;
            cal.swS = iArr[i8];
            i8 = i6 + 1;
            cal.swT = iArr[i6];
            int i9 = i8 + 1;
            cal.swU = iArr[i8];
            i6 = i9 + 1;
            cal.swV = iArr[i9];
            cai.swI.add(cal);
        }
        if (this.oKs.oJX.oPS.oLr != 0) {
            i5 = (int) ((System.currentTimeMillis() - this.oKs.oJX.oPS.oLr) / 1000);
        }
        cai.swJ = i5;
    }

    public final int getType() {
        return 678;
    }

    public final void dP(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((caj) this.diG.dIE.dIL) != null) {
                x.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((caj) this.diG.dIE.dIL).rxG), Long.valueOf(((caj) this.diG.dIE.dIL).rxH), Integer.valueOf(((caj) this.diG.dIE.dIL).seq)});
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.Redirect", "Redirect error");
    }

    public final e bLm() {
        return new e() {
            public final void a(int i, int i2, String str, l lVar) {
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.Redirect", "Redirect response:" + i + " errCode:" + i2 + " status:" + h.this.oKs.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.Redirect", " redirect response with error code:" + i2);
                    return;
                }
                caj caj = (caj) h.this.bLq();
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.Redirect", "room " + caj.rxG + " member " + caj.seq + " key " + caj.rxH + " relay addr cnt " + caj.swK + " RedirectThreshold " + caj.swP + " RedirectDecision " + caj.swQ);
                byy byy = new byy();
                byy byy2 = new byy();
                byy byy3 = new byy();
                byy.suW = caj.swK;
                byy.suX = caj.swL;
                byy2.suW = caj.swM;
                byy2.suX = caj.swN;
                byy3.suW = caj.swO;
                byy3.suX = caj.svB;
                h.this.oKs.oJX.a(byy, byy2, byy3, caj.swP, caj.swQ);
            }
        };
    }
}
