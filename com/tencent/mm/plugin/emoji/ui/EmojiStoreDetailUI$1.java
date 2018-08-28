package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.g.a.cu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class EmojiStoreDetailUI$1 extends c<cu> {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$1(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
        this.sFo = cu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cu cuVar = (cu) bVar;
        if (!(EmojiStoreDetailUI.a(this.inz) == null || cuVar.bKj.bKk == null || !cuVar.bKj.bKk.equals(EmojiStoreDetailUI.a(this.inz)))) {
            this.inz.h(cuVar.bKj.bKk, cuVar.bKj.status, cuVar.bKj.progress, cuVar.bKj.bKl);
        }
        return false;
    }
}
