package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.model.d.1.1;
import com.tencent.mm.sdk.platformtools.bi;

class d$1$1$1 implements Runnable {
    final /* synthetic */ 1 ibZ;

    d$1$1$1(1 1) {
        this.ibZ = 1;
    }

    public final void run() {
        PendingIntent pendingIntent = null;
        if (this.ibZ.ibY.ibG.field_fileType == 1) {
            pendingIntent = d.J(this.ibZ.ibY.ibG.field_filePath, this.ibZ.ibY.ibG.field_md5, this.ibZ.ibY.ibG.field_appId);
        }
        String str;
        if (this.ibZ.ibY.ibG.field_showNotification && bi.oW(this.ibZ.ibY.ibG.field_fileName)) {
            str = this.ibZ.ibY.ibG.field_downloadUrl;
            d.b(this.ibZ.ibY.val$context.getString(c.file_downloader_download_finished), "", pendingIntent);
        } else if (this.ibZ.ibY.ibG.field_showNotification && !bi.oW(this.ibZ.ibY.ibG.field_fileName)) {
            str = this.ibZ.ibY.ibG.field_downloadUrl;
            d.b(this.ibZ.ibY.ibG.field_fileName, this.ibZ.ibY.val$context.getString(c.file_downloader_download_finished), pendingIntent);
        }
        if (this.ibZ.ibY.ibG.field_autoInstall && this.ibZ.ibY.ibG.field_fileType == 1) {
            d.f(this.ibZ.ibY.ibG);
        }
        d.a(this.ibZ.ibY.ibX).c(this.ibZ.ibY.ibH, this.ibZ.ibY.ibG.field_filePath, this.ibZ.ibY.ibL);
    }
}
