package com.tencent.mm.plugin.chatroom.ui;

import android.os.Build.VERSION;

class SeeRoomMemberUI$1 implements Runnable {
    final /* synthetic */ SeeRoomMemberUI hOM;

    SeeRoomMemberUI$1(SeeRoomMemberUI seeRoomMemberUI) {
        this.hOM = seeRoomMemberUI;
    }

    public final void run() {
        if (VERSION.SDK_INT >= 19) {
            SeeRoomMemberUI.b(this.hOM).scrollListBy(SeeRoomMemberUI.a(this.hOM));
            return;
        }
        SeeRoomMemberUI.a(SeeRoomMemberUI.b(this.hOM), "trackMotionScroll", new Object[]{Integer.valueOf(-SeeRoomMemberUI.a(this.hOM)), Integer.valueOf(-SeeRoomMemberUI.a(this.hOM))}, new Class[]{Integer.TYPE, Integer.TYPE});
    }
}
