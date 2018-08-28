package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.compat.a.b$i;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.10;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.11;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.12;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.c.f.a;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends c {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapMarkers", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddMapMarkers", "data is null");
            return false;
        }
        x.i("MicroMsg.JsApiAddMapMarkers", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
        com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiAddMapMarkers", "appBrandMapView is null, return");
            return false;
        }
        x.i("MicroMsg.JsApiAddMapMarkers", "clear:%b", new Object[]{Boolean.valueOf(jSONObject.optBoolean("clear", true))});
        if (jSONObject.optBoolean("clear", true)) {
            E.ajj();
        }
        if (jSONObject.has("markers")) {
            JSONArray jSONArray;
            try {
                jSONArray = new JSONArray(jSONObject.optString("markers"));
            } catch (JSONException e) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2;
                    try {
                        jSONObject2 = (JSONObject) jSONArray.get(i3);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e2, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        JSONObject jSONObject3;
                        int aQ;
                        int optInt;
                        int a;
                        f fVar = new f();
                        String optString = jSONObject2.optString("id");
                        double d = (double) bi.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        double d2 = (double) bi.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        fVar.latitude = d;
                        fVar.longitude = d2;
                        String optString2 = jSONObject2.optString("iconPath");
                        float a2 = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "width", 0.0f);
                        float a3 = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "height", 0.0f);
                        if (!bi.oW(optString2)) {
                            fVar.fTs = optString2;
                            fVar.fTy = a2;
                            fVar.fTz = a3;
                        }
                        fVar.rotate = (float) jSONObject2.optDouble("rotate", 0.0d);
                        fVar.alpha = (float) jSONObject2.optDouble("alpha", 1.0d);
                        fVar.data = jSONObject2.optString("data");
                        if (jSONObject2.has("anchor")) {
                            try {
                                jSONObject3 = new JSONObject(jSONObject2.optString("anchor"));
                            } catch (JSONException e3) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                fVar.A((float) jSONObject3.optDouble("x", 0.5d), (float) jSONObject3.optDouble("y", 1.0d));
                            } else {
                                fVar.A(0.5f, 1.0f);
                            }
                        }
                        String optString3 = jSONObject2.optString("label");
                        if (!bi.oW(optString3)) {
                            try {
                                jSONObject3 = new JSONObject(optString3);
                            } catch (JSONException e4) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                String optString4 = jSONObject3.optString("content");
                                aQ = com.tencent.mm.plugin.appbrand.q.f.aQ(jSONObject3.optString("color", ""), Color.parseColor("#000000"));
                                optInt = jSONObject3.optInt("fontSize", 12);
                                a = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject3, "anchorX", com.tencent.mm.plugin.appbrand.q.f.a(jSONObject3, "x", 0));
                                int a4 = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject3, "anchorY", com.tencent.mm.plugin.appbrand.q.f.a(jSONObject3, "y", 0));
                                int optInt2 = jSONObject3.optInt("borderRadius", 0);
                                int e5 = com.tencent.mm.plugin.appbrand.q.f.e(jSONObject3, "borderWidth");
                                int vO = com.tencent.mm.plugin.appbrand.q.f.vO(jSONObject3.optString("borderColor"));
                                fVar.fTB = new f.b(optString4, aQ, optInt, a, a4, com.tencent.mm.plugin.appbrand.q.f.aQ(jSONObject3.optString("bgColor", ""), Color.parseColor("#000000")), optInt2, e5, vO, jSONObject3.optString("textAlign", ""), com.tencent.mm.plugin.appbrand.q.f.a(jSONObject3, "padding", 0));
                            }
                        }
                        optString3 = jSONObject2.optString("callout");
                        if (!bi.oW(optString3)) {
                            try {
                                jSONObject3 = new JSONObject(optString3);
                            } catch (JSONException e6) {
                                jSONObject3 = null;
                            }
                            if (jSONObject3 != null) {
                                fVar.fTA = new a(jSONObject3.optString("content"), com.tencent.mm.plugin.appbrand.q.f.aQ(jSONObject3.optString("color", "#000000"), Color.parseColor("#000000")), jSONObject3.optInt("fontSize", 12), jSONObject3.optInt("borderRadius", 0), com.tencent.mm.plugin.appbrand.q.f.aQ(jSONObject3.optString("bgColor", "#000000"), Color.parseColor("#000000")), com.tencent.mm.plugin.appbrand.q.f.a(jSONObject3, "padding", 0), com.tencent.mm.plugin.appbrand.q.f.aQ(jSONObject3.optString("shadowColor", "#000000"), Color.parseColor("#000000")), jSONObject3.optInt("shadowOpacity"), jSONObject3.optInt("shadowOffsetX"), jSONObject3.optInt("shadowOffsetY"), jSONObject3.optInt("display", 0), jSONObject3.optString("textAlign", ""));
                            }
                        }
                        b$i ady = E.fSW.ady();
                        ady.h(fVar.latitude, fVar.longitude);
                        if (!bi.oW(fVar.title)) {
                            ady.rF(fVar.title);
                        }
                        ady.Y(fVar.rotate);
                        ady.Z(fVar.alpha);
                        Bitmap bitmap = null;
                        if (!bi.oW(fVar.fTs)) {
                            if (fVar.fTs == null || !fVar.fTs.startsWith("wxfile://")) {
                                bitmap = o.j(com.tencent.mm.plugin.appbrand.a.pY(E.appId), fVar.fTs);
                            } else {
                                AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(E.appId, fVar.fTs);
                                if (itemByLocalId != null) {
                                    bitmap = com.tencent.mm.sdk.platformtools.c.decodeFile(itemByLocalId.dDG, null);
                                }
                            }
                        }
                        FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) E.context.getSystemService("layout_inflater")).inflate(h.app_brand_map_marker_icon, null);
                        ImageView imageView = (ImageView) frameLayout.findViewById(g.marker_icon);
                        if (bitmap != null) {
                            if (fVar.fTy == 0.0f || fVar.fTz == 0.0f) {
                                fVar.fTy = (float) com.tencent.mm.plugin.appbrand.q.f.lP(bitmap.getWidth());
                                fVar.fTz = (float) com.tencent.mm.plugin.appbrand.q.f.lP(bitmap.getHeight());
                            }
                            if (fVar.fTy <= 0.0f || fVar.fTz <= 0.0f || (fVar.fTy == ((float) bitmap.getWidth()) && fVar.fTz == ((float) bitmap.getHeight()))) {
                                imageView.setImageBitmap(bitmap);
                                imageView.setScaleType(ScaleType.CENTER);
                            } else {
                                a2 = fVar.fTy / ((float) bitmap.getWidth());
                                a3 = fVar.fTz / ((float) bitmap.getHeight());
                                Matrix matrix = new Matrix();
                                matrix.postScale(a2, a3);
                                imageView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
                            }
                        } else {
                            x.e("MicroMSg.AppBrandMapView", "[addMarker] bitmap is null, use default");
                        }
                        if (fVar.fTA == null || fVar.fTA.fTH != a.fTK) {
                            ady.bF(frameLayout);
                            ady.A(fVar.bhr, fVar.bhs);
                        } else {
                            float f;
                            View linearLayout = new LinearLayout(E.context);
                            linearLayout.setLayoutParams(new LayoutParams(-2, -2));
                            linearLayout.setOrientation(1);
                            linearLayout.setGravity(17);
                            com.tencent.mm.plugin.appbrand.widget.e.c a5 = E.a(fVar.fTA);
                            a5.setOnClickListener(new 10(E, optString));
                            linearLayout.addView(a5);
                            linearLayout.addView(frameLayout);
                            linearLayout.measure(0, 0);
                            ady.bF(linearLayout);
                            aQ = linearLayout.getMeasuredHeight();
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            optInt = imageView.getMeasuredHeight();
                            a = imageView.getMeasuredWidth();
                            if (measuredWidth > 0) {
                                if (a >= measuredWidth) {
                                    f = fVar.bhr;
                                } else {
                                    f = 0.5f - ((((float) a) - (((float) (a * 2)) * fVar.bhr)) / ((float) (measuredWidth * 2)));
                                }
                                a2 = f;
                            } else {
                                a2 = 0.5f;
                            }
                            f = 1.0f;
                            if (aQ > 0) {
                                f = 1.0f - ((((float) optInt) * (1.0f - fVar.bhs)) / ((float) aQ));
                            }
                            x.d("MicroMSg.AppBrandMapView", "newAnchorX:%f, newAnchorY:%f", new Object[]{Float.valueOf(a2), Float.valueOf(f)});
                            ady.A(a2, f);
                        }
                        ady.bg(optString);
                        ady.h(new 11(E));
                        ady.g(new 12(E));
                        ady.adJ();
                        e eVar = new e(E.fSW.a(ady), fVar);
                        eVar.data = fVar.data;
                        E.a(optString, eVar);
                        if (fVar.fTB != null) {
                            b$i ady2 = E.fSW.ady();
                            ady2.h(fVar.latitude, fVar.longitude);
                            ady.Z(fVar.alpha);
                            com.tencent.mm.plugin.appbrand.widget.e.e aji = com.tencent.mm.plugin.appbrand.jsapi.f.a.a.aji();
                            if (aji == null) {
                                aji = new com.tencent.mm.plugin.appbrand.widget.e.e(E.context);
                            }
                            aji.setText("");
                            aji.setTextSize(12);
                            aji.setTextColor(com.tencent.mm.plugin.appbrand.widget.e.e.gMp);
                            aji.setTextPadding(0);
                            aji.setGravity("center");
                            aji.m(0, 0, com.tencent.mm.plugin.appbrand.widget.e.e.gMq, com.tencent.mm.plugin.appbrand.widget.e.e.gMq);
                            aji.setTextColor(fVar.fTB.color);
                            aji.setTextSize(fVar.fTB.fTC);
                            aji.setText(fVar.fTB.content);
                            aji.setTextPadding(fVar.fTB.padding);
                            aji.setGravity(fVar.fTB.fTI);
                            aji.m(fVar.fTB.fTD, fVar.fTB.borderWidth, fVar.fTB.fTL, fVar.fTB.bgColor);
                            aji.setX(fVar.fTB.x);
                            aji.setY(fVar.fTB.y);
                            aji.measure(0, 0);
                            ady2.A(aji.getAnchorX(), aji.getAnchorY());
                            ady2.bF(aji);
                            ady2.adJ();
                            ady2.bg(optString + "#label");
                            eVar.fTw = E.fSW.a(ady2);
                            E.a(optString + "#label", eVar);
                        }
                    }
                    i2 = i3 + 1;
                }
            } else {
                x.e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
                return false;
            }
        }
        return true;
    }
}
