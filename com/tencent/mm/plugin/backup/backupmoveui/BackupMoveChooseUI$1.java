package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BackupMoveChooseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BackupMoveChooseUI gVl;

    BackupMoveChooseUI$1(BackupMoveChooseUI backupMoveChooseUI) {
        this.gVl = backupMoveChooseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.gVl.finish();
        return false;
    }
}
