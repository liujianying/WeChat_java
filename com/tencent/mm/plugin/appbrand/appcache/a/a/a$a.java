package com.tencent.mm.plugin.appbrand.appcache.a.a;

import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;

class a$a implements a<Boolean, c<akl, akm>> {
    a$a() {
    }

    private Boolean a(c<akl, akm> cVar) {
        r rVar;
        akl akl = (akl) cVar.get(0);
        akm akm = (akm) cVar.get(1);
        if (akl.type == 0) {
            rVar = new r(akl.bPS);
        } else if (akl.type == 4) {
            rVar = new r(akl.bPS, akl.rLl);
        } else {
            throw new IllegalArgumentException(String.format("not support request.type %d", new Object[]{Integer.valueOf(akl.type)}));
        }
        b cBF = g.cBF();
        cBF.cBE();
        1 1 = new 1(this, cBF);
        x.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s downloadPkg, patch_url(%s), full_url(%s)", new Object[]{rVar.toString(), akm.bRK, akm.url});
        f fVar = new f(rVar.toString(), akl.rNc.sbG, akl.rkb, akm.url);
        e eVar = e.fft;
        aq acn = aq.acn();
        if (acn != null) {
            x.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, addRequest(%s) ret = %d", new Object[]{fVar.toShortString(), Integer.valueOf(acn.fif.b(fVar))});
            switch (acn.fif.b(fVar)) {
                case 4:
                    1.a(fVar.appId, com.tencent.mm.plugin.appbrand.appcache.base.b.a.a.fiv, null);
                    break;
                default:
                    eVar.ffu.o(fVar.qBy, 1);
                    break;
            }
        }
        x.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, null updater");
        1.a(fVar.appId, com.tencent.mm.plugin.appbrand.appcache.base.b.a.a.fiv, null);
        return Boolean.FALSE;
    }
}
