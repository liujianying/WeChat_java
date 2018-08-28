package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class EmojiAddCustomDialogUI$5 implements OnDismissListener {
    final /* synthetic */ EmojiAddCustomDialogUI ilg;

    EmojiAddCustomDialogUI$5(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        this.ilg = emojiAddCustomDialogUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.ilg.finish();
    }
}
