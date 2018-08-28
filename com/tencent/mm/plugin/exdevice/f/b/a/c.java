package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.g.c.bz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bz {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.sKA.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "rankID";
        aVar.sKA.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.sKA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "step";
        aVar.sKA.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "sort";
        aVar.sKA.put("sort", "INTEGER default '0' ");
        stringBuilder.append(" sort INTEGER default '0' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final String toString() {
        return ("{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername) + "}";
    }
}
