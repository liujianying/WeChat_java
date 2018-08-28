package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class RoomCardUI$9 implements OnClickListener {
    final /* synthetic */ RoomCardUI hNw;

    RoomCardUI$9(RoomCardUI roomCardUI) {
        this.hNw = roomCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RoomCardUI roomCardUI = this.hNw;
        ActionBarActivity actionBarActivity = this.hNw.mController.tml;
        this.hNw.getString(R.l.app_tip);
        RoomCardUI.a(roomCardUI, h.a(actionBarActivity, this.hNw.getString(R.l.room_saving_notice), false, null));
        if (RoomCardUI.e(this.hNw)) {
            RoomCardUI.f(this.hNw);
            RoomCardUI.a(this.hNw, RoomCardUI.b(this.hNw).getText().toString());
        }
    }
}
