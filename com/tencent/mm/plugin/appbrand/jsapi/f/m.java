package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.13;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.3;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.plugin.appbrand.widget.e.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";
    private static final LinkedList<JSONObject> fSK = new LinkedList();
    private a.a fSL;

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean a(p pVar, JSONObject jSONObject, a.a aVar, f fVar) {
        this.fSL = aVar;
        x.d("MicroMsg.JsApiTranslateMapMarker", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "data is null");
            return false;
        }
        c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "appBrandMapView is null, return");
            return false;
        }
        String optString = jSONObject.optString("markerId");
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("keyFrames"));
            LinkedList linkedList = new LinkedList();
            x.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", new Object[]{Integer.valueOf(jSONArray.length())});
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                h hVar = new h();
                hVar.duration = jSONObject2.optInt("duration", 0);
                if (hVar.duration == 0) {
                    x.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
                } else {
                    hVar.rotate = (float) jSONObject2.optDouble("rotate", 0.0d);
                    hVar.latitude = (double) bi.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    hVar.longitude = (double) bi.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    linkedList.add(hVar);
                }
                i = i2 + 1;
            }
            1 1 = new 1(this, fVar);
            e tF = E.tF(optString);
            if (tF == null || tF.fTv == null) {
                x.e("MicroMSg.AppBrandMapView", "get marker failed!");
                1.cR(false);
            } else if (linkedList.size() <= 0) {
                x.e("MicroMSg.AppBrandMapView", "keyFrame is empty, err, return");
                1.cR(false);
            } else {
                c.a(linkedList, tF);
                d dVar = new d(linkedList, tF.fTv, E.fSW);
                dVar.gMt.addListener(new 13(E, 1));
                com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new 2(E, dVar));
                if (tF.fTw != null) {
                    com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new 3(E, new d(linkedList, tF.fTw, E.fSW)));
                }
            }
            return true;
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[]{e});
            fVar.tp(f("fail", null));
            return false;
        }
    }

    protected final boolean aik() {
        return true;
    }
}
