package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.ViewTreeObserver.OnPreDrawListener;

class FTSSOSHomeWebViewUI$14 implements OnPreDrawListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$14(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final boolean onPreDraw() {
        this.qeq.qdi.getViewTreeObserver().removeOnPreDrawListener(this);
        FTSSOSHomeWebViewUI.a(this.qeq, this.qeq.qdi.getX());
        return true;
    }
}
