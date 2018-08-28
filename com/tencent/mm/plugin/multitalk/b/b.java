package com.tencent.mm.plugin.multitalk.b;

import com.tencent.mm.g.c.co;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends co {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "memberUuid";
        aVar.sKA.put("memberUuid", "LONG");
        stringBuilder.append(" memberUuid LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "wxGroupId";
        aVar.sKA.put("wxGroupId", "TEXT");
        stringBuilder.append(" wxGroupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "userName";
        aVar.sKA.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "inviteUserName";
        aVar.sKA.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "memberId";
        aVar.sKA.put("memberId", "LONG");
        stringBuilder.append(" memberId LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "status";
        aVar.sKA.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
