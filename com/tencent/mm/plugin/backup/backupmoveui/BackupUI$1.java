package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View.OnClickListener;

class BackupUI$1 implements OnClickListener {
    final /* synthetic */ BackupUI gVH;

    BackupUI$1(BackupUI backupUI) {
        this.gVH = backupUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r13) {
        /*
        r12 = this;
        r6 = 1;
        r4 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r9 = 1;
        r3 = -100;
        r8 = 0;
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r8);
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x003d;
    L_0x0021:
        r0 = com.tencent.mm.plugin.backup.c.b.arv();
        r0 = r0.aqP();
        r0 = r0.gRC;
        if (r0 != r3) goto L_0x00d2;
    L_0x002d:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r8);
        r0.a(r1, r2);
    L_0x003d:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r8);
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x006f;
    L_0x0056:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r8);
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x009b;
    L_0x006f:
        r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.arV();
        r0 = r0.aqP();
        r0 = r0.gRC;
        if (r0 != r3) goto L_0x00f6;
    L_0x007b:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r8);
        r0.a(r1, r2);
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r8);
        r0.a(r1, r2);
    L_0x009b:
        r0 = com.tencent.mm.plugin.backup.a.g.ara();
        r1 = 50;
        if (r0 >= r1) goto L_0x011a;
    L_0x00a3:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 485; // 0x1e5 float:6.8E-43 double:2.396E-321;
        r4 = 7;
        r1.a(r2, r4, r6, r8);
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 11787; // 0x2e0b float:1.6517E-41 double:5.8236E-320;
        r3 = new java.lang.Object[r9];
        r4 = 4;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r8] = r4;
        r1.h(r2, r3);
        r3 = r12.gVH;
        r4 = com.tencent.mm.R.l.backup_move_error_low_battery_tip;
        r5 = com.tencent.mm.R.l.backup_move_error_low_battery;
        r6 = com.tencent.mm.R.l.backup_sure;
        r7 = com.tencent.mm.R.l.backup_cancel;
        r9 = new com.tencent.mm.plugin.backup.backupmoveui.BackupUI$1$1;
        r9.<init>(r12, r0);
        r10 = 0;
        r11 = com.tencent.mm.R.e.backup_green;
        com.tencent.mm.ui.base.h.a(r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L_0x00d1:
        return;
    L_0x00d2:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = "com.tencent.mm.ui.LauncherUI";
        r0 = r0.setClassName(r1, r2);
        r0.addFlags(r4);
        r1 = "nofification_type";
        r2 = "backup_move_notification";
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1.startActivity(r0);
        goto L_0x00d1;
    L_0x00f6:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = "com.tencent.mm.ui.LauncherUI";
        r0 = r0.setClassName(r1, r2);
        r0.addFlags(r4);
        r1 = "nofification_type";
        r2 = "back_to_pcmgr_notification";
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1.startActivity(r0);
        goto L_0x00d1;
    L_0x011a:
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 485; // 0x1e5 float:6.8E-43 double:2.396E-321;
        r4 = 21;
        r1.a(r2, r4, r6, r8);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 11788; // 0x2e0c float:1.6519E-41 double:5.824E-320;
        r2 = new java.lang.Object[r9];
        r3 = 3;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r0.h(r1, r2);
        r0 = new android.content.Intent;
        r1 = r12.gVH;
        r2 = com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.class;
        r0.<init>(r1, r2);
        r1 = r12.gVH;
        com.tencent.mm.ui.MMWizardActivity.D(r1, r0);
        goto L_0x00d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.backupmoveui.BackupUI$1.onClick(android.view.View):void");
    }
}
