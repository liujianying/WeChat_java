package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t extends a {
    public static final int CTRL_INDEX = 373;
    public static final String NAME = "canvasPutImageData";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        try {
            int i2 = jSONObject.getInt("canvasId");
            p d = d(lVar);
            if (d == null) {
                x.w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasGetImageData failed, current page view is null.");
                lVar.E(i, f("fail:page is null", null));
                return;
            }
            View lx = d.agU().lx(i2);
            if (lx == null) {
                x.w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", new Object[]{Integer.valueOf(i2)});
                lVar.E(i, f("fail:view is null", null));
            } else if (lx instanceof CoverViewContainer) {
                View A = ((CoverViewContainer) lx).A(View.class);
                if (A instanceof a) {
                    float aor = f.aor();
                    int optInt = jSONObject.optInt("x");
                    int optInt2 = jSONObject.optInt("y");
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    Math.round(((float) optInt) * aor);
                    Math.round(((float) optInt2) * aor);
                    Math.round(((float) optInt3) * aor);
                    Math.round(aor * ((float) optInt4));
                    if (optInt3 == 0 || optInt4 == 0) {
                        x.i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", new Object[]{Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2)});
                        lVar.E(i, f("fail:width or height is 0", null));
                        return;
                    }
                    if (optInt3 < 0) {
                        optInt += optInt3;
                        i2 = -optInt3;
                    } else {
                        i2 = optInt3;
                    }
                    if (optInt4 < 0) {
                        optInt2 += optInt4;
                        optInt3 = -optInt4;
                    } else {
                        optInt3 = optInt4;
                    }
                    m.a(lVar, jSONObject, this);
                    try {
                        Object obj = jSONObject.get("data");
                        if (obj instanceof ByteBuffer) {
                            ByteBuffer byteBuffer = (ByteBuffer) obj;
                            JSONArray jSONArray = new JSONArray();
                            int[] h = h(byteBuffer);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(optInt);
                                jSONArray2.put(optInt2);
                                jSONArray2.put(i2);
                                jSONArray2.put(optInt3);
                                jSONArray2.put(Bitmap.createBitmap(h, i2, optInt3, Config.ARGB_8888));
                                jSONObject2.put("method", "__setPixels");
                                jSONObject2.put("data", jSONArray2);
                                jSONArray.put(jSONObject2);
                                a aVar = (a) A;
                                aVar.b(jSONArray, new 1(this, lVar, i));
                                aVar.adk();
                                return;
                            } catch (JSONException e) {
                                x.w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", new Object[]{e});
                                lVar.E(i, f("fail:build action JSON error", null));
                                return;
                            }
                        }
                        x.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
                        lVar.E(i, f("fail:illegal data", null));
                        return;
                    } catch (Throwable e2) {
                        x.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", new Object[]{Log.getStackTraceString(e2)});
                        lVar.E(i, f("fail:missing data", null));
                        return;
                    }
                }
                x.i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", new Object[]{Integer.valueOf(i2)});
                lVar.E(i, f("fail:illegal view type", null));
            } else {
                x.w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", new Object[]{Integer.valueOf(i2)});
                lVar.E(i, f("fail:illegal view type", null));
            }
        } catch (Throwable e22) {
            x.i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", new Object[]{Log.getStackTraceString(e22)});
            lVar.E(i, f("fail:illegal canvasId", null));
        }
    }

    private static int[] h(ByteBuffer byteBuffer) {
        int i = 0;
        byte[] k = c.k(byteBuffer);
        int[] iArr = new int[(k.length / 4)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= iArr.length) {
                return iArr;
            }
            i = i3 + 1;
            int i4 = i + 1;
            i = ((k[i] & WebView.NORMAL_MODE_ALPHA) << 8) | ((k[i3] & WebView.NORMAL_MODE_ALPHA) << 16);
            i3 = i4 + 1;
            i4 = (k[i4] & WebView.NORMAL_MODE_ALPHA) | i;
            i = i3 + 1;
            iArr[i2] = ((k[i3] & WebView.NORMAL_MODE_ALPHA) << 24) | i4;
            i2++;
        }
    }
}
