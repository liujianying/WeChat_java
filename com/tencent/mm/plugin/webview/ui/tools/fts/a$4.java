package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class a$4 implements AnimatorUpdateListener {
    final /* synthetic */ a qfn;

    a$4(a aVar) {
        this.qfn = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.qfn.qeX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.qfn.qeX.setX(this.qfn.qff[1][1]);
        this.qfn.qeX.setY(this.qfn.qff[0][1]);
        if (this.qfn.bXE()) {
            this.qfn.qeX.setPadding(this.qfn.qeW, 0, 0, 0);
        }
        LayoutParams layoutParams = (LayoutParams) this.qfn.qeX.getLayoutParams();
        if (layoutParams.leftMargin != 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.width = ((int) this.qfn.qff[2][0]) + (this.qfn.qeT * 2);
            this.qfn.qeX.setLayoutParams(layoutParams);
        }
    }
}
