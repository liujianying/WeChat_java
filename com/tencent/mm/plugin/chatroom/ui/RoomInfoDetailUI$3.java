package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import com.tencent.mm.model.bd.a;

class RoomInfoDetailUI$3 implements a {
    final /* synthetic */ RoomInfoDetailUI hNH;
    final /* synthetic */ ProgressDialog hsv;

    RoomInfoDetailUI$3(RoomInfoDetailUI roomInfoDetailUI, ProgressDialog progressDialog) {
        this.hNH = roomInfoDetailUI;
        this.hsv = progressDialog;
    }

    public final boolean Ip() {
        return RoomInfoDetailUI.b(this.hNH);
    }

    public final void Io() {
        if (this.hsv != null) {
            this.hsv.dismiss();
        }
    }
}
