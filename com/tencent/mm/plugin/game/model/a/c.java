package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.g.c.br;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends br {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[15];
        aVar.columns = new String[16];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "appId";
        aVar.columns[1] = "downloadUrl";
        aVar.sKA.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "size";
        aVar.sKA.put("size", "LONG default '0' ");
        stringBuilder.append(" size LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "md5";
        aVar.sKA.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "packageName";
        aVar.sKA.put("packageName", "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "expireTime";
        aVar.sKA.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "randomTime";
        aVar.sKA.put("randomTime", "LONG default '0' ");
        stringBuilder.append(" randomTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "isFirst";
        aVar.sKA.put("isFirst", "INTEGER default 'true' ");
        stringBuilder.append(" isFirst INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "nextCheckTime";
        aVar.sKA.put("nextCheckTime", "LONG default '0' ");
        stringBuilder.append(" nextCheckTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "isRunning";
        aVar.sKA.put("isRunning", "INTEGER default 'false' ");
        stringBuilder.append(" isRunning INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "noWifi";
        aVar.sKA.put("noWifi", "INTEGER default 'true' ");
        stringBuilder.append(" noWifi INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "noSdcard";
        aVar.sKA.put("noSdcard", "INTEGER default 'true' ");
        stringBuilder.append(" noSdcard INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "noEnoughSpace";
        aVar.sKA.put("noEnoughSpace", "INTEGER default 'true' ");
        stringBuilder.append(" noEnoughSpace INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "lowBattery";
        aVar.sKA.put("lowBattery", "INTEGER default 'true' ");
        stringBuilder.append(" lowBattery INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "continueDelay";
        aVar.sKA.put("continueDelay", "INTEGER default 'true' ");
        stringBuilder.append(" continueDelay INTEGER default 'true' ");
        aVar.columns[15] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
