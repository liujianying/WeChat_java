package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ConversationWithAppBrandListView$7 implements AnimatorListener {
    final /* synthetic */ ConversationWithAppBrandListView upB;

    ConversationWithAppBrandListView$7(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        ConversationWithAppBrandListView.i(this.upB);
    }

    public final void onAnimationCancel(Animator animator) {
        ConversationWithAppBrandListView.i(this.upB);
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
