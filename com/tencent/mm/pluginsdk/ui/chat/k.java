package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.api.n;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class k extends n implements j {
    public final void l(EmojiInfo emojiInfo) {
        this.bxe.a(emojiInfo);
    }

    public final void m(EmojiInfo emojiInfo) {
    }

    public final boolean bcO() {
        return false;
    }

    public final boolean bcP() {
        return true;
    }

    public final void bcQ() {
        this.bxe.onHide();
    }
}
