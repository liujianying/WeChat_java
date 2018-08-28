package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.w;

class BackupMoveRecoverUI$17 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$17(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.gVy = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("title", this.gVy.getString(R.l.backup_move_open_wifiap_title));
        intent.putExtra("rawUrl", this.gVy.getString(R.l.backup_move_open_wifiap_doc, new Object[]{w.chP()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.gVy, "webview", ".ui.tools.WebViewUI", intent);
    }
}
