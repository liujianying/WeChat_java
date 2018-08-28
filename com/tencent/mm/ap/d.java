package com.tencent.mm.ap;

import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.Map;

public final class d extends a {
    public String bLe;
    public String ebL;
    public LinkedList<String> ebM = new LinkedList();
    public int ebO;
    public LinkedList<String> ebP = new LinkedList();
    public LinkedList<String> ebQ = new LinkedList();
    public String ebR = null;
    public String ebS = null;
    public String ebT = null;
    public String text = null;

    public d(Map<String, String> map, bd bdVar) {
        super(map, bdVar);
    }

    protected final boolean Qi() {
        int i = 0;
        if (this.values == null) {
            x.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[]{bi.oV(this.TYPE), Integer.valueOf(this.values.size())});
        if (bi.oW(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            x.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[]{bi.oV(this.TYPE)});
            return false;
        }
        this.ebL = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername";
        String str4 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.ebT = bi.oV((String) this.values.get(str));
        }
        if (this.values.containsKey(str3)) {
            this.ebR = bi.oV((String) this.values.get(str3));
        }
        if (this.values.containsKey(str4)) {
            this.ebS = bi.oV((String) this.values.get(str4));
        }
        if (this.values.containsKey(ebD)) {
            this.text = bi.oV((String) this.values.get(ebD));
        }
        if (this.values.containsKey(str2)) {
            this.bLe = (String) this.values.get(str2);
        }
        if (this.values.containsKey(str5)) {
            this.ebO = bi.getInt((String) this.values.get(str5), 0);
        }
        if (this.bXQ.cmC()) {
            this.ebH.clear();
            this.ebI.clear();
            this.ebJ.clear();
            this.ebF = this.text + " ";
            this.ebI.add(Integer.valueOf(this.ebF.length()));
            this.ebH.add(ad.getContext().getString(a.has_approve_info));
            this.ebF += ad.getContext().getString(a.has_approve_info);
            this.ebJ.add(Integer.valueOf(this.ebF.length()));
        } else {
            this.ebI.add(Integer.valueOf(this.text.length()));
            this.ebH.add(this.ebT);
            this.ebF = this.text + this.ebT;
            this.ebJ.add(Integer.valueOf(this.ebF.length()));
        }
        while (i < this.ebO) {
            if (i == 0) {
                this.ebM.add(bi.oV((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.ebP.add(bi.oV((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.ebQ.add(bi.oV((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.ebM.add(bi.oV((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
                this.ebP.add(bi.oV((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
                this.ebQ.add(bi.oV((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        return true;
    }
}
