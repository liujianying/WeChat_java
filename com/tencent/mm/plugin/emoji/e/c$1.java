package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$1 implements Runnable {
    final /* synthetic */ EmojiInfo ifm;
    final /* synthetic */ c ifn;

    c$1(c cVar, EmojiInfo emojiInfo) {
        this.ifn = cVar;
        this.ifm = emojiInfo;
    }

    public final void run() {
        if (this.ifm != null && !this.ifm.cnE()) {
            x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", new Object[]{this.ifm.Xh()});
            c.a(this.ifm, true);
        }
    }
}
