package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;

class EmojiStoreV2DesignerUI$7 implements OnCancelListener {
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;

    EmojiStoreV2DesignerUI$7(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.ipH = emojiStoreV2DesignerUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (EmojiStoreV2DesignerUI.o(this.ipH) != null) {
            au.DF().c(EmojiStoreV2DesignerUI.o(this.ipH));
        }
    }
}
