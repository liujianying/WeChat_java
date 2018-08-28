package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class WebViewStubTempUI$1 extends ResultReceiver {
    final /* synthetic */ OnClickListener pVa;
    final /* synthetic */ OnClickListener pVb;

    WebViewStubTempUI$1(Handler handler, OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.pVa = onClickListener;
        this.pVb = onClickListener2;
        super(handler);
    }

    protected final void onReceiveResult(int i, Bundle bundle) {
        switch (i) {
            case 0:
                this.pVa.onClick(null, 0);
                return;
            case 1:
                this.pVb.onClick(null, 0);
                return;
            default:
                return;
        }
    }
}
