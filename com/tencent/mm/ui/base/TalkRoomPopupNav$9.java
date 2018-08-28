package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$9 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav tBl;

    public TalkRoomPopupNav$9(TalkRoomPopupNav talkRoomPopupNav) {
        this.tBl = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (TalkRoomPopupNav.h(this.tBl) != null) {
            TalkRoomPopupNav.g(this.tBl).startAnimation(TalkRoomPopupNav.h(this.tBl));
        }
    }
}
