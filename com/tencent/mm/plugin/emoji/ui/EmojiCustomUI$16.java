package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.a.c.l;
import com.tencent.mm.plugin.gif.g;

class EmojiCustomUI$16 implements l {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$16(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final Bitmap K(byte[] bArr) {
        return g.ay(bArr);
    }

    public final Bitmap mf(String str) {
        return g.ay(e.e(str, 0, e.cm(str)));
    }
}
