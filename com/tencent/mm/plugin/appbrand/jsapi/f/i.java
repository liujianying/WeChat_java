package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.mm.plugin.appbrand.compat.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    private static class a extends h {
        private static final int CTRL_INDEX = 199;
        private static final String NAME = "onMapCalloutClick";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        float f = bi.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f2 = bi.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            x.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            return null;
        }
        String str = pVar.mAppId;
        int k = k(jSONObject);
        boolean equals = jSONObject.optString("theme", "normal").equals("handDraw");
        x.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s mapId:%d data:%s", new Object[]{str, Integer.valueOf(k), jSONObject});
        c a = b.a(pVar.mContext, str, pVar.hashCode(), k, equals);
        if (a == null) {
            x.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
            return null;
        }
        pVar.a(new 1(this, a));
        pVar.a(new 2(this, a, jSONObject));
        pVar.a(new 3(this, pVar, str, k));
        a.getView().setVisibility(0);
        return new CoverViewContainer(pVar.mContext, a.getView());
    }

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final void a(final p pVar, final int i, View view, JSONObject jSONObject) {
        c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
            return;
        }
        E.fTc = new 4(this, i, pVar);
        E.fTd = new l() {
            public final boolean b(e eVar) {
                b bVar = new b((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    jSONObject.put("data", eVar.data);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                h a = bVar.a(pVar);
                a.mData = jSONObject.toString();
                a.ahM();
                if (eVar.fTx == null || eVar.fTx.fTA == null) {
                    return false;
                }
                if (eVar.fTx.fTA.fTH != com.tencent.mm.plugin.appbrand.jsapi.f.a.c.f.a.fTJ) {
                    return false;
                }
                if (eVar.fTv.isInfoWindowShown()) {
                    return true;
                }
                eVar.fTv.showInfoWindow();
                return true;
            }
        };
        E.fSZ = new j() {
            public final void ajg() {
                d dVar = new d();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                h a = dVar.a(pVar);
                a.mData = jSONObject.toString();
                a.ahM();
            }
        };
        E.cS(jSONObject.optBoolean("showLocation"));
        com.tencent.mm.plugin.appbrand.compat.a.b bVar = E.fSW;
        bVar.a(new 7(this, jSONObject, bVar));
        bVar.a(new k() {
            JSONObject fMp = new JSONObject();
            boolean fSH = false;
            c fSI = new c();

            public final void adM() {
                try {
                    this.fMp.put("mapId", i);
                    this.fMp.put("type", "begin");
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                if (!this.fSH) {
                    this.fSH = true;
                    h a = this.fSI.a(pVar);
                    a.mData = this.fMp.toString();
                    a.ahM();
                }
            }

            public final void adN() {
                try {
                    this.fMp.put("mapId", i);
                    this.fMp.put("type", "end");
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                if (this.fSH) {
                    this.fSH = false;
                    h a = this.fSI.a(pVar);
                    a.mData = this.fMp.toString();
                    a.ahM();
                }
            }
        });
    }
}
