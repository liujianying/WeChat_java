package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bah;
import com.tencent.mm.protocal.c.bai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class a extends m {
    private b diG;
    private e diJ;
    public String pCN;
    public String pCO;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bah();
        aVar.dIH = new bai();
        aVar.uri = "/cgi-bin/mmpay-bin/payugenprepay";
        aVar.dIF = 1521;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bah bah = (bah) this.diG.dID.dIL;
        bah.jQb = str;
        bah.rsx = str4;
        bah.rsw = str3;
        bah.rsy = str5;
        bah.rsz = str2;
        bah.rhq = str6;
        bah.rrC = str7;
        bah.rEe = str8;
        bah.qZe = i;
        x.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str3, str5, str2, str6, str7, str8}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        bai bai = (bai) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUGenPrepay", "rr " + bai.rEf);
            this.pCN = bai.rEf;
            this.pCO = bai.rEg;
        }
        this.diJ.a(i, i2, bai.iwT, this);
    }

    public final int getType() {
        return 1521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
