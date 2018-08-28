package com.tencent.mm.plugin.normsg;

class b$1 implements Runnable {
    final /* synthetic */ b lFE;

    b$1(b bVar) {
        this.lFE = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r9 = 0;
        r0 = com.tencent.mm.kernel.g.Eg();
        r0 = r0.Dx();
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0111 }
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x0111 }
        r2 = r2.getApplicationInfo();	 Catch:{ Exception -> 0x0111 }
        r2 = r2.sourceDir;	 Catch:{ Exception -> 0x0111 }
        com.tencent.mm.kernel.g.Eg();	 Catch:{ Exception -> 0x0111 }
        r2 = com.tencent.mm.kernel.a.Df();	 Catch:{ Exception -> 0x0111 }
        r2 = com.tencent.mm.plugin.normsg.Normsg.b.tZ(r2);	 Catch:{ Exception -> 0x0111 }
        com.tencent.mm.kernel.g.Eg();	 Catch:{ Exception -> 0x0111 }
        r3 = com.tencent.mm.kernel.a.Df();	 Catch:{ Exception -> 0x0111 }
        r3 = com.tencent.mm.plugin.normsg.Normsg.b.ua(r3);	 Catch:{ Exception -> 0x0111 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0111 }
        r4 = r4 - r0;
        r0 = "<k25>%s</k25>";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0111 }
        r6 = 0;
        r7 = 0;
        r8 = r2.length;	 Catch:{ Exception -> 0x0111 }
        r2 = com.tencent.mm.plugin.normsg.b.d.q(r2, r7, r8);	 Catch:{ Exception -> 0x0111 }
        r1[r6] = r2;	 Catch:{ Exception -> 0x0111 }
        r1 = java.lang.String.format(r0, r1);	 Catch:{ Exception -> 0x0111 }
        if (r3 == 0) goto L_0x00ad;
    L_0x004a:
        r0 = r3.length;	 Catch:{ Exception -> 0x0111 }
        r2 = 8;
        if (r0 != r2) goto L_0x011f;
    L_0x004f:
        r0 = 0;
        r0 = r3[r0];	 Catch:{ Exception -> 0x0111 }
        r2 = 0;
        r6 = 3;
        r6 = r3[r6];	 Catch:{ Exception -> 0x0111 }
        r3[r2] = r6;	 Catch:{ Exception -> 0x0111 }
        r2 = 3;
        r3[r2] = r0;	 Catch:{ Exception -> 0x0111 }
        r0 = 1;
        r0 = r3[r0];	 Catch:{ Exception -> 0x0111 }
        r2 = 1;
        r6 = 2;
        r6 = r3[r6];	 Catch:{ Exception -> 0x0111 }
        r3[r2] = r6;	 Catch:{ Exception -> 0x0111 }
        r2 = 2;
        r3[r2] = r0;	 Catch:{ Exception -> 0x0111 }
        r0 = 4;
        r0 = r3[r0];	 Catch:{ Exception -> 0x0111 }
        r2 = 4;
        r6 = 7;
        r6 = r3[r6];	 Catch:{ Exception -> 0x0111 }
        r3[r2] = r6;	 Catch:{ Exception -> 0x0111 }
        r2 = 7;
        r3[r2] = r0;	 Catch:{ Exception -> 0x0111 }
        r0 = 5;
        r0 = r3[r0];	 Catch:{ Exception -> 0x0111 }
        r2 = 5;
        r6 = 6;
        r6 = r3[r6];	 Catch:{ Exception -> 0x0111 }
        r3[r2] = r6;	 Catch:{ Exception -> 0x0111 }
        r2 = 6;
        r3[r2] = r0;	 Catch:{ Exception -> 0x0111 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
        r0.<init>();	 Catch:{ Exception -> 0x0111 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
        r1 = "<k28>%s</k28><k29>%s</k29>";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0111 }
        r6 = 0;
        r7 = 0;
        r8 = 4;
        r7 = com.tencent.mm.plugin.normsg.b.d.q(r3, r7, r8);	 Catch:{ Exception -> 0x0111 }
        r2[r6] = r7;	 Catch:{ Exception -> 0x0111 }
        r6 = 1;
        r7 = 4;
        r8 = 8;
        r3 = com.tencent.mm.plugin.normsg.b.d.q(r3, r7, r8);	 Catch:{ Exception -> 0x0111 }
        r2[r6] = r3;	 Catch:{ Exception -> 0x0111 }
        r1 = java.lang.String.format(r1, r2);	 Catch:{ Exception -> 0x0111 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
        r1 = r0.toString();	 Catch:{ Exception -> 0x0111 }
    L_0x00ad:
        r0 = "mp.weixin.qq.com";
        r0 = java.net.Inet4Address.getByName(r0);	 Catch:{ Exception -> 0x0145 }
        r0 = r0.getHostAddress();	 Catch:{ Exception -> 0x0145 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0145 }
        r2.<init>();	 Catch:{ Exception -> 0x0145 }
        r2 = r2.append(r1);	 Catch:{ Exception -> 0x0145 }
        r3 = "<k32>%s</k32>";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0145 }
        r7 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oV(r0);	 Catch:{ Exception -> 0x0145 }
        r6[r7] = r0;	 Catch:{ Exception -> 0x0145 }
        r0 = java.lang.String.format(r3, r6);	 Catch:{ Exception -> 0x0145 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0145 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0145 }
    L_0x00da:
        r1 = "MicroMsg.NormsgSourceImpl";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
        r3 = "checkSoftType2 [time: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0111 }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x0111 }
        r3 = ", value: ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0111 }
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x0111 }
        r3 = "]";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0111 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0111 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);	 Catch:{ Exception -> 0x0111 }
        r1 = com.tencent.mm.kernel.g.Ei();	 Catch:{ Exception -> 0x0111 }
        r1 = r1.DT();	 Catch:{ Exception -> 0x0111 }
        r2 = 79;
        r1.set(r2, r0);	 Catch:{ Exception -> 0x0111 }
        goto L_0x000b;
    L_0x0111:
        r0 = move-exception;
        r1 = "MicroMsg.NormsgSourceImpl";
        r2 = "Failed checkSoftType2.";
        r3 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x000b;
    L_0x011f:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0111 }
        r0.<init>();	 Catch:{ Exception -> 0x0111 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
        r1 = "<k27>%s</k27>";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0111 }
        r6 = 0;
        r7 = 0;
        r8 = r3.length;	 Catch:{ Exception -> 0x0111 }
        r3 = com.tencent.mm.plugin.normsg.b.d.q(r3, r7, r8);	 Catch:{ Exception -> 0x0111 }
        r2[r6] = r3;	 Catch:{ Exception -> 0x0111 }
        r1 = java.lang.String.format(r1, r2);	 Catch:{ Exception -> 0x0111 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x0111 }
        r1 = r0.toString();	 Catch:{ Exception -> 0x0111 }
        goto L_0x00ad;
    L_0x0145:
        r0 = move-exception;
        r2 = "MicroMsg.NormsgSourceImpl";
        r3 = "exception:%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0111 }
        r7 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ Exception -> 0x0111 }
        r6[r7] = r0;	 Catch:{ Exception -> 0x0111 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r6);	 Catch:{ Exception -> 0x0111 }
        r0 = r1;
        goto L_0x00da;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.normsg.b$1.run():void");
    }

    public final String toString() {
        return super.toString() + "|checkSoftTypeExtra";
    }
}
