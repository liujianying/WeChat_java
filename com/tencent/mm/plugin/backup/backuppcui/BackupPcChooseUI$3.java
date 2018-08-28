package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;

class BackupPcChooseUI$3 implements OnClickListener {
    final /* synthetic */ BackupPcChooseUI gXg;

    BackupPcChooseUI$3(BackupPcChooseUI backupPcChooseUI) {
        this.gXg = backupPcChooseUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.gXg, BackupSelectExtUI.class);
        intent.putExtra("BACKUP_MODE", 1);
        intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.KD());
        intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", b.arV().arX().gWS);
        intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.asg());
        intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.JD());
        intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.arN());
        intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.arV().arZ().gTv);
        this.gXg.startActivityForResult(intent, 0);
    }
}
