package com.tencent.mm.modelvoice;

class j$3 implements Runnable {
    final /* synthetic */ j epy;

    j$3(j jVar) {
        this.epy = jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r11 = 2;
        r6 = -102; // 0xffffffffffffff9a float:NaN double:NaN;
        r8 = 0;
        r10 = 1;
        r7 = 0;
        r0 = -16;
        android.os.Process.setThreadPriority(r0);	 Catch:{ Exception -> 0x0052 }
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = r1.fileName;	 Catch:{ Exception -> 0x0052 }
        r1 = com.tencent.mm.vfs.d.openRead(r1);	 Catch:{ Exception -> 0x0052 }
        r0.epw = r1;	 Catch:{ Exception -> 0x0052 }
    L_0x0017:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r0 = r0.status;	 Catch:{ Exception -> 0x0052 }
        if (r0 == r10) goto L_0x0023;
    L_0x001d:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r0 = r0.status;	 Catch:{ Exception -> 0x0052 }
        if (r0 != r11) goto L_0x01f6;
    L_0x0023:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = r1.epw;	 Catch:{ Exception -> 0x0052 }
        r2 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r2 = r2.epu;	 Catch:{ Exception -> 0x0052 }
        r1 = r1.read(r2);	 Catch:{ Exception -> 0x0052 }
        r0.epv = r1;	 Catch:{ Exception -> 0x0052 }
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r0 = r0.epv;	 Catch:{ Exception -> 0x0052 }
        r1 = -1;
        if (r0 == r1) goto L_0x019c;
    L_0x003a:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r9 = r0.epq;	 Catch:{ Exception -> 0x0052 }
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r2 = r0.epu;	 Catch:{ Exception -> 0x0052 }
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r4 = r0.epv;	 Catch:{ Exception -> 0x0052 }
        r0 = r9.vgK;	 Catch:{ Exception -> 0x0052 }
        if (r0 != 0) goto L_0x00c9;
    L_0x004a:
        r0 = new com.tencent.qqpinyin.voicerecoapi.b;	 Catch:{ Exception -> 0x0052 }
        r1 = -102; // 0xffffffffffffff9a float:NaN double:NaN;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0052 }
        throw r0;	 Catch:{ Exception -> 0x0052 }
    L_0x0052:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "exception:%s";
        r3 = new java.lang.Object[r10];
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        r0 = r12.epy;
        r0 = r0.eph;
        if (r0 == 0) goto L_0x0071;
    L_0x006a:
        r0 = r12.epy;
        r0 = r0.eph;
        r0.onError(r8, r7, r7);
    L_0x0071:
        r0 = r12.epy;
        r0.status = r7;
    L_0x0075:
        r0 = r12.epy;
        r0 = r0.epw;
        if (r0 == 0) goto L_0x0086;
    L_0x007b:
        r0 = r12.epy;	 Catch:{ IOException -> 0x0204 }
        r0 = r0.epw;	 Catch:{ IOException -> 0x0204 }
        r0.close();	 Catch:{ IOException -> 0x0204 }
    L_0x0082:
        r0 = r12.epy;
        r0.epw = r8;
    L_0x0086:
        r0 = r12.epy;
        r1 = r0.epq;
        r0 = r1.vgK;
        if (r0 != 0) goto L_0x0218;
    L_0x008e:
        r0 = r6;
    L_0x008f:
        r1 = r12.epy;
        r1 = r1.status;
        r2 = 3;
        if (r1 == r2) goto L_0x0226;
    L_0x0096:
        r1 = r12.epy;
        r1 = r1.epk;
        if (r1 == 0) goto L_0x00a3;
    L_0x009c:
        r1 = r12.epy;
        r1 = r1.epk;
        r1.wd();
    L_0x00a3:
        r1 = r12.epy;
        r1 = r1.epg;
        if (r1 == 0) goto L_0x00b0;
    L_0x00a9:
        r1 = r12.epy;
        r1 = r1.epg;
        r1.onCompletion(r8);
    L_0x00b0:
        if (r0 == 0) goto L_0x00c8;
    L_0x00b2:
        r1 = "MicroMsg.SpeexPlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "res: ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
    L_0x00c8:
        return;
    L_0x00c9:
        if (r2 == 0) goto L_0x00ce;
    L_0x00cb:
        r0 = r2.length;	 Catch:{ Exception -> 0x0052 }
        if (r0 != 0) goto L_0x00d6;
    L_0x00ce:
        r0 = new com.tencent.qqpinyin.voicerecoapi.b;	 Catch:{ Exception -> 0x0052 }
        r1 = -104; // 0xffffffffffffff98 float:NaN double:NaN;
        r0.<init>(r1);	 Catch:{ Exception -> 0x0052 }
        throw r0;	 Catch:{ Exception -> 0x0052 }
    L_0x00d6:
        r0 = r9.vgL;	 Catch:{ Exception -> 0x0052 }
        r1 = r9.vgK;	 Catch:{ Exception -> 0x0052 }
        r3 = 0;
        r5 = r9.vgI;	 Catch:{ Exception -> 0x0052 }
        r1 = r0.nativeTRSpeexDecode(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0052 }
        if (r1 >= 0) goto L_0x00e9;
    L_0x00e3:
        r0 = new com.tencent.qqpinyin.voicerecoapi.b;	 Catch:{ Exception -> 0x0052 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0052 }
        throw r0;	 Catch:{ Exception -> 0x0052 }
    L_0x00e9:
        if (r1 != 0) goto L_0x00f7;
    L_0x00eb:
        r2 = r8;
    L_0x00ec:
        if (r2 == 0) goto L_0x00f0;
    L_0x00ee:
        if (r1 != 0) goto L_0x0102;
    L_0x00f0:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = 0;
        r0.status = r1;	 Catch:{ Exception -> 0x0052 }
        goto L_0x0017;
    L_0x00f7:
        r0 = new byte[r1];	 Catch:{ Exception -> 0x0052 }
        r2 = r9.vgI;	 Catch:{ Exception -> 0x0052 }
        r3 = 0;
        r4 = 0;
        java.lang.System.arraycopy(r2, r3, r0, r4, r1);	 Catch:{ Exception -> 0x0052 }
        r2 = r0;
        goto L_0x00ec;
    L_0x0102:
        r0 = r2.length;	 Catch:{ Exception -> 0x0052 }
        r1 = r7;
    L_0x0104:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.epx;	 Catch:{ Exception -> 0x0052 }
        if (r0 < r3) goto L_0x013e;
    L_0x010a:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.status;	 Catch:{ Exception -> 0x0052 }
        if (r3 != r10) goto L_0x013e;
    L_0x0110:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.ept;	 Catch:{ Exception -> 0x0052 }
        if (r3 == 0) goto L_0x011c;
    L_0x0116:
        r4 = 20;
        java.lang.Thread.sleep(r4);	 Catch:{ Exception -> 0x0052 }
        goto L_0x0104;
    L_0x011c:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.aga;	 Catch:{ Exception -> 0x0052 }
        if (r3 == 0) goto L_0x0104;
    L_0x0122:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.ept;	 Catch:{ Exception -> 0x0052 }
        if (r3 != 0) goto L_0x0104;
    L_0x0128:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.aga;	 Catch:{ Exception -> 0x0052 }
        r4 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r4 = r4.epx;	 Catch:{ Exception -> 0x0052 }
        r3.write(r2, r1, r4);	 Catch:{ Exception -> 0x0052 }
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.epx;	 Catch:{ Exception -> 0x0052 }
        r1 = r1 + r3;
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.epx;	 Catch:{ Exception -> 0x0052 }
        r0 = r0 - r3;
        goto L_0x0104;
    L_0x013e:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.epx;	 Catch:{ Exception -> 0x0052 }
        if (r0 >= r3) goto L_0x0153;
    L_0x0144:
        if (r0 <= 0) goto L_0x0153;
    L_0x0146:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.aga;	 Catch:{ Exception -> 0x0052 }
        if (r3 == 0) goto L_0x0153;
    L_0x014c:
        r3 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r3 = r3.aga;	 Catch:{ Exception -> 0x0052 }
        r3.write(r2, r1, r0);	 Catch:{ Exception -> 0x0052 }
    L_0x0153:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r0 = r0.status;	 Catch:{ Exception -> 0x0052 }
        if (r0 != r11) goto L_0x01cf;
    L_0x0159:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = r0.eoX;	 Catch:{ Exception -> 0x0052 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0052 }
        r0 = "MicroMsg.SpeexPlayer";
        r2 = "before mOk.notify";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x01a2 }
        r0 = r12.epy;	 Catch:{ Exception -> 0x01a2 }
        r0 = r0.eoX;	 Catch:{ Exception -> 0x01a2 }
        r0.notify();	 Catch:{ Exception -> 0x01a2 }
        r0 = "MicroMsg.SpeexPlayer";
        r2 = "after mOk.notify";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x01a2 }
    L_0x0177:
        monitor-exit(r1);	 Catch:{ all -> 0x01b7 }
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = r0.eoW;	 Catch:{ Exception -> 0x0052 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0052 }
        r0 = "MicroMsg.SpeexPlayer";
        r2 = "before mpause.wait";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x01ba }
        r0 = r12.epy;	 Catch:{ Exception -> 0x01ba }
        r0 = r0.eoW;	 Catch:{ Exception -> 0x01ba }
        r0.wait();	 Catch:{ Exception -> 0x01ba }
        r0 = "MicroMsg.SpeexPlayer";
        r2 = "after mpause.wait";
        com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x01ba }
    L_0x0196:
        monitor-exit(r1);	 Catch:{ all -> 0x0199 }
        goto L_0x0017;
    L_0x0199:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0199 }
        throw r0;	 Catch:{ Exception -> 0x0052 }
    L_0x019c:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = 0;
        r0.status = r1;	 Catch:{ Exception -> 0x0052 }
        goto L_0x0153;
    L_0x01a2:
        r0 = move-exception;
        r2 = "MicroMsg.SpeexPlayer";
        r3 = "exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01b7 }
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x01b7 }
        r4[r5] = r0;	 Catch:{ all -> 0x01b7 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x01b7 }
        goto L_0x0177;
    L_0x01b7:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01b7 }
        throw r0;	 Catch:{ Exception -> 0x0052 }
    L_0x01ba:
        r0 = move-exception;
        r2 = "MicroMsg.SpeexPlayer";
        r3 = "exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0199 }
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x0199 }
        r4[r5] = r0;	 Catch:{ all -> 0x0199 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0199 }
        goto L_0x0196;
    L_0x01cf:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r1 = r0.eoX;	 Catch:{ Exception -> 0x0052 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0052 }
        r0 = r12.epy;	 Catch:{ Exception -> 0x01e1 }
        r0 = r0.eoX;	 Catch:{ Exception -> 0x01e1 }
        r0.notify();	 Catch:{ Exception -> 0x01e1 }
    L_0x01db:
        monitor-exit(r1);	 Catch:{ all -> 0x01de }
        goto L_0x0017;
    L_0x01de:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01de }
        throw r0;	 Catch:{ Exception -> 0x0052 }
    L_0x01e1:
        r0 = move-exception;
        r2 = "MicroMsg.SpeexPlayer";
        r3 = "exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01de }
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x01de }
        r4[r5] = r0;	 Catch:{ all -> 0x01de }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x01de }
        goto L_0x01db;
    L_0x01f6:
        r0 = r12.epy;	 Catch:{ Exception -> 0x0052 }
        r0 = r0.status;	 Catch:{ Exception -> 0x0052 }
        r1 = 3;
        if (r0 == r1) goto L_0x0075;
    L_0x01fd:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r0);	 Catch:{ Exception -> 0x0052 }
        goto L_0x0075;
    L_0x0204:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "exception:%s";
        r3 = new java.lang.Object[r10];
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0082;
    L_0x0218:
        r1.vgI = r8;
        r0 = r1.vgL;
        r2 = r1.vgK;
        r0 = r0.nativeTRSpeexDecodeRelease(r2);
        r1.vgK = r7;
        goto L_0x008f;
    L_0x0226:
        r1 = r12.epy;	 Catch:{ Exception -> 0x022d }
        r1.TG();	 Catch:{ Exception -> 0x022d }
        goto L_0x00b0;
    L_0x022d:
        r1 = move-exception;
        goto L_0x00b0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j$3.run():void");
    }
}
