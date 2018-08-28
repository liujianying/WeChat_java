package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2DesignerUI$3 implements OnClickListener {
    final /* synthetic */ String igj;
    final /* synthetic */ String ikF;
    final /* synthetic */ String ikG;
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;

    EmojiStoreV2DesignerUI$3(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI, String str, String str2, String str3) {
        this.ipH = emojiStoreV2DesignerUI;
        this.igj = str;
        this.ikF = str2;
        this.ikG = str3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ipH.N(this.igj, this.ikF, this.ikG);
        this.ipH.aFq();
        x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{this.igj});
        EmojiStoreV2DesignerUI.a(this.ipH, this.igj);
    }
}
