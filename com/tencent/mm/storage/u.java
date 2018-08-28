package com.tencent.mm.storage;

import com.tencent.mm.g.c.ah;
import com.tencent.mm.i.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class u extends ah {
    protected static a dhO;
    public Map<String, b> dNh = new HashMap();
    private com.tencent.mm.i.a.a.a sOh = new com.tencent.mm.i.a.a.a();
    public com.tencent.mm.i.a.a.a sOi = this.sOh;
    private List<String> sOj = new LinkedList();

    static {
        a aVar = new a();
        aVar.sKy = new Field[18];
        aVar.columns = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "chatroomname";
        aVar.sKA.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "chatroomname";
        aVar.columns[1] = "addtime";
        aVar.sKA.put("addtime", "LONG");
        stringBuilder.append(" addtime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "memberlist";
        aVar.sKA.put("memberlist", "TEXT");
        stringBuilder.append(" memberlist TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "displayname";
        aVar.sKA.put("displayname", "TEXT");
        stringBuilder.append(" displayname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "chatroomnick";
        aVar.sKA.put("chatroomnick", "TEXT");
        stringBuilder.append(" chatroomnick TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roomflag";
        aVar.sKA.put("roomflag", "INTEGER");
        stringBuilder.append(" roomflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "roomowner";
        aVar.sKA.put("roomowner", "TEXT");
        stringBuilder.append(" roomowner TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "roomdata";
        aVar.sKA.put("roomdata", "BLOB");
        stringBuilder.append(" roomdata BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "isShowname";
        aVar.sKA.put("isShowname", "INTEGER");
        stringBuilder.append(" isShowname INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "selfDisplayName";
        aVar.sKA.put("selfDisplayName", "TEXT");
        stringBuilder.append(" selfDisplayName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "style";
        aVar.sKA.put("style", "INTEGER");
        stringBuilder.append(" style INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatroomdataflag";
        aVar.sKA.put("chatroomdataflag", "INTEGER");
        stringBuilder.append(" chatroomdataflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "modifytime";
        aVar.sKA.put("modifytime", "LONG");
        stringBuilder.append(" modifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[13] = "chatroomnotice";
        aVar.sKA.put("chatroomnotice", "TEXT");
        stringBuilder.append(" chatroomnotice TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "chatroomVersion";
        aVar.sKA.put("chatroomVersion", "INTEGER");
        stringBuilder.append(" chatroomVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "chatroomnoticeEditor";
        aVar.sKA.put("chatroomnoticeEditor", "TEXT");
        stringBuilder.append(" chatroomnoticeEditor TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomnoticePublishTime";
        aVar.sKA.put("chatroomnoticePublishTime", "LONG");
        stringBuilder.append(" chatroomnoticePublishTime LONG");
        stringBuilder.append(", ");
        aVar.columns[17] = "chatroomLocalVersion";
        aVar.sKA.put("chatroomLocalVersion", "LONG");
        stringBuilder.append(" chatroomLocalVersion LONG");
        aVar.columns[18] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final List<String> Nn() {
        if (this.sOj == null || this.sOj.size() == 0) {
            this.sOj = XM(this.field_memberlist);
        }
        return this.sOj;
    }

    private void a(com.tencent.mm.i.a.a.a aVar) {
        if (this.field_roomdata == null) {
            aVar = new com.tencent.mm.i.a.a.a();
        }
        Iterator it = aVar.dav.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.dNh.put(bVar.userName, bVar);
        }
    }

    public final void ckJ() {
        if (!bi.bC(this.field_roomdata)) {
            try {
                this.sOi = (com.tencent.mm.i.a.a.a) new com.tencent.mm.i.a.a.a().aG(this.field_roomdata);
            } catch (Exception e) {
                this.sOi = new com.tencent.mm.i.a.a.a();
            }
            a(this.sOi);
        }
    }

    public final boolean b(com.tencent.mm.i.a.a.a aVar) {
        return this.sOh.boi() == aVar.boi();
    }

    public final b XK(String str) {
        if (this.dNh.size() <= 0) {
            ckJ();
        }
        if (this.dNh.containsKey(str)) {
            return (b) this.dNh.get(str);
        }
        return null;
    }

    public final int ckK() {
        if (b(this.sOi)) {
            ckJ();
        }
        return this.sOi.bUd;
    }

    public final boolean ckL() {
        if (b(this.sOi)) {
            ckJ();
        }
        return this.sOi.bUd < this.sOi.daz;
    }

    public static boolean ckM() {
        return false;
    }

    public final void ge(int i) {
        this.field_chatroomdataflag = (this.sOi.bWA & -3) | (i & 2);
    }

    public final int ckN() {
        if (b(this.sOi)) {
            ckJ();
        }
        return this.sOi.type;
    }

    public final int ckO() {
        if (b(this.sOi)) {
            ckJ();
        }
        return this.sOi.daw;
    }

    public final String gT(String str) {
        b XK = XK(str);
        if (XK == null) {
            return "";
        }
        return bi.aG(XK.daA, "");
    }

    public final u ll(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean ckP() {
        return this.field_isShowname > 0;
    }

    private static int MO(String str) {
        int i = 0;
        try {
            return bi.getInt(str, 0);
        } catch (Exception e) {
            if (str == null) {
                return i;
            }
            x.e("MicroMsg.ChatRoomMember", "parserInt error " + str);
            return i;
        }
    }

    private static com.tencent.mm.i.a.a.a XL(String str) {
        com.tencent.mm.i.a.a.a aVar = new com.tencent.mm.i.a.a.a();
        if (bi.oW(str)) {
            return aVar;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map z = bl.z(str, "RoomData");
        if (z == null) {
            x.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            return null;
        }
        indexOf = 0;
        while (true) {
            try {
                Object obj;
                Object obj2;
                Object obj3;
                int i = indexOf;
                b bVar = new b();
                if (i == 0) {
                    obj = ".RoomData.Member.$UserName";
                    obj2 = ".RoomData.Member.DisplayName";
                    obj3 = ".RoomData.Member.Flag";
                } else if (i != 0) {
                    obj = ".RoomData.Member" + i + ".$UserName";
                    obj2 = ".RoomData.Member" + i + ".DisplayName";
                    String obj32 = ".RoomData.Member" + i + ".Flag";
                } else {
                    obj32 = null;
                    obj2 = null;
                    obj = null;
                }
                String aG = bi.aG((String) z.get(obj), "");
                if (bi.oW(aG)) {
                    aVar.type = MO((String) z.get(".RoomData.Type"));
                    aVar.status = MO((String) z.get(".RoomData.Status"));
                    aVar.daw = MO((String) z.get(".RoomData.MaxCount"));
                    aVar.dax = bi.aG((String) z.get(".RoomData.ExtInfo.Upgrader"), "");
                    return aVar;
                }
                bVar.userName = aG;
                bVar.daA = bi.aG((String) z.get(obj2), "");
                bVar.daB = MO((String) z.get(obj32));
                aVar.dav.add(bVar);
                indexOf = i + 1;
            } catch (Exception e) {
                return aVar;
            }
        }
    }

    public static List<String> XM(String str) {
        List<String> linkedList = new LinkedList();
        if (bi.oW(str)) {
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        return linkedList;
    }

    public final u da(List<String> list) {
        String str;
        if (list == null || list.size() == 0) {
            str = "";
        } else {
            str = "";
            int i = 0;
            while (i < list.size()) {
                String str2 = str + ((String) list.get(i));
                if (i < list.size() - 1) {
                    str2 = str2 + ";";
                }
                i++;
                str = str2;
            }
        }
        this.field_memberlist = str;
        return this;
    }

    public final u fY(String str, String str2) {
        return a(str, XL(str2), false);
    }

    public final u a(String str, com.tencent.mm.i.a.a.a aVar, boolean z) {
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            int i;
            b bVar = null;
            Iterator it = aVar.dav.iterator();
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.userName == null || !bVar2.userName.equals(str)) {
                    bVar2 = bVar;
                }
                bVar = bVar2;
            }
            if (bVar != null) {
                this.field_selfDisplayName = bVar.daA;
                this.field_isShowname = bVar.daB & 1;
                i = bVar.daB;
            } else {
                i = 0;
            }
            x.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i));
            aVar.bWA = (i & 2) | (aVar.bWA & -3);
            this.field_chatroomdataflag = aVar.bWA;
        }
        try {
            this.field_roomdata = aVar.toByteArray();
            this.sOi = aVar;
        } catch (Throwable e) {
            x.e("MicroMsg.ChatRoomMember", "exception:%s", bi.i(e));
        }
        a(aVar);
        return this;
    }

    public final com.tencent.mm.i.a.a.a ckQ() {
        if (b(this.sOi)) {
            ckJ();
        }
        return this.sOi;
    }
}
