package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.rtmp.TXLiveConstants;

class EmojiAddCustomDialogUI$1 extends ag {
    final /* synthetic */ EmojiAddCustomDialogUI ilg;

    EmojiAddCustomDialogUI$1(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        this.ilg = emojiAddCustomDialogUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case TXLiveConstants.PUSH_EVT_CONNECT_SUCC /*1001*/:
                EmojiAddCustomDialogUI.a(this.ilg, this.ilg.getString(R.l.emoji_store_watting_add));
                return;
            default:
                return;
        }
    }
}
