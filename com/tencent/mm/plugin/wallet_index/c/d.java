package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.protocal.c.zb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class d extends m {
    private b diG;
    private e diJ;
    public int errCode;
    public anm pCP;
    public ann pCQ;

    public d(int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.dIG = new za();
        aVar.dIH = new zb();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
        aVar.dIF = 1130;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        za zaVar = (za) this.diG.dID.dIL;
        zaVar.bPS = str;
        zaVar.rFc = i;
        zaVar.rFd = Integer.parseInt(str2);
        zaVar.desc = str3;
        zaVar.count = i2;
        zaVar.scene = 13;
        zaVar.rFe = str4;
        zaVar.rFf = str5;
        zaVar.sign = str6;
        zaVar.rFg = str7;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            zb zbVar = (zb) this.diG.dIE.dIL;
            x.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + zbVar.bQO + ",errMsg:" + zbVar.bQP);
            int i3 = zbVar.bQO;
            String str2 = zbVar.bQP;
            if (i3 == 0) {
                this.pCP = zbVar.rFh;
                this.pCQ = zbVar.rFi;
            }
            this.diJ.a(i, i3, str2, this);
            return;
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 1130;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
