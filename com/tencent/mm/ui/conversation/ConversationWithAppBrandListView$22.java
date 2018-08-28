package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class ConversationWithAppBrandListView$22 implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView upB;

    ConversationWithAppBrandListView$22(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final void run() {
        View childAt = this.upB.getChildAt(0);
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: " + (childAt == null ? 0 : childAt.getBottom()));
        this.upB.smoothScrollToPositionFromTop(this.upB.getFirstHeaderVisible(), 0, 300);
        ConversationWithAppBrandListView.o(this.upB);
    }
}
