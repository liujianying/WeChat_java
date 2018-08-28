package com.tencent.mm.plugin.emoji.ui;

class EmojiStoreVpHeader$1 implements Runnable {
    final /* synthetic */ EmojiStoreVpHeader inS;

    EmojiStoreVpHeader$1(EmojiStoreVpHeader emojiStoreVpHeader) {
        this.inS = emojiStoreVpHeader;
    }

    public final void run() {
        if (EmojiStoreVpHeader.a(this.inS) != null && EmojiStoreVpHeader.b(this.inS) != null) {
            EmojiStoreVpHeader.a(this.inS).setData(EmojiStoreVpHeader.b(this.inS));
        }
    }
}
