package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;

class WebViewStubTempUI$3 implements OnClickListener {
    final /* synthetic */ ResultReceiver pVc;
    final /* synthetic */ WebViewStubTempUI pVd;

    WebViewStubTempUI$3(WebViewStubTempUI webViewStubTempUI, ResultReceiver resultReceiver) {
        this.pVd = webViewStubTempUI;
        this.pVc = resultReceiver;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pVc.send(1, null);
        this.pVd.finish();
    }
}
