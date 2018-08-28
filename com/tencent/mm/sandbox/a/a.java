package com.tencent.mm.sandbox.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.c.i;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sandbox.SubCoreSandBox;
import com.tencent.mm.plugin.y.b;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k, b {
    public final com.tencent.mm.ab.b diG;
    private e diJ;

    public a(int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new aiu();
        aVar.dIH = new aiv();
        aVar.uri = "/cgi-bin/micromsg-bin/getupdateinfo";
        aVar.dIF = 113;
        aVar.dII = 35;
        aVar.dIJ = 1000000035;
        this.diG = aVar.KT();
        aiu aiu = (aiu) this.diG.dID.dIL;
        aiu.rLv = i;
        aiu.qZe = com.tencent.mm.sdk.platformtools.e.bxk;
        if (10012 == af.exm && af.exn > 0) {
            aiu.qZe = af.exn;
        }
        switch (i) {
            case 1:
                h.mEJ.a(405, 3, 1, true);
                break;
            case 2:
                h.mEJ.a(405, 4, 1, true);
                break;
            case 3:
                h.mEJ.a(405, 5, 1, true);
                break;
            case 4:
                h.mEJ.a(405, 6, 1, true);
                break;
        }
        x.i("MicroMsg.NetSceneGetUpdateInfo", "summerupdate dkchan NetSceneGetUpdateInfo updateType:%d channel:%d release:%d, stack[%s]", new Object[]{Integer.valueOf(aiu.rLv), Integer.valueOf(aiu.qZe), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bxk), bi.cjd()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 11;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken GetUpdateInfo onGYNetEnd errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            h.mEJ.a(405, 7, 1, true);
        } else {
            h.mEJ.a(405, 8, 1, true);
            if (i2 == 4) {
                h.mEJ.a(405, 9, 1, true);
                if (i3 == -16) {
                    h.mEJ.a(405, 10, 1, true);
                } else if (i3 == -17) {
                    h.mEJ.a(405, 11, 1, true);
                } else if (i3 == -18) {
                    h.mEJ.a(405, 12, 1, true);
                }
            }
        }
        this.diJ.a(i2, i3, str, this);
        String cgJ = cgJ();
        if (cgJ != null) {
            i cG = i.cG(cgJ);
            if (cG != null) {
                x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchVersionCode[%d]", new Object[]{Integer.valueOf(cG.versionCode)});
                au.DF().a(new ad(com.tencent.mm.sdk.platformtools.ad.getPackageName(), r0), 0);
                h.mEJ.a(405, 13, 1, true);
                return;
            }
            x.i("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchInfo is null patchXml[%s]", new Object[]{cgJ});
            return;
        }
        x.w("MicroMsg.NetSceneGetUpdateInfo", "summertoken patchXml is null!");
        h.mEJ.a(405, 14, 1, true);
    }

    public final int cgH() {
        return ((aiv) this.diG.dIE.dIL).rLy;
    }

    public final String cgI() {
        return ((aiv) this.diG.dIE.dIL).rLx;
    }

    public final int bfw() {
        return ((aiv) this.diG.dIE.dIL).rLw;
    }

    public final String[] bfx() {
        aiv aiv = (aiv) this.diG.dIE.dIL;
        String[] strArr = new String[aiv.rLB.size()];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = ((bhz) aiv.rLB.get(i)).siM;
        }
        return strArr;
    }

    public final String cgJ() {
        x.d("MicroMsg.NetSceneGetUpdateInfo", "summertoken getPatchInfo[%s], stack[%s]", new Object[]{((aiv) this.diG.dIE.dIL).rLC, bi.cjd()});
        return ((aiv) this.diG.dIE.dIL).rLC;
    }

    public final aiv bfy() {
        int i = 1;
        if (SubCoreSandBox.mFe) {
            aiv aiv = (aiv) this.diG.dIE.dIL;
            aiv.rLD = 1;
            aiv.rLE = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            if (!SubCoreSandBox.mFf) {
                i = 0;
            }
            aiv.rLF = i;
        }
        return (aiv) this.diG.dIE.dIL;
    }
}
