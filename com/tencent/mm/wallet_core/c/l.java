package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bxx;
import com.tencent.mm.protocal.c.bxy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class l extends m {
    private final b diG;
    private e diJ;
    public int errCode;
    public String iiv = null;
    public String iix;
    public int pDn = 0;

    public l(String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, String str6) {
        a aVar = new a();
        aVar.dIG = new bxx();
        aVar.dIH = new bxy();
        aVar.uri = "/cgi-bin/micromsg-bin/verifypurchase";
        aVar.dIF = TbsListener$ErrorCode.INFO_SDKINIT_IS_SYS_FORCED;
        aVar.dII = 215;
        aVar.dIJ = 1000000215;
        this.diG = aVar.KT();
        bxx bxx = (bxx) this.diG.dID.dIL;
        this.iiv = str;
        bxx.rem = str;
        bxx.stY = i;
        bxx.sdM = i3;
        bxx.lOM = i2;
        if (!bi.oW(str6)) {
            bxx.sdK = str6;
            bxx.sdL = str5;
        }
        bxx.sdN = str2;
        bxx.sua = str4;
        if (str3 != null) {
            bxx.stX = new bhy().bq(str3.getBytes());
        } else {
            bxx.stX = new bhy();
        }
        bxx.stZ = (int) bi.VE();
        x.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.iiv + ",verifyType:" + i + ",palyType:" + i2 + ",payload:" + str2 + ",purchaseData:" + str3 + ",dataSignature:" + str4);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + i + "   errCode:" + i2);
        this.errCode = 0;
        if (i == 0 && i2 == 0) {
            bxy bxy = (bxy) ((b) qVar).dIE.dIL;
            if (bxy.six != null) {
                this.pDn = bxy.suc;
                x.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + bxy.rxN);
                x.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + bxy.sub);
                this.iix = bxy.rxN;
            }
            this.diJ.a(i, i2, str, this);
            return;
        }
        this.errCode = -1;
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return TbsListener$ErrorCode.INFO_SDKINIT_IS_SYS_FORCED;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
