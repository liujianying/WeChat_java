package com.tencent.mm.plugin.clean.c.a;

public abstract class a implements Runnable {
    private long grC = 0;
    private a hRr;
    c hRs;

    public abstract void execute();

    public String SR() {
        return this.grC;
    }

    public a(a aVar) {
        this.hRr = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = com.tencent.mm.sdk.platformtools.bi.VG();	 Catch:{ Exception -> 0x0030 }
        r4.grC = r0;	 Catch:{ Exception -> 0x0030 }
        r4.execute();	 Catch:{ Exception -> 0x0030 }
        r0 = r4.grC;	 Catch:{ Exception -> 0x0030 }
        r0 = com.tencent.mm.sdk.platformtools.bi.bI(r0);	 Catch:{ Exception -> 0x0030 }
        r4.grC = r0;	 Catch:{ Exception -> 0x0030 }
        r0 = r4.hRs;
        if (r0 == 0) goto L_0x0026;
    L_0x0015:
        r0 = r4.hRs;
        r1 = java.lang.Thread.currentThread();
        r2 = r1.getId();
        r1 = java.lang.Long.valueOf(r2);
        r0.f(r1);
    L_0x0026:
        r0 = r4.hRr;
        if (r0 == 0) goto L_0x002f;
    L_0x002a:
        r0 = r4.hRr;
        r0.a(r4);
    L_0x002f:
        return;
    L_0x0030:
        r0 = move-exception;
        r1 = "MicroMsg.AbstractTask";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x005c }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x005c }
        r0 = r4.hRs;
        if (r0 == 0) goto L_0x0052;
    L_0x0041:
        r0 = r4.hRs;
        r1 = java.lang.Thread.currentThread();
        r2 = r1.getId();
        r1 = java.lang.Long.valueOf(r2);
        r0.f(r1);
    L_0x0052:
        r0 = r4.hRr;
        if (r0 == 0) goto L_0x002f;
    L_0x0056:
        r0 = r4.hRr;
        r0.a(r4);
        goto L_0x002f;
    L_0x005c:
        r0 = move-exception;
        r1 = r4.hRs;
        if (r1 == 0) goto L_0x0072;
    L_0x0061:
        r1 = r4.hRs;
        r2 = java.lang.Thread.currentThread();
        r2 = r2.getId();
        r2 = java.lang.Long.valueOf(r2);
        r1.f(r2);
    L_0x0072:
        r1 = r4.hRr;
        if (r1 == 0) goto L_0x007b;
    L_0x0076:
        r1 = r4.hRr;
        r1.a(r4);
    L_0x007b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.clean.c.a.a.run():void");
    }
}
