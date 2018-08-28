package com.tencent.mm.ac.a;

import com.tencent.mm.api.g;
import com.tencent.mm.g.c.w;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends w {
    protected static a dhO;
    private Map<String, j> dNh = new HashMap();
    private List<String> dNi;

    static {
        a aVar = new a();
        aVar.sKy = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatLocalId";
        aVar.sKA.put("bizChatLocalId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "bizChatLocalId";
        aVar.columns[1] = "bizChatServId";
        aVar.sKA.put("bizChatServId", "TEXT");
        stringBuilder.append(" bizChatServId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandUserName";
        aVar.sKA.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatType";
        aVar.sKA.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "headImageUrl";
        aVar.sKA.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "chatName";
        aVar.sKA.put("chatName", "TEXT default '' ");
        stringBuilder.append(" chatName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "chatNamePY";
        aVar.sKA.put("chatNamePY", "TEXT default '' ");
        stringBuilder.append(" chatNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatVersion";
        aVar.sKA.put("chatVersion", "INTEGER default '-1' ");
        stringBuilder.append(" chatVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "needToUpdate";
        aVar.sKA.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "bitFlag";
        aVar.sKA.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "maxMemberCnt";
        aVar.sKA.put("maxMemberCnt", "INTEGER default '0' ");
        stringBuilder.append(" maxMemberCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "ownerUserId";
        aVar.sKA.put("ownerUserId", "TEXT");
        stringBuilder.append(" ownerUserId TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "userList";
        aVar.sKA.put("userList", "TEXT");
        stringBuilder.append(" userList TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "addMemberUrl";
        aVar.sKA.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean hu(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final List<String> Nn() {
        if (this.dNi != null) {
            return this.dNi;
        }
        String str = this.field_userList;
        if (bi.oW(str)) {
            return new LinkedList();
        }
        this.dNi = bi.F(str.split(";"));
        return this.dNi;
    }

    public final String gT(String str) {
        j kZ = kZ(str);
        if (kZ == null) {
            return "";
        }
        return bi.aG(kZ.field_userName, "");
    }

    public final j kZ(String str) {
        if (!this.dNh.containsKey(str) || this.dNh.get(str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            j cz = ((g) com.tencent.mm.kernel.g.l(g.class)).cz(str);
            if (cz != null) {
                this.dNh.put(cz.field_userId, cz);
            }
            x.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        if (this.dNh.containsKey(str)) {
            return (j) this.dNh.get(str);
        }
        return null;
    }

    public final boolean isGroup() {
        if (this.field_bizChatServId == null) {
            return false;
        }
        return this.field_bizChatServId.endsWith("@qy_g");
    }

    public final boolean No() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (isGroup() && bi.oW(this.field_userList)) {
            return true;
        }
        if (!bi.oW(this.field_chatNamePY) || bi.oW(this.field_chatName)) {
            return false;
        }
        return true;
    }
}
