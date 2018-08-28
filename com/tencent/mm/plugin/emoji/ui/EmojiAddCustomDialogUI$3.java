package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;

class EmojiAddCustomDialogUI$3 implements OnClickListener {
    final /* synthetic */ EmojiAddCustomDialogUI ilg;

    EmojiAddCustomDialogUI$3(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        this.ilg = emojiAddCustomDialogUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        h.mEJ.h(11596, new Object[]{Integer.valueOf(3)});
        intent.setClass(EmojiAddCustomDialogUI.f(this.ilg), EmojiCustomUI.class);
        this.ilg.startActivity(intent);
    }
}
