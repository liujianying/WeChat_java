package com.tencent.mm.console;

import com.tencent.mm.console.Shell.2;

class Shell$2$1 implements Runnable {
    final /* synthetic */ String dhv;
    final /* synthetic */ 2 dhw;

    Shell$2$1(2 2, String str) {
        this.dhw = 2;
        this.dhv = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r9 = this;
        r1 = 0;
        r2 = 0;
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.dqq;
        r0 = r0.coa();
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ RuntimeException -> 0x0093 }
        r3 = com.tencent.wcdb.database.SQLiteDirectCursor.FACTORY;	 Catch:{ RuntimeException -> 0x0093 }
        r6 = r9.dhv;	 Catch:{ RuntimeException -> 0x0093 }
        r7 = 0;
        r8 = 0;
        r1 = r0.rawQueryWithFactory(r3, r6, r7, r8);	 Catch:{ RuntimeException -> 0x0093 }
        r6 = r1.getColumnNames();	 Catch:{ RuntimeException -> 0x0093 }
        if (r6 != 0) goto L_0x0089;
    L_0x0020:
        r3 = r2;
    L_0x0021:
        r0 = "MicroMsg.Shell";
        r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0093 }
        r8 = "Executing SQL from shell: ";
        r7.<init>(r8);	 Catch:{ RuntimeException -> 0x0093 }
        r8 = r9.dhv;	 Catch:{ RuntimeException -> 0x0093 }
        r7 = r7.append(r8);	 Catch:{ RuntimeException -> 0x0093 }
        r7 = r7.toString();	 Catch:{ RuntimeException -> 0x0093 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r7);	 Catch:{ RuntimeException -> 0x0093 }
        if (r3 <= 0) goto L_0x0058;
    L_0x003b:
        r0 = "MicroMsg.Shell";
        r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0093 }
        r8 = " > ";
        r7.<init>(r8);	 Catch:{ RuntimeException -> 0x0093 }
        r8 = " | ";
        r6 = android.text.TextUtils.join(r8, r6);	 Catch:{ RuntimeException -> 0x0093 }
        r6 = r7.append(r6);	 Catch:{ RuntimeException -> 0x0093 }
        r6 = r6.toString();	 Catch:{ RuntimeException -> 0x0093 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r6);	 Catch:{ RuntimeException -> 0x0093 }
    L_0x0058:
        r6 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0093 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6.<init>(r0);	 Catch:{ RuntimeException -> 0x0093 }
    L_0x005f:
        r0 = r1.moveToNext();	 Catch:{ RuntimeException -> 0x0093 }
        if (r0 == 0) goto L_0x00cb;
    L_0x0065:
        r0 = 0;
        r6.setLength(r0);	 Catch:{ RuntimeException -> 0x0093 }
        r0 = " > ";
        r6.append(r0);	 Catch:{ RuntimeException -> 0x0093 }
        r0 = r2;
    L_0x0070:
        if (r0 >= r3) goto L_0x00c0;
    L_0x0072:
        r7 = r1.getType(r0);	 Catch:{ RuntimeException -> 0x0093 }
        switch(r7) {
            case 0: goto L_0x008c;
            case 4: goto L_0x00b2;
            default: goto L_0x0079;
        };	 Catch:{ RuntimeException -> 0x0093 }
    L_0x0079:
        r7 = r1.getString(r0);	 Catch:{ RuntimeException -> 0x0093 }
        r6.append(r7);	 Catch:{ RuntimeException -> 0x0093 }
    L_0x0080:
        r7 = " | ";
        r6.append(r7);	 Catch:{ RuntimeException -> 0x0093 }
        r0 = r0 + 1;
        goto L_0x0070;
    L_0x0089:
        r0 = r6.length;	 Catch:{ RuntimeException -> 0x0093 }
        r3 = r0;
        goto L_0x0021;
    L_0x008c:
        r7 = "(null)";
        r6.append(r7);	 Catch:{ RuntimeException -> 0x0093 }
        goto L_0x0080;
    L_0x0093:
        r0 = move-exception;
        r2 = "MicroMsg.Shell";
        r3 = "Failed to execute SQL '%s': %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00b9 }
        r5 = 0;
        r6 = r9.dhv;	 Catch:{ all -> 0x00b9 }
        r4[r5] = r6;	 Catch:{ all -> 0x00b9 }
        r5 = 1;
        r0 = r0.getMessage();	 Catch:{ all -> 0x00b9 }
        r4[r5] = r0;	 Catch:{ all -> 0x00b9 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x00b9 }
        if (r1 == 0) goto L_0x00b1;
    L_0x00ae:
        r1.close();
    L_0x00b1:
        return;
    L_0x00b2:
        r7 = "(blob)";
        r6.append(r7);	 Catch:{ RuntimeException -> 0x0093 }
        goto L_0x0080;
    L_0x00b9:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00bf;
    L_0x00bc:
        r1.close();
    L_0x00bf:
        throw r0;
    L_0x00c0:
        r0 = "MicroMsg.Shell";
        r7 = r6.toString();	 Catch:{ RuntimeException -> 0x0093 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r7);	 Catch:{ RuntimeException -> 0x0093 }
        goto L_0x005f;
    L_0x00cb:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ RuntimeException -> 0x0093 }
        r2 = r2 - r4;
        r0 = "MicroMsg.Shell";
        r4 = "Finish executing SQL in %d ms: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ RuntimeException -> 0x0093 }
        r6 = 0;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ RuntimeException -> 0x0093 }
        r5[r6] = r2;	 Catch:{ RuntimeException -> 0x0093 }
        r2 = 1;
        r3 = r9.dhv;	 Catch:{ RuntimeException -> 0x0093 }
        r5[r2] = r3;	 Catch:{ RuntimeException -> 0x0093 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);	 Catch:{ RuntimeException -> 0x0093 }
        if (r1 == 0) goto L_0x00b1;
    L_0x00ea:
        r1.close();
        goto L_0x00b1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.Shell$2$1.run():void");
    }
}
