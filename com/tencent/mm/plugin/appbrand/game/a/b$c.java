package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;

class b$c extends h {
    final /* synthetic */ b fAD;

    b$c(b bVar, i iVar) {
        this.fAD = bVar;
        super(iVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void a(com.tencent.mm.plugin.fts.a.a.j r8) {
        /*
        r7 = this;
        r4 = 1;
        r0 = r7.jsj;
        r0 = r0.bWm;
        r0 = com.tencent.mm.plugin.fts.a.a.g.ax(r0, r4);
        r8.jrx = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r8.jsx = r0;
        r6 = new java.util.HashSet;
        r6.<init>();
        r0 = r7.fAD;
        r0 = r0.fAB;
        r1 = r8.jrx;
        r2 = com.tencent.mm.plugin.fts.a.c.jqh;
        r3 = r7.jsj;
        r3 = r3.jsr;
        r5 = r4;
        r1 = r0.a(r1, r2, r3, r4, r5);
    L_0x0028:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0060 }
        if (r0 == 0) goto L_0x0069;
    L_0x002e:
        r0 = new com.tencent.mm.plugin.fts.a.a.m;	 Catch:{ Throwable -> 0x0060 }
        r0.<init>();	 Catch:{ Throwable -> 0x0060 }
        r0.k(r1);	 Catch:{ Throwable -> 0x0060 }
        r2 = r0.jsA;	 Catch:{ Throwable -> 0x0060 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x0060 }
        r2 = r6.contains(r2);	 Catch:{ Throwable -> 0x0060 }
        if (r2 != 0) goto L_0x0028;
    L_0x0042:
        r2 = r7.jsj;	 Catch:{ Throwable -> 0x0060 }
        r2 = r2.jst;	 Catch:{ Throwable -> 0x0060 }
        r3 = r0.jrv;	 Catch:{ Throwable -> 0x0060 }
        r2 = r2.contains(r3);	 Catch:{ Throwable -> 0x0060 }
        if (r2 != 0) goto L_0x0028;
    L_0x004e:
        r0.aQc();	 Catch:{ Throwable -> 0x0060 }
        r2 = r8.jsx;	 Catch:{ Throwable -> 0x0060 }
        r2.add(r0);	 Catch:{ Throwable -> 0x0060 }
        r2 = r0.jsA;	 Catch:{ Throwable -> 0x0060 }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x0060 }
        r6.add(r0);	 Catch:{ Throwable -> 0x0060 }
        goto L_0x0028;
    L_0x0060:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0062:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0068;
    L_0x0065:
        r1.close();
    L_0x0068:
        throw r0;
    L_0x0069:
        if (r1 == 0) goto L_0x006e;
    L_0x006b:
        r1.close();
    L_0x006e:
        r0 = java.lang.Thread.interrupted();
        if (r0 == 0) goto L_0x007a;
    L_0x0074:
        r0 = new java.lang.InterruptedException;
        r0.<init>();
        throw r0;
    L_0x007a:
        r0 = r7.jsj;
        r0 = r0.jsu;
        if (r0 == 0) goto L_0x0089;
    L_0x0080:
        r0 = r8.jsx;
        r1 = r7.jsj;
        r1 = r1.jsu;
        java.util.Collections.sort(r0, r1);
    L_0x0089:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.game.a.b$c.a(com.tencent.mm.plugin.fts.a.a.j):void");
    }

    public final String getName() {
        return "SearchMiniGameTask";
    }

    public final int getId() {
        return 30;
    }
}
