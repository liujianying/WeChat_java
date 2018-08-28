package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2DesignerUI$8 implements a {
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;

    EmojiStoreV2DesignerUI$8(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.ipH = emojiStoreV2DesignerUI;
    }

    public final void x(String str, boolean z) {
        x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[]{str, Boolean.valueOf(z)});
        if (z) {
            EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.ipH;
            au.HU();
            EmojiStoreV2DesignerUI.a(emojiStoreV2DesignerUI, c.FR().Yg(str));
            EmojiStoreV2DesignerUI.a(this.ipH);
        }
    }
}
