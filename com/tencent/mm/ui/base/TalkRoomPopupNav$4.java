package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class TalkRoomPopupNav$4 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav tBl;

    public TalkRoomPopupNav$4(TalkRoomPopupNav talkRoomPopupNav) {
        this.tBl = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        TalkRoomPopupNav.c(this.tBl).startAnimation(AnimationUtils.loadAnimation(this.tBl.getContext(), R.a.fast_faded_in));
        TalkRoomPopupNav.c(this.tBl).setVisibility(0);
    }
}
