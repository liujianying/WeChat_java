package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class SeeRoomMemberUI$10 implements a {
    final /* synthetic */ String hMq;
    final /* synthetic */ SeeRoomMemberUI hOM;

    SeeRoomMemberUI$10(SeeRoomMemberUI seeRoomMemberUI, String str) {
        this.hOM = seeRoomMemberUI;
        this.hMq = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            SeeRoomMemberUI.a(this.hOM, this.hMq, str, R.l.invitting_room_mem);
        }
    }
}
