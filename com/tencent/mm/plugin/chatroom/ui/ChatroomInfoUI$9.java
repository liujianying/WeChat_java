package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;

class ChatroomInfoUI$9 implements b {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ String hLY;

    ChatroomInfoUI$9(ChatroomInfoUI chatroomInfoUI, String str) {
        this.hLX = chatroomInfoUI;
        this.hLY = str;
    }

    public final boolean p(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        String AD = com.tencent.mm.k.b.AD();
        if (bi.oW(AD) || !charSequence2.matches(".*[" + AD + "].*")) {
            if (!(charSequence2 == null || charSequence2.equals(this.hLY))) {
                ChatroomInfoUI.a(this.hLX, charSequence2);
            }
            return true;
        }
        h.bA(this.hLX.mController.tml, this.hLX.getString(R.l.invalid_input_character_toast, new Object[]{AD}));
        return false;
    }
}
