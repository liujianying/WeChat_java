package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.bxl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class g extends m {
    public String bKk;
    private b diG;
    private e diJ;
    public int errCode;

    public g(int i, int i2, String str, ann ann, anm anm) {
        a aVar = new a();
        aVar.dIG = new bxk();
        aVar.dIH = new bxl();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
        aVar.dIF = 1306;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bxk bxk = (bxk) this.diG.dID.dIL;
        bxk.rFc = i;
        bxk.bVC = i2;
        this.bKk = str;
        bxk.rFi = ann;
        bxk.rFh = anm;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            bxl bxl = (bxl) this.diG.dIE.dIL;
            x.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + bxl.bQO + ",errMsg:" + bxl.bQP);
            this.diJ.a(i, bxl.bQO, str, this);
            return;
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 1306;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
