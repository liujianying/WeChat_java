package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.widget.a.c.a.b;

class SelectConversationUI$6 implements b {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$6(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.setClassName(this.uEC.mController.tml, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        intent.putExtra("app_msg_id", SelectConversationUI.i(this.uEC));
        intent.putExtra("app_show_share", false);
        this.uEC.startActivity(intent);
    }
}
