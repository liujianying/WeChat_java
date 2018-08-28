package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.protocal.c.ta;

class EmojiStoreV2SingleProductDialogUI$4 implements i {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI iqU;

    EmojiStoreV2SingleProductDialogUI$4(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.iqU = emojiStoreV2SingleProductDialogUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (bitmap != null && objArr != null && objArr.length > 0 && EmojiStoreV2SingleProductDialogUI.d(this.iqU) != null && objArr[0] != null && (objArr[0] instanceof ta)) {
            ta taVar = (ta) objArr[0];
            if (EmojiStoreV2SingleProductDialogUI.a(this.iqU) != null && taVar != null && taVar.rwk.equals(EmojiStoreV2SingleProductDialogUI.a(this.iqU).rwk)) {
                EmojiStoreV2SingleProductDialogUI.e(this.iqU);
            }
        }
    }
}
