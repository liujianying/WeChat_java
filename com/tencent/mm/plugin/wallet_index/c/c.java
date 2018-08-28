package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.m;

public final class c extends m implements d {
    private b diG;
    private e diJ;
    public String pCN;
    public String pCO;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3, String str9) {
        a aVar = new a();
        aVar.dIG = new yj();
        aVar.dIH = new yk();
        aVar.uri = "/cgi-bin/mmpay-bin/genprepay";
        aVar.dIF = 398;
        aVar.dII = 189;
        aVar.dIJ = 1000000189;
        this.diG = aVar.KT();
        com.tencent.mm.plugin.soter.c.c bFh = com.tencent.mm.plugin.soter.c.b.bFh();
        String str10 = bFh.onE;
        String str11 = bFh.onF;
        yj yjVar = (yj) this.diG.dID.dIL;
        yjVar.jQb = str;
        yjVar.rsx = str4;
        yjVar.rsw = str3;
        yjVar.rsy = str5;
        yjVar.rsz = str2;
        yjVar.rhq = str6;
        yjVar.rrC = str7;
        yjVar.rEe = str8;
        yjVar.qZe = i;
        yjVar.rEi = str10;
        yjVar.rEh = str11;
        yjVar.rmQ = i.bOL();
        if (i2 > 0) {
            yjVar.otY = i2;
        }
        yjVar.rEj = i3;
        yjVar.rEk = str9;
        x.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str9});
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        yk ykVar = (yk) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(ykVar.iwS), ykVar.iwT});
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneGenPrepay", "rr " + ykVar.rEf);
            this.pCN = ykVar.rEf;
            this.pCO = ykVar.rEg;
        }
        String str2 = ykVar.iwT;
        this.diJ.a(i, ykVar.iwS, str2, this);
    }

    public final int getType() {
        return 398;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
