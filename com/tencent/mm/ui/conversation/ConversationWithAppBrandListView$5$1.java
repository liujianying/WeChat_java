package com.tencent.mm.ui.conversation;

import com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.5;

class ConversationWithAppBrandListView$5$1 implements Runnable {
    final /* synthetic */ 5 upF;

    ConversationWithAppBrandListView$5$1(5 5) {
        this.upF = 5;
    }

    public final void run() {
        if (this.upF.upE) {
            ConversationWithAppBrandListView.c(this.upF.upB, true);
            ConversationWithAppBrandListView.h(this.upF.upB);
            this.upF.upB.postDelayed(new Runnable() {
                public final void run() {
                    ConversationWithAppBrandListView.c(ConversationWithAppBrandListView$5$1.this.upF.upB, false);
                }
            }, 2000);
            return;
        }
        ConversationWithAppBrandListView.g(this.upF.upB);
    }
}
