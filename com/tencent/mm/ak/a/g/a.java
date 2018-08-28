package com.tencent.mm.ak.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ak.a.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;

public final class a {
    public static Bitmap a(c cVar, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            return com.tencent.mm.sdk.platformtools.c.e(str, i2, i, false);
        }
        if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            return com.tencent.mm.sdk.platformtools.c.Wb(str);
        }
        return com.tencent.mm.sdk.platformtools.c.aj(str, cVar.width, cVar.height);
    }

    public static Bitmap b(c cVar, String str, int i, int i2) {
        Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(str);
        if (VZ == null || (VZ.outWidth < VZ.outHeight * 2 && VZ.outWidth * 2 > VZ.outHeight)) {
            return com.tencent.mm.sdk.platformtools.c.e(str, i2, i, false);
        }
        if (i > 0 && i2 > 0) {
            return com.tencent.mm.sdk.platformtools.c.e(str, i2, i, true);
        }
        if (cVar != null && cVar.width > 0 && cVar.width > 0) {
            return com.tencent.mm.sdk.platformtools.c.e(str, cVar.height, cVar.width, true);
        }
        int i3;
        int i4;
        if (cVar == null || cVar.getImageView() == null) {
            x.w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
            i3 = 0;
            i4 = 0;
        } else {
            int measuredWidth = cVar.getImageView().getMeasuredWidth();
            i3 = cVar.getImageView().getMeasuredHeight();
            i4 = measuredWidth;
        }
        return com.tencent.mm.sdk.platformtools.c.e(str, i3, i4, true);
    }

    public static Bitmap a(c cVar, InputStream inputStream, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap a;
        if (i > 0 && i2 > 0) {
            a = com.tencent.mm.sdk.platformtools.c.a(inputStream, 0.0f, i, i2);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            a = com.tencent.mm.sdk.platformtools.c.decodeStream(inputStream);
        } else {
            a = com.tencent.mm.sdk.platformtools.c.a(inputStream, 0.0f, cVar.width, cVar.height);
        }
        if (z) {
            a = com.tencent.mm.sdk.platformtools.c.a(a, i, i2, false, true);
        }
        if (f > 0.0f) {
            a = com.tencent.mm.sdk.platformtools.c.c(a, f);
        }
        if (z2) {
            return com.tencent.mm.sdk.platformtools.c.S(a);
        }
        return a;
    }

    public static Bitmap a(c cVar, byte[] bArr, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap decodeByteArray;
        if (i > 0 && i2 > 0) {
            decodeByteArray = com.tencent.mm.sdk.platformtools.c.decodeByteArray(bArr, i, i2);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            decodeByteArray = com.tencent.mm.sdk.platformtools.c.bs(bArr);
        } else {
            decodeByteArray = com.tencent.mm.sdk.platformtools.c.decodeByteArray(bArr, cVar.width, cVar.height);
        }
        if (z) {
            decodeByteArray = com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.decodeByteArray(bArr, i, i2), i, i2, false, true);
        }
        if (f > 0.0f) {
            decodeByteArray = com.tencent.mm.sdk.platformtools.c.c(decodeByteArray, f);
        }
        if (z2) {
            return com.tencent.mm.sdk.platformtools.c.S(decodeByteArray);
        }
        return decodeByteArray;
    }

    public static Bitmap c(c cVar, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            return com.tencent.mm.sdk.platformtools.c.ak(str, i, i2);
        }
        if (cVar != null) {
            try {
                if (cVar.width > 0 && cVar.width > 0) {
                    return com.tencent.mm.sdk.platformtools.c.ak(str, cVar.width, cVar.height);
                }
            } catch (IOException e) {
                x.e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", new Object[]{e.toString()});
                return null;
            }
        }
        return com.tencent.mm.sdk.platformtools.c.ak(str, 0, 0);
    }

    public static Bitmap a(c cVar, int i, int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            return com.tencent.mm.sdk.platformtools.c.aj(i, i2, i3);
        }
        if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            return com.tencent.mm.sdk.platformtools.c.CV(i);
        }
        return com.tencent.mm.sdk.platformtools.c.aj(i, cVar.width, cVar.height);
    }
}
