package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;

class FTSSOSHomeWebViewUI$8 implements OnPreDrawListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$8(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final boolean onPreDraw() {
        FTSSOSHomeWebViewUI.C(this.qeq).getViewTreeObserver().removeOnPreDrawListener(this);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.C(this.qeq), View.TRANSLATION_Y, new float[]{(float) (-FTSSOSHomeWebViewUI.C(this.qeq).getHeight()), 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.D(this.qeq), View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(300);
        animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
        animatorSet.start();
        return true;
    }
}
