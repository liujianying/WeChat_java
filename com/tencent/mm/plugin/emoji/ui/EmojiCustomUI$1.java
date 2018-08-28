package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.model.i;

class EmojiCustomUI$1 implements OnClickListener {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$1(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final void onClick(View view) {
        switch (EmojiCustomUI$10.ilI[EmojiCustomUI.a(this.ilG).ordinal()]) {
            case 2:
                EmojiCustomUI.b(this.ilG);
                return;
            case 3:
                i.aEx().ije.aEW();
                return;
            default:
                return;
        }
    }
}
