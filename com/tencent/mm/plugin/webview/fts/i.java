package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.plugin.websearch.c.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.bsg;
import com.tencent.mm.protocal.c.bxd;
import com.tencent.mm.protocal.c.cfk;
import com.tencent.mm.protocal.c.chk;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i implements e {
    static final long pOZ = ((long) (d.coR() + 500));
    public a jsw;
    private l lUA = new 5(this);
    private ah nHt = new ah("WebSearchLogic_worker");
    public cfk pLd;
    private Set<String> pPa;
    volatile boolean pPc;
    volatile boolean pPd;
    volatile CountDownLatch pPe;
    private volatile j pPf;
    volatile boolean pPh;
    public c pPi = new 1(this);
    public int pPq = 0;
    public cfk pPr;
    long pPs;
    public c pPt = new 2(this);
    private com.tencent.mm.plugin.websearch.c.a.c pPu = new b();
    public a pPv = new a(this, (byte) 0);
    public b pPw = new b(this, (byte) 0);

    static /* synthetic */ boolean Ah(int i) {
        return i == CdnLogic.kAppTypeNearEvent;
    }

    static /* synthetic */ boolean Ai(int i) {
        return i == 21;
    }

    static /* synthetic */ boolean c(String str, int i, int i2, boolean z) {
        if (!TextUtils.isEmpty(str) && p.bST()) {
            int bSU = p.bSU();
            if ((bSU <= 0 || str.length() <= bSU) && i != 3) {
                if ((i == 3 || i == 20) && (z || i2 == 8)) {
                    return true;
                }
                if (((i == 14 || i == 22) && i2 == 8) || i == 16) {
                    return true;
                }
            }
        }
        return false;
    }

    public i() {
        x.d("MicroMsg.FTS.WebSearchLogic", "create WebSearchLogic");
        this.pPi.cht();
        this.pPt.cht();
        this.pPa = new HashSet();
        this.pPa.add(DownloadInfo.NETTYPE);
        this.pPa.add("currentPage");
        this.pPa.add("requestId");
        this.pPa.add("parentSearchID");
        bTL();
    }

    public final boolean ai(Map<String, Object> map) {
        boolean z = true;
        x.i("MicroMsg.FTS.WebSearchLogic", "getSearchData: %s", new Object[]{map.toString()});
        h.Bh(bi.p(map.get("webview_instance_id"), -1)).c(p.c(map, DownloadSettingTable$Columns.TYPE, 0), p.t(map, "query"), (Map) map);
        if (this.pPc) {
            this.pPc = false;
            int p = bi.p(map.get("webview_instance_id"), -1);
            if (this.pPf != null) {
                this.pPf.bWo = p;
            }
            if (j(aj(map))) {
                if (this.pPe != null) {
                    this.pPe.countDown();
                }
                if (this.pPf != null) {
                    x.i("MicroMsg.FTS.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[]{Integer.valueOf(this.pPf.bWo), this.pPf});
                }
            } else {
                x.e("MicroMsg.FTS.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
                this.pPd = true;
                if (this.pPe != null) {
                    this.pPe.countDown();
                }
                z = false;
            }
        } else {
            if (this.pPe != null) {
                this.pPe.countDown();
            }
            z = false;
        }
        if (z) {
            x.i("MicroMsg.FTS.WebSearchLogic", "waiting for pre getdata back");
        } else {
            this.pPv.b(ak(map));
        }
        return false;
    }

    private boolean j(Set<String> set) {
        return set == null || this.pPa.containsAll(set);
    }

    private static Set<String> aj(Map<String, Object> map) {
        Throwable e;
        String t = p.t(map, "extReqParams");
        if (bi.oW(t)) {
            return Collections.emptySet();
        }
        Set<String> hashSet;
        try {
            hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(t);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ps psVar = new ps();
                    hashSet.add(jSONObject.optString("key", ""));
                }
                return hashSet;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
                return hashSet;
            }
        } catch (Exception e3) {
            e = e3;
            hashSet = null;
            x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
            return hashSet;
        }
    }

    public final boolean a(String str, String str2, String str3, String str4, int i, String str5) {
        x.i("MicroMsg.FTS.WebSearchLogic", "preGetSearchData");
        Map hashMap = new HashMap();
        hashMap.put("displayPattern", "2");
        hashMap.put("query", str4);
        hashMap.put("scene", String.valueOf(i));
        hashMap.put(DownloadSettingTable$Columns.TYPE, "0");
        hashMap.put("sceneActionType", "1");
        hashMap.put("isHomePage", "1");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", DownloadInfo.NETTYPE);
            jSONObject.put("textValue", p.bjC());
            jSONArray.put(jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("key", "currentPage");
            jSONObject.put("textValue", 1);
            jSONArray.put(jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("key", "requestId");
            jSONObject.put("textValue", str);
            jSONArray.put(jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("key", "parentSearchID");
            jSONObject.put("textValue", str5);
            jSONArray.put(jSONObject);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
        }
        hashMap.put("extReqParams", jSONArray.toString());
        hashMap.put("sessionId", str2);
        hashMap.put("subSessionId", str3);
        hashMap.put("requestId", str);
        j ak = ak(hashMap);
        ak.pLh = true;
        if (al(ak.pKZ)) {
            this.pPv.b(ak);
            return false;
        }
        throw new IllegalStateException("pre get data must use same commKvSets with hardcode set");
    }

    private boolean al(LinkedList<ps> linkedList) {
        Set hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hashSet.add(((ps) it.next()).aAL);
        }
        return this.pPa.equals(hashSet);
    }

    private j ak(Map<String, Object> map) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Object obj;
        int c = p.c(map, "scene", 0);
        j jVar = new j();
        jVar.bHt = p.t(map, "query");
        jVar.offset = p.c(map, "offset", 0);
        jVar.iPZ = p.c(map, DownloadSettingTable$Columns.TYPE, 0);
        jVar.scene = c;
        jVar.pKR = p.t(map, "sugId");
        jVar.pKT = p.c(map, "sugType", 0);
        jVar.pKS = p.t(map, "prefixSug");
        jVar.pLe = p.t(map, "poiInfo");
        jVar.pKO = p.u(map, "isHomePage") ? 1 : 0;
        jVar.iow = p.t(map, "searchId");
        if (map.containsKey("sessionId")) {
            jVar.bJK = p.t(map, "sessionId");
        }
        jVar.pKQ = p.c(map, "sceneActionType", 1);
        jVar.pKV = p.c(map, "displayPattern", 2);
        jVar.pKW = p.c(map, "sugPosition", 0);
        jVar.pKX = p.t(map, "sugBuffer");
        jVar.kJG = p.t(map, "requestId");
        jVar.bJK = p.t(map, "sessionId");
        jVar.bWr = p.t(map, "subSessionId");
        jVar.pLf = p.t(map, "tagId");
        String t = p.t(map, "extReqParams");
        if (!bi.oW(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (c = 0; c < jSONArray.length(); c++) {
                    jSONObject = jSONArray.getJSONObject(c);
                    ps psVar = new ps();
                    psVar.aAL = jSONObject.optString("key", "");
                    psVar.rtU = (long) jSONObject.optInt("uintValue", 0);
                    psVar.rtV = jSONObject.optString("textValue", "");
                    jVar.pKZ.add(psVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        t = p.t(map, "matchUser");
        if (!bi.oW(t)) {
            try {
                jSONObject2 = new JSONObject(t);
                bxd bxd = new bxd();
                bxd.hbL = jSONObject2.optString("userName");
                bxd.stJ = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(bxd.hbL)) {
                    jVar.pKP.add(bxd);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        t = p.t(map, "prefixQuery");
        if (!bi.oW(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (c = 0; c < jSONArray.length(); c++) {
                    jVar.pKU.add(jSONArray.getString(c));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        t = p.t(map, "tagInfo");
        if (!bi.oW(t)) {
            try {
                jSONObject2 = new JSONObject(t);
                jVar.pKY = new bsg();
                jVar.pKY.spO = jSONObject2.optString("tagText");
                jVar.pKY.spN = jSONObject2.optInt("tagType");
                jVar.pKY.spP = jSONObject2.optString("tagExtValue");
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        t = p.t(map, "numConditions");
        if (!bi.oW(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (c = 0; c < jSONArray.length(); c++) {
                    jSONObject = jSONArray.optJSONObject(c);
                    awg awg = new awg();
                    awg.rZA = jSONObject.optLong("from");
                    awg.rZB = jSONObject.optLong("to");
                    awg.rZz = jSONObject.optInt("field");
                    jVar.pLa.add(awg);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        jVar.bWo = bi.p(map.get("webview_instance_id"), -1);
        jVar.aem = w.fD(ad.getContext());
        jVar.jru = p.c(map, "subType", 0);
        if (n.aot()) {
            jVar.pLb = p.c(map, "isWeAppMore", 0);
            if (jVar.pLb == 1) {
                jVar.pLc = new chk();
                hx hxVar = new hx();
                com.tencent.mm.sdk.b.a.sFg.m(hxVar);
                jVar.pLc.sBm = hxVar.bRs.bRt;
                jVar.pLc.sBo = com.tencent.mm.modelappbrand.b.dFx;
                jVar.pLc.sBn = p.c(map, "subType", 0);
                jVar.pLc.srZ = com.tencent.mm.modelappbrand.b.dFw;
                jVar.pLc.sBp = jVar.pKW;
                au.HU();
                obj = com.tencent.mm.model.c.DT().get(aa.a.sVB, null);
                if (obj != null && (obj instanceof String)) {
                    jVar.pLc.sAz = (String) obj;
                }
            }
        }
        if (this.pPq == 1) {
            jVar.pLd = this.pLd;
        } else {
            jVar.pLd = null;
        }
        t = jVar.bHt;
        com.tencent.mm.plugin.webview.fts.b.a.a.bTN();
        com.tencent.mm.plugin.webview.fts.b.a.a.a Qg = com.tencent.mm.plugin.webview.fts.b.a.a.Qg(t);
        if (Qg == null) {
            obj = "";
        } else {
            x.i("MicroMsg.FTS.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[]{Qg.pPR, Qg.bPS, Qg.pPP, Qg.pPQ});
            this.pLd = new cfk();
            this.pLd.szS = 1;
            this.pLd.szT = new iv();
            this.pLd.szT.bPS = Qg.bPS;
            this.pLd.szT.rka = bi.WU(Qg.pPP);
            this.pLd.szT.rkc = Qg.pPQ;
            obj = Qg.pPR;
        }
        if (!TextUtils.isEmpty(obj)) {
            jVar.bHt = obj;
            jVar.pLd = this.pLd;
        }
        if (jVar.scene == 33 && this.pPr != null) {
            if (jVar.pLd == null) {
                jVar.pLd = new cfk();
            }
            if (jVar.pLd.szT == null) {
                jVar.pLd.szT = new iv();
            }
            if (this.pPr.szT != null) {
                jVar.pLd.szT.rki = this.pPr.szT.rki;
                x.i("MicroMsg.FTS.WebSearchLogic", "websearch from url [%s]", new Object[]{this.pPr.szT.rki});
            }
            this.pPr = null;
        }
        if (jVar.iPZ == 262144 && this.pPr != null && this.pPr.szT.rkf == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("isRefresh", 1);
            bundle.putString("widgetId", p.t(map, "widgetId"));
            jVar.pLg = bundle;
            jVar.pLd = this.pPr;
            this.pPr = null;
        }
        return jVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        String str2 = "MicroMsg.FTS.WebSearchLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(lVar != null ? lVar.getType() : 0);
        x.v(str2, str3, objArr);
        if (lVar instanceof com.tencent.mm.plugin.websearch.api.a) {
            au.DF().b(lVar.getType(), this);
            com.tencent.mm.plugin.websearch.api.a aVar = (com.tencent.mm.plugin.websearch.api.a) lVar;
            if (i == 0 && i2 == 0) {
                str3 = aVar.JS();
                int JT = aVar.JT();
                x.i("MicroMsg.FTS.WebSearchLogic", "callback %s", new Object[]{aVar.pKM});
                a(aVar.pKL, str3, aVar.bSI(), aVar.bWs, aVar.pKN);
                if (JT > 0) {
                    x.i("MicroMsg.FTS.WebSearchLogic", "updateCode %d, need update", new Object[]{Integer.valueOf(JT)});
                    com.tencent.mm.pluginsdk.g.a.a.b.c.ccr();
                    com.tencent.mm.pluginsdk.g.a.a.b.BK(27);
                    return;
                }
                return;
            }
            x.i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", new Object[]{aVar.pKM});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            a(aVar.pKL, jSONObject.toString(), aVar.bSI(), aVar.bWs, null);
        } else if (lVar instanceof com.tencent.mm.plugin.websearch.api.b) {
            au.DF().b(lVar.getType(), this);
            com.tencent.mm.plugin.websearch.api.b bVar = (com.tencent.mm.plugin.websearch.api.b) lVar;
            if (i == 0 && i2 == 0) {
                h.Bh(bVar.pKL).RH(bVar.JS());
                return;
            }
            x.i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", new Object[]{bVar.fur});
            h.Bh(bVar.pKL).RH("{}");
        }
    }

    private void a(int i, String str, boolean z, String str2, Bundle bundle) {
        this.nHt.H(new 4(this, i, str2, str, z, bundle));
    }

    public final boolean al(Map<String, Object> map) {
        x.i("MicroMsg.FTS.WebSearchLogic", "getSuggestionData %s", new Object[]{map});
        j jVar = new j();
        jVar.bHt = p.t(map, "query");
        try {
            jVar.bHt = URLDecoder.decode(jVar.bHt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        jVar.iPZ = p.c(map, DownloadSettingTable$Columns.TYPE, 0);
        jVar.scene = p.c(map, "scene", 0);
        jVar.pKO = p.u(map, "isHomePage") ? 1 : 0;
        jVar.bWo = bi.p(map.get("webview_instance_id"), -1);
        jVar.pKU.add(p.t(map, "prefixQuery"));
        int c = p.c(map, "requestType", 0);
        jVar.jru = p.c(map, "subtype", 0);
        x.i("MicroMsg.FTS.WebSearchLogic", "getSearchData, webviewID = %d", new Object[]{Integer.valueOf(jVar.bWo)});
        if (n.aot()) {
            jVar.pLb = p.c(map, "isWeAppMore", 0);
            if (jVar.pLb == 1) {
                jVar.pLc = new chk();
                hx hxVar = new hx();
                com.tencent.mm.sdk.b.a.sFg.m(hxVar);
                jVar.pLc.sBm = hxVar.bRs.bRt;
                jVar.pLc.sBo = com.tencent.mm.modelappbrand.b.dFx;
                jVar.pLc.sBn = p.c(map, "subType", 0);
                jVar.pLc.srZ = com.tencent.mm.modelappbrand.b.dFw;
                au.HU();
                Object obj = com.tencent.mm.model.c.DT().get(aa.a.sVB, null);
                if (obj != null && (obj instanceof String)) {
                    jVar.pLc.sAz = (String) obj;
                }
            }
        }
        switch (c) {
            case 0:
                b bVar = this.pPw;
                if (bVar.pPD != null) {
                    au.DF().b(bVar.pPD.getType(), bVar.pPx);
                    au.DF().c(bVar.pPD);
                    bVar.pPD = null;
                }
                if (bVar.pPD == null) {
                    com.tencent.mm.plugin.websearch.api.b pVar = !n.aot() ? Ah(jVar.scene) ? new com.tencent.mm.modelappbrand.p(jVar.bHt, jVar.scene, jVar.bWo) : new g(jVar) : new g(jVar);
                    bVar.pPD = pVar;
                    au.DF().a(bVar.pPD.getType(), bVar.pPx);
                    au.DF().a(bVar.pPD, 0);
                    break;
                }
                break;
            case 1:
                String str = jVar.bHt;
                int i = jVar.iPZ;
                int i2 = jVar.bWo;
                if (!bi.oW(str)) {
                    int[] iArr;
                    if (this.jsw != null) {
                        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.jsw);
                        this.jsw = null;
                    }
                    switch (i) {
                        case 8:
                            iArr = new int[]{131072};
                            break;
                        default:
                            iArr = null;
                            break;
                    }
                    if (iArr != null) {
                        com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                        iVar.jsn = 16;
                        iVar.bWm = str;
                        iVar.jsq = iArr;
                        iVar.jss = 5;
                        iVar.jsu = com.tencent.mm.plugin.fts.a.c.b.jsU;
                        iVar.jst = new HashSet();
                        iVar.jsv = this.lUA;
                        this.jsw = ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).search(2, iVar);
                        this.jsw.jrq = Integer.valueOf(i2);
                        break;
                    }
                }
                break;
            case 2:
                h.Bh(jVar.bWo).RH(u.bSZ());
                break;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject a(com.tencent.mm.plugin.fts.a.a.l r12, com.tencent.mm.plugin.fts.a.a.g r13) {
        /*
        r9 = 0;
        r2 = 0;
        r1 = 1;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FR();
        r3 = r12.jrv;
        r4 = r0.Yg(r3);
        r0 = r12.jrv;
        r5 = com.tencent.mm.plugin.fts.a.d.Bc(r0);
        r0 = r12.jru;
        switch(r0) {
            case 1: goto L_0x01c6;
            case 2: goto L_0x01c3;
            case 3: goto L_0x009e;
            case 4: goto L_0x00ba;
            case 5: goto L_0x01cd;
            case 6: goto L_0x01ca;
            case 7: goto L_0x00a6;
            case 8: goto L_0x0020;
            case 9: goto L_0x0020;
            case 10: goto L_0x0020;
            case 11: goto L_0x0147;
            case 12: goto L_0x0020;
            case 13: goto L_0x0020;
            case 14: goto L_0x0020;
            case 15: goto L_0x00ce;
            case 16: goto L_0x00ec;
            case 17: goto L_0x0133;
            case 18: goto L_0x011f;
            default: goto L_0x0020;
        };
    L_0x0020:
        r6 = r2;
        r3 = r2;
        r7 = r2;
        r8 = r2;
        r4 = r9;
        r10 = r9;
    L_0x0026:
        if (r8 == 0) goto L_0x01bd;
    L_0x0028:
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r5, r13, r3, r6);
        r1 = com.tencent.mm.plugin.fts.a.a.d.a.jrJ;
        r0.jrA = r1;
        r1 = "<em class=\"highlight\">";
        r0.jrF = r1;
        r1 = "</em>";
        r0.jrG = r1;
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r0 = r0.toString();
        r1 = r0;
    L_0x0045:
        if (r7 == 0) goto L_0x01ba;
    L_0x0047:
        r0 = com.tencent.mm.plugin.fts.a.a.d.a(r4, r13, r3, r6);
        r2 = com.tencent.mm.plugin.fts.a.a.d.a.jrJ;
        r0.jrA = r2;
        r2 = "<em class=\"highlight\">";
        r0.jrF = r2;
        r2 = "</em>";
        r0.jrG = r2;
        r0 = com.tencent.mm.plugin.fts.a.f.a(r0);
        r0 = r0.jrO;
        r0 = r0.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r10);
        r0 = r2.append(r0);
        r0 = r0.toString();
    L_0x0074:
        r2 = new org.json.JSONObject;
        r2.<init>();
        r3 = "nickName";
        r4 = r12.jrv;	 Catch:{ JSONException -> 0x01b7 }
        r4 = com.tencent.mm.plugin.fts.a.d.Bc(r4);	 Catch:{ JSONException -> 0x01b7 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x01b7 }
        r3 = "userName";
        r4 = r12.jrv;	 Catch:{ JSONException -> 0x01b7 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x01b7 }
        if (r8 == 0) goto L_0x0095;
    L_0x008f:
        r3 = "nickNameHighlight";
        r2.put(r3, r1);	 Catch:{ JSONException -> 0x01b7 }
    L_0x0095:
        if (r7 == 0) goto L_0x009d;
    L_0x0097:
        r1 = "extraHighlight";
        r2.put(r1, r0);	 Catch:{ JSONException -> 0x01b7 }
    L_0x009d:
        return r2;
    L_0x009e:
        r0 = r1;
    L_0x009f:
        r3 = r1;
    L_0x00a0:
        r6 = r0;
        r7 = r2;
        r8 = r1;
        r4 = r9;
        r10 = r9;
        goto L_0x0026;
    L_0x00a6:
        r0 = r1;
    L_0x00a7:
        r3 = r1;
    L_0x00a8:
        r4 = r4.field_nickname;
        r6 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r7 = com.tencent.mm.R.l.search_contact_tag_nickname;
        r9 = r6.getString(r7);
        r6 = r0;
        r7 = r1;
        r8 = r2;
        r10 = r9;
        goto L_0x0026;
    L_0x00ba:
        r0 = r4.csT;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r4 = com.tencent.mm.R.l.search_contact_tag_description;
        r9 = r3.getString(r4);
        r6 = r2;
        r3 = r2;
        r7 = r1;
        r8 = r2;
        r4 = r0;
        r10 = r9;
        goto L_0x0026;
    L_0x00ce:
        r0 = r4.wM();
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r3 == 0) goto L_0x00da;
    L_0x00d8:
        r0 = r4.field_username;
    L_0x00da:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r4 = com.tencent.mm.R.l.search_contact_tag_wxid;
        r9 = r3.getString(r4);
        r6 = r2;
        r3 = r2;
        r7 = r1;
        r8 = r2;
        r4 = r0;
        r10 = r9;
        goto L_0x0026;
    L_0x00ec:
        r3 = r12.content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r0 != 0) goto L_0x01c0;
    L_0x00f4:
        r0 = "​";
        r6 = r3.split(r0);
        r7 = r6.length;
        r4 = r2;
    L_0x00fd:
        if (r4 >= r7) goto L_0x01c0;
    L_0x00ff:
        r0 = r6[r4];
        r8 = r13.jrV;
        r8 = r0.startsWith(r8);
        if (r8 == 0) goto L_0x011b;
    L_0x0109:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r4 = com.tencent.mm.R.l.search_contact_tag_mobile;
        r9 = r3.getString(r4);
        r6 = r2;
        r3 = r2;
        r7 = r1;
        r8 = r2;
        r4 = r0;
        r10 = r9;
        goto L_0x0026;
    L_0x011b:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x00fd;
    L_0x011f:
        r0 = r12.content;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r4 = com.tencent.mm.R.l.search_contact_tag_province;
        r9 = r3.getString(r4);
        r6 = r2;
        r3 = r2;
        r7 = r1;
        r8 = r2;
        r4 = r0;
        r10 = r9;
        goto L_0x0026;
    L_0x0133:
        r0 = r12.content;
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r4 = com.tencent.mm.R.l.search_contact_tag_city;
        r9 = r3.getString(r4);
        r6 = r2;
        r3 = r2;
        r7 = r1;
        r8 = r2;
        r4 = r0;
        r10 = r9;
        goto L_0x0026;
    L_0x0147:
        r0 = com.tencent.mm.plugin.fts.a.n.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.fts.a.n) r0;
        r0 = r0.getFTSMainDB();
        r3 = r4.field_contactLabelIds;
        r4 = r0.Cr(r3);
        r6 = new java.lang.StringBuffer;
        r6.<init>();
        r7 = r13.jrX;
        r8 = r7.length;
        r3 = r2;
    L_0x0162:
        if (r3 >= r8) goto L_0x018e;
    L_0x0164:
        r9 = r7[r3];
        r10 = r4.iterator();
    L_0x016a:
        r0 = r10.hasNext();
        if (r0 == 0) goto L_0x018a;
    L_0x0170:
        r0 = r10.next();
        r0 = (java.lang.String) r0;
        r11 = com.tencent.mm.plugin.fts.a.d.Cv(r0);
        r11 = r11.contains(r9);
        if (r11 == 0) goto L_0x016a;
    L_0x0180:
        r6.append(r0);
        r0 = ",";
        r6.append(r0);
        goto L_0x016a;
    L_0x018a:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0162;
    L_0x018e:
        r6.trimToSize();
        r0 = r6.length();
        if (r0 != 0) goto L_0x01ac;
    L_0x0197:
        r0 = "";
    L_0x019a:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r4 = com.tencent.mm.R.l.search_contact_tag_tag;
        r9 = r3.getString(r4);
        r6 = r2;
        r3 = r2;
        r7 = r1;
        r8 = r2;
        r4 = r0;
        r10 = r9;
        goto L_0x0026;
    L_0x01ac:
        r0 = r6.length();
        r0 = r0 + -1;
        r0 = r6.substring(r2, r0);
        goto L_0x019a;
    L_0x01b7:
        r0 = move-exception;
        goto L_0x009d;
    L_0x01ba:
        r0 = r4;
        goto L_0x0074;
    L_0x01bd:
        r1 = r5;
        goto L_0x0045;
    L_0x01c0:
        r0 = r3;
        goto L_0x0109;
    L_0x01c3:
        r0 = r2;
        goto L_0x009f;
    L_0x01c6:
        r0 = r2;
        r3 = r2;
        goto L_0x00a0;
    L_0x01ca:
        r0 = r2;
        goto L_0x00a7;
    L_0x01cd:
        r0 = r2;
        r3 = r2;
        goto L_0x00a8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.i.a(com.tencent.mm.plugin.fts.a.a.l, com.tencent.mm.plugin.fts.a.a.g):org.json.JSONObject");
    }

    public final void bTL() {
        Object zY = p.zY(0);
        x.i("MicroMsg.FTS.WebSearchLogic", "config commKV %s", new Object[]{zY});
        if (TextUtils.isEmpty(zY)) {
            this.pPh = true;
        } else {
            this.pPh = j(new HashSet(Arrays.asList(zY.split(","))));
        }
    }
}
