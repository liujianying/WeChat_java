package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a.1;
import java.math.BigInteger;

class o$a$1$1 implements AnimationListener {
    final /* synthetic */ 1 nEz;

    o$a$1$1(1 1) {
        this.nEz = 1;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        long longValue = new BigInteger((String) this.nEz.nEx.getTag()).longValue();
        if (longValue >= 3) {
            Animation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
            alphaAnimation.setDuration((long) this.nEz.nEy.nEu);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setAnimationListener(new 1(this));
            this.nEz.nEx.startAnimation(alphaAnimation);
            return;
        }
        this.nEz.nEx.setTag(String.valueOf(longValue + 1));
        a.a(this.nEz.nEy, this.nEz.nEx);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
