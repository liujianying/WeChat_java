package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    protected final int k(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapLines", "get mapId error, exception : %s", new Object[]{e});
            return -1;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddMapLines", "data is null");
            return false;
        }
        x.d("MicroMsg.JsApiAddMapLines", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
        com.tencent.mm.plugin.appbrand.jsapi.f.a.c E = b.E(pVar.mAppId, pVar.hashCode(), k(jSONObject));
        if (E == null) {
            x.e("MicroMsg.JsApiAddMapLines", "appBrandMapView is null, return");
            return false;
        }
        try {
            if (jSONObject.has("lines")) {
                E.ajl();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    int i4;
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    Iterable arrayList = new ArrayList();
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                    for (i4 = 0; i4 < jSONArray2.length(); i4++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                        arrayList.add(E.C(bi.getFloat(jSONObject3.optString("latitude"), 0.0f), bi.getFloat(jSONObject3.optString("longitude"), 0.0f)));
                    }
                    i4 = f.aQ(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    int a = f.a(jSONObject2, "width", 0);
                    boolean optBoolean = jSONObject2.optBoolean("dottedLine", false);
                    int aQ = f.aQ(jSONObject2.optString("borderColor", ""), Color.parseColor("#000000"));
                    int a2 = f.a(jSONObject2, "borderWidth", 0);
                    boolean optBoolean2 = jSONObject2.optBoolean("arrowLine", false);
                    String optString = jSONObject2.optString("arrowIconPath", "");
                    com.tencent.mm.plugin.appbrand.compat.a.b.p adA = E.fSW.adA();
                    adA.c(arrayList);
                    adA.jT(i4);
                    adA.jU(a);
                    adA.setDottedLine(optBoolean);
                    adA.jV(aQ);
                    adA.jW(a2);
                    if (optBoolean2) {
                        Object obj = 1;
                        Bitmap bitmap;
                        if (!bi.oW(optString) && optString.startsWith("wxfile://")) {
                            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, optString);
                            if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.dDG)) {
                                x.e("MicroMsg.JsApiAddMapLines", "arrowIconPath:%s, item is null", new Object[]{optString});
                            } else {
                                x.d("MicroMsg.JsApiAddMapLines", "fileFullPath:%s", new Object[]{itemByLocalId.dDG});
                                bitmap = null;
                                Options options = new Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(itemByLocalId.dDG, options);
                                if (options.outHeight <= 0 || options.outWidth <= 0) {
                                    x.e("MicroMsg.JsApiAddMapLines", "decode[%s] error, outHeight[%d] outWidth[%d]", new Object[]{itemByLocalId.dDG, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth)});
                                } else {
                                    bitmap = com.tencent.mm.sdk.platformtools.c.aj(itemByLocalId.dDG, (options.outHeight * a) / options.outWidth, a);
                                }
                                if (bitmap != null) {
                                    adA.u(bitmap);
                                    obj = null;
                                } else {
                                    x.e("MicroMsg.JsApiAddMapLines", "BitmapUtil decode fail, mLocalBitmap is null, use default");
                                }
                            }
                        } else if (!bi.oW(optString)) {
                            bitmap = o.j(pVar.fdO, optString);
                            if (bitmap != null) {
                                obj = null;
                                adA.u(bitmap);
                            } else {
                                x.e("MicroMsg.JsApiAddMapLines", "arrowIconPath:%s, AppBrandPageIconCache.getIcon fail, mLocalBitmap is null", new Object[]{optString});
                            }
                        }
                        if (obj != null) {
                            adA.u(BitmapFactory.decodeStream(ad.getContext().getAssets().open("app_brand_map_line_texture_arrow.png")));
                        }
                    }
                    com.tencent.mm.plugin.appbrand.compat.a.b.o a3 = E.fSW.a(adA);
                    synchronized (E.fTg) {
                        E.fTg.add(a3);
                    }
                    i2 = i3 + 1;
                }
            } else {
                x.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[]{e});
            return false;
        }
    }
}
