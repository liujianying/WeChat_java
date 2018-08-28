package com.tencent.mm.view.e;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storage.emotion.EmojiInfo;

class a$5 implements a {
    final /* synthetic */ a uWa;

    a$5(a aVar) {
        this.uWa = aVar;
    }

    public final void a(String str, l lVar) {
        if (str != null) {
            if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                this.uWa.cCw();
            } else if (g.Eg().Dx()) {
                EmojiInfo zi = ((c) g.n(c.class)).getEmojiMgr().zi(str);
                if (zi != null && zi.field_catalog == EmojiInfo.tcH) {
                    ((c) g.n(c.class)).getProvider().aDY();
                    this.uWa.cCw();
                }
            }
        }
    }
}
