package com.tencent.mm.plugin.appbrand.appcache.a.d;

import com.tencent.mm.g.c.db;
import java.lang.reflect.Field;

public final class a extends db {
    static final com.tencent.mm.sdk.e.c.a dzU;

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dzU;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.sKA.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[1] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "startTime";
        aVar.sKA.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "endTime";
        aVar.sKA.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "sceneList";
        aVar.sKA.put("sceneList", "TEXT");
        stringBuilder.append(" sceneList TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "cgiList";
        aVar.sKA.put("cgiList", "TEXT");
        stringBuilder.append(" cgiList TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportId";
        aVar.sKA.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }

    public final String toString() {
        return "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
    }
}
