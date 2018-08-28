package com.tencent.mm.ui.chatting;

import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;

class y$8 implements Runnable {
    final /* synthetic */ y tMm;

    y$8(y yVar) {
        this.tMm = yVar;
    }

    public final void run() {
        boolean z = true;
        if (this.tMm.isCurrentActivity) {
            y.k(this.tMm);
        } else if (this.tMm.thisActivity() instanceof LauncherUI) {
            LauncherUI launcherUI = (LauncherUI) this.tMm.thisActivity();
            if (launcherUI != null) {
                if (this.tMm.isSupportNavigationSwipeBack()) {
                    z = false;
                }
                launcherUI.closeChatting(z);
            }
        } else if (this.tMm.thisActivity() instanceof BaseConversationUI) {
            BaseConversationUI baseConversationUI = (BaseConversationUI) this.tMm.thisActivity();
            if (baseConversationUI != null) {
                if (this.tMm.isSupportNavigationSwipeBack()) {
                    z = false;
                }
                baseConversationUI.closeChatting(z);
            }
        }
    }
}
