package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.smtt.utils.TbsLog;

class EmojiStoreTopicUI$3 implements c {
    final /* synthetic */ EmojiStoreTopicUI inJ;

    EmojiStoreTopicUI$3(EmojiStoreTopicUI emojiStoreTopicUI) {
        this.inJ = emojiStoreTopicUI;
    }

    public final void a(l lVar) {
        lVar.a(1001, this.inJ.getString(R.l.wv_alert_share_to_friend), R.k.bottomsheet_icon_transmit);
        lVar.a(TbsLog.TBSLOG_CODE_SDK_BASE, this.inJ.getString(R.l.wv_alert_share_timeline), R.k.bottomsheet_icon_moment);
    }
}
