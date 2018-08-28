package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.c.a;

class EmojiCustomUI$14 extends a {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$14(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final void aEZ() {
        EmojiCustomUI.a(this.ilG, i.aEx().aEU());
        if (EmojiCustomUI.f(this.ilG) != null) {
            EmojiCustomUI.f(this.ilG).sendEmptyMessage(1001);
        }
    }

    public final void aFa() {
        if (EmojiCustomUI.f(this.ilG) != null) {
            EmojiCustomUI.f(this.ilG).sendEmptyMessage(1002);
        }
    }
}
