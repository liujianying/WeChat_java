package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.m;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class ChatroomInfoUI$35 implements a<com.tencent.mm.ab.a.a<abx>, com.tencent.mm.ab.a.a<abx>> {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$35(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        if (ChatroomInfoUI.a(this.hLX, aVar.errType, aVar.errCode, aVar.Yy)) {
            return null;
        }
        int i = aVar.errType;
        int i2 = aVar.errCode;
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] roomId:%s", new Object[]{ChatroomInfoUI.b(this.hLX)});
            return null;
        } else if (i != 0 || i2 != 0) {
            return aVar;
        } else {
            String str = ((abx) aVar.dIv).rGv;
            int i3 = ((abx) aVar.dIv).rGw;
            long j = (long) ((abx) aVar.dIv).rGy;
            String str2 = ((abx) aVar.dIv).rGx;
            x.i("MicroMsg.ChatroomInfoUI", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s", new Object[]{ChatroomInfoUI.b(this.hLX), Integer.valueOf(i3), Long.valueOf(j)});
            m.a(ChatroomInfoUI.b(this.hLX), bi.oV(str), str2, j, i3);
            return aVar;
        }
    }
}
