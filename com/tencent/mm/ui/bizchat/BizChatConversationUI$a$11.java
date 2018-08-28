package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ac.a.b.a;
import com.tencent.mm.ac.a.b.a.b;
import com.tencent.mm.sdk.platformtools.x;

class BizChatConversationUI$a$11 implements a {
    final /* synthetic */ BizChatConversationUI.a tEC;

    BizChatConversationUI$a$11(BizChatConversationUI.a aVar) {
        this.tEC = aVar;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.dNg != null && BizChatConversationUI.a.a(this.tEC).equals(bVar.dNg.field_brandUserName)) {
            x.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.a.b(this.tEC).gr(bVar.dNf);
            if (BizChatConversationUI.a.q(this.tEC)) {
                BizChatConversationUI.a.b(this.tEC).WT();
            }
        }
    }
}
