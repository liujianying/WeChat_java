package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$7 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav tBl;

    TalkRoomPopupNav$7(TalkRoomPopupNav talkRoomPopupNav) {
        this.tBl = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        TalkRoomPopupNav.c(this.tBl).setVisibility(4);
        TalkRoomPopupNav.e(this.tBl).setVisibility(4);
    }
}
