package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class ConversationWithAppBrandListView$a implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView upB;

    ConversationWithAppBrandListView$a(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final void run() {
        View childAt = this.upB.getChildAt(0);
        if (this.upB.getFirstVisiblePosition() == 0 && childAt != null && childAt.getTop() < 0) {
            x.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
            if (((float) childAt.getBottom()) >= ConversationWithAppBrandListView.p(this.upB)) {
                ConversationWithAppBrandListView.q(this.upB);
            } else {
                ConversationWithAppBrandListView.r(this.upB);
            }
        }
    }
}
