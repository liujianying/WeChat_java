package com.tencent.mm.ui.bizchat;

import com.tencent.mm.model.r;
import com.tencent.mm.ui.r.a;

class BizChatConversationUI$a$19 implements a {
    final /* synthetic */ BizChatConversationUI.a tEC;

    BizChatConversationUI$a$19(BizChatConversationUI.a aVar) {
        this.tEC = aVar;
    }

    public final void Xb() {
        this.tEC.setMMTitle(r.gT(BizChatConversationUI.a.a(this.tEC)));
        if (BizChatConversationUI.a.b(this.tEC).getCount() <= 0) {
            BizChatConversationUI.a.i(this.tEC).setVisibility(0);
            BizChatConversationUI.a.j(this.tEC).setVisibility(8);
            return;
        }
        BizChatConversationUI.a.i(this.tEC).setVisibility(8);
        if (BizChatConversationUI.a.j(this.tEC) != null) {
            BizChatConversationUI.a.j(this.tEC).setVisibility(0);
        }
    }

    public final void Xa() {
    }
}
