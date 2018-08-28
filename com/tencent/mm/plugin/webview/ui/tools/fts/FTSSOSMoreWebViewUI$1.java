package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FTSSOSMoreWebViewUI$1 implements OnTouchListener {
    final /* synthetic */ FTSSOSMoreWebViewUI qeH;

    FTSSOSMoreWebViewUI$1(FTSSOSMoreWebViewUI fTSSOSMoreWebViewUI) {
        this.qeH = fTSSOSMoreWebViewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.qeH.bXk().jzo.clearFocus();
        this.qeH.YC();
        return false;
    }
}
