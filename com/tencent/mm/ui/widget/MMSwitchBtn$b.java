package com.tencent.mm.ui.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class MMSwitchBtn$b extends Animation {
    int direction;
    float uHa;
    long uHb;
    final /* synthetic */ MMSwitchBtn uHc;

    /* synthetic */ MMSwitchBtn$b(MMSwitchBtn mMSwitchBtn, byte b) {
        this(mMSwitchBtn);
    }

    private MMSwitchBtn$b(MMSwitchBtn mMSwitchBtn) {
        this.uHc = mMSwitchBtn;
        this.direction = 0;
        this.uHa = 0.0f;
        this.uHb = 0;
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(new 1(this, mMSwitchBtn));
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (this.direction == 0) {
            MMSwitchBtn.d(this.uHc).left = this.uHa - (((float) this.uHb) * f);
        } else {
            MMSwitchBtn.d(this.uHc).left = this.uHa + (((float) this.uHb) * f);
        }
        MMSwitchBtn.e(this.uHc);
        this.uHc.invalidate();
    }
}
