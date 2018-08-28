package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSSOSHomeWebViewUI$11 implements OnTouchListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$11(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.qeq.bXk().jzo.clearFocus();
        this.qeq.YC();
        return false;
    }
}
