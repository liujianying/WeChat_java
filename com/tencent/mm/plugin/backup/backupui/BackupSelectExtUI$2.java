package com.tencent.mm.plugin.backup.backupui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BackupSelectExtUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BackupSelectExtUI gZa;

    BackupSelectExtUI$2(BackupSelectExtUI backupSelectExtUI) {
        this.gZa = backupSelectExtUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.gZa.finish();
        return true;
    }
}
