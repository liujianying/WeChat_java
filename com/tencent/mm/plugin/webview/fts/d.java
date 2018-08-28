package com.tencent.mm.plugin.webview.fts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ab.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.cdb;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d implements e {
    public c fIu = new 3(this);
    private long ghF;
    public a jsw;
    public l lUA = new 4(this);
    private Map<Integer, g> pOA = new HashMap();
    public e pOB = new e(this);
    public List<avq> pOC;
    private com.tencent.mm.plugin.websearch.c.a.c pOD;
    com.tencent.mm.plugin.websearch.c.a.d pOE;
    public Set<Integer> pOv;
    public l pOw = new 1(this);
    private HashMap<String, b> pOx;
    public g pOy;
    public m pOz;

    public d() {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
        this.pOx = new HashMap();
        this.pOv = Collections.synchronizedSet(new HashSet());
        com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
    }

    public static Bundle p(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 2:
                try {
                    String string = bundle.getString("key");
                    bundle2.putString("result", r.PX(string).toString());
                    if ("educationTab".equals(string)) {
                        JSONObject PX = r.PX("discoverSearchGuide");
                        if (PX.optJSONArray("items").length() > 0) {
                            bundle2.putString("result_1", PX.toString());
                            break;
                        }
                    }
                } catch (Exception e) {
                    break;
                }
                break;
            case 4:
                Map b = p.b(bundle.getInt("scene"), bundle.getBoolean("isHomePage"), bundle.getInt("type"));
                bundle2.putString("type", (String) b.get("type"));
                bundle2.putString("isMostSearchBiz", (String) b.get("isMostSearchBiz"));
                bundle2.putString("isLocalSug", (String) b.get("isLocalSug"));
                bundle2.putString("isSug", (String) b.get("isSug"));
                bundle2.putString("scene", (String) b.get("scene"));
                break;
            case 6:
                try {
                    bundle2.putString("result", r.PY(bundle.getString("key")));
                    break;
                } catch (Exception e2) {
                    break;
                }
            case 7:
                bundle2.putString(SlookAirButtonFrequentContactAdapter.DATA, com.tencent.mm.plugin.webview.modeltools.e.bUU().bTG());
                break;
        }
        return bundle2;
    }

    public final boolean aa(Map<String, Object> map) {
        String t;
        int c;
        switch (p.c(map, "action", 0)) {
            case 1:
                if (u.pLM == null) {
                    u.bSX();
                }
                u.pLM.hbG.clear();
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("fts_history_search_sp", 0);
                try {
                    sharedPreferences.edit().putString(u.bSY(), Base64.encodeToString(u.pLM.toByteArray(), 0)).apply();
                    x.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", new Object[]{t});
                    break;
                } catch (IOException e) {
                    break;
                }
            case 2:
                int c2 = p.c(map, "type", 0);
                c = p.c(map, "scene", 0);
                if (System.currentTimeMillis() - this.ghF > 1000) {
                    this.ghF = System.currentTimeMillis();
                    if (!p.zO(0)) {
                        x.e("MicroMsg.FTS.FTSWebViewLogic", "fts h5 template not avail");
                        break;
                    }
                    com.tencent.mm.plugin.websearch.api.ad.q(c2, c, r.PY("searchID"));
                    Intent adR = p.adR();
                    adR.putExtra("ftsneedkeyboard", true);
                    adR.putExtra("ftsbizscene", c);
                    adR.putExtra("ftsType", c2);
                    adR.putExtra("rawUrl", p.v(p.b(c, true, c2)));
                    adR.putExtra("key_load_js_without_delay", true);
                    com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", adR);
                    break;
                }
                break;
            case 3:
                g Bh = h.Bh(p.c(map, "webview_instance_id", -1));
                c = p.c(map, "scene", 0);
                t = p.t(map, "query");
                if (c == 20 && !bi.oW(t)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fts_key_new_query", t);
                    try {
                        if (Bh.pRY != null) {
                            Bh.pRY.c(136, bundle);
                            break;
                        }
                    } catch (Exception e2) {
                        x.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + e2.getMessage());
                        break;
                    }
                }
                x.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", new Object[]{Integer.valueOf(c), t});
                break;
                break;
        }
        return false;
    }

    public final String bTG() {
        String p = p(20, 0, true);
        if (this.pOx.get(p) == null) {
            b bVar = new b(this, (byte) 0);
            bVar.ei(20, 0);
            this.pOx.put(p, bVar);
        }
        b bVar2 = (b) this.pOx.get(p);
        p = bVar2.isAvailable() ? bVar2.bPL : "";
        return bi.oW(p) ? "" : p;
    }

    public final boolean ab(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", new Object[]{map});
        int c = p.c(map, "scene", 0);
        int c2 = p.c(map, "type", 0);
        int c3 = p.c(map, "requestType", 0);
        int p = bi.p(map.get("webview_instance_id"), -1);
        String str = (String) map.get("requestId");
        boolean u = p.u(map, "ignoreCache");
        String p2;
        if (c3 == 0) {
            b bVar;
            p2 = p(c, c2, true);
            if (this.pOx.get(p2) == null) {
                bVar = new b(this, (byte) 0);
                bVar.ei(c, c2);
                this.pOx.put(p2, bVar);
            }
            bVar = (b) this.pOx.get(p2);
            if (!(bi.oW(bVar.bPL) || u)) {
                x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", new Object[]{Integer.valueOf(p), bVar.bPL});
                if (!(bVar.scene == 20 && bVar.type == 0 && (bVar.eeJ || !bVar.isAvailable()))) {
                    h.Bh(p).c(c3, bVar.bPL, 1, str);
                }
            }
            if (!bVar.isAvailable() || u) {
                au.DF().a(1048, this);
                x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[]{Integer.valueOf(p)});
                this.pOz = new m(c, c2, p.zP(0), p, w.fD(ad.getContext()), r.PX("discoverSearchEntry").optLong("guideParam"), str);
                au.DF().a(this.pOz, 0);
            } else {
                x.i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", new Object[]{Integer.valueOf(bVar.scene), Long.valueOf(bVar.pOO), Long.valueOf(bVar.pOP), Integer.valueOf(bVar.type), bVar.bPL});
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.plugin.websearch.api.ad.a(bVar.scene, 0, bVar.iow, bVar.type, 2, bVar.bTH(), 1);
                } else {
                    com.tencent.mm.plugin.websearch.api.ad.a(bVar.scene, 0, bVar.iow, bVar.type, 1, "", 0);
                }
                return false;
            }
        }
        avl bTb = com.tencent.mm.plugin.websearch.api.x.bTb();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (c = bTb.hbG.size() - 1; c >= 0; c--) {
                JSONObject jSONObject3 = new JSONObject();
                avk avk = (avk) bTb.hbG.get(c);
                if (s.he(avk.rdS)) {
                    com.tencent.mm.ac.d kH = f.kH(avk.rdS);
                    if (kH != null) {
                        jSONObject3.put("avatarUrl", kH.field_brandIconURL);
                        jSONObject3.put("userName", kH.field_username);
                        jSONObject3.put("nickName", com.tencent.mm.model.r.gT(kH.field_username));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("type", 5);
            jSONObject2.put("title", "");
            jSONArray.put(jSONObject2);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
            x.d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[]{jSONObject.toString()});
            h.Bh(p).c(1, p2, 1, str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "gen mostSearchBizContactList error", new Object[0]);
        }
        return false;
    }

    public final boolean ac(Map<String, Object> map) {
        g bTI;
        int i = 1;
        int p = bi.p(map.get("webview_instance_id"), -1);
        if (this.pOA.get(Integer.valueOf(201)) == null) {
            bTI = g.bTI();
            if (bTI != null) {
                this.pOA.put(Integer.valueOf(201), bTI);
            }
        }
        bTI = (g) this.pOA.get(Integer.valueOf(201));
        if (bTI != null) {
            h.Bh(p).af(bTI.bPL, 1, bTI.bTJ() ? 1 : 0);
            i = bTI.bTJ();
        }
        if (i != 0) {
            au.DF().a(1866, this);
            e eVar = new e();
            if (map != null) {
                eVar.bWo = p.c(map, "webview_instance_id", -1);
            }
            au.DF().a(eVar, 0);
        }
        return false;
    }

    public final boolean a(Map<String, Object> map, g gVar) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "openSearchWebView %s", new Object[]{map.toString()});
        int WU = bi.WU((String) map.get("actionType"));
        int c = p.c(map, "type", 0);
        String str5 = (String) map.get("extParams");
        String str6 = (String) map.get("jumpTo");
        String str7 = (String) map.get("navBarColor");
        String t = p.t(map, "publishId");
        String str8 = (String) map.get("nativeConfig");
        if (!TextUtils.isEmpty(str8)) {
            try {
                JSONObject jSONObject = new JSONObject(str8);
                if (jSONObject.has("title")) {
                    str8 = jSONObject.optString("title");
                } else {
                    str8 = null;
                }
                str = str8;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
            i = 0;
            if (!bi.oW(str7)) {
                try {
                    i = Color.parseColor(str7);
                } catch (IllegalArgumentException e2) {
                    x.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e2.getMessage());
                    return true;
                }
            }
            str2 = (String) map.get("statusBarStyle");
            str3 = (String) map.get("tagId");
            str4 = (String) map.get("sessionId");
            Bundle bundle;
            switch (WU) {
                case 1:
                    switch (c) {
                        case 1:
                            a(ae(map), false);
                            break;
                        case 8:
                            p.t(map, "snsid");
                            str6 = p.t(map, "objectXmlDesc");
                            str7 = p.t(map, "userName");
                            boolean u = p.u(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.modeltools.e.bUU();
                            p(str6, str7, u);
                            break;
                        case i$l.AppCompatTheme_actionModeCutDrawable /*32*/:
                            a(af(map));
                            break;
                        default:
                            str6 = p.t(map, "jumpUrl");
                            x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                            bundle = null;
                            if (gVar != null) {
                                bundle = gVar.bYo();
                            }
                            if (!bi.oW(str6)) {
                                com.tencent.mm.plugin.webview.modeltools.e.bUU();
                                a(str6, bundle, i, str2, t, 0);
                                break;
                            }
                            break;
                    }
                case 2:
                    str6 = p.t(map, "jumpUrl");
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                    bundle = null;
                    if (gVar != null) {
                        bundle = gVar.bYo();
                    }
                    if (!bi.oW(str6)) {
                        com.tencent.mm.plugin.webview.modeltools.e.bUU();
                        a(str6, bundle, i, str2, t, 0);
                        break;
                    }
                    break;
                case 3:
                    str7 = p.t(map, "query");
                    int c2 = p.c(map, "scene", 0);
                    String t2 = p.t(map, "searchId");
                    Intent intent = new Intent();
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("key_load_js_without_delay", true);
                    intent.putExtra("ftsQuery", str7);
                    intent.putExtra("ftsType", c);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    intent.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str6));
                    intent.putExtra("KPublisherId", t);
                    intent.putExtra("ftsbizscene", c2);
                    if (str != null) {
                        intent.putExtra("title", str);
                    }
                    Map a;
                    if (n.aot()) {
                        Object obj = p.c(map, "isWeAppMore", 0) == 1 ? 1 : null;
                        int c3 = p.c(map, "tabPageType", 0);
                        if (obj != null) {
                            a = n.a(c2, false, c, str5);
                            a.put("query", str7);
                            a.put("searchId", t2);
                            a.put("subType", String.valueOf(p.c(map, "subType", 0)));
                            a.put("isWeAppMore", String.valueOf(p.c(map, "isWeAppMore", 0)));
                            str7 = b.JK();
                            a.put("sessionId", str7);
                            intent.putExtra("key_session_id", str7);
                            intent.putExtra("rawUrl", n.v(a));
                            intent.putExtra("ftsbizscene", c2);
                            intent.putExtra("customize_status_bar_color", i);
                            intent.putExtra("status_bar_style", str2);
                            com.tencent.mm.bg.d.b(ad.getContext(), "appbrand", ".ui.AppBrandSearchUI", intent);
                            break;
                        }
                        a = p.a(c2, false, c, str5);
                        a.put("query", str7);
                        a.put("searchId", t2);
                        if (!TextUtils.isEmpty(str4)) {
                            a.put("sessionId", str4);
                            intent.putExtra("sessionId", str4);
                        }
                        String zK = p.zK(c2);
                        a.put("subSessionId", zK);
                        intent.putExtra("subSessionId", zK);
                        intent.putExtra("rawUrl", com.tencent.mm.au.a.b(c2, a));
                        intent.putExtra("ftsQuery", str7);
                        intent.putExtra("customize_status_bar_color", i);
                        intent.putExtra("status_bar_style", str2);
                        intent.putExtra("tabId", str3);
                        intent.putExtra("key_load_js_without_delay", true);
                        if (c3 != 1) {
                            if (c2 == 20 || c2 == 22 || c2 == 33 || c2 == 3 || c2 == 36) {
                                intent.putExtra("ftsInitToSearch", true);
                                str6 = ".ui.tools.fts.FTSSOSHomeWebViewUI";
                            } else {
                                str6 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                            }
                            if (!TextUtils.isEmpty(str6)) {
                                com.tencent.mm.bg.d.b(ad.getContext(), "webview", str6, intent);
                                break;
                            }
                        }
                        intent.putExtra("ftscaneditable", false);
                        p.a(ad.getContext(), str7, intent, str, str5, t2, str4, zK);
                        return false;
                    }
                    a = com.tencent.mm.au.a.bn(c2, c);
                    a.put("query", str7);
                    a.put("searchId", t2);
                    intent.putExtra("rawUrl", com.tencent.mm.au.a.b(c2, a));
                    if (c2 == 20 || c2 == 22 || c2 == 33) {
                        str6 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str6 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bg.d.b(ad.getContext(), "webview", str6, intent);
                    break;
                    break;
                case 5:
                    str6 = p.t(map, "query");
                    int c4 = p.c(map, "topStoryScene", 0);
                    i = p.c(map, "tagId", 0);
                    str2 = p.t(map, "navigationId");
                    if (bi.oW(str4)) {
                        str4 = p.zK(c4);
                    }
                    t = String.valueOf(System.currentTimeMillis());
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", "21");
                    hashMap.put("query", str6);
                    hashMap.put("extParams", str5);
                    hashMap.put("sessionId", str4);
                    hashMap.put("subSessionId", str4);
                    hashMap.put("requestId", t);
                    hashMap.put("pRequestId", t);
                    hashMap.put("seq", t);
                    hashMap.put("navigationId", str2);
                    hashMap.put("channelId", String.valueOf(i));
                    bte bte = new bte();
                    bte.sqA = com.tencent.mm.plugin.topstory.ui.d.bHF();
                    bte.scene = c4;
                    bte.fuu = "";
                    bte.bHt = str6;
                    bte.bJK = str4;
                    bte.bWr = str4;
                    bte.sqC = 2;
                    bte.url = com.tencent.mm.plugin.topstory.a.g.n(hashMap);
                    bte.sqD = str;
                    bte.bxk = i;
                    bte.kJG = t;
                    bte.pLi = str2;
                    ps psVar = new ps();
                    psVar.aAL = "rec_category";
                    psVar.rtU = (long) i;
                    psVar.rtV = String.valueOf(i);
                    bte.pKZ.add(psVar);
                    com.tencent.mm.plugin.topstory.ui.d.a(ad.getContext(), bte, t);
                    break;
            }
            return false;
        }
        str = null;
        i = 0;
        if (bi.oW(str7)) {
            try {
                i = Color.parseColor(str7);
            } catch (IllegalArgumentException e22) {
                x.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e22.getMessage());
                return true;
            }
        }
        str2 = (String) map.get("statusBarStyle");
        str3 = (String) map.get("tagId");
        str4 = (String) map.get("sessionId");
        switch (WU) {
            case 1:
                switch (c) {
                    case 1:
                        a(ae(map), false);
                        break;
                    case 8:
                        p.t(map, "snsid");
                        str6 = p.t(map, "objectXmlDesc");
                        str7 = p.t(map, "userName");
                        boolean u2 = p.u(map, "fromMusicItem");
                        com.tencent.mm.plugin.webview.modeltools.e.bUU();
                        p(str6, str7, u2);
                        break;
                    case i$l.AppCompatTheme_actionModeCutDrawable /*32*/:
                        a(af(map));
                        break;
                    default:
                        str6 = p.t(map, "jumpUrl");
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                        bundle = null;
                        if (gVar != null) {
                            bundle = gVar.bYo();
                        }
                        if (!bi.oW(str6)) {
                            com.tencent.mm.plugin.webview.modeltools.e.bUU();
                            a(str6, bundle, i, str2, t, 0);
                            break;
                        }
                        break;
                }
            case 2:
                str6 = p.t(map, "jumpUrl");
                x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str6});
                bundle = null;
                if (gVar != null) {
                    bundle = gVar.bYo();
                }
                if (!bi.oW(str6)) {
                    com.tencent.mm.plugin.webview.modeltools.e.bUU();
                    a(str6, bundle, i, str2, t, 0);
                    break;
                }
                break;
            case 3:
                str7 = p.t(map, "query");
                int c22 = p.c(map, "scene", 0);
                String t22 = p.t(map, "searchId");
                Intent intent2 = new Intent();
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("key_load_js_without_delay", true);
                intent2.putExtra("ftsQuery", str7);
                intent2.putExtra("ftsType", c);
                intent2.putExtra("customize_status_bar_color", i);
                intent2.putExtra("status_bar_style", str2);
                intent2.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str6));
                intent2.putExtra("KPublisherId", t);
                intent2.putExtra("ftsbizscene", c22);
                if (str != null) {
                    intent2.putExtra("title", str);
                }
                Map a2;
                if (n.aot()) {
                    Object obj2 = p.c(map, "isWeAppMore", 0) == 1 ? 1 : null;
                    int c32 = p.c(map, "tabPageType", 0);
                    if (obj2 != null) {
                        a2 = n.a(c22, false, c, str5);
                        a2.put("query", str7);
                        a2.put("searchId", t22);
                        a2.put("subType", String.valueOf(p.c(map, "subType", 0)));
                        a2.put("isWeAppMore", String.valueOf(p.c(map, "isWeAppMore", 0)));
                        str7 = b.JK();
                        a2.put("sessionId", str7);
                        intent2.putExtra("key_session_id", str7);
                        intent2.putExtra("rawUrl", n.v(a2));
                        intent2.putExtra("ftsbizscene", c22);
                        intent2.putExtra("customize_status_bar_color", i);
                        intent2.putExtra("status_bar_style", str2);
                        com.tencent.mm.bg.d.b(ad.getContext(), "appbrand", ".ui.AppBrandSearchUI", intent2);
                        break;
                    }
                    a2 = p.a(c22, false, c, str5);
                    a2.put("query", str7);
                    a2.put("searchId", t22);
                    if (!TextUtils.isEmpty(str4)) {
                        a2.put("sessionId", str4);
                        intent2.putExtra("sessionId", str4);
                    }
                    String zK2 = p.zK(c22);
                    a2.put("subSessionId", zK2);
                    intent2.putExtra("subSessionId", zK2);
                    intent2.putExtra("rawUrl", com.tencent.mm.au.a.b(c22, a2));
                    intent2.putExtra("ftsQuery", str7);
                    intent2.putExtra("customize_status_bar_color", i);
                    intent2.putExtra("status_bar_style", str2);
                    intent2.putExtra("tabId", str3);
                    intent2.putExtra("key_load_js_without_delay", true);
                    if (c32 != 1) {
                        if (c22 == 20 || c22 == 22 || c22 == 33 || c22 == 3 || c22 == 36) {
                            intent2.putExtra("ftsInitToSearch", true);
                            str6 = ".ui.tools.fts.FTSSOSHomeWebViewUI";
                        } else {
                            str6 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            com.tencent.mm.bg.d.b(ad.getContext(), "webview", str6, intent2);
                            break;
                        }
                    }
                    intent2.putExtra("ftscaneditable", false);
                    p.a(ad.getContext(), str7, intent2, str, str5, t22, str4, zK2);
                    return false;
                }
                a2 = com.tencent.mm.au.a.bn(c22, c);
                a2.put("query", str7);
                a2.put("searchId", t22);
                intent2.putExtra("rawUrl", com.tencent.mm.au.a.b(c22, a2));
                if (c22 == 20 || c22 == 22 || c22 == 33) {
                    str6 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                } else {
                    str6 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                }
                com.tencent.mm.bg.d.b(ad.getContext(), "webview", str6, intent2);
                break;
                break;
            case 5:
                str6 = p.t(map, "query");
                int c42 = p.c(map, "topStoryScene", 0);
                i = p.c(map, "tagId", 0);
                str2 = p.t(map, "navigationId");
                if (bi.oW(str4)) {
                    str4 = p.zK(c42);
                }
                t = String.valueOf(System.currentTimeMillis());
                HashMap hashMap2 = new HashMap();
                hashMap2.put("scene", "21");
                hashMap2.put("query", str6);
                hashMap2.put("extParams", str5);
                hashMap2.put("sessionId", str4);
                hashMap2.put("subSessionId", str4);
                hashMap2.put("requestId", t);
                hashMap2.put("pRequestId", t);
                hashMap2.put("seq", t);
                hashMap2.put("navigationId", str2);
                hashMap2.put("channelId", String.valueOf(i));
                bte bte2 = new bte();
                bte2.sqA = com.tencent.mm.plugin.topstory.ui.d.bHF();
                bte2.scene = c42;
                bte2.fuu = "";
                bte2.bHt = str6;
                bte2.bJK = str4;
                bte2.bWr = str4;
                bte2.sqC = 2;
                bte2.url = com.tencent.mm.plugin.topstory.a.g.n(hashMap2);
                bte2.sqD = str;
                bte2.bxk = i;
                bte2.kJG = t;
                bte2.pLi = str2;
                ps psVar2 = new ps();
                psVar2.aAL = "rec_category";
                psVar2.rtU = (long) i;
                psVar2.rtV = String.valueOf(i);
                bte2.pKZ.add(psVar2);
                com.tencent.mm.plugin.topstory.ui.d.a(ad.getContext(), bte2, t);
                break;
        }
        return false;
    }

    public final boolean a(Map<String, Object> map, g gVar, String str) {
        this.pOB.ozk = true;
        boolean u = p.u(map, "isTeachPage");
        boolean u2 = p.u(map, "isMoreButton");
        Object obj = p.c(map, "isFeedBack", 0) == 1 ? 1 : null;
        Object obj2 = p.c(map, "isWeAppMore", 0) == 1 ? 1 : null;
        String t = p.t(map, "sessionId");
        String str2 = (String) map.get("navBarColor");
        String t2 = p.t(map, "searchPlaceHolder");
        int i = 0;
        if (!bi.oW(str2)) {
            try {
                i = Color.parseColor(str2);
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e.getMessage());
                return true;
            }
        }
        String str3 = (String) map.get("statusBarStyle");
        String t3;
        Bundle bundle;
        if (obj == null) {
            int c = p.c(map, "type", 0);
            int c2 = p.c(map, "opType", 0);
            if (c2 <= 0) {
                if (!u2) {
                    str2 = (String) map.get("url");
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[]{Integer.valueOf(c), str2});
                    switch (c) {
                        case 1:
                            a(ae(map), false);
                            break;
                        case 8:
                            p.t(map, "snsid");
                            str2 = p.t(map, "objectXmlDesc");
                            t3 = p.t(map, "userName");
                            boolean u3 = p.u(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.modeltools.e.bUU();
                            p(str2, t3, u3);
                            break;
                        case i$l.AppCompatTheme_actionModeCutDrawable /*32*/:
                            a(af(map));
                            break;
                        default:
                            str2 = p.t(map, "jumpUrl");
                            x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", new Object[]{str2, p.t(map, "publishId"), Integer.valueOf(p.c(map, "payScene", 0))});
                            Bundle bundle2 = null;
                            if (gVar != null) {
                                bundle2 = gVar.bYo();
                            }
                            if (!bi.oW(str2)) {
                                com.tencent.mm.plugin.webview.modeltools.e.bUU();
                                a(str2, bundle2, i, str3, r4, r5);
                                break;
                            }
                            break;
                    }
                }
                str2 = p.t(map, "query");
                i = p.c(map, "scene", 0);
                str3 = p.t(map, "searchId");
                Intent intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str2);
                intent.putExtra("ftsType", c);
                intent.putExtra("sessionId", t);
                Map bn;
                if (!n.aot()) {
                    bn = com.tencent.mm.au.a.bn(i, c);
                    try {
                        bn.put("query", com.tencent.mm.compatible.util.p.encode(str2, "UTF-8"));
                    } catch (Exception e2) {
                        bn.put("query", str2);
                    }
                    bn.put("searchId", str3);
                    bn.put("sessionId", t);
                    str2 = p.zK(bi.WU((String) bn.get("scene")));
                    bn.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", t);
                    intent.putExtra("rawUrl", com.tencent.mm.au.a.b(i, bn));
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bg.d.b(ad.getContext(), "webview", str2, intent);
                } else if (obj2 != null) {
                    bn = n.a(i, false, c, str);
                    try {
                        bn.put("query", com.tencent.mm.compatible.util.p.encode(str2, "UTF-8"));
                    } catch (Exception e3) {
                        bn.put("query", str2);
                    }
                    bn.put("searchId", str3);
                    bn.put("subType", String.valueOf(p.c(map, "subType", 0)));
                    bn.put("isWeAppMore", String.valueOf(p.c(map, "isWeAppMore", 0)));
                    bn.put("sessionId", t);
                    str3 = b.JK();
                    bn.put("sessionId", str3);
                    str2 = p.zK(bi.WU((String) bn.get("scene")));
                    bn.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", str3);
                    intent.putExtra("rawUrl", n.v(bn));
                    intent.putExtra("ftsbizscene", i);
                    intent.putExtra("key_search_place_holder", t2);
                    if (i == 20 || i == 22 || i == 24) {
                        str2 = ".ui.AppBrandSOSUI";
                    } else {
                        str2 = ".ui.AppBrandSearchUI";
                    }
                    com.tencent.mm.bg.d.b(ad.getContext(), "appbrand", str2, intent);
                } else {
                    bn = p.a(i, false, c, str);
                    try {
                        bn.put("query", com.tencent.mm.compatible.util.p.encode(str2, "UTF-8"));
                    } catch (Exception e4) {
                        bn.put("query", str2);
                    }
                    bn.put("searchId", str3);
                    bn.put("sessionId", t);
                    str2 = p.zK(bi.WU((String) bn.get("scene")));
                    bn.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("rawUrl", com.tencent.mm.au.a.b(i, bn));
                    intent.putExtra("key_session_id", t);
                    intent.putExtra("searchId", str3);
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bg.d.b(ad.getContext(), "webview", str2, intent);
                }
            } else {
                switch (c2) {
                    case 2:
                        a(ae(map), u);
                        break;
                    case 3:
                        c ae = ae(map);
                        if (!s.he(ae.username)) {
                            a(ae, u);
                            break;
                        }
                        com.tencent.mm.plugin.websearch.api.x.PZ(ae.username);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", ae.username);
                        intent2.putExtra("finish_direct", true);
                        intent2.putExtra("key_temp_session_show_type", 0);
                        com.tencent.mm.bg.d.e(ad.getContext(), ".ui.chatting.ChattingUI", intent2);
                        break;
                    case 4:
                        t3 = p.t(map, "jumpUrl");
                        bundle = null;
                        if (gVar != null) {
                            bundle = gVar.bYo();
                        }
                        com.tencent.mm.plugin.webview.modeltools.e.bUU();
                        g(t3, bundle);
                        break;
                }
            }
        }
        t3 = p.t(map, "jumpUrl");
        bundle = null;
        if (gVar != null) {
            bundle = gVar.bYo();
        }
        com.tencent.mm.plugin.webview.modeltools.e.bUU();
        g(t3, bundle);
        return false;
    }

    public final boolean ad(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[]{map.toString()});
        bgx bgx = new bgx();
        bgx.shQ = p.t(map, "logString");
        au.DF().a(1134, this);
        au.DF().a(new com.tencent.mm.plugin.websearch.api.n(bgx), 0);
        return false;
    }

    private static void g(String str, Bundle bundle) {
        a(str, bundle, 0, "", "", 0);
    }

    private static void a(String str, Bundle bundle, int i, String str2, String str3, int i2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("convertActivityFromTranslucent", false);
        intent.putExtra("customize_status_bar_color", i);
        intent.putExtra("status_bar_style", str2);
        if (!bi.oW(str3)) {
            intent.putExtra("prePublishId", str3);
            intent.putExtra("KPublisherId", str3);
        } else if (!(bundle == null || bi.oW(str))) {
            String str4 = bundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.a.g.u(str.getBytes());
            intent.putExtra("prePublishId", str4);
            intent.putExtra("KPublisherId", str4);
        }
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    private static void p(String str, String str2, boolean z) {
        bsu ng = ((com.tencent.mm.plugin.sns.b.m) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sns.b.m.class)).ng(str);
        Intent intent = new Intent();
        intent.putExtra("INTENT_TALKER", str2);
        intent.putExtra("INTENT_SNSID", new BigInteger(ng.ksA).longValue());
        intent.putExtra("SNS_FROM_MUSIC_ITEM", z);
        try {
            intent.putExtra("INTENT_SNS_TIMELINEOBJECT", ng.toByteArray());
        } catch (IOException e) {
        }
        com.tencent.mm.bg.d.b(ad.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
    }

    private static void a(d dVar) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", dVar.username);
        intent.putExtra("Contact_Nick", dVar.nickname);
        intent.putExtra("Contact_Alias", dVar.cCR);
        intent.putExtra("Contact_Sex", dVar.sex);
        intent.putExtra("Contact_Scene", dVar.scene);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(dVar.country, dVar.csK, dVar.csL));
        intent.putExtra("Contact_Signature", dVar.signature);
        intent.putExtra("Contact_KSnsIFlag", dVar.pOU);
        intent.putExtra("Contact_full_Mobile_MD5", dVar.bWm);
        com.tencent.mm.bg.d.b(ad.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    private static void a(c cVar, boolean z) {
        int i;
        if (cVar.pKQ == 2) {
            i = 89;
        } else if (z) {
            i = 85;
        } else if (cVar.scene != 3 && cVar.scene != 16) {
            i = 39;
        } else if (cVar.pOS) {
            i = 88;
        } else {
            i = 87;
        }
        com.tencent.mm.plugin.websearch.api.x.PZ(cVar.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", cVar.username);
        intent.putExtra("Contact_Nick", cVar.nickname);
        intent.putExtra("Contact_BrandIconURL", cVar.lUI);
        intent.putExtra("Contact_Signature", cVar.signature);
        intent.putExtra("Contact_VUser_Info_Flag", cVar.pOR);
        intent.putExtra("Contact_Scene", i);
        if (cVar.lVI != null) {
            try {
                intent.putExtra("Contact_customInfo", cVar.lVI.toByteArray());
            } catch (IOException e) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", cVar.fuu);
        bundle.putString("Contact_Ext_Args_Query_String", cVar.bWm);
        bundle.putInt("Contact_Scene", i);
        bundle.putInt("Contact_Ext_Args_Index", cVar.position);
        bundle.putString("Contact_Ext_Extra_Params", cVar.pOT);
        intent.putExtra("Contact_Ext_Args", bundle);
        com.tencent.mm.bg.d.b(ad.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    public static int c(Map<String, Object> map, Map<String, Object> map2) {
        try {
            JSONArray jSONArray = new JSONArray(p.t(map, SlookAirButtonFrequentContactAdapter.DATA));
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object string;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has(SlookAirButtonFrequentContactAdapter.ID)) {
                    string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                } else {
                    String string2 = "";
                }
                String string3 = jSONObject.has("userName") ? jSONObject.getString("userName") : "";
                String gT = com.tencent.mm.model.r.gT(string3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, string2);
                jSONObject2.put("userName", string3);
                jSONObject2.put("displayName", gT);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", Integer.valueOf(0));
            map2.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray2.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        return 0;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        String p;
        int i3;
        String Ge;
        File file;
        byte[] bArr;
        if (lVar instanceof m) {
            au.DF().b(1048, this);
            if (i == 0 && i2 == 0) {
                m mVar = (m) lVar;
                b bVar = new b(this, (byte) 0);
                bVar.scene = mVar.scene;
                bVar.pOO = (long) mVar.pLm.rUL;
                bVar.bPL = mVar.pLm.rjK;
                bVar.pOP = System.currentTimeMillis() / 1000;
                bVar.iow = mVar.pLm.rUM;
                bVar.type = mVar.iPZ;
                p = p(bVar.scene, bVar.type, true);
                x.i("MicroMsg.FTS.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", new Object[]{bVar.bPL});
                if (!bi.oW(bVar.bPL)) {
                    h.Bh(mVar.bWo).c(0, bVar.bPL, 0, mVar.kJG);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[]{bVar.bPL});
                }
                this.pOx.put(p, bVar);
                if (bVar.pOO == 0) {
                    i3 = bVar.scene;
                    int i4 = bVar.type;
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                    au.HU();
                    Ge = com.tencent.mm.model.c.Ge();
                    file = new File(Ge, p(i3, i4, true));
                    if (file.exists()) {
                        file.delete();
                    }
                    file = new File(Ge, p(i3, i4, false));
                    if (file.exists()) {
                        file.delete();
                    }
                } else {
                    asj asj = new asj();
                    asj.scene = bVar.scene;
                    asj.rjK = bVar.bPL;
                    asj.rUE = bVar.pOO;
                    asj.rUF = bVar.pOP;
                    asj.rlo = bVar.iow;
                    asj.hcE = bVar.type;
                    bArr = null;
                    try {
                        bArr = asj.toByteArray();
                    } catch (IOException e) {
                    }
                    if (bArr != null) {
                        au.HU();
                        file = new File(com.tencent.mm.model.c.Ge(), p(bVar.scene, bVar.type, true));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(bArr.length)});
                    } else {
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.plugin.websearch.api.ad.a(bVar.scene, 1, bVar.iow, bVar.type, 2, bVar.bTH(), 1);
                    return;
                } else {
                    com.tencent.mm.plugin.websearch.api.ad.a(bVar.scene, 1, bVar.iow, bVar.type, 1, "", 0);
                    return;
                }
            }
            x.e("MicroMsg.FTS.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (lVar instanceof com.tencent.mm.plugin.websearch.api.n) {
            au.DF().b(1134, this);
        } else if (lVar instanceof g) {
            au.DF().b(1161, this);
            if (i == 0 && i2 == 0) {
                p = this.pOy.JS();
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(p);
                    JSONArray optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    Ge = jSONObject.optString("suggestionID", "");
                    jSONObject = null;
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        if (optJSONObject.optInt("type") != 1) {
                            optJSONObject = jSONObject;
                        }
                        i5++;
                        jSONObject = optJSONObject;
                    }
                    if (jSONObject != null) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String optString = optJSONArray2.optJSONObject(i3).optString("word");
                            if (!bi.oW(optString)) {
                                arrayList.add(optString);
                            }
                        }
                    }
                    p = Ge;
                } catch (Exception e2) {
                    p = "";
                }
                ah.A(new 2(this, p, arrayList));
            }
        } else if (lVar instanceof e) {
            au.DF().b(1866, this);
            if (i == 0 && i2 == 0) {
                e eVar = (e) lVar;
                if (eVar.bWo != -1) {
                    h.Bh(eVar.bWo).af(((cdb) eVar.diG.dIE.dIL).bPL, 0, 0);
                }
                g gVar = new g((cdb) eVar.diG.dIE.dIL);
                ask ask = new ask();
                ask.otY = gVar.scene;
                ask.rjK = gVar.bPL;
                ask.rUG = gVar.dkB;
                ask.rUF = gVar.pOP;
                bArr = null;
                try {
                    bArr = ask.toByteArray();
                } catch (IOException e3) {
                }
                if (bArr != null) {
                    au.HU();
                    file = new File(com.tencent.mm.model.c.Ge(), g.Ae(gVar.scene));
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", new Object[]{Integer.valueOf(gVar.scene)});
                } else {
                    x.w("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", new Object[]{Integer.valueOf(gVar.scene)});
                }
                this.pOA.put(Integer.valueOf(gVar.scene), gVar);
            }
        }
    }

    private c ae(Map<String, Object> map) {
        c cVar = new c(this, (byte) 0);
        cVar.username = p.t(map, "userName");
        cVar.nickname = p.t(map, "nickName");
        cVar.lUI = p.t(map, "headHDImgUrl");
        cVar.pOR = p.c(map, "verifyFlag", 0);
        cVar.signature = p.t(map, "signature");
        cVar.scene = p.c(map, "scene", 0);
        cVar.pKQ = p.c(map, "sceneActionType", 1);
        cVar.lVI = new qt();
        cVar.lVI.eJV = p.c(map, "brandFlag", 0);
        cVar.lVI.eJY = p.t(map, "iconUrl");
        cVar.lVI.eJX = p.t(map, "brandInfo");
        cVar.lVI.eJW = p.t(map, "externalInfo");
        cVar.fuu = p.t(map, "searchId");
        cVar.bWm = p.t(map, "query");
        cVar.position = p.c(map, "position", 0);
        cVar.pOS = p.u(map, "isCurrentDetailPage");
        cVar.pOT = p.t(map, "extraParams");
        return cVar;
    }

    private d af(Map<String, Object> map) {
        int i = 3;
        d dVar = new d(this, (byte) 0);
        dVar.username = p.t(map, "userName");
        dVar.nickname = p.t(map, "nickName");
        dVar.cCR = p.t(map, "alias");
        dVar.signature = p.t(map, "signature");
        dVar.sex = p.c(map, "sex", 0);
        dVar.country = p.t(map, "country");
        dVar.csL = p.t(map, "city");
        dVar.csK = p.t(map, "province");
        dVar.pOU = p.c(map, "snsFlag", 0);
        String t = p.t(map, "query");
        if (bi.oW(t)) {
            dVar.scene = 3;
        } else {
            if (Character.isDigit(t.charAt(0))) {
                i = 15;
            }
            dVar.scene = i;
            if (dVar.scene == 15) {
                if ("mobile".equals(p.t(map, "matchType"))) {
                    dVar.bWm = t;
                } else {
                    dVar.scene = 1;
                }
            }
        }
        return dVar;
    }

    static String p(int i, int i2, boolean z) {
        String str = "FTS_BizCacheObj" + i + "-" + i2;
        String str2 = str + "-" + w.fD(ad.getContext());
        if (z) {
            return str2;
        }
        au.HU();
        if (new File(com.tencent.mm.model.c.Ge(), str2).exists()) {
            return str2;
        }
        return str;
    }

    public static boolean ag(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", new Object[]{map});
        String t = p.t(map, "word");
        boolean u = p.u(map, "isInputChange");
        String t2 = p.t(map, "custom");
        String t3 = p.t(map, "tagList");
        g Bh = h.Bh(bi.p(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", t);
        bundle.putString("fts_key_custom_query", t2);
        bundle.putBoolean("fts_key_need_keyboard", u);
        bundle.putString("fts_key_tag_list", t3);
        try {
            if (Bh.pRY != null) {
                Bh.pRY.c(122, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e.getMessage());
        }
        return false;
    }

    public final boolean ah(Map<String, Object> map) {
        String str = (String) map.get("query");
        String str2 = (String) map.get("sortedContacts");
        int WU = bi.WU((String) map.get("offset"));
        int WU2 = bi.WU((String) map.get("count"));
        int p = bi.p(map.get("webview_instance_id"), -1);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        if (this.pOD == null) {
            this.pOD = new com.tencent.mm.plugin.websearch.c.a.b();
        }
        com.tencent.mm.plugin.websearch.c.a.d dVar = new com.tencent.mm.plugin.websearch.c.a.d(str, arrayList);
        if (this.pOE == null || !this.pOE.equals(dVar)) {
            this.pOE = dVar;
            this.pOD.a(dVar, new 5(this, WU, WU2, p));
        } else if (this.pOE.bHx) {
            a(this.pOE, WU, WU2, p);
        }
        return false;
    }

    static void a(com.tencent.mm.plugin.websearch.c.a.d dVar, int i, int i2, int i3) {
        JSONObject eg = dVar.eg(i, i2);
        g Bh = h.Bh(i3);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", eg.toString());
        try {
            if (Bh.pRY != null) {
                Bh.pRY.c(137, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }
}
