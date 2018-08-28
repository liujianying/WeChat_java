package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;

class RoomAlphaProcessUI$1 implements Runnable {
    final /* synthetic */ boolean hMY;
    final /* synthetic */ int hMZ;
    final /* synthetic */ RoomAlphaProcessUI hNa;

    RoomAlphaProcessUI$1(RoomAlphaProcessUI roomAlphaProcessUI, boolean z, int i) {
        this.hNa = roomAlphaProcessUI;
        this.hMY = z;
        this.hMZ = i;
    }

    public final void run() {
        Intent intent = new Intent(this.hNa, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", RoomAlphaProcessUI.a(this.hNa));
        intent.putExtra("upgrade_success", this.hMY);
        intent.putExtra("left_quota", this.hMZ);
        this.hNa.startActivity(intent);
    }
}
