package com.tencent.mm.plugin.shake.d.a;

class a$3 implements Runnable {
    final /* synthetic */ a mYA;

    a$3(a aVar) {
        this.mYA = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r6 = 1;
        r9 = 0;
        r0 = r10.mYA;
        r0 = r0.mYs;
        if (r0 == 0) goto L_0x001e;
    L_0x0008:
        r0 = "MicroMsg.MusicFingerPrintRecorder";
        r1 = "tryStartNetscene clientid: %d but netscene is running.";
        r2 = new java.lang.Object[r6];
        r3 = r10.mYA;
        r3 = r3.mYu;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
    L_0x001d:
        return;
    L_0x001e:
        r0 = r10.mYA;
        r1 = r0.mYk;
        monitor-enter(r1);
        r0 = r10.mYA;	 Catch:{ all -> 0x002b }
        r0 = r0.mYl;	 Catch:{ all -> 0x002b }
        if (r0 > 0) goto L_0x002e;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x001d;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0 = r10.mYA;	 Catch:{ all -> 0x002b }
        r0 = r0.mYl;	 Catch:{ all -> 0x002b }
        r2 = new byte[r0];	 Catch:{ all -> 0x002b }
        r0 = r10.mYA;	 Catch:{ all -> 0x002b }
        r0 = r0.mYk;	 Catch:{ all -> 0x002b }
        r3 = 0;
        r4 = 0;
        r5 = r10.mYA;	 Catch:{ all -> 0x002b }
        r5 = r5.mYl;	 Catch:{ all -> 0x002b }
        java.lang.System.arraycopy(r0, r3, r2, r4, r5);	 Catch:{ all -> 0x002b }
        r0 = r10.mYA;	 Catch:{ all -> 0x002b }
        r3 = 0;
        r0.mYl = r3;	 Catch:{ all -> 0x002b }
        r0 = r10.mYA;	 Catch:{ all -> 0x002b }
        r4 = r0.mYn;	 Catch:{ all -> 0x002b }
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        r0 = r10.mYA;
        r0.mYs = r6;
        r0 = r10.mYA;
        r0 = r0.mYo;
        r1 = r10.mYA;
        r3 = r1.mYm;
        r1 = r10.mYA;
        r6 = r1.mYu;
        r1 = r10.mYA;
        r7 = r1.mYt;
        r1 = r10.mYA;
        r8 = r1.mYv;
        r1 = 367; // 0x16f float:5.14E-43 double:1.813E-321;
        if (r0 != r1) goto L_0x0074;
    L_0x0067:
        r1 = new com.tencent.mm.plugin.shake.d.a.f;
        r1.<init>(r2, r3, r4, r6, r7, r8);
    L_0x006c:
        r0 = com.tencent.mm.model.au.DF();
        r0.a(r1, r9);
        goto L_0x001d;
    L_0x0074:
        r1 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r0 != r1) goto L_0x007e;
    L_0x0078:
        r1 = new com.tencent.mm.plugin.shake.d.a.g;
        r1.<init>(r2, r3, r4, r6, r7, r8);
        goto L_0x006c;
    L_0x007e:
        r1 = 0;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.shake.d.a.a$3.run():void");
    }

    public final String toString() {
        return super.toString() + "|tryStartNetscene";
    }
}
