package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.g.a.cu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class BaseEmojiStoreUI$a extends c<cu> {
    final /* synthetic */ BaseEmojiStoreUI ikH;

    private BaseEmojiStoreUI$a(BaseEmojiStoreUI baseEmojiStoreUI) {
        this.ikH = baseEmojiStoreUI;
        this.sFo = cu.class.getName().hashCode();
    }

    /* synthetic */ BaseEmojiStoreUI$a(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
        this(baseEmojiStoreUI);
        this.sFo = cu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cu cuVar = (cu) bVar;
        this.ikH.h(cuVar.bKj.bKk, cuVar.bKj.status, cuVar.bKj.progress, cuVar.bKj.bKl);
        return false;
    }
}
