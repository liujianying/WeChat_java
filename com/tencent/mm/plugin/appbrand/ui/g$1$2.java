package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.ui.g.1;

class g$1$2 implements AnimatorUpdateListener {
    final /* synthetic */ 1 gwK;

    g$1$2(1 1) {
        this.gwK = 1;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gwK.gwJ.guo.setTextColor(Color.argb(Math.round(255.0f * floatValue), 0, 0, 0));
        this.gwK.gwJ.gtb.setAlpha(floatValue);
        this.gwK.gwJ.gum.setAlpha(floatValue);
        this.gwK.gwJ.gum.setScaleY(floatValue);
        this.gwK.gwJ.gum.setScaleX(floatValue);
        if (floatValue == 0.0f) {
            g.b(this.gwK.gwJ);
        } else {
            this.gwK.gwJ.ar(-1, true);
        }
    }
}
