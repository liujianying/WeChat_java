package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.h;

class EmojiCustomUI$8 implements OnClickListener {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$8(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BKGLoaderManager bKGLoaderManager = i.aEx().ije;
        bKGLoaderManager.ijr = true;
        bKGLoaderManager.aEV();
        h.mEJ.h(11595, new Object[]{Integer.valueOf(1)});
    }
}
