package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.21;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class EmojiStoreDetailUI$21$1 implements Runnable {
    final /* synthetic */ int hW;
    final /* synthetic */ EmojiInfo ifm;
    final /* synthetic */ 21 inA;

    EmojiStoreDetailUI$21$1(21 21, EmojiInfo emojiInfo, int i) {
        this.inA = 21;
        this.ifm = emojiInfo;
        this.hW = i;
    }

    public final void run() {
        EmojiDetailGridView q = EmojiStoreDetailUI.q(this.inA.inz);
        EmojiInfo emojiInfo = this.ifm;
        if (q.uTA == this.hW && q.uTB) {
            q.r(emojiInfo);
            return;
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "not show:%d, needData: %B, so do not refresh", new Object[]{Integer.valueOf(r2), Boolean.valueOf(q.uTB)});
    }
}
