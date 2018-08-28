package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c;

class FaceDetectCameraView$c$1 implements Runnable {
    final /* synthetic */ long iTx;
    final /* synthetic */ c iTy;

    FaceDetectCameraView$c$1(c cVar, long j) {
        this.iTy = cVar;
        this.iTx = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r0 = 1;
        r1 = 0;
        r2 = r10.iTy;
        r2 = r2.iTq;
        r2 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.e(r2);
        monitor-enter(r2);
        r3 = "MicroMsg.FaceDetectCameraView";
        r4 = "hy: enter worker thread. using %d ms";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0120 }
        r6 = 0;
        r8 = r10.iTx;	 Catch:{ all -> 0x0120 }
        r8 = com.tencent.mm.sdk.platformtools.bi.bI(r8);	 Catch:{ all -> 0x0120 }
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0120 }
        r5[r6] = r7;	 Catch:{ all -> 0x0120 }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ all -> 0x0120 }
        r4 = com.tencent.mm.sdk.platformtools.bi.VG();	 Catch:{ all -> 0x0120 }
        r3 = r10.iTy;	 Catch:{ all -> 0x0120 }
        r3 = r3.iTu;	 Catch:{ all -> 0x0120 }
        if (r3 != 0) goto L_0x004b;
    L_0x002e:
        r0 = "MicroMsg.FaceDetectCameraView";
        r1 = "hy: already released";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x0120 }
        r0 = r10.iTy;	 Catch:{ all -> 0x0120 }
        r0 = r0.iTq;	 Catch:{ all -> 0x0120 }
        r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.i(r0);	 Catch:{ all -> 0x0120 }
        if (r0 == 0) goto L_0x0049;
    L_0x0041:
        r0 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1$1;	 Catch:{ all -> 0x0120 }
        r0.<init>(r10);	 Catch:{ all -> 0x0120 }
        com.tencent.mm.sdk.platformtools.ah.A(r0);	 Catch:{ all -> 0x0120 }
    L_0x0049:
        monitor-exit(r2);	 Catch:{ all -> 0x0120 }
    L_0x004a:
        return;
    L_0x004b:
        r3 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r3 = r3.iTu;	 Catch:{ IOException -> 0x0126 }
        r6 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r6 = r6.iTq;	 Catch:{ IOException -> 0x0126 }
        r6 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.j(r6);	 Catch:{ IOException -> 0x0126 }
        r7 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r7 = r7.iTq;	 Catch:{ IOException -> 0x0126 }
        r7 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.k(r7);	 Catch:{ IOException -> 0x0126 }
        r8 = new android.graphics.Point;	 Catch:{ IOException -> 0x0126 }
        r8.<init>(r6, r7);	 Catch:{ IOException -> 0x0126 }
        r3.iOn = r8;	 Catch:{ IOException -> 0x0126 }
        r3 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r3 = r3.iTu;	 Catch:{ IOException -> 0x0126 }
        r6 = r3.ddt;	 Catch:{ IOException -> 0x0126 }
        if (r6 == 0) goto L_0x0123;
    L_0x006e:
        r3 = r3.iOt;	 Catch:{ IOException -> 0x0126 }
        if (r3 == 0) goto L_0x0123;
    L_0x0072:
        if (r0 != 0) goto L_0x0083;
    L_0x0074:
        r0 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r0 = r0.iTu;	 Catch:{ IOException -> 0x0126 }
        r1 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r1 = r1.iTq;	 Catch:{ IOException -> 0x0126 }
        r1 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.l(r1);	 Catch:{ IOException -> 0x0126 }
        r0.e(r1);	 Catch:{ IOException -> 0x0126 }
    L_0x0083:
        r0 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r0 = r0.iTu;	 Catch:{ IOException -> 0x0126 }
        r0 = r0.iOm;	 Catch:{ IOException -> 0x0126 }
        r1 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r1 = r1.iTq;	 Catch:{ IOException -> 0x0126 }
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.a(r1, r0);	 Catch:{ IOException -> 0x0126 }
        r0 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r0 = r0.iTu;	 Catch:{ IOException -> 0x0126 }
        r1 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r1 = r1.iTq;	 Catch:{ IOException -> 0x0126 }
        r1 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.l(r1);	 Catch:{ IOException -> 0x0126 }
        r6 = com.tencent.mm.sdk.platformtools.bi.VG();	 Catch:{ IOException -> 0x0126 }
        r3 = r0.ddt;	 Catch:{ IOException -> 0x0126 }
        if (r3 == 0) goto L_0x00e2;
    L_0x00a4:
        r3 = r0.iOl;	 Catch:{ IOException -> 0x0126 }
        if (r3 != 0) goto L_0x00e2;
    L_0x00a8:
        if (r1 == 0) goto L_0x00b8;
    L_0x00aa:
        r3 = "MicroMsg.FaceScanCamera";
        r8 = "hy: SurfaceTexture is not null";
        com.tencent.mm.sdk.platformtools.x.i(r3, r8);	 Catch:{ IOException -> 0x0126 }
        r3 = r0.ddt;	 Catch:{ IOException -> 0x0126 }
        r3.setPreviewTexture(r1);	 Catch:{ IOException -> 0x0126 }
    L_0x00b8:
        r1 = r0.getPreviewWidth();	 Catch:{ IOException -> 0x0126 }
        r3 = r0.getPreviewHeight();	 Catch:{ IOException -> 0x0126 }
        com.tencent.mm.plugin.facedetect.model.c.cx(r1, r3);	 Catch:{ IOException -> 0x0126 }
        r1 = r0.ddt;	 Catch:{ IOException -> 0x0126 }
        r1.startPreview();	 Catch:{ IOException -> 0x0126 }
        r1 = 1;
        r0.iOl = r1;	 Catch:{ IOException -> 0x0126 }
        r0 = "MicroMsg.FaceScanCamera";
        r1 = "startPreview done costTime=[%s]";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0126 }
        r8 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.bI(r6);	 Catch:{ IOException -> 0x0126 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ IOException -> 0x0126 }
        r3[r8] = r6;	 Catch:{ IOException -> 0x0126 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r3);	 Catch:{ IOException -> 0x0126 }
    L_0x00e2:
        r0 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r0 = r0.iTu;	 Catch:{ IOException -> 0x0126 }
        r1 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r1 = r1.iTv;	 Catch:{ IOException -> 0x0126 }
        r0.setPreviewCallback(r1);	 Catch:{ IOException -> 0x0126 }
        r0 = r10.iTy;	 Catch:{ IOException -> 0x0126 }
        r0 = r0.iTq;	 Catch:{ IOException -> 0x0126 }
        r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.i(r0);	 Catch:{ IOException -> 0x0126 }
        if (r0 == 0) goto L_0x00ff;
    L_0x00f7:
        r0 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1$2;	 Catch:{ IOException -> 0x0126 }
        r0.<init>(r10);	 Catch:{ IOException -> 0x0126 }
        com.tencent.mm.sdk.platformtools.ah.A(r0);	 Catch:{ IOException -> 0x0126 }
    L_0x00ff:
        r0 = "MicroMsg.FaceDetectCameraView";
        r1 = "hy: opened and start preview. use: %d ms";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0126 }
        r6 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bi.bI(r4);	 Catch:{ IOException -> 0x0126 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ IOException -> 0x0126 }
        r3[r6] = r4;	 Catch:{ IOException -> 0x0126 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);	 Catch:{ IOException -> 0x0126 }
        r0 = r10.iTy;	 Catch:{ all -> 0x0120 }
        r0 = r0.iTq;	 Catch:{ all -> 0x0120 }
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.f(r0);	 Catch:{ all -> 0x0120 }
        monitor-exit(r2);	 Catch:{ all -> 0x0120 }
        goto L_0x004a;
    L_0x0120:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0120 }
        throw r0;
    L_0x0123:
        r0 = r1;
        goto L_0x0072;
    L_0x0126:
        r0 = move-exception;
        r1 = "MicroMsg.FaceDetectCameraView";
        r3 = "hy: exception caused";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0120 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r3, r4);	 Catch:{ all -> 0x0120 }
        r0 = r10.iTy;	 Catch:{ all -> 0x0120 }
        r0 = r0.iTq;	 Catch:{ all -> 0x0120 }
        r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.i(r0);	 Catch:{ all -> 0x0120 }
        if (r0 == 0) goto L_0x0145;
    L_0x013d:
        r0 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1$3;	 Catch:{ all -> 0x0120 }
        r0.<init>(r10);	 Catch:{ all -> 0x0120 }
        com.tencent.mm.sdk.platformtools.ah.A(r0);	 Catch:{ all -> 0x0120 }
    L_0x0145:
        monitor-exit(r2);	 Catch:{ all -> 0x0120 }
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1.run():void");
    }
}
