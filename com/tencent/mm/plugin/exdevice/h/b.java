package com.tencent.mm.plugin.exdevice.h;

import com.tencent.mm.g.c.bw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends bw {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceID";
        aVar.sKA.put("deviceID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" deviceID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "deviceID";
        aVar.columns[1] = "brandName";
        aVar.sKA.put("brandName", "TEXT");
        stringBuilder.append(" brandName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mac";
        aVar.sKA.put("mac", "LONG");
        stringBuilder.append(" mac LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "deviceType";
        aVar.sKA.put("deviceType", "TEXT");
        stringBuilder.append(" deviceType TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connProto";
        aVar.sKA.put("connProto", "TEXT");
        stringBuilder.append(" connProto TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "connStrategy";
        aVar.sKA.put("connStrategy", "INTEGER");
        stringBuilder.append(" connStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "closeStrategy";
        aVar.sKA.put("closeStrategy", "INTEGER");
        stringBuilder.append(" closeStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "md5Str";
        aVar.sKA.put("md5Str", "TEXT");
        stringBuilder.append(" md5Str TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "authKey";
        aVar.sKA.put("authKey", "TEXT");
        stringBuilder.append(" authKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "url";
        aVar.sKA.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "sessionKey";
        aVar.sKA.put("sessionKey", "BLOB");
        stringBuilder.append(" sessionKey BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "sessionBuf";
        aVar.sKA.put("sessionBuf", "BLOB");
        stringBuilder.append(" sessionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "authBuf";
        aVar.sKA.put("authBuf", "BLOB");
        stringBuilder.append(" authBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuffer";
        aVar.sKA.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
