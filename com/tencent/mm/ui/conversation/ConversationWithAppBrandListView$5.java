package com.tencent.mm.ui.conversation;

class ConversationWithAppBrandListView$5 implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView upB;
    final /* synthetic */ boolean upE;

    ConversationWithAppBrandListView$5(ConversationWithAppBrandListView conversationWithAppBrandListView, boolean z) {
        this.upB = conversationWithAppBrandListView;
        this.upE = z;
    }

    public final void run() {
        this.upB.setSelection(0);
        this.upB.postDelayed(new 1(this), 666);
    }
}
