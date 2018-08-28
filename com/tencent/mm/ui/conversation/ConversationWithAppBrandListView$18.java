package com.tencent.mm.ui.conversation;

class ConversationWithAppBrandListView$18 implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView upB;

    ConversationWithAppBrandListView$18(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final void run() {
        this.upB.smoothScrollToPositionFromTop(0, 0, 300);
    }
}
