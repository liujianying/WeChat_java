package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CompressPreviewUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ CompressPreviewUI mfN;

    CompressPreviewUI$4(CompressPreviewUI compressPreviewUI) {
        this.mfN = compressPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.mfN, AttachDownloadPage.class);
        intent.putExtra("attach_name", CompressPreviewUI.e(this.mfN));
        intent.putExtra("mail_id", CompressPreviewUI.b(this.mfN));
        intent.putExtra("attach_id", CompressPreviewUI.f(this.mfN));
        intent.putExtra("total_size", CompressPreviewUI.g(this.mfN));
        intent.putExtra("is_preview", 0);
        intent.putExtra("is_compress", true);
        this.mfN.startActivity(intent);
        return true;
    }
}
