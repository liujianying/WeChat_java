package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.g.a;
import com.tencent.mm.protocal.c.cgu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    private static final k gsi = new k(true, g.grq);
    public String appId;
    public int bGF;
    public String bGG;
    public String bGH;
    public String bJK;
    public int cbB;
    public String cbC;
    public int gqK;
    private final boolean grE;
    private final g grG;
    public String grK;
    public int grP;
    public int scene;

    private k(boolean z, g gVar) {
        this.grE = z;
        this.grG = gVar;
    }

    public static k amQ() {
        return gsi;
    }

    public static k b(g gVar, String str, g gVar2) {
        k kVar = new k(false, gVar2);
        kVar.bJK = str;
        kVar.appId = gVar.mAppId;
        AppBrandStatObject appBrandStatObject = gVar.fcE;
        kVar.scene = appBrandStatObject.scene;
        kVar.bGG = appBrandStatObject.bGG;
        kVar.cbB = appBrandStatObject.cbB;
        kVar.cbC = appBrandStatObject.cbC;
        kVar.gqK = appBrandStatObject.gqK;
        kVar.bGF = gVar.fcu.frm.fih + 1;
        return kVar;
    }

    public final void j(p pVar) {
        int i;
        this.bGH = pVar.ahc();
        a g = this.grG.g(pVar);
        String str = (g == null || g.grt == null) ? null : g.grt.path;
        this.grK = str;
        if (this.grG.vr(this.bGH)) {
            i = 1;
        } else {
            i = 0;
        }
        this.grP = i;
        if (!this.grE) {
            cgu cgu = new cgu();
            cgu.hcE = 1;
            cgu.jQb = this.appId;
            cgu.sAS = this.bGH;
            cgu.mEb = 0;
            cgu.ixe = (int) bi.VE();
            cgu.mEc = 1;
            cgu.sAT = "";
            cgu.sAU = this.bGF;
            cgu.sAV = this.bJK;
            cgu.sAW = com.tencent.mm.plugin.appbrand.report.a.cH(ad.getContext());
            cgu.pPq = this.scene;
            cgu.sAX = this.gqK;
            cgu.sAY = this.bGG;
            cgu.grK = this.grK;
            cgu.cbB = this.cbB;
            cgu.cbC = this.cbC;
            cgu.grP = this.grP;
            AppBrandIDKeyBatchReport.a(cgu);
            x.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
        }
    }

    public final String toString() {
        return "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.bJK + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.bGG + '\'' + ", preScene=" + this.cbB + ", preSceneNote='" + this.cbC + '\'' + ", pagePath='" + this.bGH + '\'' + ", usedState=" + this.gqK + ", appState=" + this.bGF + ", referPagePath='" + this.grK + '\'' + ", isEntrance=" + this.grP + '}';
    }
}
