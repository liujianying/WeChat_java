package com.tencent.mm.ui.contact;

import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.sdk.platformtools.x;

class ChatroomContactUI$5 implements b {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$5(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final void bZ(boolean z) {
        x.d("MicroMsg.ChatroomContactUI", "visible " + z);
        if (z) {
            int firstVisiblePosition = ChatroomContactUI.b(this.uiv).getFirstVisiblePosition();
            x.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  " + firstVisiblePosition);
            if (firstVisiblePosition > 0) {
                ChatroomContactUI.b(this.uiv).post(new 1(this));
            }
        }
    }
}
