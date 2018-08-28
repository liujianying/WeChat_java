package com.tencent.mm.plugin.webview.fts;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.boq;
import com.tencent.mm.protocal.c.bxd;
import com.tencent.mm.protocal.c.cfk;
import com.tencent.mm.protocal.c.cfo;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONObject;

public final class f extends a implements k {
    private j dFC;
    private b dZf;
    private e diJ;
    private int pKO;
    private cfp pOX;
    private cfo pOY;
    private int scene;

    public f(j jVar) {
        boolean z = false;
        this.dFC = jVar;
        this.pKM = jVar.bHt;
        this.bWs = jVar.kJG;
        this.tH = jVar.offset;
        this.fdx = jVar.scene;
        this.pKL = jVar.bWo;
        this.pKO = jVar.pKO;
        this.dFC = jVar;
        this.pKN = jVar.pLg;
        if (bi.oW(jVar.bHt)) {
            x.e("MicroMsg.FTS.NetSceneWebSearch", "keyword is unavailable");
            return;
        }
        int i;
        float f;
        float f2;
        x.i("MicroMsg.FTS.NetSceneWebSearch", "Constructors: keyword=%s", new Object[]{jVar.bHt});
        this.scene = jVar.scene;
        b.a aVar = new b.a();
        aVar.dIF = 719;
        aVar.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
        aVar.dIG = new cfo();
        aVar.dIH = new cfp();
        this.dZf = aVar.KT();
        this.pOY = (cfo) this.dZf.dID.dIL;
        this.pOY.rDH = jVar.bHt;
        this.pOY.shN = jVar.pKO;
        this.pOY.rll = (long) jVar.iPZ;
        this.pOY.rUI = p.JU();
        this.pOY.rjC = jVar.offset;
        this.pOY.syH = p.zP(0);
        this.pOY.sjr = jVar.pKP;
        this.pOY.otY = jVar.scene;
        this.pOY.rlo = jVar.iow;
        this.pOY.szP = jVar.pKQ;
        this.pOY.szX = jVar.pKR;
        this.pOY.szZ = jVar.pKT;
        this.pOY.szY = jVar.pKS;
        this.pOY.sAa = jVar.pKU;
        this.pOY.szQ = jVar.pKZ;
        this.pOY.pKY = jVar.pKY;
        this.pOY.sAb = jVar.pLa;
        this.pOY.iwP = jVar.aem;
        this.pOY.syL = jVar.bJK;
        if (jVar.pLd == null) {
            jVar.pLd = new cfk();
        }
        if (jVar.pLd.szT == null) {
            jVar.pLd.szT = new iv();
        }
        if (this.pOY.rUI != null) {
            iv ivVar = jVar.pLd.szT;
            c OB = c.OB();
            if (OB.dSf <= 0 || !OB.dSh || System.currentTimeMillis() - OB.dSf >= 600000) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            ivVar.rkh = i2 != 0 ? 0 : 1;
            float f3 = this.pOY.rUI.rmr;
            f = this.pOY.rUI.rms;
            f2 = f3;
        } else {
            jVar.pLd.szT.rkh = 1;
            f = 0.0f;
            f2 = 0.0f;
        }
        x.i("MicroMsg.FTS.NetSceneWebSearch", "websearch location: longitude[%f], latitude[%f], isUsingCached[%d]", new Object[]{Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(jVar.pLd.szT.rkh)});
        if (!TextUtils.isEmpty(jVar.pLe)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(jVar.pLe));
                bbb bbb = new bbb();
                bbb.eJJ = jSONObject.optString("city");
                bbb.eJQ = jSONObject.optString("country");
                bbb.rms = (float) jSONObject.optDouble("latitude");
                bbb.rmr = (float) jSONObject.optDouble("longitude");
                bbb.sdn = jSONObject.optString("poiId");
                bbb.rPL = jSONObject.optString("poiName");
                bbb.sdp = p.LP(jSONObject.optString("snsId"));
                if (!TextUtils.isEmpty(bbb.sdn)) {
                    this.pOY.sAg = bbb;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.NetSceneWebSearch", e, "", new Object[0]);
            }
        }
        if (jVar.pLd != null) {
            try {
                jVar.pLd.szU = WxaCommLibRuntimeReader.abP().fii;
                this.pOY.sAd = new com.tencent.mm.bk.b(jVar.pLd.toByteArray());
                x.v("MicroMsg.FTS.NetSceneWebSearch", "ctrl_type %d, appid %s, ext %s", new Object[]{Long.valueOf(jVar.pLd.szS), jVar.pLd.szT.bPS, jVar.pLd.szT.rkc});
            } catch (Exception e2) {
            }
        }
        if (jVar.pLc != null) {
            try {
                this.pOY.sAc = new com.tencent.mm.bk.b(jVar.pLc.toByteArray());
            } catch (Exception e3) {
            }
        }
        String str = "MicroMsg.FTS.NetSceneWebSearch";
        String str2 = "contains location = %b | matchUserSize=%d | scene=%d | businessType=%d | isHomePage=%b | sceneActionType=%d | webViewId=%d";
        Object[] objArr = new Object[7];
        objArr[0] = Boolean.valueOf(this.pOY.rUI != null);
        objArr[1] = Integer.valueOf(jVar.pKP.size());
        objArr[2] = Integer.valueOf(jVar.scene);
        objArr[3] = Integer.valueOf(jVar.iPZ);
        objArr[4] = Integer.valueOf(this.pKO);
        objArr[5] = Integer.valueOf(jVar.pKQ);
        objArr[6] = Integer.valueOf(jVar.bWo);
        x.i(str, str2, objArr);
        if (this.pOY.rUI != null) {
            o.a(2005, this.pOY.rUI.rmr, this.pOY.rUI.rms, this.pOY.rUI.ryV);
        }
        i2 = jVar.scene;
        str = jVar.bJK;
        str2 = jVar.bWr;
        String str3 = jVar.iow;
        int i3 = jVar.offset;
        if (jVar.pKO == 1) {
            z = true;
        }
        com.tencent.mm.plugin.websearch.api.o.a(i2, str, str2, str3, i3, z, jVar.kJG, jVar.bHt, jVar.iPZ, "");
    }

    public final int getType() {
        return 719;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        ad.ef(this.scene, 2);
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        boolean z = i2 == 0 && i3 == 0;
        if (i2 == 0 && i3 == 0) {
            this.pOX = (cfp) this.dZf.dIE.dIL;
            if (this.pOX != null) {
                com.tencent.mm.plugin.websearch.api.o.a(this.dFC.scene, this.dFC.bJK, this.dFC.bWr, this.dFC.iow, this.dFC.offset, this.dFC.pKO == 1, this.dFC.kJG, z, this.dFC.bHt, this.dFC.iPZ);
                x.v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", new Object[]{this.pOX.rjK});
            }
            this.diJ.a(i2, i3, str, this);
            ad.aa(this.scene, i2, i3);
            return;
        }
        this.diJ.a(i2, i3, str, this);
        com.tencent.mm.plugin.websearch.api.o.a(this.dFC.scene, this.dFC.bJK, this.dFC.bWr, this.dFC.iow, this.dFC.offset, this.dFC.pKO == 1, this.dFC.kJG, z, this.dFC.bHt, this.dFC.iPZ);
        ad.aa(this.scene, i2, i3);
    }

    public final String JS() {
        return this.pOX != null ? this.pOX.rjK : "";
    }

    public final int JT() {
        return this.pOX != null ? this.pOX.syR : 0;
    }

    public final void ak(LinkedList<bxd> linkedList) {
        this.pOY.sjr = linkedList;
        boq boq = new boq();
        boq.smC = linkedList.size();
        this.pOY.sAe = boq;
    }
}
