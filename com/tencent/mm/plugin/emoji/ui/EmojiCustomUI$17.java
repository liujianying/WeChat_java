package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class EmojiCustomUI$17 extends ag {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$17(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                EmojiCustomUI.g(this.ilG);
                return;
            case 1002:
                i.aEx();
                if (!BKGLoaderManager.aDK()) {
                    return;
                }
                if (i.aEx().aEU() == a.ijg) {
                    EmojiCustomUI.a(this.ilG, true);
                    return;
                } else {
                    EmojiCustomUI.a(this.ilG, false);
                    return;
                }
            case 1003:
                EmojiCustomUI.h(this.ilG).setVisibility(8);
                EmojiCustomUI.e(this.ilG).notifyDataSetChanged();
                return;
            case 1004:
                if (EmojiCustomUI.e(this.ilG) != null) {
                    EmojiCustomUI.e(this.ilG).aFM();
                    EmojiCustomUI.e(this.ilG).notifyDataSetChanged();
                }
                EmojiCustomUI.aFJ();
                return;
            default:
                x.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
                return;
        }
    }
}
