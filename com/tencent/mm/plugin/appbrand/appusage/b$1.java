package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.v;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.protocal.c.bwo;
import com.tencent.mm.protocal.c.bwp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class b$1 extends c<pk> {
    b$1() {
        this.sFo = pk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pk pkVar = (pk) bVar;
        pkVar.cai.cak = b.acE();
        if (pkVar.cah.caj) {
            pk.b bVar2 = pkVar.cai;
            pkVar.cai.cal = false;
            bVar2.cam = false;
            if (!b.acG()) {
                switch (b$2.flb[j.acY().ordinal()]) {
                    case 1:
                        pkVar.cai.cam = true;
                        break;
                    case 2:
                        pkVar.cai.cal = true;
                        break;
                }
            }
            pkVar.cai.cam = true;
            if (pkVar.cai.cal || pkVar.cai.cam) {
                j.ada();
            }
            j$c j_c = j.flO;
            i.acO();
            if (g.Eg().Dx() && v.LO()) {
                long VE = bi.VE();
                long longValue = ((Long) g.Ei().DT().get(a.sTN, Long.valueOf(0))).longValue();
                long longValue2 = ((Long) g.Ei().DT().get(a.sTP, Long.valueOf(Long.MAX_VALUE))).longValue() + ((Long) g.Ei().DT().get(a.sTO, Long.valueOf(0))).longValue();
                if (longValue2 > 0 && VE < longValue && VE >= longValue2) {
                    x.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "doReport");
                    com.tencent.mm.modelgeo.c.OB().b((a$a) com.tencent.mm.plugin.appbrand.r.c.br(new a$a() {
                        int count = 0;

                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                            com.tencent.mm.plugin.appbrand.r.c.az(this);
                            com.tencent.mm.modelgeo.c.OB().c(this);
                            int i2 = this.count;
                            this.count = i2 + 1;
                            if (i2 <= 0 && z) {
                                com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
                                aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/uploaduserlocationinfo";
                                aVar.dIF = 1154;
                                aVar.dIH = new bwp();
                                bwo bwo = new bwo();
                                bwo.latitude = (double) f2;
                                bwo.longitude = (double) f;
                                bwo.ssO = d2;
                                aVar.dIG = bwo;
                                v.a(aVar.KT(), new 1(this, f, f2, d2), true);
                            }
                            return true;
                        }
                    }), true);
                    g.Ei().DT().a(a.sTO, Long.valueOf(VE));
                }
            }
        }
        return true;
    }
}
