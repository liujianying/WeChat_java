package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class p {
    private static final p gsB = new p(true);
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
    private final boolean grE;
    boolean grH = false;
    public String grI;
    public String grK;
    public int grL;
    public String grM;
    public long grN;
    public int grO;
    public int grP;
    public String grQ;
    String gsC = "";
    public final LinkedList<String> gsD = new LinkedList();
    public String gsE;
    public boolean gsF = true;
    public int scene;

    private p(boolean z) {
        this.grE = z;
    }

    public static p amS() {
        return gsB;
    }

    public static p a(g gVar, String str, LinkedList<String> linkedList) {
        p pVar = new p(false);
        pVar.bJK = str;
        AppBrandStatObject appBrandStatObject = gVar.fcE;
        pVar.scene = appBrandStatObject.scene;
        pVar.bGG = appBrandStatObject.bGG;
        pVar.appId = gVar.mAppId;
        pVar.fdO = gVar;
        pVar.bGF = gVar.fcu.frm.fih + 1;
        pVar.cbu = gVar.fcu.frm.fii;
        pVar.gqK = appBrandStatObject.gqK;
        pVar.cbB = appBrandStatObject.cbB;
        pVar.cbC = appBrandStatObject.cbC;
        pVar.gsD.addAll(linkedList);
        return pVar;
    }

    public final void b(com.tencent.mm.plugin.appbrand.page.p pVar, boolean z) {
        this.grL = z ? 1 : 7;
        String str = (String) this.gsD.pollFirst();
        this.grM = str;
        this.grK = str;
        if (!z) {
            this.grM = this.gsC;
        }
        k(pVar);
    }

    public final void k(com.tencent.mm.plugin.appbrand.page.p pVar) {
        a alS = pVar.alS();
        if (alS != null) {
            int i;
            AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
            if (appBrandSysConfig != null) {
                this.cbu = appBrandSysConfig.frm.fii;
                this.grO = WxaCommLibRuntimeReader.abP().fii;
            }
            this.grN = System.currentTimeMillis();
            String url = alS.getWebView().getUrl();
            if (url == null) {
                url = "";
            }
            this.gsE = com.tencent.mm.compatible.util.p.encode(url);
            this.bGH = pVar.getURL();
            this.grQ = pVar.ahc();
            this.grI = com.tencent.mm.plugin.appbrand.report.a.cH(ad.getContext());
            if (this.gsF) {
                i = 1;
            } else {
                i = 0;
            }
            this.grP = i;
            this.gsF = false;
            g gVar = pVar.fdO;
            AppBrandInitConfig appBrandInitConfig = gVar == null ? null : gVar.fct;
            if (appBrandInitConfig != null) {
                this.apptype = appBrandInitConfig.bGM;
            } else {
                this.apptype = b.vo(this.appId);
                x.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[]{Integer.valueOf(this.apptype)});
            }
            this.apptype += 1000;
            if (!this.grE) {
                x.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
                1 1 = new 1(this, new Object[]{Integer.valueOf(this.scene), this.bGG, this.bJK, this.appId, Integer.valueOf(this.cbu), Integer.valueOf(this.bGF), Integer.valueOf(this.gqK), this.bGH, this.gsE, this.grI, this.grK, Integer.valueOf(this.grL), this.grM, Long.valueOf(this.grN), Integer.valueOf(this.grO), Integer.valueOf(this.cbB), this.cbC, Integer.valueOf(this.grP), this.grQ, Integer.valueOf(this.apptype)});
                if (this.grH) {
                    1.run();
                    try {
                        KVCommCrossProcessReceiver.brP();
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", e, "sendKV", new Object[0]);
                        return;
                    }
                }
                c.Em().H(1);
            }
        }
    }

    public final String toString() {
        return "kv_4992{scene=" + this.scene + ", sceneNote='" + this.bGG + '\'' + ", sessionId='" + this.bJK + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.cbu + ", appState=" + this.bGF + ", usedState=" + this.gqK + ", pagePath='" + this.bGH + '\'' + ", currentUrl='" + this.gsE + '\'' + ", networkType='" + this.grI + '\'' + ", referPagePath='" + this.grK + '\'' + ", targetAction=" + this.grL + ", targetPagePath='" + this.grM + '\'' + ", clickTimestamp=" + this.grN + ", publicLibVersion=" + this.grO + ", preScene=" + this.cbB + ", preSceneNote='" + this.cbC + '\'' + ", isEntrance=" + this.grP + ", apptype=" + this.apptype + '}';
    }
}
