package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public b foN;
    private Map<String, d> foO;
    public e foP;
    public c foQ;
    public a foR;
    public boolean foS = true;
    public JSONObject foT;
    public String foU;

    public static class a {
        String foV;
        public boolean foW;
    }

    public static class c {
        public int cez;
        public int foX;
        public int foY;
        public int foZ;
    }

    public final d rG(String str) {
        if (this.foO.containsKey(str)) {
            return (d) this.foO.get(str);
        }
        return b(null, this.foN);
    }

    public final String adT() {
        return this.foR == null ? b.fpv.name().toLowerCase() : this.foR.foV;
    }

    public final String adU() {
        if (bi.oW(this.foU)) {
            return "index.html";
        }
        return this.foU;
    }

    public static a o(g gVar) {
        JSONObject jSONObject;
        String a = ao.a(gVar, "app-config.json");
        a aVar = new a();
        try {
            jSONObject = new JSONObject(a);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAppConfig", e.getMessage());
            jSONObject = new JSONObject();
        }
        aVar.foU = jSONObject.optString("entryPagePath");
        aVar.foT = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("global");
        b bVar = new b();
        a(optJSONObject, bVar, bVar);
        if (ad.cia().getBoolean("appbrand_new_actionbar", false)) {
            bVar.fpi = "custom";
        }
        aVar.foN = bVar;
        aVar.foO = a(jSONObject.optJSONObject("page"), aVar.foN);
        aVar.foP = h(jSONObject.optJSONObject("tabBar"));
        optJSONObject = jSONObject.optJSONObject("networkTimeout");
        c cVar = new c();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        cVar.cez = optJSONObject.optInt("request");
        cVar.foX = optJSONObject.optInt("connectSocket");
        cVar.foZ = optJSONObject.optInt("downloadFile");
        cVar.foY = optJSONObject.optInt("uploadFile");
        aVar.foQ = cVar;
        if (gVar.aaq()) {
            a aVar2 = new a();
            aVar2.foV = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.foW = jSONObject.optBoolean("showStatusBar", false);
            aVar.foR = aVar2;
        }
        aVar.foS = jSONObject.optBoolean("preloadEnabled", true);
        return aVar;
    }

    private static <T extends g> T a(JSONObject jSONObject, T t, g gVar) {
        if (jSONObject == null) {
            jSONObject = g.fpq;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            optJSONObject = g.fpq;
        }
        t.fpf = optJSONObject.optString("navigationBarTitleText", gVar.fpf);
        t.fpg = optJSONObject.optString("navigationBarTextStyle", gVar.fpg);
        t.fpi = optJSONObject.optString("navigationStyle", gVar.fpi);
        t.fpj = optJSONObject.optString("navigationBarBackgroundColor", gVar.fpj);
        t.fpc = optJSONObject.optString("backgroundColor", gVar.fpc);
        t.fpo = optJSONObject.optBoolean("enablePullDownRefresh", gVar.fpo);
        t.fpp = optJSONObject.optString("backgroundTextStyle", gVar.fpp);
        t.fpn = optJSONObject.optBoolean("enableFullScreen", gVar.fpn);
        optJSONObject = optJSONObject.optJSONObject("navigationBarRightButton");
        if (optJSONObject == null) {
            optJSONObject = g.fpq;
        }
        t.fpm = optJSONObject.optBoolean("hide", gVar.fpm);
        t.fpk = optJSONObject.optString("text", gVar.fpk);
        t.fpl = optJSONObject.optString("iconPath", gVar.fpl);
        return t;
    }

    private static Map<String, d> a(JSONObject jSONObject, b bVar) {
        Map<String, d> hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, b(jSONObject.optJSONObject(str), bVar));
        }
        return hashMap;
    }

    private static d b(JSONObject jSONObject, b bVar) {
        return (d) a(jSONObject, new d(), bVar);
    }

    private static e h(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        e eVar = new e();
        eVar.fpa = jSONObject.optString("position");
        eVar.dxh = jSONObject.optString("color");
        eVar.fpb = jSONObject.optString("selectedColor");
        eVar.fpc = jSONObject.optString("backgroundColor");
        eVar.fpd = jSONObject.optString("borderStyle");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            for (int i = 0; i < jSONArray.length(); i++) {
                ArrayList arrayList = eVar.bUX;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.url = jSONObject2.optString("pagePath");
                fVar.text = jSONObject2.optString("text");
                fVar.bWP = jSONObject2.optString("iconData");
                fVar.fpe = jSONObject2.optString("selectedIconData");
                arrayList.add(fVar);
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        return eVar;
    }
}
