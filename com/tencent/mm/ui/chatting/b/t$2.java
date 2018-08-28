package com.tencent.mm.ui.chatting.b;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.ac;

class t$2 implements Runnable {
    final /* synthetic */ t tQI;

    t$2(t tVar) {
        this.tQI = tVar;
    }

    public final void run() {
        x.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
        t.b(this.tQI).setVisibility(0);
        t.a(this.tQI, 1);
        if (((ac) this.tQI.bAG.O(ac.class)).cwb()) {
            this.tQI.Fb(1);
        } else if (t.c(this.tQI)) {
            this.tQI.Fb(3);
        } else {
            this.tQI.Fb(0);
        }
        Animation translateAnimation = new TranslateAnimation((float) t.b(this.tQI).getWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.tQI.bAG.tTq.getContext(), 17432581));
        t.b(this.tQI).startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                t.b(t$2.this.tQI).setClickable(false);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                t.b(t$2.this.tQI).setClickable(true);
            }
        });
    }
}
