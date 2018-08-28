package com.tencent.mm.modelvoice;

class i$a implements Runnable {
    final /* synthetic */ i epi;

    private i$a(i iVar) {
        this.epi = iVar;
    }

    /* synthetic */ i$a(i iVar, byte b) {
        this(iVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r0 = -16;
        android.os.Process.setThreadPriority(r0);	 Catch:{ Exception -> 0x00ad }
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.f(r0);	 Catch:{ Exception -> 0x00ad }
        r1 = 2;
        r2 = 2;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r1, r2);	 Catch:{ Exception -> 0x00ad }
        r0 = r0 * 2;
        r9 = new byte[r0];	 Catch:{ Exception -> 0x00ad }
        r1 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.modelvoice.i.f(r1);	 Catch:{ Exception -> 0x00ad }
        r1 = r1 * 20;
        r1 = r1 / 1000;
        r10 = (short) r1;	 Catch:{ Exception -> 0x00ad }
        r1 = "MicroMsg.SilkPlayer";
        r2 = "frameLen: %d, playBufferSize: %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00ad }
        r4 = 0;
        r5 = java.lang.Short.valueOf(r10);	 Catch:{ Exception -> 0x00ad }
        r3[r4] = r5;	 Catch:{ Exception -> 0x00ad }
        r4 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00ad }
        r3[r4] = r0;	 Catch:{ Exception -> 0x00ad }
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);	 Catch:{ Exception -> 0x00ad }
        r0 = "MicroMsg.SilkPlayer";
        r1 = "Thread start";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ Exception -> 0x00ad }
    L_0x0043:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.g(r0);	 Catch:{ Exception -> 0x00ad }
        r1 = 1;
        if (r0 == r1) goto L_0x0055;
    L_0x004c:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.g(r0);	 Catch:{ Exception -> 0x00ad }
        r1 = 2;
        if (r0 != r1) goto L_0x02e4;
    L_0x0055:
        r1 = com.tencent.mm.modelvoice.i.TD();	 Catch:{ Exception -> 0x00ad }
        monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.TE();	 Catch:{ all -> 0x0145 }
        r2 = r12.epi;	 Catch:{ all -> 0x0145 }
        r2 = com.tencent.mm.modelvoice.i.h(r2);	 Catch:{ all -> 0x0145 }
        if (r0 == r2) goto L_0x0095;
    L_0x0066:
        r0 = "MicroMsg.SilkPlayer";
        r2 = "[%d] diff id, useDeocder: %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0145 }
        r4 = 0;
        r5 = r12.epi;	 Catch:{ all -> 0x0145 }
        r5 = com.tencent.mm.modelvoice.i.h(r5);	 Catch:{ all -> 0x0145 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0145 }
        r3[r4] = r5;	 Catch:{ all -> 0x0145 }
        r4 = 1;
        r5 = com.tencent.mm.modelvoice.i.TE();	 Catch:{ all -> 0x0145 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0145 }
        r3[r4] = r5;	 Catch:{ all -> 0x0145 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x0145 }
        r0 = r12.epi;	 Catch:{ all -> 0x0145 }
        r2 = r12.epi;	 Catch:{ all -> 0x0145 }
        r2 = com.tencent.mm.modelvoice.i.d(r2);	 Catch:{ all -> 0x0145 }
        com.tencent.mm.modelvoice.i.a(r0, r2);	 Catch:{ all -> 0x0145 }
    L_0x0095:
        monitor-exit(r1);	 Catch:{ all -> 0x0145 }
    L_0x0096:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.i(r0);	 Catch:{ Exception -> 0x00ad }
        if (r0 == 0) goto L_0x0148;
    L_0x009e:
        r0 = "MicroMsg.SilkPlayer";
        r1 = "waitting for switching complete";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ Exception -> 0x00ad }
        r0 = 20;
        java.lang.Thread.sleep(r0);	 Catch:{ Exception -> 0x00ad }
        goto L_0x0096;
    L_0x00ad:
        r0 = move-exception;
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r4 = 0;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "MicroMsg.SilkPlayer";
        r2 = "exception:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.n(r0);
        if (r0 == 0) goto L_0x00e1;
    L_0x00d5:
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.n(r0);
        r1 = 0;
        r2 = 0;
        r3 = 0;
        r0.onError(r1, r2, r3);
    L_0x00e1:
        r0 = r12.epi;
        r1 = 0;
        com.tencent.mm.modelvoice.i.a(r0, r1);
    L_0x00e7:
        r1 = com.tencent.mm.modelvoice.i.TD();
        monitor-enter(r1);
        r0 = com.tencent.mm.modelvoice.i.TE();	 Catch:{ all -> 0x02f4 }
        r2 = r12.epi;	 Catch:{ all -> 0x02f4 }
        r2 = com.tencent.mm.modelvoice.i.h(r2);	 Catch:{ all -> 0x02f4 }
        if (r0 != r2) goto L_0x0117;
    L_0x00f8:
        com.tencent.mm.modelvoice.MediaRecorder.SilkDecUnInit();	 Catch:{ all -> 0x02f4 }
        r0 = "MicroMsg.SilkPlayer";
        r2 = "[%d] SilkDecUnInit";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02f4 }
        r4 = 0;
        r5 = r12.epi;	 Catch:{ all -> 0x02f4 }
        r5 = com.tencent.mm.modelvoice.i.h(r5);	 Catch:{ all -> 0x02f4 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x02f4 }
        r3[r4] = r5;	 Catch:{ all -> 0x02f4 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x02f4 }
        com.tencent.mm.modelvoice.i.TF();	 Catch:{ all -> 0x02f4 }
    L_0x0117:
        monitor-exit(r1);	 Catch:{ all -> 0x02f4 }
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.g(r0);
        r1 = 3;
        if (r0 == r1) goto L_0x02f7;
    L_0x0121:
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.o(r0);
        if (r0 == 0) goto L_0x0132;
    L_0x0129:
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.o(r0);
        r0.wd();
    L_0x0132:
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.p(r0);
        if (r0 == 0) goto L_0x0144;
    L_0x013a:
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.p(r0);
        r1 = 0;
        r0.onCompletion(r1);
    L_0x0144:
        return;
    L_0x0145:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0145 }
        throw r0;	 Catch:{ Exception -> 0x00ad }
    L_0x0148:
        r11 = com.tencent.mm.modelvoice.MediaRecorder.SilkDoDec(r9, r10);	 Catch:{ Exception -> 0x00ad }
        if (r11 >= 0) goto L_0x01a3;
    L_0x014e:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r1 = 0;
        com.tencent.mm.modelvoice.i.a(r0, r1);	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x00ad }
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r4 = 0;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x00ad }
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r4 = 4;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
        r0 = "MicroMsg.SilkPlayer";
        r1 = "[%d] SilkDoDec failed: %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00ad }
        r3 = 0;
        r4 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r4 = com.tencent.mm.modelvoice.i.h(r4);	 Catch:{ Exception -> 0x00ad }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00ad }
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ad }
        r3 = 1;
        r4 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x00ad }
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ad }
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);	 Catch:{ Exception -> 0x00ad }
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.j(r0);	 Catch:{ Exception -> 0x00ad }
        if (r0 == 0) goto L_0x0043;
    L_0x0194:
        r0 = com.tencent.mm.platformtools.af.exQ;	 Catch:{ Exception -> 0x00ad }
        if (r0 == 0) goto L_0x0043;
    L_0x0198:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.j(r0);	 Catch:{ Exception -> 0x00ad }
        r0.wC();	 Catch:{ Exception -> 0x00ad }
        goto L_0x0043;
    L_0x01a3:
        r0 = com.tencent.mm.platformtools.af.exQ;	 Catch:{ Exception -> 0x00ad }
        if (r0 == 0) goto L_0x01ba;
    L_0x01a7:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.j(r0);	 Catch:{ Exception -> 0x00ad }
        if (r0 == 0) goto L_0x01ba;
    L_0x01af:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.j(r0);	 Catch:{ Exception -> 0x00ad }
        r1 = r10 * 2;
        r0.w(r9, r1);	 Catch:{ Exception -> 0x00ad }
    L_0x01ba:
        r0 = r12.epi;	 Catch:{ Exception -> 0x020b }
        r0 = com.tencent.mm.modelvoice.i.b(r0);	 Catch:{ Exception -> 0x020b }
        r1 = 0;
        r2 = r10 * 2;
        r0.write(r9, r1, r2);	 Catch:{ Exception -> 0x020b }
    L_0x01c6:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        com.tencent.mm.modelvoice.i.k(r0);	 Catch:{ Exception -> 0x00ad }
        if (r11 != 0) goto L_0x0238;
    L_0x01cd:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r1 = 0;
        com.tencent.mm.modelvoice.i.a(r0, r1);	 Catch:{ Exception -> 0x00ad }
        r0 = "MicroMsg.SilkPlayer";
        r1 = "[%d] play completed";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00ad }
        r3 = 0;
        r4 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r4 = com.tencent.mm.modelvoice.i.h(r4);	 Catch:{ Exception -> 0x00ad }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00ad }
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ad }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x00ad }
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.j(r0);	 Catch:{ Exception -> 0x00ad }
        if (r0 == 0) goto L_0x0043;
    L_0x01f4:
        r0 = com.tencent.mm.platformtools.af.exQ;	 Catch:{ Exception -> 0x00ad }
        if (r0 == 0) goto L_0x0043;
    L_0x01f8:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.j(r0);	 Catch:{ Exception -> 0x00ad }
        r0.wC();	 Catch:{ Exception -> 0x00ad }
        r0 = new com.tencent.mm.modelvoice.i$a$1;	 Catch:{ Exception -> 0x00ad }
        r0.<init>(r12);	 Catch:{ Exception -> 0x00ad }
        com.tencent.mm.sdk.platformtools.ah.A(r0);	 Catch:{ Exception -> 0x00ad }
        goto L_0x0043;
    L_0x020b:
        r0 = move-exception;
        r1 = "MicroMsg.SilkPlayer";
        r2 = "write audio track failed: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00ad }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x00ad }
        r3[r4] = r0;	 Catch:{ Exception -> 0x00ad }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x00ad }
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r4 = 0;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x00ad }
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r4 = 5;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
        goto L_0x01c6;
    L_0x0238:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.g(r0);	 Catch:{ Exception -> 0x00ad }
        r1 = 2;
        if (r0 != r1) goto L_0x02b9;
    L_0x0241:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.modelvoice.i.l(r0);	 Catch:{ Exception -> 0x00ad }
        monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
        r0 = "MicroMsg.SilkPlayer";
        r2 = "before mOk.notify";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x028c }
        r0 = r12.epi;	 Catch:{ Exception -> 0x028c }
        r0 = com.tencent.mm.modelvoice.i.l(r0);	 Catch:{ Exception -> 0x028c }
        r0.notify();	 Catch:{ Exception -> 0x028c }
        r0 = "MicroMsg.SilkPlayer";
        r2 = "after mOk.notify";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x028c }
    L_0x0263:
        monitor-exit(r1);	 Catch:{ all -> 0x02a1 }
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.modelvoice.i.m(r0);	 Catch:{ Exception -> 0x00ad }
        monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
        r0 = "MicroMsg.SilkPlayer";
        r2 = "before mpause.wait";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x02a4 }
        r0 = r12.epi;	 Catch:{ Exception -> 0x02a4 }
        r0 = com.tencent.mm.modelvoice.i.m(r0);	 Catch:{ Exception -> 0x02a4 }
        r0.wait();	 Catch:{ Exception -> 0x02a4 }
        r0 = "MicroMsg.SilkPlayer";
        r2 = "after mpause.wait";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x02a4 }
    L_0x0286:
        monitor-exit(r1);	 Catch:{ all -> 0x0289 }
        goto L_0x0043;
    L_0x0289:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0289 }
        throw r0;	 Catch:{ Exception -> 0x00ad }
    L_0x028c:
        r0 = move-exception;
        r2 = "MicroMsg.SilkPlayer";
        r3 = "exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x02a1 }
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x02a1 }
        r4[r5] = r0;	 Catch:{ all -> 0x02a1 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x02a1 }
        goto L_0x0263;
    L_0x02a1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x02a1 }
        throw r0;	 Catch:{ Exception -> 0x00ad }
    L_0x02a4:
        r0 = move-exception;
        r2 = "MicroMsg.SilkPlayer";
        r3 = "exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0289 }
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x0289 }
        r4[r5] = r0;	 Catch:{ all -> 0x0289 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0289 }
        goto L_0x0286;
    L_0x02b9:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r1 = com.tencent.mm.modelvoice.i.l(r0);	 Catch:{ Exception -> 0x00ad }
        monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
        r0 = r12.epi;	 Catch:{ Exception -> 0x02cf }
        r0 = com.tencent.mm.modelvoice.i.l(r0);	 Catch:{ Exception -> 0x02cf }
        r0.notify();	 Catch:{ Exception -> 0x02cf }
    L_0x02c9:
        monitor-exit(r1);	 Catch:{ all -> 0x02cc }
        goto L_0x0043;
    L_0x02cc:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x02cc }
        throw r0;	 Catch:{ Exception -> 0x00ad }
    L_0x02cf:
        r0 = move-exception;
        r2 = "MicroMsg.SilkPlayer";
        r3 = "exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x02cc }
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x02cc }
        r4[r5] = r0;	 Catch:{ all -> 0x02cc }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x02cc }
        goto L_0x02c9;
    L_0x02e4:
        r0 = r12.epi;	 Catch:{ Exception -> 0x00ad }
        r0 = com.tencent.mm.modelvoice.i.g(r0);	 Catch:{ Exception -> 0x00ad }
        r1 = 3;
        if (r0 == r1) goto L_0x00e7;
    L_0x02ed:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r0);	 Catch:{ Exception -> 0x00ad }
        goto L_0x00e7;
    L_0x02f4:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x02f4 }
        throw r0;
    L_0x02f7:
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.b(r0);
        if (r0 == 0) goto L_0x0144;
    L_0x02ff:
        r0 = "MicroMsg.SilkPlayer";
        r1 = "mAudioTrack.stop()";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.b(r0);
        r0.stop();
        r0 = r12.epi;
        r0 = com.tencent.mm.modelvoice.i.b(r0);
        r0.release();
        r0 = r12.epi;
        com.tencent.mm.modelvoice.i.c(r0);
        goto L_0x0144;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.i$a.run():void");
    }
}
