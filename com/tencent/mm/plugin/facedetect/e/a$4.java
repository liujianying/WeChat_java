package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.b;

class a$4 implements Runnable {
    final /* synthetic */ a iSF;
    final /* synthetic */ b iSJ;

    a$4(a aVar, b bVar) {
        this.iSF = aVar;
        this.iSJ = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r3 = this;
        r0 = r3.iSF;
        r1 = com.tencent.mm.plugin.facedetect.e.a.a(r0);
        monitor-enter(r1);
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r2 = r3.iSJ;	 Catch:{ all -> 0x0070 }
        com.tencent.mm.plugin.facedetect.e.a.a(r0, r2);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.n(r0);	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.a.iSN;	 Catch:{ all -> 0x0070 }
        if (r0 != r2) goto L_0x003a;
    L_0x0018:
        r0 = "MicroMsg.FaceVideoRecorder";
        r2 = "hy: not initialized. should not happen";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        com.tencent.mm.plugin.facedetect.e.a.d(r0);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.r(r0);	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x0038;
    L_0x002e:
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.r(r0);	 Catch:{ all -> 0x0070 }
        r2 = 0;
        r0.AW(r2);	 Catch:{ all -> 0x0070 }
    L_0x0038:
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
    L_0x0039:
        return;
    L_0x003a:
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.n(r0);	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.a.iSS;	 Catch:{ all -> 0x0070 }
        if (r0 == r2) goto L_0x004e;
    L_0x0044:
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.n(r0);	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.a.iSO;	 Catch:{ all -> 0x0070 }
        if (r0 != r2) goto L_0x0073;
    L_0x004e:
        r0 = "MicroMsg.FaceVideoRecorder";
        r2 = "hy: cancelled or not started capturing.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        com.tencent.mm.plugin.facedetect.e.a.d(r0);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.r(r0);	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x006e;
    L_0x0064:
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.r(r0);	 Catch:{ all -> 0x0070 }
        r2 = 0;
        r0.AW(r2);	 Catch:{ all -> 0x0070 }
    L_0x006e:
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0039;
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        throw r0;
    L_0x0073:
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.n(r0);	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.a.iSR;	 Catch:{ all -> 0x0070 }
        if (r0 != r2) goto L_0x00a3;
    L_0x007d:
        r0 = "MicroMsg.FaceVideoRecorder";
        r2 = "hy: already stopped";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.r(r0);	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x00a1;
    L_0x008e:
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.r(r0);	 Catch:{ all -> 0x0070 }
        r2 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.g(r2);	 Catch:{ all -> 0x0070 }
        r2 = r2.getFilePath();	 Catch:{ all -> 0x0070 }
        r0.AW(r2);	 Catch:{ all -> 0x0070 }
    L_0x00a1:
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0039;
    L_0x00a3:
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.n(r0);	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.a.iSQ;	 Catch:{ all -> 0x0070 }
        if (r0 != r2) goto L_0x00b8;
    L_0x00ad:
        r0 = "MicroMsg.FaceVideoRecorder";
        r2 = "hy: stopping. wait";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0039;
    L_0x00b8:
        r0 = "MicroMsg.FaceVideoRecorder";
        r2 = "hy: stop record and release";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.model.d.aJB();	 Catch:{ all -> 0x0070 }
        r2 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.o(r2);	 Catch:{ all -> 0x0070 }
        r0.b(r2);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r2 = com.tencent.mm.plugin.facedetect.e.a.a.iSQ;	 Catch:{ all -> 0x0070 }
        com.tencent.mm.plugin.facedetect.e.a.e(r0, r2);	 Catch:{ all -> 0x0070 }
        r0 = r3.iSF;	 Catch:{ all -> 0x0070 }
        r0 = com.tencent.mm.plugin.facedetect.e.a.g(r0);	 Catch:{ all -> 0x0070 }
        r2 = new com.tencent.mm.plugin.facedetect.e.a$4$1;	 Catch:{ all -> 0x0070 }
        r2.<init>(r3);	 Catch:{ all -> 0x0070 }
        r0.E(r2);	 Catch:{ all -> 0x0070 }
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.e.a$4.run():void");
    }
}
