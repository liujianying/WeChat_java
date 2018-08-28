package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class b extends m {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public String pCN;
    public String pCO;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9) {
        a aVar = new a();
        aVar.dIG = new yh();
        aVar.dIH = new yi();
        aVar.uri = "/cgi-bin/mmpay-bin/genmallprepay";
        aVar.dII = k.CTRL_BYTE;
        aVar.dIJ = 1000000189;
        this.diG = aVar.KT();
        yh yhVar = (yh) this.diG.dID.dIL;
        yhVar.jQb = str;
        yhVar.rsx = str4;
        yhVar.rsw = str3;
        yhVar.rsy = str5;
        yhVar.rsz = str2;
        yhVar.rhq = str6;
        yhVar.rrC = str7;
        yhVar.rEe = str8;
        yhVar.qZe = i;
        yhVar.jTB = str9;
        if (i2 > 0) {
            yhVar.otY = i2;
        }
        x.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        yi yiVar = (yi) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(yiVar.iwS), yiVar.iwT);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneGenMallPrepay", "rr " + yiVar.rEf);
            this.pCN = yiVar.rEf;
            this.pCO = yiVar.rEg;
        }
        String str2 = yiVar.iwT;
        this.diJ.a(i, yiVar.iwS, str2, this);
    }

    public final int getType() {
        return 2755;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
