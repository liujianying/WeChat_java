package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class EmojiStoreV2SingleProductDialogUI$6 implements a {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI iqU;

    EmojiStoreV2SingleProductDialogUI$6(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.iqU = emojiStoreV2SingleProductDialogUI;
    }

    public final void h(EmojiInfo emojiInfo) {
        if (emojiInfo == null || EmojiStoreV2SingleProductDialogUI.a(this.iqU) == null || !EmojiStoreV2SingleProductDialogUI.a(this.iqU).rwk.equals(emojiInfo.Xh())) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "somethings error.");
        } else {
            EmojiStoreV2SingleProductDialogUI.e(this.iqU);
        }
    }
}
