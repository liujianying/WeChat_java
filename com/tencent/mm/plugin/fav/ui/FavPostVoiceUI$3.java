package com.tencent.mm.plugin.fav.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.plugin.fav.ui.m.e;

class FavPostVoiceUI$3 implements Runnable {
    final /* synthetic */ FavPostVoiceUI iZn;

    FavPostVoiceUI$3(FavPostVoiceUI favPostVoiceUI) {
        this.iZn = favPostVoiceUI;
    }

    public final void run() {
        this.iZn.findViewById(e.voice_rcd_hint).setVisibility(0);
        FavPostVoiceUI.d(this.iZn).setVisibility(0);
        this.iZn.findViewById(e.fav_post_voice_footer).setVisibility(0);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300);
        FavPostVoiceUI.d(this.iZn).startAnimation(alphaAnimation);
        this.iZn.findViewById(e.voice_rcd_hint).startAnimation(alphaAnimation);
        this.iZn.findViewById(e.fav_post_voice_footer).startAnimation(translateAnimation);
    }
}
