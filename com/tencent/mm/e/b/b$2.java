package com.tencent.mm.e.b;

import com.tencent.mm.e.b.c.a;

class b$2 implements a {
    final /* synthetic */ b bDx;

    b$2(b bVar) {
        this.bDx = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(byte[] r11, int r12) {
        /*
        r10 = this;
        r0 = -1;
        r2 = 1;
        r1 = 0;
        r3 = "MicroMsg.MMAudioRecorder";
        r4 = "onRecPcmDataReady, markStop: %s";
        r5 = new java.lang.Object[r2];
        r6 = r10.bDx;
        r6 = com.tencent.mm.e.b.b.c(r6);
        r6 = java.lang.Boolean.valueOf(r6);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = r10.bDx;
        r3 = com.tencent.mm.e.b.b.d(r3);
        r4 = com.tencent.mm.e.b.b.b.bDD;
        if (r3 != r4) goto L_0x0036;
    L_0x0024:
        r3 = r10.bDx;
        r3 = com.tencent.mm.e.b.b.c(r3);
        if (r3 != 0) goto L_0x0036;
    L_0x002c:
        r0 = "MicroMsg.MMAudioRecorder";
        r1 = "recorder has been stopped";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
    L_0x0035:
        return;
    L_0x0036:
        r3 = com.tencent.mm.e.b.b.wl();
        monitor-enter(r3);
        r4 = r10.bDx;	 Catch:{ all -> 0x00d3 }
        r4 = com.tencent.mm.e.b.b.c(r4);	 Catch:{ all -> 0x00d3 }
        if (r4 == 0) goto L_0x007e;
    L_0x0043:
        r4 = r10.bDx;	 Catch:{ all -> 0x00d3 }
        r4 = com.tencent.mm.e.b.b.e(r4);	 Catch:{ all -> 0x00d3 }
        if (r4 == 0) goto L_0x00c9;
    L_0x004b:
        r1 = "MicroMsg.MMAudioRecorder";
        r4 = "do stop pcm recorder, last frame data: %s, read: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00d3 }
        r6 = 0;
        r5[r6] = r11;	 Catch:{ all -> 0x00d3 }
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x00d3 }
        r5[r6] = r7;	 Catch:{ all -> 0x00d3 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);	 Catch:{ all -> 0x00d3 }
        r1 = r10.bDx;	 Catch:{ all -> 0x00d3 }
        r1 = com.tencent.mm.e.b.b.e(r1);	 Catch:{ all -> 0x00d3 }
        r1.we();	 Catch:{ all -> 0x00d3 }
        r1 = r10.bDx;	 Catch:{ all -> 0x00d3 }
        r1 = com.tencent.mm.e.b.b.e(r1);	 Catch:{ all -> 0x00d3 }
        r4 = 0;
        r1.bEb = r4;	 Catch:{ all -> 0x00d3 }
        r1 = r10.bDx;	 Catch:{ all -> 0x00d3 }
        com.tencent.mm.e.b.b.f(r1);	 Catch:{ all -> 0x00d3 }
        r1 = r2;
    L_0x0079:
        r2 = r10.bDx;	 Catch:{ all -> 0x00d3 }
        com.tencent.mm.e.b.b.g(r2);	 Catch:{ all -> 0x00d3 }
    L_0x007e:
        r2 = r1;
        monitor-exit(r3);	 Catch:{ all -> 0x00d3 }
        r1 = r10.bDx;
        r4 = com.tencent.mm.e.b.b.h(r1);
        r4 = com.tencent.mm.sdk.platformtools.bi.bH(r4);
        r1 = r10.bDx;
        r6 = com.tencent.mm.e.b.b.i(r1);
        r8 = 0;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x00d6;
    L_0x0096:
        r1 = r10.bDx;
        r6 = com.tencent.mm.e.b.b.i(r1);
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x00d6;
    L_0x00a0:
        r0 = "MicroMsg.MMAudioRecorder";
        r1 = new java.lang.StringBuilder;
        r2 = "Stop now ! expire duration ms:";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = new com.tencent.mm.sdk.platformtools.ag;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = new com.tencent.mm.e.b.b$2$1;
        r1.<init>(r10);
        r0.post(r1);
        goto L_0x0035;
    L_0x00c9:
        r2 = "MicroMsg.MMAudioRecorder";
        r4 = "stop now, but recorder is null";
        com.tencent.mm.sdk.platformtools.x.i(r2, r4);	 Catch:{ all -> 0x00d3 }
        goto L_0x0079;
    L_0x00d3:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00d3 }
        throw r0;
    L_0x00d6:
        r1 = "MicroMsg.MMAudioRecorder";
        r3 = new java.lang.StringBuilder;
        r4 = "read :";
        r3.<init>(r4);
        r3 = r3.append(r12);
        r4 = " time: ";
        r3 = r3.append(r4);
        r4 = r10.bDx;
        r4 = com.tencent.mm.e.b.b.j(r4);
        r4 = r4.Ad();
        r3 = r3.append(r4);
        r4 = " dataReadedCnt: ";
        r3 = r3.append(r4);
        r4 = r10.bDx;
        r4 = com.tencent.mm.e.b.b.k(r4);
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r1, r3);
        if (r12 >= 0) goto L_0x013c;
    L_0x0114:
        r0 = r10.bDx;
        r0 = com.tencent.mm.e.b.b.d(r0);
        r1 = com.tencent.mm.e.b.b.b.bDD;
        if (r0 != r1) goto L_0x0129;
    L_0x011e:
        r0 = "MicroMsg.MMAudioRecorder";
        r1 = "recorder has been stopped";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x0035;
    L_0x0129:
        r0 = new com.tencent.mm.sdk.platformtools.ag;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = new com.tencent.mm.e.b.b$2$2;
        r1.<init>();
        r0.post(r1);
        goto L_0x0035;
    L_0x013c:
        r1 = r10.bDx;
        r3 = r10.bDx;
        r3 = com.tencent.mm.e.b.b.k(r3);
        r3 = r3 + r12;
        com.tencent.mm.e.b.b.a(r1, r3);
        r1 = r10.bDx;
        r3 = com.tencent.mm.e.b.b.l(r1);
        monitor-enter(r3);
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.m(r1);	 Catch:{ all -> 0x02a7 }
        if (r1 != 0) goto L_0x01ea;
    L_0x0157:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.n(r1);	 Catch:{ all -> 0x02a7 }
        r4 = com.tencent.mm.compatible.b.b.a.daL;	 Catch:{ all -> 0x02a7 }
        if (r1 == r4) goto L_0x016b;
    L_0x0161:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.n(r1);	 Catch:{ all -> 0x02a7 }
        r4 = com.tencent.mm.compatible.b.b.a.daN;	 Catch:{ all -> 0x02a7 }
        if (r1 != r4) goto L_0x01ea;
    L_0x016b:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.o(r1);	 Catch:{ all -> 0x02a7 }
        if (r1 == 0) goto L_0x01ea;
    L_0x0173:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.p(r1);	 Catch:{ all -> 0x02a7 }
        if (r1 == 0) goto L_0x01ea;
    L_0x017b:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r4 = new com.tencent.mm.aw.c;	 Catch:{ all -> 0x02a7 }
        r4.<init>();	 Catch:{ all -> 0x02a7 }
        com.tencent.mm.e.b.b.a(r1, r4);	 Catch:{ all -> 0x02a7 }
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.m(r1);	 Catch:{ all -> 0x02a7 }
        r4 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r4 = com.tencent.mm.e.b.b.q(r4);	 Catch:{ all -> 0x02a7 }
        r5 = "MicroMsg.SpeexEncoderWorker";
        r6 = "init ";
        com.tencent.mm.sdk.platformtools.x.i(r5, r6);	 Catch:{ all -> 0x02a7 }
        r5 = r1.ehl;	 Catch:{ all -> 0x02a7 }
        r5.clear();	 Catch:{ all -> 0x02a7 }
        r5 = new com.tencent.mm.aw.d$b;	 Catch:{ all -> 0x02a7 }
        r5.<init>();	 Catch:{ all -> 0x02a7 }
        r6 = com.tencent.mm.aw.d.getPrefix();	 Catch:{ all -> 0x02a7 }
        r5.eeG = r6;	 Catch:{ all -> 0x02a7 }
        r5.sampleRate = r4;	 Catch:{ all -> 0x02a7 }
        r4 = 1;
        r5.ehg = r4;	 Catch:{ all -> 0x02a7 }
        r4 = 16;
        r5.ehh = r4;	 Catch:{ all -> 0x02a7 }
        r4 = "%s%d_%d_%d_%d";
        r6 = 5;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x02a7 }
        r7 = 0;
        r8 = r5.eeG;	 Catch:{ all -> 0x02a7 }
        r6[r7] = r8;	 Catch:{ all -> 0x02a7 }
        r7 = 1;
        r8 = r5.sampleRate;	 Catch:{ all -> 0x02a7 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x02a7 }
        r6[r7] = r8;	 Catch:{ all -> 0x02a7 }
        r7 = 2;
        r8 = r5.ehg;	 Catch:{ all -> 0x02a7 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x02a7 }
        r6[r7] = r8;	 Catch:{ all -> 0x02a7 }
        r7 = 3;
        r5 = r5.ehh;	 Catch:{ all -> 0x02a7 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x02a7 }
        r6[r7] = r5;	 Catch:{ all -> 0x02a7 }
        r5 = 4;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x02a7 }
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x02a7 }
        r6[r5] = r7;	 Catch:{ all -> 0x02a7 }
        r4 = java.lang.String.format(r4, r6);	 Catch:{ all -> 0x02a7 }
        r1.mFileName = r4;	 Catch:{ all -> 0x02a7 }
    L_0x01ea:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.m(r1);	 Catch:{ all -> 0x02a7 }
        if (r1 == 0) goto L_0x0224;
    L_0x01f2:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.m(r1);	 Catch:{ all -> 0x02a7 }
        r4 = "MicroMsg.SpeexEncoderWorker";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02a7 }
        r6 = "push into queue queueLen:";
        r5.<init>(r6);	 Catch:{ all -> 0x02a7 }
        r6 = r1.ehl;	 Catch:{ all -> 0x02a7 }
        r6 = r6.size();	 Catch:{ all -> 0x02a7 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x02a7 }
        r5 = r5.toString();	 Catch:{ all -> 0x02a7 }
        com.tencent.mm.sdk.platformtools.x.d(r4, r5);	 Catch:{ all -> 0x02a7 }
        if (r11 == 0) goto L_0x0224;
    L_0x0216:
        r4 = r11.length;	 Catch:{ all -> 0x02a7 }
        if (r4 <= 0) goto L_0x0224;
    L_0x0219:
        r1 = r1.ehl;	 Catch:{ all -> 0x02a7 }
        r4 = new com.tencent.mm.e.b.g$a;	 Catch:{ all -> 0x02a7 }
        r5 = r11.length;	 Catch:{ all -> 0x02a7 }
        r4.<init>(r11, r5);	 Catch:{ all -> 0x02a7 }
        r1.add(r4);	 Catch:{ all -> 0x02a7 }
    L_0x0224:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.n(r1);	 Catch:{ all -> 0x02a7 }
        r4 = com.tencent.mm.compatible.b.b.a.daN;	 Catch:{ all -> 0x02a7 }
        if (r1 != r4) goto L_0x02da;
    L_0x022e:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.r(r1);	 Catch:{ all -> 0x02a7 }
        if (r1 != 0) goto L_0x025b;
    L_0x0236:
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r4 = new com.tencent.mm.e.c.c;	 Catch:{ all -> 0x02a7 }
        r5 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r5 = com.tencent.mm.e.b.b.q(r5);	 Catch:{ all -> 0x02a7 }
        r6 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r6 = com.tencent.mm.e.b.b.s(r6);	 Catch:{ all -> 0x02a7 }
        r4.<init>(r5, r6);	 Catch:{ all -> 0x02a7 }
        com.tencent.mm.e.b.b.a(r1, r4);	 Catch:{ all -> 0x02a7 }
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r1 = com.tencent.mm.e.b.b.r(r1);	 Catch:{ all -> 0x02a7 }
        r4 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r4 = com.tencent.mm.e.b.b.t(r4);	 Catch:{ all -> 0x02a7 }
        r1.df(r4);	 Catch:{ all -> 0x02a7 }
    L_0x025b:
        r10.u(r11, r12);	 Catch:{ all -> 0x02a7 }
        r1 = r10.bDx;	 Catch:{ all -> 0x02a7 }
        r4 = com.tencent.mm.e.b.b.r(r1);	 Catch:{ all -> 0x02a7 }
        r5 = "MicroMsg.SilkWriter";
        r6 = "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s";
        r1 = 4;
        r7 = new java.lang.Object[r1];	 Catch:{ all -> 0x02a7 }
        r8 = 0;
        r1 = r4.bFC;	 Catch:{ all -> 0x02a7 }
        if (r1 != 0) goto L_0x02aa;
    L_0x0272:
        r1 = r0;
    L_0x0273:
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x02a7 }
        r7[r8] = r1;	 Catch:{ all -> 0x02a7 }
        r1 = 1;
        if (r11 != 0) goto L_0x02b1;
    L_0x027c:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x02a7 }
        r7[r1] = r0;	 Catch:{ all -> 0x02a7 }
        r0 = 2;
        r1 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x02a7 }
        r7[r0] = r1;	 Catch:{ all -> 0x02a7 }
        r0 = 3;
        r1 = java.lang.Boolean.valueOf(r2);	 Catch:{ all -> 0x02a7 }
        r7[r0] = r1;	 Catch:{ all -> 0x02a7 }
        com.tencent.mm.sdk.platformtools.x.d(r5, r6, r7);	 Catch:{ all -> 0x02a7 }
        if (r12 <= 0) goto L_0x02a4;
    L_0x0295:
        monitor-enter(r4);	 Catch:{ all -> 0x02a7 }
        r0 = r4.bFD;	 Catch:{ all -> 0x02d7 }
        if (r0 == 0) goto L_0x02b3;
    L_0x029a:
        r0 = "MicroMsg.SilkWriter";
        r1 = "already stop";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x02d7 }
        monitor-exit(r4);	 Catch:{ all -> 0x02d7 }
    L_0x02a4:
        monitor-exit(r3);	 Catch:{ all -> 0x02a7 }
        goto L_0x0035;
    L_0x02a7:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x02a7 }
        throw r0;
    L_0x02aa:
        r1 = r4.bFC;	 Catch:{ all -> 0x02a7 }
        r1 = r1.size();	 Catch:{ all -> 0x02a7 }
        goto L_0x0273;
    L_0x02b1:
        r0 = r11.length;	 Catch:{ all -> 0x02a7 }
        goto L_0x027c;
    L_0x02b3:
        monitor-exit(r4);	 Catch:{ all -> 0x02d7 }
        r0 = r4.bFJ;	 Catch:{ all -> 0x02a7 }
        if (r0 != 0) goto L_0x02c8;
    L_0x02b8:
        r0 = new com.tencent.mm.e.c.c$a;	 Catch:{ all -> 0x02a7 }
        r1 = 0;
        r0.<init>(r4, r1);	 Catch:{ all -> 0x02a7 }
        r4.bFJ = r0;	 Catch:{ all -> 0x02a7 }
        r0 = r4.bFJ;	 Catch:{ all -> 0x02a7 }
        r1 = "SilkWriter_run";
        com.tencent.mm.sdk.f.e.post(r0, r1);	 Catch:{ all -> 0x02a7 }
    L_0x02c8:
        r0 = r4.bFC;	 Catch:{ all -> 0x02a7 }
        if (r0 == 0) goto L_0x02a4;
    L_0x02cc:
        r0 = r4.bFC;	 Catch:{ all -> 0x02a7 }
        r1 = new com.tencent.mm.e.b.g$a;	 Catch:{ all -> 0x02a7 }
        r1.<init>(r11, r12, r2);	 Catch:{ all -> 0x02a7 }
        r0.add(r1);	 Catch:{ all -> 0x02a7 }
        goto L_0x02a4;
    L_0x02d7:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x02d7 }
        throw r0;	 Catch:{ all -> 0x02a7 }
    L_0x02da:
        monitor-exit(r3);	 Catch:{ all -> 0x02a7 }
        r0 = r10.bDx;
        r0 = com.tencent.mm.e.b.b.q(r0);
        r1 = 16000; // 0x3e80 float:2.2421E-41 double:7.905E-320;
        if (r0 != r1) goto L_0x02ea;
    L_0x02e5:
        r11 = t(r11, r12);
        r12 = r11.length;
    L_0x02ea:
        r10.u(r11, r12);
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.e.b.b$2.s(byte[], int):void");
    }

    private static byte[] t(byte[] bArr, int i) {
        int i2 = i % 4;
        if (i2 != 0) {
            i -= i2;
        }
        if (i <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[(i / 2)];
        for (i2 = 0; i2 < i / 2; i2 += 2) {
            bArr2[i2] = bArr[i2 * 2];
            bArr2[i2 + 1] = bArr[(i2 * 2) + 1];
        }
        return bArr2;
    }

    private void u(byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > b.u(this.bDx)) {
                b.b(this.bDx, s);
            }
        }
    }

    public final void aN(int i, int i2) {
    }
}
