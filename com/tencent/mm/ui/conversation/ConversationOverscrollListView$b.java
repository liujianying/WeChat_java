package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;

public class ConversationOverscrollListView$b implements Runnable {
    final /* synthetic */ ConversationOverscrollListView uoU;

    public ConversationOverscrollListView$b(ConversationOverscrollListView conversationOverscrollListView) {
        this.uoU = conversationOverscrollListView;
    }

    public final void run() {
        if (ConversationOverscrollListView.a(this.uoU) != null && !ConversationOverscrollListView.a(this.uoU).cyK()) {
            x.d("MicroMsg.ConversationOverscrollListView", "jacks cancel to Show Main");
            ConversationOverscrollListView.a(this.uoU);
        }
    }
}
