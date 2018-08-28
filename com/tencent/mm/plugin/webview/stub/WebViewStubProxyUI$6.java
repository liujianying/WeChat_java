package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class WebViewStubProxyUI$6 implements OnDismissListener {
    final /* synthetic */ WebViewStubProxyUI pUE;

    WebViewStubProxyUI$6(WebViewStubProxyUI webViewStubProxyUI) {
        this.pUE = webViewStubProxyUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (!this.pUE.isFinishing()) {
            this.pUE.finish();
        }
    }
}
