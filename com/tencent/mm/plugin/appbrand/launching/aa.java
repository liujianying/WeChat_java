package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ab.w;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.a.b;
import com.tencent.mm.protocal.c.cgg;
import com.tencent.mm.protocal.c.chh;
import com.tencent.mm.protocal.c.chx;
import com.tencent.mm.sdk.platformtools.bi;

final class aa extends w<t> {
    final String appId;
    final int cbB;
    final int cbu;
    final int fKP;
    final int fmv;
    final AppBrandLaunchReferrer fqA;
    final String fqx;
    final int gfw;
    final String gfx;

    aa(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4) {
        int i5 = 0;
        this.appId = str;
        this.fmv = i;
        this.cbB = i2;
        this.gfw = i3;
        this.fqx = str2;
        this.fqA = appBrandLaunchReferrer;
        this.gfx = str3;
        al a = e.abi().a(str, i, new String[]{"version"});
        if (a != null) {
            i5 = a.field_version;
        }
        this.cbu = i5;
        if (i4 < 0) {
            i4 = ab.abL();
        }
        this.fKP = i4;
    }

    /* renamed from: akL */
    public final t call() {
        int i = 0;
        t tVar = new t();
        tVar.field_appId = this.appId;
        s abb = e.abb();
        if (abb == null) {
            return null;
        }
        boolean z;
        cgg cgg = new cgg();
        cgg.rRb = this.fmv;
        cgg.riv = this.cbu;
        cgg.otY = this.gfw;
        cgg.rUC = this.fqx;
        cgg.rUB = 0;
        cgg.rUA = this.cbB;
        if (1055 == this.gfw) {
            z = true;
        } else if (1037 == this.gfw) {
            z = true;
        } else {
            int[] iArr = AppBrandGlobalSystemConfig.adZ().fpL;
            z = iArr != null && a.c(iArr, this.gfw);
        }
        if (!z) {
            if (abb.a(tVar, new String[]{"appId"})) {
                if (tVar.field_jsapiInfo != null) {
                    i = 1;
                }
                if (!(i == 0 || tVar.field_launchAction == null || 1 != tVar.field_launchAction.qZk)) {
                    new com.tencent.mm.plugin.appbrand.launching.a.a(this.appId, cgg, this.gfx, this.fKP).akR();
                    return tVar;
                }
            }
        }
        chx b = b.b(this.fqA);
        chh c = b.c(this.fqA);
        long VF = bi.VF();
        com.tencent.mm.plugin.appbrand.launching.a.a aVar = new com.tencent.mm.plugin.appbrand.launching.a.a(this.appId, true, cgg, b, c, this.gfx, this.fKP);
        aVar.ggm = true;
        w.a(aVar);
        r.a(r.b.ggj, this.appId, this.cbu, this.fmv, this.gfw, bi.VF() - VF);
        return aVar.ggV;
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
    }
}
