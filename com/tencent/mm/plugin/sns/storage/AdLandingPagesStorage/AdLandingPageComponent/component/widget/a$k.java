package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

class a$k implements Runnable {
    final /* synthetic */ a nGD;
    WeakReference<Bitmap> nde;

    private a$k(a aVar) {
        this.nGD = aVar;
        this.nde = new WeakReference(null);
    }

    /* synthetic */ a$k(a aVar, byte b) {
        this(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r1 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.m(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x0017;
    L_0x000b:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.m(r0);	 Catch:{ Exception -> 0x00df }
        r0 = r0.isValid();	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x020a;
    L_0x0017:
        r4 = "MicroMsg.SightPlayController";
        r5 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
        r0 = 6;
        r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
        r0 = 0;
        r7 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r7 = r7.hashCode();	 Catch:{ Exception -> 0x00df }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
        r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
        r0 = 1;
        r7 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
        r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
        r7 = 2;
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.m(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x00c9;
    L_0x0041:
        r0 = r2;
    L_0x0042:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
        r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
        r7 = 3;
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.n(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x00cc;
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
        r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
        r7 = 4;
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x00ce;
    L_0x0061:
        r0 = r2;
    L_0x0062:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
        r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
        r7 = 5;
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x00d0;
    L_0x0071:
        r0 = r2;
    L_0x0072:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
        r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.sdk.platformtools.x.w(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x00ec;
    L_0x0083:
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
        r4 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.n(r4);	 Catch:{ Exception -> 0x00df }
        if (r4 == 0) goto L_0x009f;
    L_0x0093:
        r1 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.n(r1);	 Catch:{ Exception -> 0x00df }
        r1 = r1.get();	 Catch:{ Exception -> 0x00df }
        r1 = (android.view.View) r1;	 Catch:{ Exception -> 0x00df }
    L_0x009f:
        if (r1 == 0) goto L_0x00a9;
    L_0x00a1:
        if (r0 == 0) goto L_0x00a9;
    L_0x00a3:
        r4 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
        if (r4 == 0) goto L_0x00d6;
    L_0x00a9:
        r4 = "MicroMsg.SightPlayController";
        r5 = "bgView:%B, thumb:%B";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
        r7 = 0;
        if (r1 != 0) goto L_0x00d2;
    L_0x00b5:
        r1 = r2;
    L_0x00b6:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00df }
        r6[r7] = r1;	 Catch:{ Exception -> 0x00df }
        r1 = 1;
        if (r0 != 0) goto L_0x00d4;
    L_0x00bf:
        r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
        r6[r1] = r0;	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
    L_0x00c8:
        return;
    L_0x00c9:
        r0 = r3;
        goto L_0x0042;
    L_0x00cc:
        r0 = r3;
        goto L_0x0052;
    L_0x00ce:
        r0 = r3;
        goto L_0x0062;
    L_0x00d0:
        r0 = r3;
        goto L_0x0072;
    L_0x00d2:
        r1 = r3;
        goto L_0x00b6;
    L_0x00d4:
        r2 = r3;
        goto L_0x00bf;
    L_0x00d6:
        r2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$1;	 Catch:{ Exception -> 0x00df }
        r2.<init>(r10, r1, r0);	 Catch:{ Exception -> 0x00df }
        r1.post(r2);	 Catch:{ Exception -> 0x00df }
        goto L_0x00c8;
    L_0x00df:
        r0 = move-exception;
        r1 = "MicroMsg.SightPlayController";
        r2 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x00c8;
    L_0x00ec:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.p(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x0120;
    L_0x00f4:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.p(r0);	 Catch:{ Exception -> 0x00df }
        r0 = r0.getWidth();	 Catch:{ Exception -> 0x00df }
        r4 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r4);	 Catch:{ Exception -> 0x00df }
        r4 = r4.getWidth();	 Catch:{ Exception -> 0x00df }
        if (r0 != r4) goto L_0x0120;
    L_0x010a:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.p(r0);	 Catch:{ Exception -> 0x00df }
        r0 = r0.getHeight();	 Catch:{ Exception -> 0x00df }
        r4 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r4);	 Catch:{ Exception -> 0x00df }
        r4 = r4.getHeight();	 Catch:{ Exception -> 0x00df }
        if (r0 == r4) goto L_0x013f;
    L_0x0120:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x018a }
        r4 = r10.nGD;	 Catch:{ Exception -> 0x018a }
        r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r4);	 Catch:{ Exception -> 0x018a }
        r4 = r4.getWidth();	 Catch:{ Exception -> 0x018a }
        r5 = r10.nGD;	 Catch:{ Exception -> 0x018a }
        r5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r5);	 Catch:{ Exception -> 0x018a }
        r5 = r5.getHeight();	 Catch:{ Exception -> 0x018a }
        r6 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x018a }
        r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6);	 Catch:{ Exception -> 0x018a }
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.a(r0, r4);	 Catch:{ Exception -> 0x018a }
    L_0x013f:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.p(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x015d;
    L_0x0147:
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x015d;
    L_0x014f:
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
        r0 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x01a9;
    L_0x015d:
        r1 = "MicroMsg.SightPlayController";
        r4 = "mThubmBgBmp:%B, thumbRef:%B";
        r0 = 2;
        r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
        r6 = 0;
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.p(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x01a5;
    L_0x016f:
        r0 = r2;
    L_0x0170:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
        r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
        r0 = 1;
        r6 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r6 = r6.get();	 Catch:{ Exception -> 0x00df }
        if (r6 != 0) goto L_0x01a7;
    L_0x017f:
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
        r5[r0] = r2;	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.sdk.platformtools.x.e(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
        goto L_0x00c8;
    L_0x018a:
        r0 = move-exception;
        r4 = "MicroMsg.SightPlayController";
        r5 = "try to create thumb bmp error:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
        r7 = 0;
        r8 = r0.getMessage();	 Catch:{ Exception -> 0x00df }
        r6[r7] = r8;	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x00df }
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r4 = 0;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.a(r0, r4);	 Catch:{ Exception -> 0x00df }
        goto L_0x013f;
    L_0x01a5:
        r0 = r3;
        goto L_0x0170;
    L_0x01a7:
        r2 = r3;
        goto L_0x017f;
    L_0x01a9:
        r4 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
        r2 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.p(r2);	 Catch:{ Exception -> 0x00df }
        r6 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r6 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r6);	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.plugin.sight.base.SightVideoJNI.handleThumb(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
        r0 = "MicroMsg.SightPlayController";
        r2 = "handle thumb use %d us";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
        r7 = 0;
        r8 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
        r4 = r8 - r4;
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r8;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00df }
        r6[r7] = r4;	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.p(r0);	 Catch:{ Exception -> 0x00df }
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.n(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x0208;
    L_0x01ee:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.n(r0);	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
    L_0x01fa:
        if (r0 == 0) goto L_0x00c8;
    L_0x01fc:
        if (r2 == 0) goto L_0x00c8;
    L_0x01fe:
        r1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$2;	 Catch:{ Exception -> 0x00df }
        r1.<init>(r10, r0, r2);	 Catch:{ Exception -> 0x00df }
        r0.post(r1);	 Catch:{ Exception -> 0x00df }
        goto L_0x00c8;
    L_0x0208:
        r0 = r1;
        goto L_0x01fa;
    L_0x020a:
        r1 = "MicroMsg.SightPlayController";
        r4 = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
        r0 = 3;
        r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
        r0 = 0;
        r6 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r6 = r6.hashCode();	 Catch:{ Exception -> 0x00df }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
        r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
        r0 = 1;
        r6 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
        r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
        r6 = 2;
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x0270;
    L_0x0234:
        r0 = r2;
    L_0x0235:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
        r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.sdk.platformtools.x.d(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.n(r0);	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x025c;
    L_0x0246:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.n(r0);	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x025c;
    L_0x0254:
        r1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$3;	 Catch:{ Exception -> 0x00df }
        r1.<init>(r10, r0);	 Catch:{ Exception -> 0x00df }
        r0.post(r1);	 Catch:{ Exception -> 0x00df }
    L_0x025c:
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        if (r0 != 0) goto L_0x0272;
    L_0x0264:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.m(r0);	 Catch:{ Exception -> 0x00df }
        r1 = 0;
        com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceColor(r0, r1);	 Catch:{ Exception -> 0x00df }
        goto L_0x00c8;
    L_0x0270:
        r0 = r3;
        goto L_0x0235;
    L_0x0272:
        r0 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.m(r0);	 Catch:{ Exception -> 0x00df }
        r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
        r0 = r0.get();	 Catch:{ Exception -> 0x00df }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
        r2 = r10.nGD;	 Catch:{ Exception -> 0x00df }
        r2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.o(r2);	 Catch:{ Exception -> 0x00df }
        com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceThumb(r1, r0, r2);	 Catch:{ Exception -> 0x00df }
        goto L_0x00c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k.run():void");
    }
}
