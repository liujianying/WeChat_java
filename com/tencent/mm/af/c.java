package com.tencent.mm.af;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class c implements Runnable {
    int dRf = 0;
    private d dRg = null;
    b dRh = new b();
    private long dRi = 0;
    private long dRj = 0;
    private long dRk = 0;
    String dRl = null;
    private String dRm = null;
    boolean dRn = false;

    c() {
        if (this.dRl == null) {
            this.dRl = b.duN + "ProcessDetector";
            File file = new File(this.dRl);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        if (ad.cic()) {
            this.dRm = this.dRl + "/mm";
        } else if (ad.cid()) {
            this.dRm = this.dRl + "/push";
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r12.clear();
        r0 = java.lang.System.currentTimeMillis();
        r12.dRj = r0;
        r0 = r12.dRj;
        r12.dRk = r0;
        r0 = new com.tencent.mm.af.c$d;
        r0.<init>();
        r12.dRg = r0;
        r0 = r12.dRg;
        r1 = android.os.Process.myPid();
        r2 = r12.dRj;
        r4 = r12.dRk;
        r6 = r12.dRf;
        r0.a(r1, r2, r4, r6);
        r0 = r12.dRh;
        r0 = r0.dRo;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0059;
    L_0x002d:
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x01a4 }
        r1 = r12.dRm;	 Catch:{ Exception -> 0x01a4 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x01a4 }
        r0 = com.tencent.mm.af.b.l(r0);	 Catch:{ Exception -> 0x01a4 }
        r0 = (com.tencent.mm.af.c.b) r0;	 Catch:{ Exception -> 0x01a4 }
        if (r0 == 0) goto L_0x0059;
    L_0x003c:
        r1 = r0.dRp;	 Catch:{ Exception -> 0x01a4 }
        r2 = r12.dRh;	 Catch:{ Exception -> 0x01a4 }
        r2 = r2.dRp;	 Catch:{ Exception -> 0x01a4 }
        r1.addAll(r2);	 Catch:{ Exception -> 0x01a4 }
        r1 = r0.dRq;	 Catch:{ Exception -> 0x01a4 }
        r2 = r12.dRh;	 Catch:{ Exception -> 0x01a4 }
        r2 = r2.dRq;	 Catch:{ Exception -> 0x01a4 }
        r1.addAll(r2);	 Catch:{ Exception -> 0x01a4 }
        r1 = r0.dRr;	 Catch:{ Exception -> 0x01a4 }
        r2 = r12.dRh;	 Catch:{ Exception -> 0x01a4 }
        r2 = r2.dRr;	 Catch:{ Exception -> 0x01a4 }
        r1.addAll(r2);	 Catch:{ Exception -> 0x01a4 }
        r12.dRh = r0;	 Catch:{ Exception -> 0x01a4 }
    L_0x0059:
        r0 = r12.dRh;
        a(r0);
        r0 = r12.dRh;
        r0 = r0.dRo;
        r1 = r12.dRg;
        r0.add(r1);
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]exist process status data size:%s,send broadcast size:%s, receive broadcast size:%s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.dRh;
        r4 = r4.dRo;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r12.dRh;
        r4 = r4.dRp;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r12.dRh;
        r4 = r4.dRq;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
    L_0x00a0:
        r0 = r12.dRn;
        if (r0 == 0) goto L_0x02cb;
    L_0x00a4:
        r0 = java.lang.Thread.currentThread();
        r0 = r0.isInterrupted();
        if (r0 != 0) goto L_0x02cb;
    L_0x00ae:
        r1 = android.os.Process.myPid();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.dRg;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2 = r12.dRk;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = r12.dRf;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r8 = r4 - r2;
        r7 = r0.dQY;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r7 != r6) goto L_0x00c8;
    L_0x00c2:
        r10 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x01c9;
    L_0x00c8:
        r1 = com.tencent.mm.af.c.d.b(r1, r2, r4, r6);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.dQY;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == r6) goto L_0x00d3;
    L_0x00d0:
        r0 = 1;
        r1.dRa = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x00d3:
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00dc;
    L_0x00d9:
        r0 = 0;
        r1.dQZ = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x00dc:
        r0 = r1;
    L_0x00dd:
        if (r0 == 0) goto L_0x01cf;
    L_0x00df:
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = "[oneliang]create process status:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = 0;
        r3[r6] = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r12.dRg = r0;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.dRo;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r1 = r12.dRg;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0.add(r1);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x00f9:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]send broadcast:%s,receive broadcast:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r6 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = r6.dRp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r6;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 1;
        r6 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r6 = r6.dRq;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r6;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r12.dRk = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.dRi;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0128;
    L_0x011d:
        r0 = r12.dRi;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r4 - r0;
        r2 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0179;
    L_0x0128:
        r12.dRi = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == 0) goto L_0x013e;
    L_0x012e:
        r0 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.dRo;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == 0) goto L_0x013e;
    L_0x0134:
        r0 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.dRo;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        if (r0 == 0) goto L_0x01f8;
    L_0x013e:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]one 3*minute per log, current process status:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.dRg;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.dRp;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.size();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 1;
        r4 = r12.dRh;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.dRq;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = r4.size();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
    L_0x0179:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        goto L_0x00a0;
    L_0x0180:
        r0 = move-exception;
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "process detector thread interrupt.thread id:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = android.os.Process.myTid();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = 0;
        r12.dRn = r0;
        goto L_0x00a0;
    L_0x01a4:
        r0 = move-exception;
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = new java.lang.StringBuilder;
        r3 = "%s,read exception:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.dRm;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.e(r1, r0, r2);
        goto L_0x0059;
    L_0x01c9:
        r0.a(r1, r2, r4, r6);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = 0;
        goto L_0x00dd;
    L_0x01cf:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]current process status:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r6 = r12.dRg;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r6;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        goto L_0x00f9;
    L_0x01e2:
        r0 = move-exception;
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = "exception,%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = r0.getMessage();
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x00a0;
    L_0x01f8:
        r0 = "MicroMsg.ActiveDetector.ProcessDetector";
        r1 = "[oneliang]save data to %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.dRm;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r12.dRh;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r12.dRm;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        if (r0 == 0) goto L_0x013e;
    L_0x0214:
        r2 = 0;
        r1 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x0267, all -> 0x02a7 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0267, all -> 0x02a7 }
        r1.writeObject(r0);	 Catch:{ Exception -> 0x02ce }
        r1.flush();	 Catch:{ Exception -> 0x02ce }
        r1.close();	 Catch:{ Exception -> 0x0225, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x0225:
        r0 = move-exception;
        r1 = "MicroMsg.ObjectUtil";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3 = "Write close exception:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.w(r1, r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x0242:
        r0 = move-exception;
        r1 = "MicroMsg.ActiveDetector.ProcessDetector";
        r2 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = "%s,write exception:";
        r2.<init>(r3);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.getMessage();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r2.append(r0);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r0 = r0.toString();	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r3 = 0;
        r4 = r12.dRm;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        r2[r3] = r4;	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        com.tencent.mm.sdk.platformtools.x.e(r1, r0, r2);	 Catch:{ InterruptedException -> 0x0180, Exception -> 0x01e2 }
        goto L_0x013e;
    L_0x0267:
        r0 = move-exception;
        r1 = r2;
    L_0x0269:
        r2 = "MicroMsg.ObjectUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02cc }
        r4 = "Write exception:";
        r3.<init>(r4);	 Catch:{ all -> 0x02cc }
        r0 = r0.getMessage();	 Catch:{ all -> 0x02cc }
        r0 = r3.append(r0);	 Catch:{ all -> 0x02cc }
        r0 = r0.toString();	 Catch:{ all -> 0x02cc }
        com.tencent.mm.sdk.platformtools.x.w(r2, r0);	 Catch:{ all -> 0x02cc }
        if (r1 == 0) goto L_0x013e;
    L_0x0285:
        r1.close();	 Catch:{ Exception -> 0x028a, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x028a:
        r0 = move-exception;
        r1 = "MicroMsg.ObjectUtil";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r3 = "Write close exception:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.w(r1, r0);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        goto L_0x013e;
    L_0x02a7:
        r0 = move-exception;
        r1 = r2;
    L_0x02a9:
        if (r1 == 0) goto L_0x02ae;
    L_0x02ab:
        r1.close();	 Catch:{ Exception -> 0x02af, InterruptedException -> 0x0180 }
    L_0x02ae:
        throw r0;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
    L_0x02af:
        r1 = move-exception;
        r2 = "MicroMsg.ObjectUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r4 = "Write close exception:";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r1.getMessage();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r1);	 Catch:{ Exception -> 0x0242, InterruptedException -> 0x0180 }
        goto L_0x02ae;
    L_0x02cb:
        return;
    L_0x02cc:
        r0 = move-exception;
        goto L_0x02a9;
    L_0x02ce:
        r0 = move-exception;
        goto L_0x0269;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.c.run():void");
    }

    final void clear() {
        this.dRn = false;
        this.dRj = 0;
        this.dRk = 0;
    }

    private static void a(b bVar) {
        if (bVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                for (d dVar : bVar.dRo) {
                    if (dVar != null) {
                        if (currentTimeMillis - dVar.endTime < 86400000) {
                            break;
                        }
                        bVar.dRo.remove(dVar);
                    } else {
                        bVar.dRo.remove(dVar);
                    }
                }
                for (a aVar : bVar.dRp) {
                    if (aVar != null) {
                        if (currentTimeMillis - aVar.time < 86400000) {
                            break;
                        }
                        bVar.dRp.remove(aVar);
                    } else {
                        bVar.dRp.remove(aVar);
                    }
                }
                for (a aVar2 : bVar.dRq) {
                    if (aVar2 != null) {
                        if (currentTimeMillis - aVar2.time < 86400000) {
                            break;
                        }
                        bVar.dRq.remove(aVar2);
                    } else {
                        bVar.dRq.remove(aVar2);
                    }
                }
                for (c cVar : bVar.dRr) {
                    if (cVar == null) {
                        bVar.dRr.remove(cVar);
                    } else if (currentTimeMillis - cVar.dRs >= 86400000) {
                        bVar.dRr.remove(cVar);
                    } else {
                        return;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ActiveDetector.ProcessDetector", e, "check data exception.", new Object[0]);
            }
        }
    }
}
