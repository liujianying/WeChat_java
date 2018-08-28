package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.2;

class WebViewDownloadWithX5UI$2$1 implements OnClickListener {
    final /* synthetic */ 2 pWQ;

    WebViewDownloadWithX5UI$2$1(2 2) {
        this.pWQ = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14217, new Object[]{"", Integer.valueOf(5), this.pWQ.pWG, this.pWQ.val$url, Integer.valueOf(1)});
        WebViewDownloadWithX5UI.a(this.pWQ.pWO, this.pWQ.val$url, this.pWQ.pWG);
        dialogInterface.dismiss();
    }
}
