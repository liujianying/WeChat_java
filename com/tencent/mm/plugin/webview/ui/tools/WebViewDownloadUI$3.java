package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class WebViewDownloadUI$3 implements OnClickListener {
    final /* synthetic */ String bAj;
    final /* synthetic */ WebViewDownloadUI pWE;
    final /* synthetic */ String pWG;
    final /* synthetic */ String val$url;

    WebViewDownloadUI$3(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3) {
        this.pWE = webViewDownloadUI;
        this.bAj = str;
        this.pWG = str2;
        this.val$url = str3;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[]{Long.valueOf(WebViewDownloadUI.c(this.pWE)), WebViewDownloadUI.a(this.pWE)});
        h.mEJ.h(14217, new Object[]{this.bAj, Integer.valueOf(3), this.pWG, this.val$url, Integer.valueOf(0)});
        if (WebViewDownloadUI.c(this.pWE) <= 0) {
            x.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
        } else {
            x.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[]{Integer.valueOf(d.aCU().cl(WebViewDownloadUI.c(this.pWE)))});
            if (d.aCU().cl(WebViewDownloadUI.c(this.pWE)) > 0) {
                Toast.makeText(this.pWE.mController.tml, this.pWE.getString(R.l.webview_download_ui_canceled), 1).show();
                this.pWE.finish();
                return;
            }
        }
        Toast.makeText(this.pWE.mController.tml, this.pWE.getString(R.l.webview_download_ui_cancel_failed), 1).show();
    }
}
