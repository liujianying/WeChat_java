package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;

class EmojiCustomUI$13 implements a {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$13(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final void a(String str, l lVar) {
        if (!bi.oW(str)) {
            if ((str.length() == 32 || str.equals("event_update_emoji")) && EmojiCustomUI.e(this.ilG) != null) {
                EmojiCustomUI.e(this.ilG).aFM();
                EmojiCustomUI.e(this.ilG).notifyDataSetChanged();
            }
        }
    }
}
