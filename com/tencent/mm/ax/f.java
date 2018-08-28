package com.tencent.mm.ax;

import com.tencent.mm.g.c.cn;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class f extends cn {
    public static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wxGroupId";
        aVar.sKA.put("wxGroupId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "wxGroupId";
        aVar.columns[1] = "groupId";
        aVar.sKA.put("groupId", "TEXT");
        stringBuilder.append(" groupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "roomId";
        aVar.sKA.put("roomId", "INTEGER");
        stringBuilder.append(" roomId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "roomKey";
        aVar.sKA.put("roomKey", "LONG");
        stringBuilder.append(" roomKey LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "routeId";
        aVar.sKA.put("routeId", "INTEGER");
        stringBuilder.append(" routeId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "inviteUserName";
        aVar.sKA.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "memberCount";
        aVar.sKA.put("memberCount", "INTEGER");
        stringBuilder.append(" memberCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfoColumns.STATE;
        aVar.sKA.put(DownloadInfoColumns.STATE, "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        aVar.columns[9] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
