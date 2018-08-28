package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static n ev(String str, String str2) {
        int argb = Color.argb(51, 255, 255, 255);
        n LH = i.LH(str);
        if (LH != null) {
            return a(LH.Fw(), str2, argb, 55);
        }
        x.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
        return null;
    }

    public static n a(Bitmap bitmap, String str, int i, int i2) {
        n m = n.m(c.e(bitmap, i2));
        if (m == null) {
            x.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
        }
        if (m != null) {
            new Canvas(m.Fw()).drawColor(i);
        }
        try {
            c.a(m.Fw(), 70, CompressFormat.JPEG, str, false);
        } catch (Throwable e) {
            x.e("MicroMsg.BlurHelper", "error for exception " + e.getMessage());
            x.printErrStackTrace("MicroMsg.BlurHelper", e, "", new Object[0]);
        }
        x.i("MicroMsg.BlurHelper", "blur done bitmap  " + m);
        return m;
    }
}
