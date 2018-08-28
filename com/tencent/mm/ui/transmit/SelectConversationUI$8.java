package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.widget.a.c.a.b;
import com.tencent.mm.y.g.a;

class SelectConversationUI$8 implements b {
    final /* synthetic */ a fZg;
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$8(SelectConversationUI selectConversationUI, a aVar) {
        this.uEC = selectConversationUI;
        this.fZg = aVar;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.putExtra("message_id", SelectConversationUI.i(this.uEC));
        intent.putExtra("record_xml", this.fZg.dwW);
        intent.putExtra("record_show_share", false);
        d.b(this.uEC.mController.tml, "record", ".ui.RecordMsgDetailUI", intent);
    }
}
