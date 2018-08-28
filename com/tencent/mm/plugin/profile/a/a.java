package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private final b diG;
    private e diJ;
    public String lUe;

    public a(String str, String str2) {
        this.lUe = str;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new akh();
        aVar.dIH = new aki();
        aVar.uri = "/cgi-bin/micromsg-bin/getwburl";
        aVar.dIF = 205;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        akh akh = (akh) this.diG.dID.dIL;
        akh.hbL = str2;
        au.HU();
        String oV = bi.oV((String) c.DT().get(46, null));
        akh.reB = new bhy().bq(bi.WP(oV));
        au.HU();
        String oV2 = bi.oV((String) c.DT().get(72, null));
        akh.rEu = new bhy().bq(bi.WP(oV2));
        x.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + oV + " , newa2:" + oV2);
    }

    public final int getType() {
        return 205;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), getURL()});
        this.diJ.a(i2, i3, str, this);
    }

    public final String getURL() {
        return ((aki) this.diG.dIE.dIL).URL;
    }
}
