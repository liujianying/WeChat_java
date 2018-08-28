package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.bsg;
import com.tencent.mm.protocal.c.bxd;
import com.tencent.mm.protocal.c.chk;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.b.a;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h implements e {
    private static final long pOZ = ((long) (d.coR() + 500));
    private static h pPg = new h();
    private ah nHt = new ah("RecommendLogic_worker");
    private Set<String> pPa;
    public a pPb = new a(this, (byte) 0);
    private volatile boolean pPc;
    private volatile boolean pPd;
    private volatile CountDownLatch pPe;
    private volatile j pPf;
    private volatile boolean pPh;
    public c pPi = new 1(this);

    static /* synthetic */ boolean Af(int i) {
        return i == CdnLogic.kAppTypeNearEvent;
    }

    static /* synthetic */ boolean Ag(int i) {
        return i == 21;
    }

    public h() {
        x.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
        x.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
        this.pPi.cht();
        this.pPa = new HashSet();
        this.pPa.add(DownloadInfo.NETTYPE);
        this.pPa.add("time_zone_min");
        this.pPa.add("currentPage");
        this.pPa.add("is_prefetch");
        this.pPa.add(TencentLocation.EXTRA_DIRECTION);
        this.pPa.add("seq");
        this.pPa.add("client_exposed_info");
        this.pPa.add("requestId");
        this.pPa.add("recType");
        this.pPa.add("redPointMsgId");
        bTL();
    }

    public static h bTK() {
        return pPg;
    }

    private boolean j(Set<String> set) {
        return set == null || this.pPa.containsAll(set);
    }

    public final boolean ai(Map<String, Object> map) {
        boolean z;
        x.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[]{map.toString()});
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bh(bi.p(map.get("webview_instance_id"), -1)).c(p.c(map, DownloadSettingTable$Columns.TYPE, 0), p.t(map, "query"), (Map) map);
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
                    x.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[]{Integer.valueOf(this.pPf.bWo), this.pPf});
                }
                z = true;
            } else {
                x.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
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
        if (!z) {
            j ak = ak(map);
            a aVar = this.pPb;
            if (aVar.pPo != null) {
                aVar.pPo.gYf = true;
            }
            aVar.pPo = new a(aVar, (byte) 0);
            aVar.pPo.dFC = ak;
            aVar.pPj.pPf = ak;
            aVar.pPo.run();
        }
        return false;
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
                x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
                return hashSet;
            }
        } catch (Exception e3) {
            e = e3;
            hashSet = null;
            x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
            return hashSet;
        }
    }

    private static j ak(Map<String, Object> map) {
        JSONArray jSONArray;
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        j jVar = new j();
        jVar.bHt = p.t(map, "query");
        jVar.offset = p.c(map, "offset", 0);
        jVar.iPZ = p.c(map, DownloadSettingTable$Columns.TYPE, 0);
        jVar.scene = p.c(map, "scene", 0);
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
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.getJSONObject(i);
                    ps psVar = new ps();
                    psVar.aAL = jSONObject.optString("key", "");
                    psVar.rtU = (long) jSONObject.optInt("uintValue", 0);
                    psVar.rtV = jSONObject.optString("textValue", "");
                    jVar.pKZ.add(psVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "commKvJSONArray", new Object[0]);
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
                x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        t = p.t(map, "prefixQuery");
        if (!bi.oW(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    jVar.pKU.add(jSONArray.getString(i));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e22, "prefixQueryJSONArray", new Object[0]);
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
                x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        t = p.t(map, "numConditions");
        if (!bi.oW(t)) {
            try {
                jSONArray = new JSONArray(t);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.optJSONObject(i);
                    awg awg = new awg();
                    awg.rZA = jSONObject.optLong("from");
                    awg.rZB = jSONObject.optLong("to");
                    awg.rZz = jSONObject.optInt("field");
                    jVar.pLa.add(awg);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        jVar.bWo = bi.p(map.get("webview_instance_id"), -1);
        jVar.aem = w.fD(ad.getContext());
        jVar.jru = p.c(map, "subType", 0);
        jVar.bxk = p.c(map, "channelId", 0);
        jVar.pLi = p.t(map, "navigationId");
        if (n.aot()) {
            jVar.pLb = p.c(map, "isWeAppMore", 0);
            if (jVar.pLb == 1) {
                jVar.pLc = new chk();
                hx hxVar = new hx();
                a.sFg.m(hxVar);
                jVar.pLc.sBm = hxVar.bRs.bRt;
                jVar.pLc.sBo = b.dFx;
                jVar.pLc.sBn = p.c(map, "subType", 0);
                jVar.pLc.srZ = b.dFw;
                jVar.pLc.sBp = jVar.pKW;
                au.HU();
                Object obj = com.tencent.mm.model.c.DT().get(aa.a.sVB, null);
                if (obj != null && (obj instanceof String)) {
                    jVar.pLc.sAz = (String) obj;
                }
            }
        }
        return jVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.TopStory.RecommendLogic";
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
                String JS = aVar.JS();
                int JT = aVar.JT();
                x.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[]{aVar.pKM});
                a(aVar.pKL, JS, aVar.bSI(), aVar.bWs);
                if (JT > 0) {
                    x.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[]{Integer.valueOf(JT)});
                    com.tencent.mm.pluginsdk.g.a.a.b.c.ccr();
                    com.tencent.mm.pluginsdk.g.a.a.b.BK(27);
                    return;
                }
                return;
            }
            x.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[]{aVar.pKM});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            a(aVar.pKL, jSONObject.toString(), aVar.bSI(), aVar.bWs);
        }
    }

    private void a(int i, String str, boolean z, String str2) {
        this.nHt.H(new 2(this, i, str2, str, z));
    }

    public static void start() {
        try {
            Looper.prepare();
        } catch (Exception e) {
        }
    }

    public final void bTL() {
        Object zY = p.zY(1);
        x.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[]{zY});
        if (TextUtils.isEmpty(zY)) {
            this.pPh = true;
        } else {
            this.pPh = j(new HashSet(Arrays.asList(zY.split(","))));
        }
    }
}
