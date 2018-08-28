package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7;

class SnsCommentFooter$7$1 implements AnimationListener {
    final /* synthetic */ 7 nVS;

    SnsCommentFooter$7$1(7 7) {
        this.nVS = 7;
    }

    public final void onAnimationEnd(Animation animation) {
        SnsCommentFooter.m(this.nVS.nVN).setImageResource(e.chatting_setmode_heart_btn);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
