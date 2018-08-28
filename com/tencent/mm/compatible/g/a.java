package com.tencent.mm.compatible.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public final class a extends BitmapFactory {
    private static a dfW = null;

    public interface a {
        Bitmap decodeResource(Resources resources, int i, Options options);
    }

    public static void a(a aVar) {
        dfW = aVar;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, null);
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        if (dfW != null) {
            Bitmap decodeResource = dfW.decodeResource(resources, i, options);
            if (decodeResource != null) {
                return decodeResource;
            }
        }
        return a(resources, i, options);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(android.content.res.Resources r4, int r5, android.graphics.BitmapFactory.Options r6) {
        /*
        r1 = 0;
        com.tencent.mm.sdk.platformtools.c.c(r6);
        r2 = new android.util.TypedValue;	 Catch:{ Exception -> 0x002a, all -> 0x0035 }
        r2.<init>();	 Catch:{ Exception -> 0x002a, all -> 0x0035 }
        r0 = r4.openRawResource(r5, r2);	 Catch:{ Exception -> 0x002a, all -> 0x0035 }
        r3 = 0;
        r1 = decodeResourceStream(r4, r2, r0, r3, r6);	 Catch:{ Exception -> 0x003e, all -> 0x0045 }
    L_0x0012:
        if (r1 != 0) goto L_0x004c;
    L_0x0014:
        r2 = decodeStream(r0);	 Catch:{ Exception -> 0x0049, all -> 0x0045 }
    L_0x0018:
        if (r0 == 0) goto L_0x001d;
    L_0x001a:
        r0.close();	 Catch:{ IOException -> 0x0040 }
    L_0x001d:
        if (r2 != 0) goto L_0x0044;
    L_0x001f:
        if (r6 == 0) goto L_0x0044;
    L_0x0021:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Problem decoding into existing bitmap";
        r0.<init>(r1);
        throw r0;
    L_0x002a:
        r0 = move-exception;
        r0 = r1;
        r2 = r1;
    L_0x002d:
        if (r0 == 0) goto L_0x001d;
    L_0x002f:
        r0.close();	 Catch:{ IOException -> 0x0033 }
        goto L_0x001d;
    L_0x0033:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0035:
        r0 = move-exception;
        r2 = r0;
        r3 = r1;
    L_0x0038:
        if (r3 == 0) goto L_0x003d;
    L_0x003a:
        r3.close();	 Catch:{ IOException -> 0x0042 }
    L_0x003d:
        throw r2;
    L_0x003e:
        r2 = move-exception;
        goto L_0x0012;
    L_0x0040:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0042:
        r0 = move-exception;
        goto L_0x003d;
    L_0x0044:
        return r2;
    L_0x0045:
        r1 = move-exception;
        r2 = r1;
        r3 = r0;
        goto L_0x0038;
    L_0x0049:
        r2 = move-exception;
        r2 = r1;
        goto L_0x002d;
    L_0x004c:
        r2 = r1;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.g.a.a(android.content.res.Resources, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }
}
