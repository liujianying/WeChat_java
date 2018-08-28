package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView$a;

class FacingCreateChatRoomAllInOneUI$3 implements MMCallBackScrollView$a {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;

    FacingCreateChatRoomAllInOneUI$3(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.mam = facingCreateChatRoomAllInOneUI;
    }

    public final void br(int i) {
        if (FacingCreateChatRoomAllInOneUI.j(this.mam) == null) {
            return;
        }
        if (i == 0) {
            FacingCreateChatRoomAllInOneUI.j(this.mam).setVisibility(4);
        } else {
            FacingCreateChatRoomAllInOneUI.j(this.mam).setVisibility(0);
        }
    }
}
