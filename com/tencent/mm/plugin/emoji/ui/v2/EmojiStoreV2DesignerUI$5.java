package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.smtt.utils.TbsLog;

class EmojiStoreV2DesignerUI$5 implements c {
    final /* synthetic */ EmojiStoreV2DesignerUI ipH;

    EmojiStoreV2DesignerUI$5(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.ipH = emojiStoreV2DesignerUI;
    }

    public final void a(l lVar) {
        lVar.a(1001, this.ipH.getString(R.l.wv_alert_share_to_friend), R.k.bottomsheet_icon_transmit);
        lVar.a(TbsLog.TBSLOG_CODE_SDK_BASE, this.ipH.getString(R.l.wv_alert_share_timeline), R.k.bottomsheet_icon_moment);
    }
}
