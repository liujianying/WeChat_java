package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Point;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$c implements b {
    final /* synthetic */ FaceDetectCameraView iTq;
    m iTu;
    PreviewCallback iTv;
    private d.b iTw;

    /* synthetic */ FaceDetectCameraView$c(FaceDetectCameraView faceDetectCameraView, byte b) {
        this(faceDetectCameraView);
    }

    private FaceDetectCameraView$c(FaceDetectCameraView faceDetectCameraView) {
        this.iTq = faceDetectCameraView;
        this.iTu = null;
        this.iTv = new 3(this);
        this.iTw = new 4(this);
        this.iTu = new m(faceDetectCameraView.getContext());
        FaceDetectCameraView.a(faceDetectCameraView, -1);
        FaceDetectCameraView.d(faceDetectCameraView);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.facedetect.views.c r5) {
        /*
        r4 = this;
        r0 = r4.iTq;
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.a(r0, r5);
        r0 = r4.iTq;
        r1 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.e(r0);
        monitor-enter(r1);
        r0 = r4.iTu;	 Catch:{ all -> 0x0031 }
        if (r0 != 0) goto L_0x001b;
    L_0x0010:
        r0 = "MicroMsg.FaceDetectCameraView";
        r2 = "hy: camera is null. return";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x0031 }
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
    L_0x001a:
        return;
    L_0x001b:
        r0 = r4.iTu;	 Catch:{ all -> 0x0031 }
        r0 = r0.iOl;	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0034;
    L_0x0021:
        r0 = "MicroMsg.FaceDetectCameraView";
        r2 = "hy: already previewed. return";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x0031 }
        r0 = r4.iTq;	 Catch:{ all -> 0x0031 }
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.f(r0);	 Catch:{ all -> 0x0031 }
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        goto L_0x001a;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        r0 = r4.iTq;
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.g(r0);
        r0 = r4.iTq;
        r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.h(r0);
        if (r0 != 0) goto L_0x0075;
    L_0x0042:
        r0 = r4.iTq;
        r0 = r0.isAvailable();
        if (r0 == 0) goto L_0x006b;
    L_0x004a:
        r0 = "MicroMsg.FaceDetectCameraView";
        r1 = "hy: already available. manually call available";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r4.iTq;
        r1 = r4.iTq;
        r1 = r1.getSurfaceTexture();
        r2 = r4.iTq;
        r2 = r2.getWidth();
        r3 = r4.iTq;
        r3 = r3.getHeight();
        r0.onSurfaceTextureAvailable(r1, r2, r3);
        goto L_0x001a;
    L_0x006b:
        r0 = "MicroMsg.FaceDetectCameraView";
        r1 = "hy: not initialized yet. do after init";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x001a;
    L_0x0075:
        r0 = com.tencent.mm.sdk.platformtools.bi.VG();
        r2 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1;
        r2.<init>(r4, r0);
        r0 = "FaceDetectCameraView_Camera";
        com.tencent.mm.sdk.f.e.post(r2, r0);
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c.a(com.tencent.mm.plugin.facedetect.views.c):void");
    }

    public final void stopPreview() {
        synchronized (FaceDetectCameraView.e(this.iTq)) {
            if (this.iTu != null && this.iTu.iOl) {
                m mVar = this.iTu;
                if (mVar.ddt != null) {
                    mVar.ddt.stopPreview();
                    mVar.iOl = false;
                    c.iNi.Fm();
                }
            }
        }
    }

    public final void aKI() {
        if (!FaceDetectCameraView.m(this.iTq)) {
            FaceDetectCameraView.b(this.iTq, true);
            e.post(new Runnable() {
                public final void run() {
                    synchronized (FaceDetectCameraView.e(FaceDetectCameraView$c.this.iTq)) {
                        if (FaceDetectCameraView$c.this.iTu == null) {
                            return;
                        }
                        x.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
                        FaceDetectCameraView$c.this.iTu.setPreviewCallback(null);
                        d aJB = d.aJB();
                        synchronized (d.mLock) {
                            if (aJB.iNl != null) {
                                aJB.iNl.clear();
                            }
                        }
                        if (FaceDetectCameraView.l(FaceDetectCameraView$c.this.iTq) != null) {
                            FaceDetectCameraView.l(FaceDetectCameraView$c.this.iTq).release();
                        }
                        FaceDetectCameraView$c.this.iTu.release();
                        FaceDetectCameraView$c.this.iTu = null;
                        x.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                        FaceDetectCameraView.b(FaceDetectCameraView$c.this.iTq, false);
                    }
                }
            }, "FaceDetectCameraView_Camera");
        }
    }

    public final int getPreviewWidth() {
        int previewWidth;
        synchronized (FaceDetectCameraView.e(this.iTq)) {
            previewWidth = this.iTu.getPreviewWidth();
        }
        return previewWidth;
    }

    public final int getPreviewHeight() {
        int previewHeight;
        synchronized (FaceDetectCameraView.e(this.iTq)) {
            previewHeight = this.iTu.getPreviewHeight();
        }
        return previewHeight;
    }

    public final int getRotation() {
        int i;
        synchronized (FaceDetectCameraView.e(this.iTq)) {
            i = this.iTu.iOq;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dg(long r8) {
        /*
        r7 = this;
        r0 = r7.iTq;
        r1 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.e(r0);
        monitor-enter(r1);
        r0 = r7.iTu;	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0016;
    L_0x000b:
        r0 = "MicroMsg.FaceDetectCameraView";
        r2 = "hy: camera is null. return";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x005f }
        monitor-exit(r1);	 Catch:{ all -> 0x005f }
    L_0x0015:
        return;
    L_0x0016:
        r0 = "MicroMsg.FaceDetectCameraView";
        r2 = "hy: start capturing. tween: %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x005f }
        r4 = 0;
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x005f }
        r3[r4] = r5;	 Catch:{ all -> 0x005f }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x005f }
        r0 = r7.iTq;	 Catch:{ all -> 0x005f }
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b(r0, r8);	 Catch:{ all -> 0x005f }
        r0 = r7.iTq;	 Catch:{ all -> 0x005f }
        r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.q(r0);	 Catch:{ all -> 0x005f }
        if (r0 != 0) goto L_0x0072;
    L_0x0036:
        r0 = r7.iTu;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0062;
    L_0x003a:
        r0 = r7.iTu;	 Catch:{ all -> 0x005f }
        r0 = r0.iOl;	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0062;
    L_0x0040:
        r0 = "MicroMsg.FaceDetectCameraView";
        r2 = "hy: is previewing. directly start capture";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x005f }
        r0 = r7.iTq;	 Catch:{ all -> 0x005f }
        r2 = 0;
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.a(r0, r2);	 Catch:{ all -> 0x005f }
        r0 = com.tencent.mm.plugin.facedetect.model.d.aJB();	 Catch:{ all -> 0x005f }
        r2 = r7.iTw;	 Catch:{ all -> 0x005f }
        r0.a(r2);	 Catch:{ all -> 0x005f }
        r0 = r7.iTq;	 Catch:{ all -> 0x005f }
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.r(r0);	 Catch:{ all -> 0x005f }
    L_0x005d:
        monitor-exit(r1);	 Catch:{ all -> 0x005f }
        goto L_0x0015;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005f }
        throw r0;
    L_0x0062:
        r0 = "MicroMsg.FaceDetectCameraView";
        r2 = "hy: not previewed yet. wait";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x005f }
        r0 = r7.iTq;	 Catch:{ all -> 0x005f }
        r2 = 1;
        com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.a(r0, r2);	 Catch:{ all -> 0x005f }
        goto L_0x005d;
    L_0x0072:
        r0 = "MicroMsg.FaceDetectCameraView";
        r2 = "hy: already scanning";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x005f }
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c.dg(long):void");
    }

    public final void aKJ() {
        synchronized (FaceDetectCameraView.e(this.iTq)) {
            if (this.iTu != null && this.iTu.iOl) {
                d.aJB().b(this.iTw);
                if (!FaceDetectCameraView.n(this.iTq)) {
                    FaceDetectCameraView.a(this.iTq, null);
                }
            }
        }
    }

    public final Point aKK() {
        Point point;
        synchronized (FaceDetectCameraView.e(this.iTq)) {
            point = this.iTu.iOu;
        }
        return point;
    }
}
