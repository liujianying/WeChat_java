package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class EmojiStoreV2SingleProductDialogUI$1 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI iqU;

    EmojiStoreV2SingleProductDialogUI$1(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.iqU = emojiStoreV2SingleProductDialogUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EmojiStoreV2SingleProductDialogUI.a(this.iqU, EmojiStoreV2SingleProductDialogUI.a(this.iqU));
        h hVar = h.mEJ;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(EmojiStoreV2SingleProductDialogUI.b(this.iqU));
        objArr[1] = Integer.valueOf(2);
        objArr[2] = EmojiStoreV2SingleProductDialogUI.a(this.iqU) == null ? "" : EmojiStoreV2SingleProductDialogUI.a(this.iqU).rwk;
        objArr[3] = Long.valueOf(EmojiStoreV2SingleProductDialogUI.c(this.iqU));
        hVar.h(12787, objArr);
    }
}
