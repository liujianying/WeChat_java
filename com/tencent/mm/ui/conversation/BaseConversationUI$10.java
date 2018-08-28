package com.tencent.mm.ui.conversation;

import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ai;

class BaseConversationUI$10 implements Runnable {
    final /* synthetic */ BaseConversationUI unn;

    BaseConversationUI$10(BaseConversationUI baseConversationUI) {
        this.unn = baseConversationUI;
    }

    public final void run() {
        d.b(4, "ChattingUI" + BaseConversationUI.access$000(this.unn), BaseConversationUI.access$100(this.unn).hashCode());
        d.h("ChattingUI" + BaseConversationUI.access$000(this.unn), BaseConversationUI.access$400(this.unn), ai.VE());
        d.b(3, this.unn.getLocalClassName(), this.unn.hashCode());
    }
}
