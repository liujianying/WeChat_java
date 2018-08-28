package com.tencent.mm.plugin.downloader.d;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ long ibH;
    final /* synthetic */ a icL;

    a$2(a aVar, long j) {
        this.icL = aVar;
        this.ibH = j;
    }

    public final void run() {
        a cs = c.cs(this.ibH);
        if (cs != null) {
            try {
                a.a(this.icL).cancelDownloadTask(cs.field_downloadUrl);
                e.deleteFile(cs.field_filePath);
                this.icL.icH.remove(Long.valueOf(cs.field_downloadId));
                this.icL.cancelNotification(cs.field_downloadUrl);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: status = " + cs.field_status);
                if (cs.field_status != 5) {
                    c.k(cs.field_downloadId, 5);
                    long a = bi.a((Long) this.icL.ibE.get(cs.field_downloadUrl), cs.field_startTime);
                    float a2 = ((((float) (cs.field_downloadedSize - bi.a((Long) this.icL.ibD.get(cs.field_downloadUrl), cs.field_startSize))) * 1000.0f) / ((float) (System.currentTimeMillis() - a))) / 1048576.0f;
                    b.a(cs.field_downloadId, a2, (int) ((((float) cs.field_downloadedSize) / ((float) cs.field_totalSize)) * 100.0f));
                    this.icL.ibT.cp(cs.field_downloadId);
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", new Object[]{Long.valueOf(this.ibH), cs.field_filePath});
                }
            } catch (Exception e) {
                x.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + e.toString());
            }
        }
    }
}
