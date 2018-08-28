package com.tencent.mm.plugin.emoji.ui;

class EmojiStoreDetailUI$2 implements Runnable {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$2(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void run() {
        EmojiStoreDetailUI.m(this.inz).fullScroll(130);
    }
}
