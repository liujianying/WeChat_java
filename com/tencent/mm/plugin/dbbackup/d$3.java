package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.c;

class d$3 implements Runnable {
    final /* synthetic */ b iaa;
    final /* synthetic */ c iab;
    final /* synthetic */ d iam;
    final String[] iap = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation"};
    final /* synthetic */ String iaq;

    d$3(d dVar, c cVar, String str, b bVar) {
        this.iam = dVar;
        this.iab = cVar;
        this.iaq = str;
        this.iaa = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r14 = this;
        r0 = r14.iam;
        r1 = 0;
        com.tencent.mm.plugin.dbbackup.d.a(r0, r1);
        r8 = 0;
        r7 = 0;
        com.tencent.mm.model.c.FT();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        com.tencent.mm.model.c.FW();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        com.tencent.mm.ak.o.Pf();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        com.tencent.mm.modelvideo.o.Ta();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0.<init>();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r1 = com.tencent.mm.compatible.e.q.zy();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r1 = com.tencent.mm.model.c.Df();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r9 = com.tencent.mm.a.g.v(r0);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = com.tencent.mm.a.g.u(r0);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r1 = 0;
        r2 = 7;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r1 = r0.getBytes();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r4 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0 = com.tencent.mm.bt.f.cnW();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        if (r0 == 0) goto L_0x004d;
    L_0x004b:
        r4 = 805306368; // 0x30000000 float:4.656613E-10 double:3.97874211E-315;
    L_0x004d:
        r0 = com.tencent.mm.model.c.FO();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = r0.coa();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r2 = com.tencent.mm.plugin.dbbackup.d.aCH();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r11 = com.tencent.wcdb.database.SQLiteDatabase.openDatabase(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
        r12 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r0 = 2;
        r4 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r0 = 0;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r2.<init>();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r3 = r14.iaq;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r3 = ".sm";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r4[r0] = r2;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r0 = 1;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r2.<init>();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        com.tencent.mm.kernel.g.Ek();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r3 = com.tencent.mm.kernel.g.Ei();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r3 = r3.dqp;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r3 = "dbback/EnMicroMsg.db.sm";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r4[r0] = r2;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
        r0 = 0;
        r3 = r0;
        r2 = r8;
    L_0x00a7:
        r0 = 2;
        if (r3 >= r0) goto L_0x00c8;
    L_0x00aa:
        r0 = r4[r3];	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r5 = r14.iap;	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
        r2 = com.tencent.wcdb.repair.RepairKit.MasterInfo.load(r0, r9, r5);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
        r5 = "MicroMsg.SubCoreDBBackup";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
        r7 = "Loaded saved master: ";
        r6.<init>(r7);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
        com.tencent.mm.sdk.platformtools.x.i(r5, r0);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
    L_0x00c8:
        if (r2 != 0) goto L_0x01ba;
    L_0x00ca:
        r0 = r14.iap;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r2 = com.tencent.wcdb.repair.RepairKit.MasterInfo.make(r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = "MicroMsg.SubCoreDBBackup";
        r3 = "Saved master not available.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r3);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r4 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
        r6 = 32;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
    L_0x00e5:
        r0 = r14.iam;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r3 = new com.tencent.wcdb.repair.RepairKit;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r4 = r14.iaq;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r5 = com.tencent.mm.plugin.dbbackup.d.aCH();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r3.<init>(r4, r1, r5, r2);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        com.tencent.mm.plugin.dbbackup.d.a(r0, r3);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = r14.iam;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r1 = 1;
        r0 = r0.output(r11, r1);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        if (r0 != 0) goto L_0x0249;
    L_0x0102:
        r0 = 1;
        r1 = r0;
    L_0x0104:
        r0 = r14.iam;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = r0.isHeaderCorrupted();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        if (r0 == 0) goto L_0x011c;
    L_0x0110:
        r0 = r14.iam;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = r0.isDataCorrupted();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        if (r0 != 0) goto L_0x024d;
    L_0x011c:
        r0 = 1;
    L_0x011d:
        r1 = r1 & r0;
        r11.close();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r9 = 0;
        r2.release();	 Catch:{ Exception -> 0x02ce, all -> 0x02ba }
        r10 = 0;
        r0 = r14.iam;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r0.release();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r0 = r14.iam;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r2 = 0;
        com.tencent.mm.plugin.dbbackup.d.a(r0, r2);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        com.tencent.mm.plugin.dbbackup.d.aCF();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r2 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r2 = r2 - r12;
        r4 = "MicroMsg.SubCoreDBBackup";
        r5 = "DB repair %s, elapsed %.2f seconds.";
        r0 = 2;
        r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r7 = 0;
        if (r1 == 0) goto L_0x0250;
    L_0x0149:
        r0 = "succeeded";
    L_0x014c:
        r6[r7] = r0;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r0 = 1;
        r2 = (float) r2;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r3 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
        r2 = r2 / r3;
        r2 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r6[r0] = r2;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        if (r1 == 0) goto L_0x0255;
    L_0x015f:
        r0 = 26;
        r1 = r14.iaa;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        if (r1 == 0) goto L_0x016b;
    L_0x0165:
        r1 = r14.iaa;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r2 = 0;
        r1.ov(r2);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
    L_0x016b:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r2 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
        r4 = (long) r0;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r0 = r14.iam;
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);
        if (r0 == 0) goto L_0x018d;
    L_0x017e:
        r0 = r14.iam;
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);
        r0.release();
        r0 = r14.iam;
        r1 = 0;
        com.tencent.mm.plugin.dbbackup.d.a(r0, r1);
    L_0x018d:
        r0 = r14.iam;
        com.tencent.mm.plugin.dbbackup.d.c(r0);
        r0 = com.tencent.mm.model.au.Em();
        r0.cik();
    L_0x0199:
        return;
    L_0x019a:
        r0 = move-exception;
        r5 = "MicroMsg.SubCoreDBBackup";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r7 = "Failed to load saved master: ";
        r6.<init>(r7);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x00a7;
    L_0x01ba:
        if (r3 <= 0) goto L_0x00e5;
    L_0x01bc:
        r0 = "MicroMsg.SubCoreDBBackup";
        r3 = "Use backup saved master.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        r4 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
        r6 = 33;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
        goto L_0x00e5;
    L_0x01d3:
        r0 = move-exception;
        r9 = r11;
        r10 = r2;
    L_0x01d6:
        r1 = "MicroMsg.SubCoreDBBackup";
        r2 = "Failed to repair database '%s'";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02c1 }
        r4 = 0;
        r5 = r14.iaq;	 Catch:{ all -> 0x02c1 }
        r3[r4] = r5;	 Catch:{ all -> 0x02c1 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x02c1 }
        r0 = r14.iaa;	 Catch:{ all -> 0x02c1 }
        if (r0 == 0) goto L_0x01f1;
    L_0x01eb:
        r0 = r14.iaa;	 Catch:{ all -> 0x02c1 }
        r1 = -1;
        r0.ov(r1);	 Catch:{ all -> 0x02c1 }
    L_0x01f1:
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x02c1 }
        r1 = "DBRepair";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02c1 }
        r3 = "Repair failed: ";
        r2.<init>(r3);	 Catch:{ all -> 0x02c1 }
        r3 = com.tencent.wcdb.repair.RepairKit.lastError();	 Catch:{ all -> 0x02c1 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x02c1 }
        r2 = r2.toString();	 Catch:{ all -> 0x02c1 }
        r3 = 0;
        r0.c(r1, r2, r3);	 Catch:{ all -> 0x02c1 }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ all -> 0x02c1 }
        r2 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
        r4 = 27;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ all -> 0x02c1 }
        r0 = r14.iam;
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);
        if (r0 == 0) goto L_0x0231;
    L_0x0222:
        r0 = r14.iam;
        r0 = com.tencent.mm.plugin.dbbackup.d.e(r0);
        r0.release();
        r0 = r14.iam;
        r1 = 0;
        com.tencent.mm.plugin.dbbackup.d.a(r0, r1);
    L_0x0231:
        if (r9 == 0) goto L_0x0236;
    L_0x0233:
        r9.close();
    L_0x0236:
        if (r10 == 0) goto L_0x023b;
    L_0x0238:
        r10.release();
    L_0x023b:
        r0 = r14.iam;
        com.tencent.mm.plugin.dbbackup.d.c(r0);
        r0 = com.tencent.mm.model.au.Em();
        r0.cik();
        goto L_0x0199;
    L_0x0249:
        r0 = 0;
        r1 = r0;
        goto L_0x0104;
    L_0x024d:
        r0 = 0;
        goto L_0x011d;
    L_0x0250:
        r0 = "failed";
        goto L_0x014c;
    L_0x0255:
        r0 = 27;
        r1 = r14.iaa;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        if (r1 == 0) goto L_0x0261;
    L_0x025b:
        r1 = r14.iaa;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r2 = -1;
        r1.ov(r2);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
    L_0x0261:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r2 = "DBRepair";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r4 = "Repair failed: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r4 = com.tencent.wcdb.repair.RepairKit.lastError();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        r4 = 0;
        r1.c(r2, r3, r4);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
        goto L_0x016b;
    L_0x0280:
        r0 = move-exception;
        goto L_0x01d6;
    L_0x0283:
        r0 = move-exception;
        r11 = r7;
        r10 = r8;
    L_0x0286:
        r1 = r14.iam;
        r1 = com.tencent.mm.plugin.dbbackup.d.e(r1);
        if (r1 == 0) goto L_0x029d;
    L_0x028e:
        r1 = r14.iam;
        r1 = com.tencent.mm.plugin.dbbackup.d.e(r1);
        r1.release();
        r1 = r14.iam;
        r2 = 0;
        com.tencent.mm.plugin.dbbackup.d.a(r1, r2);
    L_0x029d:
        if (r11 == 0) goto L_0x02a2;
    L_0x029f:
        r11.close();
    L_0x02a2:
        if (r10 == 0) goto L_0x02a7;
    L_0x02a4:
        r10.release();
    L_0x02a7:
        r1 = r14.iam;
        com.tencent.mm.plugin.dbbackup.d.c(r1);
        r1 = com.tencent.mm.model.au.Em();
        r1.cik();
        throw r0;
    L_0x02b4:
        r0 = move-exception;
        r10 = r8;
        goto L_0x0286;
    L_0x02b7:
        r0 = move-exception;
        r10 = r2;
        goto L_0x0286;
    L_0x02ba:
        r0 = move-exception;
        r11 = r9;
        r10 = r2;
        goto L_0x0286;
    L_0x02be:
        r0 = move-exception;
        r11 = r9;
        goto L_0x0286;
    L_0x02c1:
        r0 = move-exception;
        r11 = r9;
        goto L_0x0286;
    L_0x02c4:
        r0 = move-exception;
        r9 = r7;
        r10 = r8;
        goto L_0x01d6;
    L_0x02c9:
        r0 = move-exception;
        r9 = r11;
        r10 = r8;
        goto L_0x01d6;
    L_0x02ce:
        r0 = move-exception;
        r10 = r2;
        goto L_0x01d6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d$3.run():void");
    }
}
