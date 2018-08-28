package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.c.bfq;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends l implements k {
    private static long hnN = 0;
    private b diG;
    private e diJ;

    public static boolean auN() {
        return System.currentTimeMillis() - hnN > 3600000;
    }

    public final int getType() {
        return 456;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        hnN = System.currentTimeMillis();
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new alk();
        aVar.dIH = new all();
        aVar.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
        aVar.dIF = 456;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            all all = (all) this.diG.dIE.dIL;
            if (all.rNY.rYP > 0) {
                x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[]{Integer.valueOf(all.rNY.rYP)});
                try {
                    byte[] toByteArray = all.rNY.toByteArray();
                    d.b(g.Ei().dqp + "search_biz_recommend", toByteArray, toByteArray.length);
                    Iterator it = all.rNY.sgQ.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((bfp) it.next()).sgP.iterator();
                        while (it2.hasNext()) {
                            bju bju = (bju) it2.next();
                            j jVar = new j();
                            jVar.username = ab.a(bju.rvi);
                            jVar.dHR = bju.rqZ;
                            jVar.dHQ = bju.rra;
                            jVar.bWA = -1;
                            jVar.csA = 3;
                            jVar.by(true);
                            com.tencent.mm.aa.q.KH().a(jVar);
                        }
                    }
                } catch (Throwable e) {
                    x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
                    x.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
                }
            } else {
                d.deleteFile(g.Ei().dqp + "search_biz_recommend");
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public static LinkedList<bfp> auO() {
        try {
            byte[] dv = d.dv(g.Ei().dqp + "search_biz_recommend", Integer.MAX_VALUE);
            if (dv != null) {
                bfq bfq = new bfq();
                bfq.aG(dv);
                x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[]{Integer.valueOf(bfq.rYP)});
                return bfq.sgQ;
            }
        } catch (Throwable e) {
            x.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
            x.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
        }
        return new LinkedList();
    }
}
