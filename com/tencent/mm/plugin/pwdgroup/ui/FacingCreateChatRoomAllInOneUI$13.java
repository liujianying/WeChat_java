package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a;
import com.tencent.mm.sdk.platformtools.x;

class FacingCreateChatRoomAllInOneUI$13 implements a {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;

    FacingCreateChatRoomAllInOneUI$13(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.mam = facingCreateChatRoomAllInOneUI;
    }

    public final void m(boolean z, String str) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[]{Boolean.valueOf(z), str});
        FacingCreateChatRoomAllInOneUI.a(this.mam, str);
        if (z) {
            FacingCreateChatRoomAllInOneUI.a(this.mam, true);
            FacingCreateChatRoomAllInOneUI.e(this.mam);
        }
    }
}
