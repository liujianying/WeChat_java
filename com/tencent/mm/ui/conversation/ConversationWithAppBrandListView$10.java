package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ConversationWithAppBrandListView$10 implements AnimatorUpdateListener {
    final /* synthetic */ ConversationWithAppBrandListView upB;

    ConversationWithAppBrandListView$10(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ConversationWithAppBrandListView.k(this.upB).setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
        this.upB.invalidate();
    }
}
