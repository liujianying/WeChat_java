package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.a.c$a.b;
import com.tencent.mm.y.g.a;

class SelectConversationUI$11 implements b {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$11(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final void aMV() {
        mw gL = k.gL(this.uEC.mController.tml);
        a gp = a.gp(bi.WT(h.a(gL.bXM.bXU.title, gL.bXM.bXU.desc, gL.bXM.bXn.bJF.bJH, gL.bXL.bXS)));
        if (gp != null) {
            Intent intent = new Intent();
            intent.putExtra("message_id", SelectConversationUI.i(this.uEC));
            intent.putExtra("record_xml", gp.dwW);
            intent.putExtra("record_show_share", false);
            d.b(this.uEC.mController.tml, "record", ".ui.RecordMsgDetailUI", intent);
        }
    }
}
