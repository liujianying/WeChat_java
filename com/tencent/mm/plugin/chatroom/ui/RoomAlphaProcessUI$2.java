package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;

class RoomAlphaProcessUI$2 implements Runnable {
    final /* synthetic */ boolean hMY;
    final /* synthetic */ RoomAlphaProcessUI hNa;

    RoomAlphaProcessUI$2(RoomAlphaProcessUI roomAlphaProcessUI, boolean z) {
        this.hNa = roomAlphaProcessUI;
        this.hMY = z;
    }

    public final void run() {
        Intent intent = new Intent(this.hNa, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", RoomAlphaProcessUI.a(this.hNa));
        intent.putExtra("upgrade_success", this.hMY);
        this.hNa.startActivity(intent);
    }
}
