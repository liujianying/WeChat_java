package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.launching.j.c;
import com.tencent.mm.plugin.appbrand.launching.j.d;
import com.tencent.mm.plugin.appbrand.launching.p.2;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class p$1 implements a<Void, com.tencent.mm.ab.a.a<akm>> {
    final /* synthetic */ akl gfW;
    final /* synthetic */ p gfX;

    p$1(p pVar, akl akl) {
        this.gfX = pVar;
        this.gfW = akl;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        c cVar = this.gfX.gfQ;
        if (cVar != null && (cVar instanceof d)) {
            ((d) cVar).a(aVar);
        }
        if (aVar.errCode == 0 && aVar.errType == 0 && aVar.dIv != null) {
            p pVar = this.gfX;
            akl akl = this.gfW;
            akm akm = (akm) aVar.dIv;
            2 2 = new 2(pVar);
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", new Object[]{pVar.akH(), akm.bRK, akm.url});
            boolean b = (akl.rNb <= 0 || bi.oW(akm.bRK)) ? aq.b(pVar.gfS.toString(), 0, pVar.gfU, akm.url, 2) : i.a(pVar.gfS.toString(), akl.rNb, pVar.gfU, akm.bRK, 2);
            if (!b) {
                x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s start downloadPkg failed", new Object[]{pVar.akH()});
                pVar.d(null);
            }
        } else {
            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, getDownloadURL failed %d, %d", new Object[]{this.gfX.akH(), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
            if (this.gfX.gfV) {
                x.um(x.getMMString(j.app_brand_prepare_get_cdn_url_err, new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)}));
            }
            this.gfX.d(null);
        }
        return uQG;
    }
}
