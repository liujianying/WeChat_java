package com.tencent.mm.plugin.emoji.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class EmojiBaseActivity$b extends ag {
    final /* synthetic */ EmojiBaseActivity ilj;

    EmojiBaseActivity$b(EmojiBaseActivity emojiBaseActivity, Looper looper) {
        this.ilj = emojiBaseActivity;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        this.ilj.l(message);
    }
}
