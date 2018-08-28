package com.tencent.mm.modelvideo;

import com.tencent.mm.g.c.ds;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends ds {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.sKA.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "localId";
        aVar.columns[1] = "fileName";
        aVar.sKA.put("fileName", "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "fileNameHash";
        aVar.sKA.put("fileNameHash", "INTEGER");
        stringBuilder.append(" fileNameHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileMd5";
        aVar.sKA.put("fileMd5", "TEXT default '' ");
        stringBuilder.append(" fileMd5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileLength";
        aVar.sKA.put("fileLength", "LONG default '0' ");
        stringBuilder.append(" fileLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "fileStatus";
        aVar.sKA.put("fileStatus", "INTEGER default '0' ");
        stringBuilder.append(" fileStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "fileDuration";
        aVar.sKA.put("fileDuration", "INTEGER default '0' ");
        stringBuilder.append(" fileDuration INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.sKA.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
