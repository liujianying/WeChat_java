package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreVpHeader$a extends ag {
    final /* synthetic */ EmojiStoreVpHeader inS;

    private EmojiStoreVpHeader$a(EmojiStoreVpHeader emojiStoreVpHeader) {
        this.inS = emojiStoreVpHeader;
    }

    /* synthetic */ EmojiStoreVpHeader$a(EmojiStoreVpHeader emojiStoreVpHeader, byte b) {
        this(emojiStoreVpHeader);
    }

    public final void handleMessage(Message message) {
        if (!EmojiStoreVpHeader.d(this.inS) && message.what != 0) {
            return;
        }
        if (EmojiStoreVpHeader.b(this.inS) == null || EmojiStoreVpHeader.b(this.inS).size() <= 1) {
            x.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
        } else if (EmojiStoreVpHeader.a(this.inS) == null) {
            x.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
        } else {
            int currentItem = EmojiStoreVpHeader.e(this.inS).getCurrentItem() + 1;
            if (currentItem >= EmojiStoreVpHeader.a(this.inS).getCount()) {
                currentItem = (EmojiStoreVpHeader.b(this.inS).size() * i.ied) / 2;
            }
            EmojiStoreVpHeader.e(this.inS).setCurrentItem(currentItem);
            if (EmojiStoreVpHeader.d(this.inS) && EmojiStoreVpHeader.f(this.inS) != null) {
                sendMessageDelayed(EmojiStoreVpHeader.f(this.inS).obtainMessage(0), 5000);
            }
        }
    }
}
