package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;

class EmojiStoreDetailUI$15 implements a {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$15(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void u(ArrayList<n> arrayList) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish]");
        EmojiStoreDetailUI.E(this.inz);
        if (arrayList != null && arrayList.size() > 0) {
            n nVar = (n) arrayList.get(0);
            if (nVar.qzg == 10232) {
                EmojiStoreDetailUI.a(this.inz, 4);
                EmojiStoreDetailUI.a(this.inz, nVar.qzd);
            } else {
                EmojiStoreDetailUI.a(this.inz, 10);
                EmojiStoreDetailUI.b(this.inz, nVar.qzg);
            }
            this.inz.oP(TXLiveConstants.PUSH_EVT_PUSH_BEGIN);
        }
    }
}
