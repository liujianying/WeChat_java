package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends l implements k {
    private int bNI = 0;
    private b diG;
    private e diJ;
    private String hnS;
    private int hnT;
    private bhy hnU = new bhy().bq(new byte[0]);
    public LinkedList<bju> hnV;

    public j(String str) {
        this.hnS = str;
        this.hnT = 0;
    }

    public final int getType() {
        return 455;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new bjs();
        aVar.dIH = new bjt();
        aVar.uri = "/cgi-bin/micromsg-bin/searchorrecommendbiz";
        aVar.dIF = 455;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bjs bjs = (bjs) this.diG.dID.dIL;
        bjs.rQz = ab.oT(this.hnS);
        bjs.qZc = this.bNI;
        bjs.sjF = this.hnT;
        bjs.rcT = this.hnU;
        x.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "doScene:" + this.hnS + "  :" + this.bNI + "  entryFlag:" + this.hnT);
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            bjt bjt = (bjt) this.diG.dIE.dIL;
            this.hnU = bjt.sjl;
            this.hnV = bjt.sjH;
            Iterator it = this.hnV.iterator();
            while (it.hasNext()) {
                bju bju = (bju) it.next();
                com.tencent.mm.aa.j jVar = new com.tencent.mm.aa.j();
                jVar.username = ab.a(bju.rvi);
                jVar.dHR = bju.rqZ;
                jVar.dHQ = bju.rra;
                jVar.bWA = -1;
                jVar.csA = 3;
                jVar.by(true);
                com.tencent.mm.aa.q.KH().a(jVar);
            }
        } else {
            this.hnV = null;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
