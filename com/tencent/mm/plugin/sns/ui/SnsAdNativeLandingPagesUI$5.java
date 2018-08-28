package com.tencent.mm.plugin.sns.ui;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.plugin.sns.ui.b.2;
import java.util.Iterator;
import java.util.LinkedList;

class SnsAdNativeLandingPagesUI$5 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$5(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void run() {
        SnsAdNativeLandingPagesUI.N(this.nSR);
        SnsAdNativeLandingPagesUI.O(this.nSR);
        this.nSR.nSb.u(SnsAdNativeLandingPagesUI.P(this.nSR), SnsAdNativeLandingPagesUI.Q(this.nSR), SnsAdNativeLandingPagesUI.R(this.nSR), SnsAdNativeLandingPagesUI.S(this.nSR));
        b bVar = this.nSR.nSb;
        View T = SnsAdNativeLandingPagesUI.T(this.nSR);
        LinkedList U = SnsAdNativeLandingPagesUI.U(this.nSR);
        View V = SnsAdNativeLandingPagesUI.V(this.nSR);
        1 1 = new 1(this);
        if (VERSION.SDK_INT >= 12 && T != null && bVar.nKj != bVar.nKg && bVar.nKj != bVar.nKi && bVar.nKj != bVar.nKf) {
            T.getLocationOnScreen(new int[2]);
            bVar.j(T, true);
            if (V != null) {
                V.animate().setDuration(300).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
            }
            Animation animationSet = new AnimationSet(true);
            2 2 = new 2(bVar, bVar.nJW, bVar.nJW, T);
            2.setDuration(300);
            2.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(2);
            Animation translateAnimation = new TranslateAnimation(0.0f, (float) bVar.nJU, 0.0f, (float) bVar.nJV);
            translateAnimation.setDuration(300);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(new b$3(bVar, 1));
            T.startAnimation(animationSet);
            Iterator it = U.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(0.0f);
            }
        }
    }
}
