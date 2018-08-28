package com.tencent.mm.ap;

import com.tencent.mm.plugin.chatroom.c$a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
    public String bLe = null;
    public String ebL;
    public LinkedList<String> ebM = new LinkedList();
    public String ebN = null;
    public String text = null;

    public b(Map<String, String> map, bd bdVar) {
        super(map, bdVar);
    }

    protected final boolean Qi() {
        if (this.values == null) {
            x.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[]{bi.oV(this.TYPE), Integer.valueOf(this.values.size())});
        if (bi.oW(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            x.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[]{bi.oV(this.TYPE)});
            return false;
        }
        this.ebL = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket";
        if (this.values.containsKey(ebD)) {
            this.text = bi.oV((String) this.values.get(ebD));
        }
        if (this.values.containsKey(str)) {
            this.ebN = bi.oV((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.bLe = bi.oV((String) this.values.get(str2));
        }
        this.ebF = this.text;
        if (this.bXQ.cmC()) {
            this.ebF += " " + ad.getContext().getString(c$a.has_send_invite);
        } else {
            this.ebH.add(this.ebN);
            this.ebI.add(Integer.valueOf(this.ebF.length()));
            this.ebF += this.ebN;
            this.ebJ.add(Integer.valueOf(this.ebF.length()));
        }
        for (String str3 : this.values.keySet()) {
            if (str3.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
                this.ebM.add(this.values.get(str3));
            }
        }
        return true;
    }
}
