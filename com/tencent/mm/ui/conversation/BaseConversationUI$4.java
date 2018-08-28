package com.tencent.mm.ui.conversation;

import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ai;

class BaseConversationUI$4 implements Runnable {
    final /* synthetic */ boolean unm;
    final /* synthetic */ BaseConversationUI unn;

    BaseConversationUI$4(BaseConversationUI baseConversationUI, boolean z) {
        this.unn = baseConversationUI;
        this.unm = z;
    }

    public final void run() {
        d.b(4, this.unm ? "ChattingUI" + BaseConversationUI.access$000(this.unn) : this.unn.getLocalClassName(), this.unm ? BaseConversationUI.access$100(this.unn).hashCode() : this.unn.hashCode());
        if (this.unm) {
            d.h("ChattingUI" + BaseConversationUI.access$000(this.unn), BaseConversationUI.access$400(this.unn), ai.VE());
        }
    }
}
