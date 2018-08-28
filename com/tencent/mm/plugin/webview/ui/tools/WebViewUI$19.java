package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$19 implements OnCancelListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$19(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.pZJ.gcU != null && this.pZJ.gcO != null) {
            try {
                this.pZJ.gcO.QX(this.pZJ.gcU.pUp);
                this.pZJ.gcU.bVc();
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "cancel capture failed");
            }
        }
    }
}
