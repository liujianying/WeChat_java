package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsoluteLayout;
import android.widget.RelativeLayout.LayoutParams;

class FTSSOSHomeWebViewUI$10 implements OnGlobalLayoutListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$10(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final void onGlobalLayout() {
        if (FTSSOSHomeWebViewUI.b(this.qeq).getHeight() > 0) {
            FTSSOSHomeWebViewUI.c(this.qeq).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.qeq.qeQ.countDown();
            if (this.qeq.qdi.getLayoutParams() instanceof LayoutParams) {
                FTSSOSHomeWebViewUI.b(this.qeq, ((LayoutParams) this.qeq.qdi.getLayoutParams()).topMargin);
            }
            if (FTSSOSHomeWebViewUI.c(this.qeq).getLayoutParams() instanceof LayoutParams) {
                FTSSOSHomeWebViewUI.c(this.qeq, ((LayoutParams) FTSSOSHomeWebViewUI.c(this.qeq).getLayoutParams()).topMargin);
                if (this.qeq.qeP && FTSSOSHomeWebViewUI.d(this.qeq).getTopView() != null && (FTSSOSHomeWebViewUI.e(this.qeq).getTopView() instanceof AbsoluteLayout)) {
                    ((ViewGroup) FTSSOSHomeWebViewUI.c(this.qeq).getParent()).removeView(FTSSOSHomeWebViewUI.c(this.qeq));
                    ((AbsoluteLayout) FTSSOSHomeWebViewUI.g(this.qeq).getTopView()).addView(FTSSOSHomeWebViewUI.c(this.qeq), new AbsoluteLayout.LayoutParams(-1, -2, 0, FTSSOSHomeWebViewUI.f(this.qeq) - FTSSOSHomeWebViewUI.b(this.qeq).getHeight()));
                }
            }
            FTSSOSHomeWebViewUI.h(this.qeq);
        }
    }
}
