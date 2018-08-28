package com.tencent.mm.ap;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.Map;

public final class e extends a {
    public String bUu;
    public LinkedList<String> ebU = new LinkedList();
    public String url;

    public e(Map<String, String> map, bd bdVar) {
        super(map, bdVar);
    }

    protected final boolean Qi() {
        if (this.values == null) {
            x.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[]{bi.oV(this.TYPE), Integer.valueOf(this.values.size())});
        if (bi.oW(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            x.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[]{bi.oV(this.TYPE)});
            return false;
        }
        this.url = bi.oV((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.bUu = bi.oV((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
        this.ebU.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
        for (String str : this.values.keySet()) {
            if (str.startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
                this.ebU.add(this.values.get(str));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str2 : this.values.keySet()) {
            if (!str2.startsWith(ebD)) {
                int length;
                if (str2.startsWith(".sysmsg.delchatroommember.link.text")) {
                    stringBuilder.append((String) this.values.get(str2));
                    this.ebH.add(this.values.get(str2));
                    length = ((String) this.values.get(str2)).length();
                } else {
                    length = i;
                }
                i = length;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.ebI.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.ebJ.add(Integer.valueOf(stringBuilder.length()));
        this.ebF = stringBuilder.toString();
        x.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[]{this.url, this.bUu, Integer.valueOf(this.ebU.size())});
        return true;
    }
}
