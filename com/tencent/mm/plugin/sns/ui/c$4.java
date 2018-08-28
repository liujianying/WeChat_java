package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;

class c$4 extends Animation {
    final /* synthetic */ c nKx;
    final /* synthetic */ int nKy;
    final /* synthetic */ int nKz;

    c$4(c cVar, int i, int i2) {
        this.nKx = cVar;
        this.nKy = i;
        this.nKz = i2;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        ((LayoutParams) this.nKx.nKv.getLayoutParams()).bottomMargin = f == 1.0f ? 0 : (int) (((float) (this.nKy - this.nKz)) * (1.0f - f));
        this.nKx.nKv.requestLayout();
    }

    public final boolean willChangeBounds() {
        return true;
    }
}
