package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ac.a.d.a;
import com.tencent.mm.ac.a.d.a.b;
import com.tencent.mm.sdk.platformtools.x;

class BizChatConversationUI$a$13 implements a {
    final /* synthetic */ BizChatConversationUI.a tEC;

    BizChatConversationUI$a$13(BizChatConversationUI.a aVar) {
        this.tEC = aVar;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.dNq != null && BizChatConversationUI.a.a(this.tEC).equals(bVar.dNq.field_brandUserName)) {
            x.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.a.b(this.tEC).gr(bVar.dNf);
            if (BizChatConversationUI.a.q(this.tEC)) {
                BizChatConversationUI.a.b(this.tEC).WT();
            }
        }
    }
}
