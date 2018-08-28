package com.tencent.mm.ui.bizchat;

import com.tencent.mm.model.r;
import com.tencent.mm.ui.r.a;

class BizChatFavUI$9 implements a {
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$9(BizChatFavUI bizChatFavUI) {
        this.tEG = bizChatFavUI;
    }

    public final void Xb() {
        this.tEG.setMMTitle(r.gT(BizChatFavUI.a(this.tEG)));
        if (BizChatFavUI.c(this.tEG).getCount() <= 0) {
            BizChatFavUI.d(this.tEG).setVisibility(0);
            BizChatFavUI.e(this.tEG).setVisibility(8);
            return;
        }
        BizChatFavUI.d(this.tEG).setVisibility(8);
        BizChatFavUI.e(this.tEG).setVisibility(0);
    }

    public final void Xa() {
    }
}
