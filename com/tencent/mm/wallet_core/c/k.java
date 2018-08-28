package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.protocal.c.bbq;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends m {
    public final b diG;
    private e diJ;
    public String iiv;
    public String pCK;
    public String pCL;

    public k(String str, String str2, String str3, int i, int i2, String str4) {
        a aVar = new a();
        aVar.dIG = new bbp();
        aVar.dIH = new bbq();
        aVar.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        aVar.dIF = 422;
        aVar.dII = 214;
        aVar.dIJ = 1000000214;
        this.diG = aVar.KT();
        bbp bbp = (bbp) this.diG.dID.dIL;
        this.iiv = str;
        bbp.rem = str;
        this.pCL = str2;
        bbp.sdK = str2;
        this.pCK = str3;
        bbp.sdL = str3;
        bbp.lOM = i2;
        bbp.sdM = i;
        bbp.jTB = str4;
        x.d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i2);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.diJ.a(i, i2, str, this);
        } else {
            this.diJ.a(i, i2, str, this);
        }
    }

    public final int getType() {
        return 422;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
