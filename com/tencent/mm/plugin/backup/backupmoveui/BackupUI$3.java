package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BackupUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BackupUI gVH;

    BackupUI$3(BackupUI backupUI) {
        this.gVH = backupUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.gVH.finish();
        return true;
    }
}
