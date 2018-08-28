package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.f.b.d;

class c$4 implements d {
    final /* synthetic */ c gWG;

    c$4(c cVar) {
        this.gWG = cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r10, int r11, byte[] r12, int r13) {
        /*
        r9 = this;
        r1 = "MicroMsg.BackupPcProcessMgr";
        r2 = "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]";
        r0 = 4;
        r3 = new java.lang.Object[r0];
        r0 = 0;
        r4 = java.lang.Boolean.valueOf(r10);
        r3[r0] = r4;
        r0 = 1;
        r4 = java.lang.Integer.valueOf(r11);
        r3[r0] = r4;
        r0 = 2;
        r4 = java.lang.Integer.valueOf(r13);
        r3[r0] = r4;
        r4 = 3;
        if (r12 != 0) goto L_0x0054;
    L_0x0021:
        r0 = -1;
    L_0x0022:
        r0 = java.lang.Integer.valueOf(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        if (r10 == 0) goto L_0x00ab;
    L_0x002d:
        if (r12 == 0) goto L_0x00ab;
    L_0x002f:
        r0 = 10011; // 0x271b float:1.4028E-41 double:4.946E-320;
        if (r0 != r11) goto L_0x0053;
    L_0x0033:
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.aqP();
        r0 = r0.gRC;
        r1 = "MicroMsg.BackupPcProcessMgr";
        r2 = "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        switch(r0) {
            case -100: goto L_0x009f;
            case -21: goto L_0x009f;
            case -5: goto L_0x009f;
            case 1: goto L_0x0056;
            default: goto L_0x0053;
        };
    L_0x0053:
        return;
    L_0x0054:
        r0 = r12.length;
        goto L_0x0022;
    L_0x0056:
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.c.access$200();
        if (r0 != 0) goto L_0x007c;
    L_0x005c:
        r0 = r9.gWG;
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.c.c(r0);
        if (r0 == 0) goto L_0x0076;
    L_0x0064:
        r0 = "MicroMsg.BackupPcProcessMgr";
        r1 = "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r9.gWG;
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.c.c(r0);
        r0.SO();
    L_0x0076:
        r0 = r9.gWG;
        com.tencent.mm.plugin.backup.backuppcmodel.c.d(r0);
        goto L_0x0053;
    L_0x007c:
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.arw();
        r0.stop();
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.aqP();
        r1 = -4;
        r0.gRC = r1;
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.arX();
        r1 = -4;
        r0.mH(r1);
        goto L_0x0053;
    L_0x009f:
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.arw();
        r0.stop();
        goto L_0x0053;
    L_0x00ab:
        r0 = 17;
        if (r11 != r0) goto L_0x00d1;
    L_0x00af:
        r0 = new com.tencent.mm.plugin.backup.h.b;
        r0.<init>();
        r0.aG(r12);	 Catch:{ Exception -> 0x013a }
        r1 = "MicroMsg.BackupPcProcessMgr";
        r2 = "onBackupPcProcessMgrNotify receive commandReq, command[%d]";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x013a }
        r4 = 0;
        r5 = r0.hbr;	 Catch:{ Exception -> 0x013a }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x013a }
        r3[r4] = r5;	 Catch:{ Exception -> 0x013a }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x013a }
        r0 = r0.hbr;	 Catch:{ Exception -> 0x013a }
        switch(r0) {
            case 1: goto L_0x0133;
            case 2: goto L_0x00d1;
            case 3: goto L_0x0205;
            case 4: goto L_0x00d1;
            case 5: goto L_0x0148;
            case 6: goto L_0x00d1;
            case 7: goto L_0x020d;
            default: goto L_0x00d1;
        };
    L_0x00d1:
        r0 = 5;
        if (r11 != r0) goto L_0x0053;
    L_0x00d4:
        r0 = "MicroMsg.BackupPcProcessMgr";
        r1 = "onBackupPcProcessMgrNotify receive cancelReq";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 13737; // 0x35a9 float:1.925E-41 double:6.787E-320;
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 5;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r4 = r4.arW();
        r4 = r4.gWC;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.aqP();
        r1 = -100;
        r0.gRC = r1;
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.arX();
        r1 = -100;
        r0.mH(r1);
        goto L_0x0053;
    L_0x0133:
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 1;
        com.tencent.mm.plugin.backup.backuppcmodel.c.a(r0, r1, r13);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
    L_0x013a:
        r0 = move-exception;
        r1 = "MicroMsg.BackupPcProcessMgr";
        r2 = "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x00d1;
    L_0x0148:
        com.tencent.mm.model.au.HU();	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.model.c.DT();	 Catch:{ Exception -> 0x013a }
        r1 = com.tencent.mm.storage.aa.a.sUY;	 Catch:{ Exception -> 0x013a }
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x013a }
        r0 = r0.get(r1, r2);	 Catch:{ Exception -> 0x013a }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Exception -> 0x013a }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x013a }
        if (r0 != 0) goto L_0x0173;
    L_0x0162:
        r0 = "MicroMsg.BackupPcProcessMgr";
        r1 = "onBackupPcProcessMgrNotify not backuping, start new backup.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ Exception -> 0x013a }
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 5;
        com.tencent.mm.plugin.backup.backuppcmodel.c.a(r0, r1, r13);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
    L_0x0173:
        com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.aqU();	 Catch:{ Exception -> 0x013a }
        r1 = "BACKUP_PC_CHOOSE_SESSION";
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ Exception -> 0x013a }
        if (r0 != 0) goto L_0x0195;
    L_0x0184:
        r0 = "MicroMsg.BackupPcProcessMgr";
        r1 = "onBackupPcProcessMgrNotify sessionString is null, start new backup.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ Exception -> 0x013a }
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 5;
        com.tencent.mm.plugin.backup.backuppcmodel.c.a(r0, r1, r13);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
    L_0x0195:
        r1 = "MicroMsg.BackupPcProcessMgr";
        r2 = "onBackupPcProcessMgrNotify start continue Backup.";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);	 Catch:{ Exception -> 0x013a }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x013a }
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r4 = 29;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x013a }
        r1 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r2 = 3;
        r1.gWw = r2;	 Catch:{ Exception -> 0x013a }
        r1 = new java.util.LinkedList;	 Catch:{ Exception -> 0x013a }
        r2 = ",";
        r0 = com.tencent.mm.plugin.backup.a.g.bQ(r0, r2);	 Catch:{ Exception -> 0x013a }
        r0 = java.util.Arrays.asList(r0);	 Catch:{ Exception -> 0x013a }
        r1.<init>(r0);	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0 = r0.arX();	 Catch:{ Exception -> 0x013a }
        r0.init();	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0 = r0.arX();	 Catch:{ Exception -> 0x013a }
        r0.D(r1);	 Catch:{ Exception -> 0x013a }
        r0 = 5;
        com.tencent.mm.plugin.backup.backuppcmodel.c.cf(r0, r13);	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0 = r0.arX();	 Catch:{ Exception -> 0x013a }
        r0.aqN();	 Catch:{ Exception -> 0x013a }
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 6;
        r0.mF(r1);	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0 = r0.arX();	 Catch:{ Exception -> 0x013a }
        r1 = com.tencent.mm.plugin.backup.g.d.asG();	 Catch:{ Exception -> 0x013a }
        r1.asJ();	 Catch:{ Exception -> 0x013a }
        r1 = r0.gUu;	 Catch:{ Exception -> 0x013a }
        r1 = r1.size();	 Catch:{ Exception -> 0x013a }
        r2 = (long) r1;	 Catch:{ Exception -> 0x013a }
        r0.bV(r2);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
    L_0x0205:
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 3;
        com.tencent.mm.plugin.backup.backuppcmodel.c.b(r0, r1, r13);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
    L_0x020d:
        com.tencent.mm.model.au.HU();	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.model.c.DT();	 Catch:{ Exception -> 0x013a }
        r1 = com.tencent.mm.storage.aa.a.sUZ;	 Catch:{ Exception -> 0x013a }
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x013a }
        r0 = r0.get(r1, r2);	 Catch:{ Exception -> 0x013a }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Exception -> 0x013a }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x013a }
        if (r0 != 0) goto L_0x0238;
    L_0x0227:
        r0 = "MicroMsg.BackupPcProcessMgr";
        r1 = "onBackupPcProcessMgrNotify not recovering, start new recover.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ Exception -> 0x013a }
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 7;
        com.tencent.mm.plugin.backup.backuppcmodel.c.b(r0, r1, r13);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
    L_0x0238:
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0.arY();	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.d.arA();	 Catch:{ Exception -> 0x013a }
        if (r0 != 0) goto L_0x0256;
    L_0x0245:
        r0 = "MicroMsg.BackupPcProcessMgr";
        r1 = "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ Exception -> 0x013a }
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 7;
        com.tencent.mm.plugin.backup.backuppcmodel.c.b(r0, r1, r13);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
    L_0x0256:
        r0 = "MicroMsg.BackupPcProcessMgr";
        r1 = "onBackupPcProcessMgrNotify continue Recover.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ Exception -> 0x013a }
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ Exception -> 0x013a }
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r4 = 30;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x013a }
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 4;
        r0.gWw = r1;	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0 = r0.arY();	 Catch:{ Exception -> 0x013a }
        r0.init();	 Catch:{ Exception -> 0x013a }
        r0 = 7;
        com.tencent.mm.plugin.backup.backuppcmodel.c.cf(r0, r13);	 Catch:{ Exception -> 0x013a }
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();	 Catch:{ Exception -> 0x013a }
        r0 = r0.arX();	 Catch:{ Exception -> 0x013a }
        r0.aqN();	 Catch:{ Exception -> 0x013a }
        r0 = r9.gWG;	 Catch:{ Exception -> 0x013a }
        r1 = 8;
        r0.mF(r1);	 Catch:{ Exception -> 0x013a }
        goto L_0x00d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.backuppcmodel.c$4.a(boolean, int, byte[], int):void");
    }
}
