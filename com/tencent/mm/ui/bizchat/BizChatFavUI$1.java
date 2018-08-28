package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ac.a.b.a;
import com.tencent.mm.ac.a.b.a.b;
import com.tencent.mm.sdk.platformtools.x;

class BizChatFavUI$1 implements a {
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$1(BizChatFavUI bizChatFavUI) {
        this.tEG = bizChatFavUI;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.dNg != null && BizChatFavUI.a(this.tEG).equals(bVar.dNg.field_brandUserName)) {
            x.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
            if (BizChatFavUI.b(this.tEG)) {
                BizChatFavUI.c(this.tEG).WT();
            }
        }
    }
}
