package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.ui.g.1;

class g$1$1 implements AnimatorUpdateListener {
    final /* synthetic */ ViewParent gut;
    final /* synthetic */ 1 gwK;

    g$1$1(1 1, ViewParent viewParent) {
        this.gwK = 1;
        this.gut = viewParent;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int argb = Color.argb(intValue, 255, 255, 255);
        g.a(this.gwK.gwJ).setBackgroundColor(argb);
        this.gwK.gwJ.setStatusBarColor(argb);
        if (intValue == 0) {
            this.gwK.gwJ.setVisibility(8);
            ((ViewGroup) this.gut).removeView(this.gwK.gwJ);
            g.b(this.gwK.gwJ);
        }
    }
}
