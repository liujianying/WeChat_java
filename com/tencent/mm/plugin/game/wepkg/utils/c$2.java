package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.ub.a;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.game.wepkg.a.d;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.game.wepkg.model.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class c$2 extends c<ub> {
    final /* synthetic */ c kgq;

    c$2(c cVar) {
        this.kgq = cVar;
        this.sFo = ub.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ub ubVar = (ub) bVar;
        boolean AG = ad.cic() ? g.AU().AG() : b.kgl;
        x.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[]{Integer.valueOf(ubVar.cfW.bIH)});
        switch (ubVar.cfW.bIH) {
            case 0:
                if (!AG) {
                    d.Em().H(new 1(this));
                    break;
                }
                break;
            case 1:
                if (!AG) {
                    WepkgVersionManager.g(ubVar.cfW.cfX, 1, ubVar.cfW.cga, 0);
                    break;
                }
                break;
            case 2:
                if (!AG) {
                    a aVar = ubVar.cfW;
                    d aVo = d.aVo();
                    String str = ubVar.cfW.cfX;
                    if (!aVo.fAQ || bi.oW(str)) {
                        AG = false;
                    } else {
                        com.tencent.mm.plugin.game.wepkg.a.c DV = aVo.DV(str);
                        AG = DV != null && DV.field_bigPackageReady && DV.field_preloadFilesReady;
                    }
                    aVar.cfY = AG;
                    break;
                }
                break;
            case 3:
                if (ad.cic()) {
                    com.tencent.mm.plugin.game.wepkg.model.b.aVv().aVw();
                    break;
                }
                break;
            case 4:
                if (!AG) {
                    WepkgVersion En = com.tencent.mm.plugin.game.wepkg.model.g.En(ubVar.cfW.cfX);
                    if (En != null) {
                        ubVar.cfW.cfZ = En.kga;
                        x.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[]{Integer.valueOf(ubVar.cfW.cfZ)});
                        break;
                    }
                }
                break;
            case 5:
                if (!AG) {
                    if (bi.bG(Long.valueOf(bi.c((Long) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sXR, Long.valueOf(0)))).longValue()) > 60) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sXR, Long.valueOf(bi.VE()));
                        AG = c.a(this.kgq, 1);
                    } else {
                        AG = false;
                    }
                    if (!AG && bi.bG(Long.valueOf(bi.c((Long) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sXQ, Long.valueOf(0)))).longValue()) > 1800) {
                        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sXQ, Long.valueOf(bi.VE()));
                        ub ubVar2 = new ub();
                        ubVar2.cfW.bIH = 0;
                        com.tencent.mm.sdk.b.a.sFg.m(ubVar2);
                        break;
                    }
                }
                break;
            case 6:
                if (!bi.oW(ubVar.cfW.cfX)) {
                    f.Ei(ubVar.cfW.cfX);
                    break;
                }
                f.Ei(null);
                break;
        }
        return false;
    }
}
