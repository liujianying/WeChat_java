package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.g.a.cu;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2DesignerUI$1 extends c<cu> {
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;

    EmojiStoreV2DesignerUI$1(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.ipH = emojiStoreV2DesignerUI;
        this.sFo = cu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cu cuVar = (cu) bVar;
        EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.ipH;
        String str = cuVar.bKj.bKk;
        int i = cuVar.bKj.status;
        int i2 = cuVar.bKj.progress;
        x.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), cuVar.bKj.bKl});
        if (i == 6) {
            emojiStoreV2DesignerUI.bf(str, i2);
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "product status:%d", new Object[]{Integer.valueOf(i)});
            emojiStoreV2DesignerUI.be(str, i);
        }
        if (!(emojiStoreV2DesignerUI.ikI == null || emojiStoreV2DesignerUI.ikI.ien == null)) {
            f za = emojiStoreV2DesignerUI.ikI.ien.za(str);
            if (za != null) {
                za.ieC = r4;
            }
        }
        return false;
    }
}
