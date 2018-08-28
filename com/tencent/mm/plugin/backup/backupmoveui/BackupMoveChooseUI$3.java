package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveChooseUI$3 implements OnClickListener {
    final /* synthetic */ BackupMoveChooseUI gVl;

    BackupMoveChooseUI$3(BackupMoveChooseUI backupMoveChooseUI) {
        this.gVl = backupMoveChooseUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.gVl, BackupSelectExtUI.class);
        intent.putExtra("BACKUP_MODE", 2);
        intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.KD());
        intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.uw());
        intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.arN());
        intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.arO());
        intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.arv().arz().gTv);
        this.gVl.startActivityForResult(intent, 0);
    }
}
