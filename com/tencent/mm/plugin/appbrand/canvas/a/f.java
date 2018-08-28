package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import org.json.JSONArray;

public final class f implements d {
    public final String getMethod() {
        return "drawImage";
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.canvas.f fVar, Canvas canvas, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length < 3) {
            return false;
        }
        String optString = jSONArray.optString(0);
        float d = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 1);
        float d2 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 2);
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        float f;
        float f2;
        Bitmap a;
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (length >= 5) {
            f3 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 3);
            f4 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 4);
            if (f3 == 0.0f || f4 == 0.0f) {
                return true;
            }
            if (f3 < 0.0f) {
                d += f3;
                f3 = -f3;
            }
            if (f4 < 0.0f) {
                d2 += f4;
                f = -f4;
                f2 = f3;
                f3 = d + f2;
                f4 = d2 + f;
                if (length < 9) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    length = jSONArray.optInt(7);
                    int optInt3 = jSONArray.optInt(8);
                    if (length == 0 || optInt3 == 0) {
                        return true;
                    }
                    int i;
                    int i2;
                    if (length < 0) {
                        optInt += length;
                        i = -length;
                    } else {
                        i = length;
                    }
                    if (optInt3 < 0) {
                        optInt2 += optInt3;
                        i2 = -optInt3;
                    } else {
                        i2 = optInt3;
                    }
                    if (optInt + i <= 0 || optInt2 + i2 <= 0) {
                        return true;
                    }
                    int i3 = optInt > 0 ? optInt : 0;
                    optInt3 = optInt2 > 0 ? optInt2 : 0;
                    a = fVar.fnl.a(fVar.doU, optString, new Rect(i3, optInt3, optInt + i, optInt2 + i2), new 1(this, fVar));
                    if (a == null || a.isRecycled()) {
                        return false;
                    }
                    optInt = com.tencent.mm.plugin.appbrand.q.f.lP(optInt);
                    optInt2 = com.tencent.mm.plugin.appbrand.q.f.lP(optInt2);
                    i = com.tencent.mm.plugin.appbrand.q.f.lP(i);
                    i2 = com.tencent.mm.plugin.appbrand.q.f.lP(i2);
                    float f5 = f2 / ((float) i);
                    float f6 = f / ((float) i2);
                    d += ((float) (com.tencent.mm.plugin.appbrand.q.f.lP(i3) - optInt)) * f5;
                    d2 += ((float) (com.tencent.mm.plugin.appbrand.q.f.lP(optInt3) - optInt2)) * f6;
                    f3 = d + (((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getWidth())) * f5);
                    f4 = (((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getHeight())) * f6) + d2;
                } else {
                    a = fVar.fnl.a(fVar.doU, optString, new 2(this, fVar));
                    if (a == null || a.isRecycled()) {
                        return false;
                    }
                    if (f2 == 0.0f) {
                        f3 = ((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getWidth())) + d;
                    }
                    if (f == 0.0f) {
                        f4 = ((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getHeight())) + d2;
                    }
                }
                canvas.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(d, d2, f3, f4), fVar.fng);
                return true;
            }
        }
        f = f4;
        f2 = f3;
        f3 = d + f2;
        f4 = d2 + f;
        if (length < 9) {
            a = fVar.fnl.a(fVar.doU, optString, new 2(this, fVar));
            if (a == null || a.isRecycled()) {
                return false;
            }
            if (f2 == 0.0f) {
                f3 = ((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getWidth())) + d;
            }
            if (f == 0.0f) {
                f4 = ((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getHeight())) + d2;
            }
        } else {
            int optInt4 = jSONArray.optInt(5);
            int optInt22 = jSONArray.optInt(6);
            length = jSONArray.optInt(7);
            int optInt32 = jSONArray.optInt(8);
            if (length == 0 || optInt32 == 0) {
                return true;
            }
            int i4;
            int i22;
            if (length < 0) {
                optInt4 += length;
                i4 = -length;
            } else {
                i4 = length;
            }
            if (optInt32 < 0) {
                optInt22 += optInt32;
                i22 = -optInt32;
            } else {
                i22 = optInt32;
            }
            if (optInt4 + i4 <= 0 || optInt22 + i22 <= 0) {
                return true;
            }
            int i32 = optInt4 > 0 ? optInt4 : 0;
            optInt32 = optInt22 > 0 ? optInt22 : 0;
            a = fVar.fnl.a(fVar.doU, optString, new Rect(i32, optInt32, optInt4 + i4, optInt22 + i22), new 1(this, fVar));
            if (a == null || a.isRecycled()) {
                return false;
            }
            optInt4 = com.tencent.mm.plugin.appbrand.q.f.lP(optInt4);
            optInt22 = com.tencent.mm.plugin.appbrand.q.f.lP(optInt22);
            i4 = com.tencent.mm.plugin.appbrand.q.f.lP(i4);
            i22 = com.tencent.mm.plugin.appbrand.q.f.lP(i22);
            float f52 = f2 / ((float) i4);
            float f62 = f / ((float) i22);
            d += ((float) (com.tencent.mm.plugin.appbrand.q.f.lP(i32) - optInt4)) * f52;
            d2 += ((float) (com.tencent.mm.plugin.appbrand.q.f.lP(optInt32) - optInt22)) * f62;
            f3 = d + (((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getWidth())) * f52);
            f4 = (((float) com.tencent.mm.plugin.appbrand.q.f.lP(a.getHeight())) * f62) + d2;
        }
        canvas.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(d, d2, f3, f4), fVar.fng);
        return true;
    }
}
