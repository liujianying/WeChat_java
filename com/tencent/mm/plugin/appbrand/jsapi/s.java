package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.h;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s extends a {
    public static final int CTRL_INDEX = 372;
    public static final String NAME = "canvasGetImageData";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        try {
            int i2 = jSONObject.getInt("canvasId");
            p d = d(lVar);
            if (d == null) {
                x.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, current page view is null.");
                lVar.E(i, f("fail:page is null", null));
                return;
            }
            View lx = d.agU().lx(i2);
            if (lx == null) {
                x.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", new Object[]{Integer.valueOf(i2)});
                lVar.E(i, f("fail:view is null", null));
            } else if (lx instanceof CoverViewContainer) {
                lx = ((CoverViewContainer) lx).A(View.class);
                if (lx instanceof a) {
                    float aor = f.aor();
                    int optInt = jSONObject.optInt("x");
                    int optInt2 = jSONObject.optInt("y");
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    if (optInt3 == 0 || optInt4 == 0) {
                        x.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", new Object[]{Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2)});
                        lVar.E(i, f("fail:width or height is 0", null));
                        return;
                    }
                    int i3;
                    int i4;
                    int i5;
                    int i6;
                    if (optInt3 < 0) {
                        optInt += optInt3;
                        optInt3 = -optInt3;
                        i3 = optInt;
                    } else {
                        i3 = optInt;
                    }
                    if (optInt4 < 0) {
                        optInt = optInt2 + optInt4;
                        i4 = -optInt4;
                    } else {
                        optInt = optInt2;
                        i4 = optInt4;
                    }
                    int round = Math.round(((float) i3) * aor);
                    int round2 = Math.round(((float) optInt) * aor);
                    optInt4 = Math.round(((float) optInt3) * aor);
                    optInt2 = Math.round(((float) i4) * aor);
                    int measuredWidth = lx.getMeasuredWidth();
                    int measuredHeight = lx.getMeasuredHeight();
                    if (round < 0) {
                        i5 = 0;
                    } else if (round >= measuredWidth) {
                        lVar.E(i, a(lVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else {
                        i5 = round;
                    }
                    if (round2 < 0) {
                        i6 = 0;
                    } else if (round2 >= measuredHeight) {
                        lVar.E(i, a(lVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else {
                        i6 = round2;
                    }
                    if (round + optInt4 > measuredWidth) {
                        optInt4 = measuredWidth - i5;
                    } else if (round + optInt4 <= 0) {
                        lVar.E(i, a(lVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else if (round < 0) {
                        optInt4 += round;
                    }
                    if (round2 + optInt2 > measuredHeight) {
                        optInt2 = measuredHeight - i6;
                    } else if (round2 + optInt2 <= 0) {
                        lVar.E(i, a(lVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else if (round2 < 0) {
                        optInt2 += round2;
                    }
                    measuredWidth = Math.round(((float) i5) / aor);
                    measuredHeight = Math.round(((float) i6) / aor);
                    round2 = Math.round(((float) optInt4) / aor);
                    round = Math.round(((float) optInt2) / aor);
                    try {
                        Bitmap createBitmap = Bitmap.createBitmap(optInt4, optInt2, Config.ARGB_8888);
                        h hVar = new h(createBitmap);
                        hVar.save();
                        hVar.translate((float) (-i5), (float) (-i6));
                        ((a) lx).d(hVar);
                        hVar.restore();
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, round2, round, false);
                        int[] iArr = new int[(optInt3 * i4)];
                        createScaledBitmap.getPixels(iArr, ((measuredHeight - optInt) * optInt3) + (measuredWidth - i3), optInt3, 0, 0, round2, round);
                        lVar.E(i, a(lVar, "ok", b(iArr, optInt3, i4)));
                        return;
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", new Object[]{Integer.valueOf(i2), e});
                        lVar.E(i, f("fail:create bitmap failed", null));
                        return;
                    }
                }
                x.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", new Object[]{Integer.valueOf(i2)});
                lVar.E(i, f("fail:illegal view type", null));
            } else {
                x.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", new Object[]{Integer.valueOf(i2)});
                lVar.E(i, f("fail:illegal view type", null));
            }
        } catch (Throwable e2) {
            x.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", new Object[]{Log.getStackTraceString(e2)});
            lVar.E(i, f("fail:illegal canvasId", null));
        }
    }

    private static Map<String, Object> b(int[] iArr, int i, int i2) {
        int i3 = 0;
        byte[] bArr = new byte[(iArr.length * 4)];
        int i4 = 0;
        while (true) {
            int i5 = i3;
            if (i4 < iArr.length) {
                i3 = i5 + 1;
                bArr[i5] = (byte) ((iArr[i4] >> 16) & 255);
                i5 = i3 + 1;
                bArr[i3] = (byte) ((iArr[i4] >> 8) & 255);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (iArr[i4] & 255);
                i3 = i6 + 1;
                bArr[i6] = (byte) ((iArr[i4] >> 24) & 255);
                i4++;
            } else {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Map<String, Object> hashMap = new HashMap();
                hashMap.put("data", wrap);
                hashMap.put("width", Integer.valueOf(i));
                hashMap.put("height", Integer.valueOf(i2));
                return hashMap;
            }
        }
    }
}
