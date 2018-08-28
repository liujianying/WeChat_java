package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.am.b.a;

class RoomUpgradeResultUI$3 implements a {
    final /* synthetic */ RoomUpgradeResultUI hNY;
    final /* synthetic */ String hNZ;

    RoomUpgradeResultUI$3(RoomUpgradeResultUI roomUpgradeResultUI, String str) {
        this.hNY = roomUpgradeResultUI;
        this.hNZ = str;
    }

    public final void x(String str, boolean z) {
        if (z) {
            RoomUpgradeResultUI.b(this.hNY).post(new 1(this));
        }
    }
}
