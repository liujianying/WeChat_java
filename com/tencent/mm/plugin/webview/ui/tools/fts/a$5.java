package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class a$5 implements AnimatorUpdateListener {
    final /* synthetic */ a qfn;

    a$5(a aVar) {
        this.qfn = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = ((this.qfn.qff[0][0] - this.qfn.qff[0][1]) * floatValue) + this.qfn.qff[0][1];
        this.qfn.qeX.setX(((this.qfn.qff[1][0] - this.qfn.qff[1][1]) * floatValue) + this.qfn.qff[1][1]);
        this.qfn.qeX.setY(f);
        if (this.qfn.bXE()) {
            this.qfn.qeX.setPadding((int) ((((float) (this.qfn.qeV - this.qfn.qeW)) * floatValue) + ((float) this.qfn.qeW)), 0, 0, 0);
        }
        LayoutParams layoutParams = (LayoutParams) this.qfn.qeX.getLayoutParams();
        int i = (int) (floatValue * ((float) this.qfn.qeT));
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.width = ((this.qfn.qeT - i) * 2) + ((int) this.qfn.qff[2][0]);
        this.qfn.qeX.setLayoutParams(layoutParams);
    }
}
