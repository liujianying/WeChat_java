package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.plugin.appbrand.page.p;

class k$1 extends e$b {
    final /* synthetic */ String bAj;
    final /* synthetic */ p fIY;
    final /* synthetic */ String fYI;

    k$1(String str, p pVar, String str2) {
        this.bAj = str;
        this.fIY = pVar;
        this.fYI = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.e.c r11) {
        /*
        r10 = this;
        r0 = 0;
        r5 = 3;
        r9 = 2;
        r8 = 0;
        r7 = 1;
        r1 = r10.bAj;
        com.tencent.mm.plugin.appbrand.e.b(r1, r10);
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = "action";
        r1.putInt(r2, r7);
        r2 = "com.tencent.mm";
        r3 = com.tencent.mm.plugin.appbrand.jsapi.share.a.class;
        com.tencent.mm.ipcinvoker.f.a(r2, r1, r3, r0);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r10.fIY;
        if (r1 != 0) goto L_0x00c1;
    L_0x0025:
        r1 = "MicroMsg.ShareHelper";
        r4 = "cropCover(appId : %s, pageView : %s, cropCost : %sms)";
        r5 = new java.lang.Object[r5];
        r6 = r10.fIY;
        r6 = r6.mAppId;
        r5[r8] = r6;
        r6 = r10.fIY;
        r6 = r6.hashCode();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r7] = r6;
        r6 = java.lang.System.currentTimeMillis();
        r2 = r6 - r2;
        r2 = java.lang.Long.valueOf(r2);
        r5[r9] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        if (r0 == 0) goto L_0x00b5;
    L_0x0050:
        r1 = r0.isRecycled();	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        if (r1 != 0) goto L_0x00b5;
    L_0x0056:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r1 = 100;
        r4 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r5 = r10.fYI;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r6 = 1;
        com.tencent.mm.sdk.platformtools.c.a(r0, r1, r4, r5, r6);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r1 = "MicroMsg.ShareHelper";
        r4 = "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r6 = 0;
        r7 = r10.fIY;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r7 = r7.mAppId;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r6 = 1;
        r7 = r10.fIY;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r7 = r7.hashCode();	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r6 = 2;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r8 = r8 - r2;
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r1 = new android.os.Bundle;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r1.<init>();	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r4 = "delay_load_img_path";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r6 = "file://";
        r5.<init>(r6);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r6 = r10.fYI;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r1.putString(r4, r5);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r4 = new com.tencent.mm.plugin.appbrand.jsapi.share.k$1$1;	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        r4.<init>(r10, r2, r1);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
        com.tencent.mm.bu.a.post(r4);	 Catch:{ IOException -> 0x00c7, Exception -> 0x00e3 }
    L_0x00b5:
        if (r0 == 0) goto L_0x00c0;
    L_0x00b7:
        r1 = r0.isRecycled();
        if (r1 != 0) goto L_0x00c0;
    L_0x00bd:
        r0.recycle();
    L_0x00c0:
        return;
    L_0x00c1:
        r0 = r1.ahe();
        goto L_0x0025;
    L_0x00c7:
        r1 = move-exception;
        r2 = "MicroMsg.ShareHelper";
        r3 = "save temp bitmap to file failed, . exception : %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ff }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ all -> 0x00ff }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ all -> 0x00ff }
        if (r0 == 0) goto L_0x00c0;
    L_0x00d9:
        r1 = r0.isRecycled();
        if (r1 != 0) goto L_0x00c0;
    L_0x00df:
        r0.recycle();
        goto L_0x00c0;
    L_0x00e3:
        r1 = move-exception;
        r2 = "MicroMsg.ShareHelper";
        r3 = "save temp bitmap to file failed, . exception : %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ff }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ all -> 0x00ff }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ all -> 0x00ff }
        if (r0 == 0) goto L_0x00c0;
    L_0x00f5:
        r1 = r0.isRecycled();
        if (r1 != 0) goto L_0x00c0;
    L_0x00fb:
        r0.recycle();
        goto L_0x00c0;
    L_0x00ff:
        r1 = move-exception;
        if (r0 == 0) goto L_0x010b;
    L_0x0102:
        r2 = r0.isRecycled();
        if (r2 != 0) goto L_0x010b;
    L_0x0108:
        r0.recycle();
    L_0x010b:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.share.k$1.a(com.tencent.mm.plugin.appbrand.e$c):void");
    }
}
