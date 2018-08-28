package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.R;
import com.tencent.mm.ui.contact.LabelContainerView$a;

class EmojiStoreV2SingleProductUI$11 implements LabelContainerView$a {
    final /* synthetic */ EmojiStoreV2SingleProductUI irx;

    EmojiStoreV2SingleProductUI$11(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.irx = emojiStoreV2SingleProductUI;
    }

    public final void aGr() {
        if (EmojiStoreV2SingleProductUI.f(this.irx) != null) {
            EmojiStoreV2SingleProductUI.f(this.irx).clearFocus();
        }
        EmojiStoreV2SingleProductUI.f(this.irx).requestFocus();
        EmojiStoreV2SingleProductUI.f(this.irx).setVisibility(8);
        this.irx.showOptionMenu(1001, EmojiStoreV2SingleProductUI.g(this.irx));
        this.irx.setMMTitle(R.l.emoji_store_product_title);
    }

    public final void aGs() {
        this.irx.YC();
    }
}
