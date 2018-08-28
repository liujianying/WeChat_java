package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class FacingCreateChatRoomAllInOneUI$11 extends ag {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;

    FacingCreateChatRoomAllInOneUI$11(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.mam = facingCreateChatRoomAllInOneUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 10001:
                if (FacingCreateChatRoomAllInOneUI.b(this.mam) != null) {
                    FacingCreateChatRoomAllInOneUI.b(this.mam).setData(FacingCreateChatRoomAllInOneUI.c(this.mam));
                    return;
                }
                return;
            case 10002:
                FacingCreateChatRoomAllInOneUI.d(this.mam);
                return;
            default:
                return;
        }
    }
}
