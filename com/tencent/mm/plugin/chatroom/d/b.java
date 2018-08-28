package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.a;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends a<dw> {
    public b(String str, String str2, String str3, LinkedList<String> linkedList) {
        x.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s", new Object[]{str, str2, bi.Xf(str3), linkedList});
        dv dvVar = new dv();
        dvVar.ebR = str;
        dvVar.reg = str2;
        dvVar.bLe = str3;
        dvVar.reh = linkedList;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = dvVar;
        aVar.dIH = new dw();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
        aVar.dIF = 774;
        this.diG = aVar.KT();
    }
}
