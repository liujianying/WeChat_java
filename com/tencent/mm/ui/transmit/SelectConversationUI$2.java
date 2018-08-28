package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.a.c$a$b;

class SelectConversationUI$2 implements c$a$b {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$2(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final void aMV() {
        Intent intent = new Intent(this.uEC.mController.tml, RetransmitPreviewUI.class);
        intent.putExtra("Retr_Msg_content", SelectConversationUI.h(this.uEC));
        this.uEC.startActivity(intent);
        b.gE(this.uEC.mController.tml);
    }
}
