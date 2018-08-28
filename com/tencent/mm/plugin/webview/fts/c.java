package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements a {
    public com.tencent.mm.sdk.b.c nll = new 2(this);
    private volatile HashMap<String, HashSet<String>> pOn = new HashMap();
    volatile HashMap<String, HashSet<String>> pOo = new HashMap();
    volatile HashMap<String, HashSet<String>> pOp = new HashMap();
    private volatile HashMap<String, Integer> pOq = new HashMap();
    volatile HashMap<String, Integer> pOr = new HashMap();
    volatile HashMap<String, Integer> pOs = new HashMap();
    public com.tencent.mm.sdk.b.c<ft> pOt = new 1(this);

    public c() {
        this.nll.cht();
        this.pOt.cht();
        q.KH().c(this);
    }

    public final boolean X(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchAvatarList");
        String t = p.t(map, "data");
        int p = bi.p(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(t);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("userName");
                int optInt = jSONObject.optInt("type");
                Object optString3 = jSONObject.optString("imageUrl");
                String optString4 = jSONObject.optString("bigImageUrl");
                switch (optInt) {
                    case 1:
                    case 4:
                    case 64:
                        break;
                    case 32:
                        j jVar = new j();
                        jVar.username = optString2;
                        jVar.dHR = optString4;
                        jVar.dHQ = optString3;
                        jVar.bWA = -1;
                        jVar.csA = 3;
                        jVar.by(true);
                        q.KH().a(jVar);
                        break;
                }
                t = q.Kp().c(optString2, false, false);
                if (FileOp.cn(t)) {
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file exist %s", new Object[]{t});
                    optString3 = "weixin://fts/avatar?path=" + t;
                } else {
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file not exist %s", new Object[]{t});
                    this.pOq.put(optString2, Integer.valueOf(p));
                    HashSet hashSet = (HashSet) this.pOn.get(optString2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(optString);
                    this.pOn.put(optString2, hashSet);
                    b.ccZ().cJ(optString2);
                    optString3 = obj;
                }
                if (optString3 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", optString);
                    jSONObject2.put("src", optString3);
                    jSONArray2.put(jSONObject2);
                    optString3 = null;
                }
                i++;
                obj = optString3;
            }
            if (jSONArray2.length() > 0) {
                h.Bh(p).aV(0, jSONArray2.toString());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewImageLogic", e, "", new Object[0]);
            h.Bh(p).aV(-1, "");
        }
        return false;
    }

    public final boolean Y(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchSnsImageList");
        String t = p.t(map, "data");
        int p = bi.p(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(t);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("objectXmlDesc");
                int i2 = jSONObject.getInt("index");
                bsu ng = ((m) g.l(m.class)).ng(string2);
                if (ng.sqc.ruA.size() > i2) {
                    ate ate = (ate) ng.sqc.ruA.get(i2);
                    qb qbVar = new qb();
                    qbVar.caJ.bIH = 3;
                    qbVar.caJ.mediaId = ate.ksA;
                    com.tencent.mm.sdk.b.a.sFg.m(qbVar);
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "generatePath: %s", new Object[]{qbVar.caJ.path});
                    if (FileOp.cn(qbVar.caJ.path)) {
                        obj2 = "weixin://fts/sns?path=" + qbVar.caJ.path;
                    } else {
                        synchronized (this.pOo) {
                            HashSet hashSet;
                            if (this.pOo.containsKey(ate.ksA)) {
                                hashSet = (HashSet) this.pOo.get(ate.ksA);
                            } else {
                                hashSet = new HashSet();
                            }
                            hashSet.add(string);
                            this.pOo.put(ate.ksA, hashSet);
                            this.pOr.put(ate.ksA, Integer.valueOf(p));
                        }
                        qbVar = new qb();
                        qbVar.caJ.bIH = 1;
                        qbVar.caJ.caK = ate;
                        com.tencent.mm.sdk.b.a.sFg.m(qbVar);
                        obj2 = obj;
                    }
                    if (obj2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", string);
                        jSONObject2.put("src", obj2);
                        jSONArray2.put(jSONObject2);
                        obj2 = null;
                    }
                } else {
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (jSONArray2.length() > 0) {
                h.Bh(p).aV(0, jSONArray2.toString());
            }
        } catch (JSONException e) {
        }
        return false;
    }

    public final boolean Z(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchImageList");
        int c = p.c((Map) map, "requestType", 0);
        String t = p.t(map, "data");
        int p = bi.p(map.get("webview_instance_id"), -1);
        boolean isWifi = ao.isWifi(ad.getContext());
        switch (c) {
            case 1:
                try {
                    JSONArray jSONArray = new JSONArray(t);
                    JSONArray jSONArray2 = new JSONArray();
                    int i = 0;
                    Object obj = null;
                    while (i < jSONArray.length()) {
                        Object obj2;
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        int optInt = jSONObject.optInt("emojiType");
                        String optString = jSONObject.optString("id");
                        JSONObject jSONObject2;
                        if (optInt == 2) {
                            ft ftVar = new ft();
                            ftVar.bOq.bIH = 3;
                            ftVar.bOq.bKg = jSONObject.optString("md5");
                            ftVar.bOq.bOs = jSONObject.optString("designerId");
                            ftVar.bOq.aeskey = jSONObject.optString("aesKey");
                            ftVar.bOq.bOt = jSONObject.optString("encryptUrl");
                            ftVar.bOq.bKk = jSONObject.optString("productID");
                            ftVar.bOq.name = jSONObject.optString("express");
                            ftVar.bOq.thumbUrl = jSONObject.optString("imageUrl");
                            com.tencent.mm.sdk.b.a.sFg.m(ftVar);
                            if (FileOp.cn(ftVar.bOr.path)) {
                                obj2 = "weixin://fts/emoji?path=" + ftVar.bOr.path;
                                x.i("MicroMsg.FTS.FTSWebViewImageLogic", "path=%s", new Object[]{ftVar.bOr.path});
                            } else if (isWifi) {
                                synchronized (this.pOp) {
                                    HashSet hashSet;
                                    if (this.pOp.containsKey(ftVar.bOq.bKg)) {
                                        hashSet = (HashSet) this.pOp.get(ftVar.bOq.bKg);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    hashSet.add(optString);
                                    this.pOp.put(ftVar.bOq.bKg, hashSet);
                                    this.pOs.put(ftVar.bOq.bKg, Integer.valueOf(p));
                                }
                                ftVar.bOq.bIH = 1;
                                com.tencent.mm.sdk.b.a.sFg.m(ftVar);
                                obj2 = obj;
                            } else {
                                obj2 = jSONObject.optString("imageUrl");
                            }
                            if (obj2 != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("id", optString);
                                jSONObject3.put("src", obj2);
                                jSONArray2.put(jSONObject3);
                                obj2 = null;
                            }
                        } else if (optInt == 4) {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("id", optString);
                            if (isWifi) {
                                jSONObject2.put("src", jSONObject.optString("raw"));
                            } else {
                                jSONObject2.put("src", jSONObject.optString("imageUrl"));
                            }
                            jSONArray2.put(jSONObject2);
                            obj2 = obj;
                        } else {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("id", optString);
                            jSONObject2.put("src", jSONObject.optString("imageUrl"));
                            jSONArray2.put(jSONObject2);
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                    if (jSONArray2.length() > 0) {
                        h.Bh(p).aV(0, jSONArray2.toString());
                        break;
                    }
                } catch (Exception e) {
                    break;
                }
                break;
            default:
                try {
                    JSONArray jSONArray3 = new JSONArray(t);
                    JSONArray jSONArray4 = new JSONArray();
                    for (c = 0; c < jSONArray3.length(); c++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(c);
                        JSONObject jSONObject5 = new JSONObject();
                        String string = jSONObject4.getString("id");
                        String string2 = jSONObject4.getString("imageUrl");
                        jSONObject5.put("id", string);
                        jSONObject5.put("src", string2);
                        jSONArray4.put(jSONObject5);
                    }
                    h.Bh(p).aV(0, jSONArray4.toString());
                    break;
                } catch (JSONException e2) {
                    break;
                }
        }
        return false;
    }

    public final void a(String str, l lVar) {
        if (lVar != null && lVar.obj != null) {
            synchronized (this.pOn) {
                x.i("MicroMsg.FTS.FTSWebViewImageLogic", "event %s，eventData %s", new Object[]{str, lVar.toString()});
                String obj = lVar.obj.toString();
                if (this.pOn.containsKey(obj) && this.pOq.containsKey(obj)) {
                    x.i("MicroMsg.FTS.FTSWebViewImageLogic", "notify avatar changed %s", new Object[]{obj});
                    int intValue = ((Integer) this.pOq.get(obj)).intValue();
                    HashSet hashSet = (HashSet) this.pOn.get(obj);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = "weixin://fts/avatar?path=" + q.Kp().c(obj, false, false);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str2);
                            jSONObject.put("src", str3);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    h.Bh(intValue).aV(0, jSONArray.toString());
                    this.pOn.remove(obj);
                    this.pOq.remove(obj);
                }
            }
        }
    }
}
