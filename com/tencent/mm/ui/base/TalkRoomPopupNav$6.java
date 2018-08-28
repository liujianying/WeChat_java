package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$6 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav tBl;

    TalkRoomPopupNav$6(TalkRoomPopupNav talkRoomPopupNav) {
        this.tBl = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
        TalkRoomPopupNav.c(this.tBl).setVisibility(4);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        TalkRoomPopupNav.e(this.tBl).setVisibility(8);
        TalkRoomPopupNav.d(this.tBl).setClickable(true);
    }
}
