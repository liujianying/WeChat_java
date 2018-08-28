package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class FTSSOSHomeWebViewUI$9 implements AnimatorListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$9(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        FTSSOSHomeWebViewUI.C(this.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.D(this.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.E(this.qeq);
    }

    public final void onAnimationCancel(Animator animator) {
        FTSSOSHomeWebViewUI.C(this.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.D(this.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.E(this.qeq);
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
