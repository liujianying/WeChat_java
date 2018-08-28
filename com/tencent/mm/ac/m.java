package com.tencent.mm.ac;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class m {
    public static Bitmap kU(String str) {
        boolean z = false;
        if (bi.oW(str) || !g.Ei().isSDCardAvailable() || !g.Eg().Dx()) {
            return null;
        }
        Bitmap bitmap;
        a Ni = z.Ni();
        String format = String.format("%s%f", new Object[]{str, Float.valueOf(1.5f)});
        if (Ni.dMz.containsKey(format)) {
            bitmap = (Bitmap) ((WeakReference) Ni.dMz.get(format)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = b.e(str, 1.5f);
                Ni.dMz.remove(format);
                Ni.dMz.put(format, new WeakReference(bitmap));
            }
        } else {
            bitmap = b.e(str, 1.5f);
            Ni.dMz.put(format, new WeakReference(bitmap));
        }
        String str2 = "MicroMsg.BrandLogic";
        format = "get verify user icon = %s, is null ? %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bitmap == null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        x.i(str2, format, objArr);
        return bitmap;
    }

    public static Bitmap d(String str, String str2, int i) {
        if (!g.Ei().isSDCardAvailable()) {
            return hy(i);
        }
        if (str == null || !g.Eg().Dx()) {
            return null;
        }
        Bitmap bitmap;
        if (str2 == null) {
            str2 = ai(str, null);
            if (str2 == null) {
                return null;
            }
        }
        a Ni = z.Ni();
        WeakReference weakReference;
        if (Ni.dMz.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) Ni.dMz.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = c.Wb(a.kW(str + ai(str, str2)));
                if (bitmap == null) {
                    x.i("MicroMsg.BrandLogic", "not found brand icon local");
                } else {
                    Ni.g(str, bitmap);
                }
            }
            weakReference = (WeakReference) Ni.dMz.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ah.A(new 1(str, str2));
                return null;
            }
        }
        bitmap = c.Wb(a.kW(str + ai(str, str2)));
        if (bitmap == null) {
            x.i("MicroMsg.BrandLogic", "not found brand icon local");
        } else {
            Ni.g(str, bitmap);
            weakReference = (WeakReference) Ni.dMz.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ah.A(new 1(str, str2));
                return null;
            }
        }
        bitmap = null;
        if (bitmap == null) {
            return bitmap;
        }
        ah.A(new 1(str, str2));
        return null;
    }

    public static Bitmap kV(String str) {
        if (!g.Ei().isSDCardAvailable()) {
            return hy(0);
        }
        if (str == null || !g.Eg().Dx()) {
            return null;
        }
        Bitmap bitmap;
        a Ni = z.Ni();
        if (Ni.dMz.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) Ni.dMz.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
        }
        bitmap = null;
        return bitmap;
    }

    private static Bitmap hy(int i) {
        Throwable e;
        if (i <= 0) {
            return null;
        }
        Options options = new Options();
        c.c(options);
        InputStream openRawResource;
        try {
            openRawResource = ad.getContext().getResources().openRawResource(i);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource, null, options);
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.BrandLogic", e2, "", new Object[0]);
                    }
                }
                if (decodeStream != null) {
                    return c.a(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
                }
                return decodeStream;
            } catch (Throwable th) {
                e2 = th;
            }
        } catch (Throwable th2) {
            e2 = th2;
            openRawResource = null;
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable th3) {
                    x.printErrStackTrace("MicroMsg.BrandLogic", th3, "", new Object[0]);
                }
            }
            throw e2;
        }
    }

    static String ai(String str, String str2) {
        if (str == null || !g.Eg().Dx()) {
            return null;
        }
        d kA = z.MY().kA(str);
        if (kA.field_brandIconURL != null) {
            return kA.field_brandIconURL;
        }
        return str2;
    }
}
