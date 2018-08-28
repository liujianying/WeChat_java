package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;

class EmojiStoreTopicUI$2 implements i {
    final /* synthetic */ EmojiStoreTopicUI inJ;

    EmojiStoreTopicUI$2(EmojiStoreTopicUI emojiStoreTopicUI) {
        this.inJ = emojiStoreTopicUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        EmojiStoreTopicUI emojiStoreTopicUI = this.inJ;
        if (emojiStoreTopicUI.ili != null) {
            emojiStoreTopicUI.ili.sendEmptyMessage(1009);
        }
    }
}
