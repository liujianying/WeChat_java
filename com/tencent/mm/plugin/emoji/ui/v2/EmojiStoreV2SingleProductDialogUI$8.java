package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.emotion.EmojiInfo;

class EmojiStoreV2SingleProductDialogUI$8 implements Runnable {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI iqU;

    EmojiStoreV2SingleProductDialogUI$8(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.iqU = emojiStoreV2SingleProductDialogUI;
    }

    public final void run() {
        EmojiStoreV2SingleProductDialogUI.f(this.iqU).setVisibility(8);
        EmojiStoreV2SingleProductDialogUI.g(this.iqU).setVisibility(0);
        EmojiStoreV2SingleProductDialogUI.a(this.iqU, i.aEA().igx.Zy(EmojiStoreV2SingleProductDialogUI.a(this.iqU).rwk));
        if (EmojiStoreV2SingleProductDialogUI.h(this.iqU) == null || (EmojiStoreV2SingleProductDialogUI.h(this.iqU).field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
            EmojiStoreV2SingleProductDialogUI.g(this.iqU).setImageFilePath(EmojiStoreV2SingleProductDialogUI.i(this.iqU));
        } else {
            EmojiStoreV2SingleProductDialogUI.g(this.iqU).g(((c) g.n(c.class)).getEmojiMgr().a(EmojiStoreV2SingleProductDialogUI.h(this.iqU)), "");
        }
        EmojiStoreV2SingleProductDialogUI.j(this.iqU);
        EmojiStoreV2SingleProductDialogUI.k(this.iqU).setEnabled(true);
        EmojiStoreV2SingleProductDialogUI.k(this.iqU).setTextColor(this.iqU.getResources().getColor(R.e.green_text_color));
    }
}
