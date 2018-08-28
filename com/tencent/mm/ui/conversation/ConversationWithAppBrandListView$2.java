package com.tencent.mm.ui.conversation;

import android.support.v7.widget.RecyclerView.c;

class ConversationWithAppBrandListView$2 extends c {
    final /* synthetic */ ConversationWithAppBrandListView upB;

    ConversationWithAppBrandListView$2(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final void ad(int i, int i2) {
        super.ad(i, i2);
        if (ConversationWithAppBrandListView.c(this.upB).getAdapter().getItemCount() == 1) {
            ConversationWithAppBrandListView.b(this.upB, true);
        } else {
            ConversationWithAppBrandListView.b(this.upB, false);
        }
    }
}
