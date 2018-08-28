package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.2;

class WebViewDownloadWithX5UI$2$2 implements OnClickListener {
    final /* synthetic */ 2 pWQ;

    WebViewDownloadWithX5UI$2$2(2 2) {
        this.pWQ = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14217, new Object[]{"", Integer.valueOf(6), this.pWQ.pWG, this.pWQ.val$url, Integer.valueOf(1)});
        dialogInterface.dismiss();
    }
}
