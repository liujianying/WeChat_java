package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.rtmp.TXLiveConstants;

class EmojiStoreV2SingleProductUI$4 implements c {
    final /* synthetic */ EmojiStoreV2SingleProductUI irx;

    EmojiStoreV2SingleProductUI$4(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.irx = emojiStoreV2SingleProductUI;
    }

    public final void a(l lVar) {
        lVar.a(TXLiveConstants.PUSH_EVT_CONNECT_SUCC, this.irx.getString(R.l.wv_alert_share_to_friend), R.k.bottomsheet_icon_transmit);
        lVar.a(1000, this.irx.getString(R.l.wv_alert_share_timeline), R.k.bottomsheet_icon_moment);
    }
}
