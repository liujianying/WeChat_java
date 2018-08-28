package com.tencent.mm.plugin.emoji.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class EmojiBaseActivity$a extends ag {
    final /* synthetic */ EmojiBaseActivity ilj;

    EmojiBaseActivity$a(EmojiBaseActivity emojiBaseActivity, Looper looper) {
        this.ilj = emojiBaseActivity;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        this.ilj.k(message);
    }
}
