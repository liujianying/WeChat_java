package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;

class EmojiStoreV2DesignerUI$15 implements i {
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;

    EmojiStoreV2DesignerUI$15(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.ipH = emojiStoreV2DesignerUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (EmojiStoreV2DesignerUI.j(this.ipH) != null) {
            EmojiStoreV2DesignerUI.j(this.ipH).sendEmptyMessage(10001);
        }
    }
}
