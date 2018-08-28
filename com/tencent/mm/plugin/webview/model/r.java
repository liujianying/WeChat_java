package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arz;
import com.tencent.mm.protocal.c.asa;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends l implements k {
    private final b diG;
    private e doG;
    public String pRp;
    public String pRq;
    public String pRr;
    public int pRs;
    public String sign;

    public r(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new arz();
        aVar.dIH = new asa();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        aVar.dIF = 1177;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        arz arz = (arz) this.diG.dID.dIL;
        arz.hva = str;
        arz.rFf = str2;
        arz.hyG = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            asa asa = (asa) this.diG.dIE.dIL;
            this.pRp = asa.pRp;
            this.sign = asa.sign;
            this.pRq = asa.pRq;
            this.pRr = asa.pRr;
            this.pRs = asa.pRs;
            x.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[]{this.pRp, this.sign, this.pRq, this.pRr, Integer.valueOf(this.pRs)});
        }
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1177;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
