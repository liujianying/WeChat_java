package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import com.tencent.mm.plugin.webview.modeltools.f.c;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$28 implements c {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$28(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void ug(String str) {
        try {
            if (this.pZJ.gcO != null) {
                this.pZJ.gcO.c(str, null);
            } else {
                x.i("MicroMsg.WebViewUI", "viewCaptureCallback, invoker is null");
            }
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "recog failed");
        }
    }
}
