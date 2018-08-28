package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$8 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav tBl;

    public TalkRoomPopupNav$8(TalkRoomPopupNav talkRoomPopupNav) {
        this.tBl = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (TalkRoomPopupNav.f(this.tBl) != null) {
            TalkRoomPopupNav.g(this.tBl).startAnimation(TalkRoomPopupNav.f(this.tBl));
        }
    }
}
