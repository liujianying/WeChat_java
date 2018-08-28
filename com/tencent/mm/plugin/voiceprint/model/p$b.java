package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.ag;

final class p$b extends Thread {
    ag handler;
    final /* synthetic */ p oFB;

    public p$b(p pVar) {
        this.oFB = pVar;
        this.handler = new 1(this, pVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r7 = this;
        r6 = 0;
        r0 = r7.oFB;
        r0 = com.tencent.mm.plugin.voiceprint.model.p.d(r0);
        if (r0 != 0) goto L_0x0013;
    L_0x0009:
        r0 = "MicroMsg.VoicePrintRecoder";
        r1 = "Stop Record Failed recorder == null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0012:
        return;
    L_0x0013:
        r1 = r7.oFB;
        monitor-enter(r1);
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r0 = com.tencent.mm.plugin.voiceprint.model.p.e(r0);	 Catch:{ all -> 0x00ac }
        r2 = 1;
        r0 = com.tencent.mm.plugin.voiceprint.model.m.aY(r0, r2);	 Catch:{ all -> 0x00ac }
        r2 = "MicroMsg.VoicePrintRecoder";
        r3 = "fullPathName %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ac }
        r5 = 0;
        r4[r5] = r0;	 Catch:{ all -> 0x00ac }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);	 Catch:{ all -> 0x00ac }
        r2 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r2.oFy = r0;	 Catch:{ all -> 0x00ac }
        r2 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r2 = com.tencent.mm.plugin.voiceprint.model.p.f(r2);	 Catch:{ all -> 0x00ac }
        if (r2 == 0) goto L_0x0045;
    L_0x003c:
        r2 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r2 = com.tencent.mm.plugin.voiceprint.model.p.f(r2);	 Catch:{ all -> 0x00ac }
        r2.requestFocus();	 Catch:{ all -> 0x00ac }
    L_0x0045:
        r2 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r2 = com.tencent.mm.plugin.voiceprint.model.p.d(r2);	 Catch:{ all -> 0x00ac }
        r0 = r2.dc(r0);	 Catch:{ all -> 0x00ac }
        if (r0 != 0) goto L_0x00af;
    L_0x0051:
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        com.tencent.mm.plugin.voiceprint.model.p.g(r0);	 Catch:{ all -> 0x00ac }
        r0 = "MicroMsg.VoicePrintRecoder";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
        r3 = "Thread Start Record  Error fileName[";
        r2.<init>(r3);	 Catch:{ all -> 0x00ac }
        r3 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r3 = com.tencent.mm.plugin.voiceprint.model.p.e(r3);	 Catch:{ all -> 0x00ac }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
        r3 = "]";
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
        r2 = r2.toString();	 Catch:{ all -> 0x00ac }
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x00ac }
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r0 = com.tencent.mm.plugin.voiceprint.model.p.d(r0);	 Catch:{ all -> 0x00ac }
        r0.we();	 Catch:{ all -> 0x00ac }
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        com.tencent.mm.plugin.voiceprint.model.p.h(r0);	 Catch:{ all -> 0x00ac }
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r0 = com.tencent.mm.plugin.voiceprint.model.p.f(r0);	 Catch:{ all -> 0x00ac }
        if (r0 == 0) goto L_0x0098;
    L_0x008f:
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r0 = com.tencent.mm.plugin.voiceprint.model.p.f(r0);	 Catch:{ all -> 0x00ac }
        r0.zY();	 Catch:{ all -> 0x00ac }
    L_0x0098:
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r0 = com.tencent.mm.plugin.voiceprint.model.p.i(r0);	 Catch:{ all -> 0x00ac }
        if (r0 == 0) goto L_0x00a9;
    L_0x00a0:
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r0 = com.tencent.mm.plugin.voiceprint.model.p.i(r0);	 Catch:{ all -> 0x00ac }
        r0.bIY();	 Catch:{ all -> 0x00ac }
    L_0x00a9:
        monitor-exit(r1);	 Catch:{ all -> 0x00ac }
        goto L_0x0012;
    L_0x00ac:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00ac }
        throw r0;
    L_0x00af:
        r0 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r2 = com.tencent.mm.sdk.platformtools.bi.VG();	 Catch:{ all -> 0x00ac }
        com.tencent.mm.plugin.voiceprint.model.p.a(r0, r2);	 Catch:{ all -> 0x00ac }
        r0 = "MicroMsg.VoicePrintRecoder";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
        r3 = "Thread Started Record fileName[";
        r2.<init>(r3);	 Catch:{ all -> 0x00ac }
        r3 = r7.oFB;	 Catch:{ all -> 0x00ac }
        r3 = com.tencent.mm.plugin.voiceprint.model.p.e(r3);	 Catch:{ all -> 0x00ac }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
        r3 = "]";
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
        r2 = r2.toString();	 Catch:{ all -> 0x00ac }
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x00ac }
        monitor-exit(r1);	 Catch:{ all -> 0x00ac }
        r0 = r7.handler;
        r2 = 1;
        r0.sendEmptyMessageDelayed(r6, r2);
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voiceprint.model.p$b.run():void");
    }
}
