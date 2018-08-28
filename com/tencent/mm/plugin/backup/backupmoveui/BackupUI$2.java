package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.w;

class BackupUI$2 implements OnClickListener {
    final /* synthetic */ BackupUI gVH;

    BackupUI$2(BackupUI backupUI) {
        this.gVH = backupUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("title", this.gVH.getString(R.l.backup_pc_doc_title));
        intent.putExtra("rawUrl", this.gVH.getString(R.l.backup_pc_tip_doc, new Object[]{w.chP()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.gVH, "webview", ".ui.tools.WebViewUI", intent);
    }
}
