package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.sdk.platformtools.x;

class WebViewDownloadUI$4 implements l {
    final /* synthetic */ WebViewDownloadUI pWE;

    WebViewDownloadUI$4(WebViewDownloadUI webViewDownloadUI) {
        this.pWE = webViewDownloadUI;
    }

    public final void onTaskStarted(long j, String str) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", Long.valueOf(j), str);
    }

    public final void b(long j, String str, boolean z) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", Long.valueOf(j), str, Boolean.valueOf(z));
        Toast.makeText(this.pWE.mController.tml, this.pWE.getString(R.l.webview_download_ui_downloaded_suc), 1).show();
        this.pWE.finish();
    }

    public final void b(long j, int i, boolean z) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
        Toast.makeText(this.pWE.mController.tml, this.pWE.getString(R.l.webview_download_ui_download_failed), 1).show();
        this.pWE.finish();
    }

    public final void onTaskRemoved(long j) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", Long.valueOf(j));
        this.pWE.finish();
    }

    public final void onTaskPaused(long j) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", Long.valueOf(j));
    }

    public final void bP(long j) {
    }

    public final void h(long j, String str) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", Long.valueOf(j), str);
    }
}
