package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.modelappbrand.b.b.c;
import com.tencent.mm.modelappbrand.b.b.i;

public final class a {
    private static final i fvr = new c();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap aY(java.lang.String r7, java.lang.String r8) {
        /*
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r1 != 0) goto L_0x000d;
    L_0x0007:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r8);
        if (r1 == 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r2 = com.tencent.mm.plugin.appbrand.appcache.a.qB(r8);
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r1 != 0) goto L_0x000d;
    L_0x0018:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r7);
        r3 = 35;
        r1 = r1.append(r3);
        r1 = r1.append(r2);
        r3 = r1.toString();
        r1 = fvr;
        r1 = r1.jz(r3);
        if (r1 == 0) goto L_0x003f;
    L_0x0037:
        r4 = r1.isRecycled();
        if (r4 != 0) goto L_0x003f;
    L_0x003d:
        r0 = r1;
        goto L_0x000d;
    L_0x003f:
        r2 = com.tencent.mm.plugin.appbrand.dynamic.j.c.bk(r7, r2);
        if (r2 == 0) goto L_0x0051;
    L_0x0045:
        r1 = r2.mInputStream;	 Catch:{ IOException -> 0x007d }
        if (r1 == 0) goto L_0x0051;
    L_0x0049:
        r1 = r2.mInputStream;	 Catch:{ IOException -> 0x007d }
        r1 = r1.available();	 Catch:{ IOException -> 0x007d }
        if (r1 > 0) goto L_0x0059;
    L_0x0051:
        if (r2 == 0) goto L_0x000d;
    L_0x0053:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bi.d(r1);
        goto L_0x000d;
    L_0x0059:
        r1 = r2.mInputStream;	 Catch:{ IOException -> 0x007d }
        r1 = com.tencent.mm.sdk.platformtools.c.decodeStream(r1);	 Catch:{ IOException -> 0x007d }
        if (r1 == 0) goto L_0x0075;
    L_0x0061:
        r4 = r1.isRecycled();	 Catch:{ IOException -> 0x007d }
        if (r4 != 0) goto L_0x0075;
    L_0x0067:
        r4 = fvr;	 Catch:{ IOException -> 0x007d }
        r4.d(r3, r1);	 Catch:{ IOException -> 0x007d }
        if (r2 == 0) goto L_0x0073;
    L_0x006e:
        r0 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bi.d(r0);
    L_0x0073:
        r0 = r1;
        goto L_0x000d;
    L_0x0075:
        if (r2 == 0) goto L_0x000d;
    L_0x0077:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bi.d(r1);
        goto L_0x000d;
    L_0x007d:
        r1 = move-exception;
        r3 = "MicroMsg.CanvasImageCache";
        r4 = "try decode icon e = %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0096 }
        r6 = 0;
        r5[r6] = r1;	 Catch:{ all -> 0x0096 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x000d;
    L_0x008f:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bi.d(r1);
        goto L_0x000d;
    L_0x0096:
        r0 = move-exception;
        if (r2 == 0) goto L_0x009e;
    L_0x0099:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bi.d(r1);
    L_0x009e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.b.a.aY(java.lang.String, java.lang.String):android.graphics.Bitmap");
    }
}
