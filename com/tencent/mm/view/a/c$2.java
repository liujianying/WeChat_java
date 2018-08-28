package com.tencent.mm.view.a;

import com.tencent.mm.ak.a.c.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$2 implements d {
    final /* synthetic */ c uTM;

    c$2(c cVar) {
        this.uTM = cVar;
    }

    public final byte[] h(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj != null && (obj instanceof EmojiInfo)) {
                return ((c) g.n(c.class)).getProvider().a((EmojiInfo) obj);
            }
        }
        return null;
    }
}
