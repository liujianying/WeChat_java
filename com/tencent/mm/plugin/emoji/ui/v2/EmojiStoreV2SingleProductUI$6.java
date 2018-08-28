package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class EmojiStoreV2SingleProductUI$6 extends c<cs> {
    final /* synthetic */ EmojiStoreV2SingleProductUI irx;

    EmojiStoreV2SingleProductUI$6(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.irx = emojiStoreV2SingleProductUI;
        this.sFo = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(EmojiStoreV2SingleProductUI.c(this.irx) == null || EmojiStoreV2SingleProductUI.d(this.irx) == null)) {
            EmojiStoreV2SingleProductUI.d(this.irx).post(new 1(this));
        }
        return false;
    }
}
