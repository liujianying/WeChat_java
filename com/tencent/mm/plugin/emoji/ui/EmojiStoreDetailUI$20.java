package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreDetailUI$20 implements i {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$20(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[]{str});
        if (bitmap != null) {
            this.inz.oP(1006);
        }
    }
}
