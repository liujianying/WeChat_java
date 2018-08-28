package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LuckyAvatarParticleView$1 implements AnimatorUpdateListener {
    final /* synthetic */ LuckyAvatarParticleView kNC;

    LuckyAvatarParticleView$1(LuckyAvatarParticleView luckyAvatarParticleView) {
        this.kNC = luckyAvatarParticleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 1.0f) {
            LuckyAvatarParticleView.a(this.kNC).clear();
            LuckyAvatarParticleView.b(this.kNC).clear();
            LuckyAvatarParticleView.c(this.kNC).clear();
        } else if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 0.0f) {
            LuckyAvatarParticleView.d(this.kNC);
        } else {
            for (int i = 0; i < LuckyAvatarParticleView.a(this.kNC).size(); i++) {
                LuckyAvatarParticleView.a(this.kNC, i);
            }
        }
        this.kNC.invalidate();
    }
}
