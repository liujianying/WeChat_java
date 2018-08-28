package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class EmojiAddCustomDialogUI$8 implements OnDismissListener {
    final /* synthetic */ EmojiAddCustomDialogUI ilg;

    EmojiAddCustomDialogUI$8(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        this.ilg = emojiAddCustomDialogUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.ilg.finish();
    }
}
