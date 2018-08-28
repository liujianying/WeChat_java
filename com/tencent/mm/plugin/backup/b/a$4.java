package com.tencent.mm.plugin.backup.b;

class a$4 implements Runnable {
    final /* synthetic */ byte[] bAa;
    final /* synthetic */ a gRT;
    final /* synthetic */ int gRU;
    final /* synthetic */ long gRV;

    a$4(a aVar, int i, byte[] bArr, long j) {
        this.gRT = aVar;
        this.gRU = i;
        this.bAa = bArr;
        this.gRV = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r11 = 4;
        r10 = 3;
        r9 = 2;
        r8 = 1;
        r1 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.VF();
        r0 = "MicroMsg.BackupCEngine";
        r4 = "before send server mode:%d  seq:%d  buff:%d time:[%d]";
        r5 = new java.lang.Object[r11];
        r6 = r12.gRT;
        r6 = com.tencent.mm.plugin.backup.b.a.a(r6);
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        r6 = r12.gRU;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r8] = r6;
        r6 = r12.bAa;
        r6 = com.tencent.mm.sdk.platformtools.bi.bD(r6);
        r6 = java.lang.Integer.valueOf(r6);
        r5[r9] = r6;
        r6 = r12.gRV;
        r6 = r2 - r6;
        r6 = java.lang.Long.valueOf(r6);
        r5[r10] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);
        r0 = r12.gRT;
        r0 = com.tencent.mm.plugin.backup.b.a.a(r0);
        if (r0 != 0) goto L_0x0050;
    L_0x0046:
        r0 = "MicroMsg.BackupCEngine";
        r1 = "sendImp err mode!!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x004f:
        return;
    L_0x0050:
        r0 = r12.gRT;
        r0 = com.tencent.mm.plugin.backup.b.a.a(r0);
        if (r0 != r8) goto L_0x00b2;
    L_0x0058:
        r0 = r12.gRT;
        r0 = com.tencent.mm.plugin.backup.b.a.b(r0);
        r4 = r12.gRT;
        r4 = com.tencent.mm.plugin.backup.b.a.c(r4);
        r5 = r12.bAa;
        r0 = com.tencent.mm.lan_cs.Server.Java2C.send(r0, r4, r5);
        if (r0 == 0) goto L_0x006c;
    L_0x006c:
        r4 = r12.bAa;
        r4 = com.tencent.mm.sdk.platformtools.bi.bD(r4);
        com.tencent.mm.plugin.backup.f.b.mK(r4);
        r4 = "MicroMsg.BackupCEngine";
        r5 = "send result[%d], seq[%d], buff[%d], time[%d,%d]";
        r6 = 5;
        r6 = new java.lang.Object[r6];
        r0 = java.lang.Integer.valueOf(r0);
        r6[r1] = r0;
        r0 = r12.gRU;
        r0 = java.lang.Integer.valueOf(r0);
        r6[r8] = r0;
        r0 = r12.bAa;
        r0 = com.tencent.mm.sdk.platformtools.bi.bD(r0);
        r0 = java.lang.Integer.valueOf(r0);
        r6[r9] = r0;
        r0 = r12.gRV;
        r0 = com.tencent.mm.sdk.platformtools.bi.bH(r0);
        r0 = java.lang.Long.valueOf(r0);
        r6[r10] = r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.bH(r2);
        r0 = java.lang.Long.valueOf(r0);
        r6[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        goto L_0x004f;
    L_0x00b2:
        r0 = r12.gRT;
        r0 = com.tencent.mm.plugin.backup.b.a.a(r0);
        if (r0 != r9) goto L_0x00cd;
    L_0x00ba:
        r0 = r12.gRT;
        r0 = com.tencent.mm.plugin.backup.b.a.b(r0);
        r4 = r12.gRT;
        r4 = com.tencent.mm.plugin.backup.b.a.c(r4);
        r5 = r12.bAa;
        r0 = com.tencent.mm.lan_cs.Client.Java2C.send(r0, r4, r5);
        goto L_0x006c;
    L_0x00cd:
        r0 = r1;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.b.a$4.run():void");
    }
}
