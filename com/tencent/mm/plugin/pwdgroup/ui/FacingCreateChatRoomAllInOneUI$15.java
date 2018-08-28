package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;

class FacingCreateChatRoomAllInOneUI$15 implements a {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;

    FacingCreateChatRoomAllInOneUI$15(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.mam = facingCreateChatRoomAllInOneUI;
    }

    public final void input(String str) {
        if (FacingCreateChatRoomAllInOneUI.g(this.mam) == null) {
            return;
        }
        if (FacingCreateChatRoomAllInOneUI.h(this.mam) || FacingCreateChatRoomAllInOneUI.i(this.mam)) {
            MMPwdInputView g = FacingCreateChatRoomAllInOneUI.g(this.mam);
            g.aPm();
            g.input(str);
            FacingCreateChatRoomAllInOneUI.a(this.mam, FacingCreateChatRoomAllInOneUI.a.mar);
            return;
        }
        FacingCreateChatRoomAllInOneUI.g(this.mam).input(str);
    }

    public final void aPm() {
        if (FacingCreateChatRoomAllInOneUI.g(this.mam) != null) {
            FacingCreateChatRoomAllInOneUI.g(this.mam).aPm();
        }
    }

    public final void delete() {
        if (FacingCreateChatRoomAllInOneUI.g(this.mam) == null) {
            return;
        }
        if (FacingCreateChatRoomAllInOneUI.h(this.mam) || FacingCreateChatRoomAllInOneUI.i(this.mam)) {
            FacingCreateChatRoomAllInOneUI.g(this.mam).aPm();
            FacingCreateChatRoomAllInOneUI.a(this.mam, FacingCreateChatRoomAllInOneUI.a.mar);
            return;
        }
        MMPwdInputView g = FacingCreateChatRoomAllInOneUI.g(this.mam);
        if (g.iUo > 0) {
            g.hPZ.deleteCharAt(g.iUo - 1);
        }
        g.bnZ();
        g.bnY();
    }
}
