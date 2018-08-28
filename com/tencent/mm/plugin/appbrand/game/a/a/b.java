package com.tencent.mm.plugin.appbrand.game.a.a;

import com.tencent.mm.g.c.fe;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends fe {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "RecordId";
        aVar.sKA.put("RecordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" RecordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "RecordId";
        aVar.columns[1] = "AppId";
        aVar.sKA.put("AppId", "TEXT");
        stringBuilder.append(" AppId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "AppName";
        aVar.sKA.put("AppName", "TEXT");
        stringBuilder.append(" AppName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "UserName";
        aVar.sKA.put("UserName", "TEXT");
        stringBuilder.append(" UserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "IconUrl";
        aVar.sKA.put("IconUrl", "TEXT");
        stringBuilder.append(" IconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "BriefIntro";
        aVar.sKA.put("BriefIntro", "TEXT");
        stringBuilder.append(" BriefIntro TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSync";
        aVar.sKA.put("isSync", "INTEGER default 'false' ");
        stringBuilder.append(" isSync INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "debugType";
        aVar.sKA.put("debugType", "INTEGER");
        stringBuilder.append(" debugType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[9] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
