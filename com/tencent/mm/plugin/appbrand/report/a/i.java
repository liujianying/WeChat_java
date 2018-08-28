package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.g.a;
import com.tencent.mm.plugin.appbrand.report.a.g.c;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    private static final i grF = new i(true, null);
    public String appId;
    public int apptype;
    public int bGF;
    public String bGG;
    public String bGH;
    public String bJK;
    public int cbB;
    public String cbC;
    public int cbu;
    public g fdO;
    public int gqK;
    public long grC;
    private final boolean grE;
    private final g grG;
    boolean grH = false;
    public String grI;
    public long grJ;
    public String grK;
    public int grL;
    public String grM;
    public long grN;
    public int grO;
    public int grP;
    public String grQ;
    public int scene;

    private i(boolean z, g gVar) {
        this.grE = z;
        this.grG = gVar;
    }

    public static i amP() {
        return grF;
    }

    public static i a(g gVar, String str, g gVar2) {
        i iVar = new i(false, gVar2);
        iVar.bJK = str;
        AppBrandStatObject appBrandStatObject = gVar.fcE;
        iVar.scene = appBrandStatObject.scene;
        iVar.bGG = appBrandStatObject.bGG;
        iVar.appId = gVar.mAppId;
        iVar.fdO = gVar;
        iVar.bGF = gVar.fcu.frm.fih + 1;
        iVar.cbu = gVar.fcu.frm.fii;
        iVar.gqK = appBrandStatObject.gqK;
        iVar.cbB = appBrandStatObject.cbB;
        iVar.cbC = appBrandStatObject.cbC;
        return iVar;
    }

    final void i(p pVar) {
        long VF;
        a g;
        c cVar;
        g gVar;
        AppBrandInitConfig appBrandInitConfig;
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        if (appBrandSysConfig != null) {
            this.cbu = appBrandSysConfig.frm.fii;
            this.grO = WxaCommLibRuntimeReader.abP().fii;
        }
        this.grN = pVar.gnC.grg;
        this.grC = Math.max(0, pVar.gnC.grh);
        c cVar2 = pVar.gnC;
        long j = cVar2.gre.gqM;
        long j2 = cVar2.grg;
        long j3 = cVar2.grh;
        if (j <= 0) {
            x.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s]", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), cVar2.mAppId, cVar2.grf});
            if (j2 > 0 && j3 > 0 && j == 0) {
                VF = bi.VF() - j2;
                this.grJ = VF;
                this.bGH = pVar.getURL();
                this.grQ = pVar.ahc();
                this.grI = com.tencent.mm.plugin.appbrand.report.a.cH(ad.getContext());
                g = this.grG.g(pVar);
                if (g != null) {
                    x.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[]{pVar.ahc()});
                    cVar = null;
                } else {
                    cVar = g.grs;
                }
                this.grL = cVar != null ? 0 : cVar.type;
                this.grM = cVar != null ? null : cVar.path;
                this.grP = this.grG.vr(this.grQ) ? 1 : 0;
                gVar = pVar.fdO;
                appBrandInitConfig = gVar != null ? null : gVar.fct;
                if (appBrandInitConfig == null) {
                    this.apptype = appBrandInitConfig.bGM;
                } else {
                    this.apptype = b.vo(this.appId);
                    x.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[]{Integer.valueOf(this.apptype)});
                }
                this.apptype += 1000;
            }
        }
        VF = Math.max(0, j);
        this.grJ = VF;
        this.bGH = pVar.getURL();
        this.grQ = pVar.ahc();
        this.grI = com.tencent.mm.plugin.appbrand.report.a.cH(ad.getContext());
        g = this.grG.g(pVar);
        if (g != null) {
            cVar = g.grs;
        } else {
            x.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[]{pVar.ahc()});
            cVar = null;
        }
        if (cVar != null) {
        }
        this.grL = cVar != null ? 0 : cVar.type;
        if (cVar != null) {
        }
        this.grM = cVar != null ? null : cVar.path;
        if (this.grG.vr(this.grQ)) {
        }
        this.grP = this.grG.vr(this.grQ) ? 1 : 0;
        gVar = pVar.fdO;
        if (gVar != null) {
        }
        if (appBrandInitConfig == null) {
            this.apptype = b.vo(this.appId);
            x.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[]{Integer.valueOf(this.apptype)});
        } else {
            this.apptype = appBrandInitConfig.bGM;
        }
        this.apptype += 1000;
    }

    public final String toString() {
        return "kv_13536{scene=" + this.scene + ", sceneNote='" + this.bGG + '\'' + ", sessionId='" + this.bJK + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.cbu + ", appState=" + this.bGF + ", usedState=" + this.gqK + ", pagePath='" + this.bGH + '\'' + ", networkType='" + this.grI + '\'' + ", costTime=" + this.grC + ", stayTime=" + this.grJ + ", referPagePath='" + this.grK + '\'' + ", targetAction=" + this.grL + ", targetPagePath='" + this.grM + '\'' + ", clickTimestamp=" + this.grN + ", publicLibVersion=" + this.grO + ", preScene=" + this.cbB + ", preSceneNote='" + this.cbC + '\'' + ", isEntrance=" + this.grP + ", apptype=" + this.apptype + '}';
    }

    final void xP() {
        if (!this.grE) {
            x.i("MicroMsg.AppBrand.Report.kv_13536", "report " + toString());
            1 1 = new 1(this, new Object[]{Integer.valueOf(this.scene), this.bGG, this.bJK, this.appId, Integer.valueOf(this.cbu), Integer.valueOf(this.bGF), Integer.valueOf(this.gqK), this.bGH, this.grI, Long.valueOf(this.grC), Long.valueOf(this.grJ), this.grK, Integer.valueOf(this.grL), this.grM, Long.valueOf(this.grN), Integer.valueOf(this.grO), Integer.valueOf(this.cbB), this.cbC, Integer.valueOf(this.grP), this.grQ, Integer.valueOf(this.apptype)});
            if (this.grH) {
                1.run();
                try {
                    KVCommCrossProcessReceiver.brP();
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", e, "sendKV", new Object[0]);
                    return;
                }
            }
            com.tencent.mm.plugin.appbrand.r.c.Em().H(1);
        }
    }
}
