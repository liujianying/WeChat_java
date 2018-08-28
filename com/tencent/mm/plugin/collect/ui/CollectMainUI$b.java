package com.tencent.mm.plugin.collect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;

class CollectMainUI$b {
    final /* synthetic */ CollectMainUI hYN;
    boolean hYX;
    LinkedList<a> hYY;

    private CollectMainUI$b(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
        this.hYY = new LinkedList();
    }

    /* synthetic */ CollectMainUI$b(CollectMainUI collectMainUI, byte b) {
        this(collectMainUI);
    }

    public final void aCy() {
        if (this.hYX) {
            x.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.hYY.size());
        } else if (!this.hYY.isEmpty()) {
            a aVar = (a) this.hYY.poll();
            this.hYX = true;
            CollectMainUI.l(this.hYN);
            CollectMainUI.o(this.hYN).setLayoutParams(new LayoutParams(CollectMainUI.j(this.hYN).getWidth(), CollectMainUI.j(this.hYN).getHeight()));
            if (this.hYN.hYo) {
                CollectMainUI.o(this.hYN).setPadding(0, CollectMainUI.aCu(), 0, 0);
            } else {
                CollectMainUI.o(this.hYN).setPadding(0, CollectMainUI.aCv(), 0, 0);
            }
            CollectMainUI.p(this.hYN).setText(j.a(this.hYN.mController.tml, aVar.daA, CollectMainUI.p(this.hYN).getTextSize()));
            b.a(CollectMainUI.q(this.hYN), aVar.username);
            CollectMainUI.r(this.hYN).setText(e.e(aVar.hUL, aVar.bJg));
            CollectMainUI.o(this.hYN).setVisibility(0);
            final AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= CollectMainUI.s(this.hYN).size()) {
                    break;
                }
                if (((a) CollectMainUI.s(this.hYN).get(i3)).bOe.equals(aVar.bOe)) {
                    i = i3;
                }
                i2 = i3 + 1;
            }
            float aBd = (float) CollectMainUI.aBd();
            float height = 0.0f + ((float) (CollectMainUI.j(this.hYN).getHeight() / 2));
            if (CollectMainUI.n(this.hYN).getVisibility() == 0) {
                height += (float) CollectMainUI.n(this.hYN).getHeight();
            }
            height += (float) ((i * CollectMainUI.aCt()) + (CollectMainUI.aCt() / 2));
            int[] iArr = new int[2];
            CollectMainUI.j(this.hYN).getLocationInWindow(iArr);
            animationSet.addAnimation(new TranslateAnimation(0.0f, aBd, 0.0f, (float) ((int) (height + ((float) (iArr[1] - CollectMainUI.arl()))))));
            animationSet.setDuration(300);
            animationSet.setInterpolator(new DecelerateInterpolator());
            animationSet.setAnimationListener(new 1(this, aVar));
            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new LinearInterpolator());
            scaleAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationEnd(Animation animation) {
                    animationSet.setStartOffset(1700);
                    CollectMainUI.o(CollectMainUI$b.this.hYN).startAnimation(animationSet);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                    CollectMainUI.o(CollectMainUI$b.this.hYN).setVisibility(0);
                }
            });
            CollectMainUI.o(this.hYN).startAnimation(scaleAnimation);
        }
    }
}
