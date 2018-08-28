package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class EmojiStoreDetailUI$13 implements c {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$13(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void a(l lVar) {
        lVar.a(1001, this.inz.getString(R.l.wv_alert_share_to_friend), R.k.bottomsheet_icon_transmit);
        lVar.a((int) BaseReportManager.MAX_READ_COUNT, this.inz.getString(R.l.wv_alert_share_timeline), R.k.bottomsheet_icon_moment);
    }
}
