package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$2 implements Runnable {
    final /* synthetic */ EmojiInfo ifm;
    final /* synthetic */ c ifn;
    final /* synthetic */ Context val$context;

    c$2(c cVar, EmojiInfo emojiInfo, Context context) {
        this.ifn = cVar;
        this.ifm = emojiInfo;
        this.val$context = context;
    }

    public final void run() {
        if (this.ifm != null && !this.ifm.cnE()) {
            if (bi.oW(this.ifm.field_groupId)) {
                x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emoji broken. try to recover:%s", new Object[]{this.ifm.Xh()});
                c.a(this.ifm, false);
                return;
            }
            c.a(this.ifn, this.val$context, this.ifm);
        }
    }
}
