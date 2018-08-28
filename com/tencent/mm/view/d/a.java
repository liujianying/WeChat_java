package com.tencent.mm.view.d;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements m {
    private com.tencent.mm.ak.a.d.a<String, Bitmap> dYe = new com.tencent.mm.ak.a.d.a(150);

    public final Bitmap jz(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return (Bitmap) this.dYe.get(str);
    }

    public final void d(String str, Bitmap bitmap) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            x.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
        } else {
            this.dYe.put(str, bitmap);
        }
    }

    public final void clear() {
        synchronized (this) {
            if (this.dYe != null) {
                Map snapshot = this.dYe.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        Bitmap bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            x.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", new Object[]{bitmap.toString()});
                        }
                    }
                }
                this.dYe.clear();
            }
        }
    }
}
