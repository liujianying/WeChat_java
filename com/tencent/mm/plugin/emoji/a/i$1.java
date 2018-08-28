package com.tencent.mm.plugin.emoji.a;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements i {
    final /* synthetic */ i iei;

    i$1(i iVar) {
        this.iei = iVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[]{str});
        i.a(this.iei).post(new 1(this));
    }
}
