package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class a$6 implements AnimatorUpdateListener {
    final /* synthetic */ a qfn;

    a$6(a aVar) {
        this.qfn = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (((double) Math.abs(floatValue - 1.0f)) <= 0.001d) {
            this.qfn.qeX.setX(this.qfn.qff[1][0]);
            this.qfn.qeX.setY(this.qfn.qff[0][0]);
            if (this.qfn.bXE()) {
                this.qfn.qeX.setPadding(0, 0, 0, 0);
            }
            LayoutParams layoutParams = (LayoutParams) this.qfn.qeX.getLayoutParams();
            layoutParams.leftMargin = this.qfn.qeT;
            layoutParams.rightMargin = this.qfn.qeT;
            layoutParams.width = (int) this.qfn.qff[2][0];
            this.qfn.qeX.setLayoutParams(layoutParams);
            this.qfn.qeX.setAlpha(1.0f);
            return;
        }
        this.qfn.qeX.setAlpha(1.0f - floatValue);
    }
}
