package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WebViewStubTempUI$4 implements OnCancelListener {
    final /* synthetic */ WebViewStubTempUI pVd;

    WebViewStubTempUI$4(WebViewStubTempUI webViewStubTempUI) {
        this.pVd = webViewStubTempUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.pVd.finish();
    }
}
