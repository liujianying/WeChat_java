package com.tencent.mm.ac.a;

import com.tencent.mm.g.c.y;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;

public final class j extends y {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userId";
        aVar.sKA.put("userId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "userId";
        aVar.columns[1] = "userName";
        aVar.sKA.put("userName", "TEXT default '' ");
        stringBuilder.append(" userName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "userNamePY";
        aVar.sKA.put("userNamePY", "TEXT default '' ");
        stringBuilder.append(" userNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandUserName";
        aVar.sKA.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "UserVersion";
        aVar.sKA.put("UserVersion", "INTEGER default '-1' ");
        stringBuilder.append(" UserVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "needToUpdate";
        aVar.sKA.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "headImageUrl";
        aVar.sKA.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "profileUrl";
        aVar.sKA.put("profileUrl", "TEXT");
        stringBuilder.append(" profileUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "bitFlag";
        aVar.sKA.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "addMemberUrl";
        aVar.sKA.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean hu(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final boolean No() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (bi.oW(this.field_profileUrl) && bi.oW(this.field_headImageUrl)) {
            return true;
        }
        if (!bi.oW(this.field_userNamePY) || bi.oW(this.field_userName)) {
            return false;
        }
        return true;
    }
}
