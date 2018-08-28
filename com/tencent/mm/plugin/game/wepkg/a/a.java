package com.tencent.mm.plugin.game.wepkg.a;

import com.tencent.mm.g.c.ex;
import java.lang.reflect.Field;

public final class a extends ex {
    public static final com.tencent.mm.sdk.e.c.a dzU;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.sKA.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "key";
        aVar.columns[1] = "pkgId";
        aVar.sKA.put("pkgId", "TEXT");
        stringBuilder.append(" pkgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "version";
        aVar.sKA.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "filePath";
        aVar.sKA.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "rid";
        aVar.sKA.put("rid", "TEXT");
        stringBuilder.append(" rid TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "mimeType";
        aVar.sKA.put("mimeType", "TEXT");
        stringBuilder.append(" mimeType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "md5";
        aVar.sKA.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "downloadUrl";
        aVar.sKA.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "size";
        aVar.sKA.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "downloadNetType";
        aVar.sKA.put("downloadNetType", "INTEGER");
        stringBuilder.append(" downloadNetType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "completeDownload";
        aVar.sKA.put("completeDownload", "INTEGER default 'false' ");
        stringBuilder.append(" completeDownload INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "autoDownloadCount";
        aVar.sKA.put("autoDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" autoDownloadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "fileDownloadCount";
        aVar.sKA.put("fileDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" fileDownloadCount INTEGER default '0' ");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dzU;
    }
}
