package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a;

class o$a$1 implements AnimationListener {
    final /* synthetic */ ImageView nEx;
    final /* synthetic */ a nEy;

    o$a$1(a aVar, ImageView imageView) {
        this.nEy = aVar;
        this.nEx = imageView;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(-5.0f, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration((long) this.nEy.nEt);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        translateAnimation.setStartTime((long) this.nEy.nEt);
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.3f, 0.8f);
        translateAnimation.setDuration((long) this.nEy.nEt);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        translateAnimation.setStartTime((long) this.nEy.nEt);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new 1(this));
        this.nEx.startAnimation(animationSet);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
