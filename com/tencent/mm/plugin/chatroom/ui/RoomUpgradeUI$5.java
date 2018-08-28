package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;

class RoomUpgradeUI$5 implements OnCancelListener {
    final /* synthetic */ RoomUpgradeUI hOi;

    RoomUpgradeUI$5(RoomUpgradeUI roomUpgradeUI) {
        this.hOi = roomUpgradeUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (RoomUpgradeUI.h(this.hOi) != null) {
            au.DF().c(RoomUpgradeUI.h(this.hOi));
            RoomUpgradeUI.i(this.hOi);
        }
        this.hOi.finish();
    }
}
