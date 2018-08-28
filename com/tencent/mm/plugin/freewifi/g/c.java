package com.tencent.mm.plugin.freewifi.g;

import com.tencent.mm.g.c.bl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bl {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "ssidmd5";
        aVar.sKA.put("ssidmd5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "ssidmd5";
        aVar.columns[1] = "ssid";
        aVar.sKA.put("ssid", "TEXT");
        stringBuilder.append(" ssid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mid";
        aVar.sKA.put("mid", "TEXT");
        stringBuilder.append(" mid TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "url";
        aVar.sKA.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connectState";
        aVar.sKA.put("connectState", "INTEGER default '-1' ");
        stringBuilder.append(" connectState INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expiredTime";
        aVar.sKA.put("expiredTime", "LONG");
        stringBuilder.append(" expiredTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiType";
        aVar.sKA.put("wifiType", "INTEGER default '1' ");
        stringBuilder.append(" wifiType INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "action";
        aVar.sKA.put("action", "INTEGER default '0' ");
        stringBuilder.append(" action INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "showUrl";
        aVar.sKA.put("showUrl", "TEXT");
        stringBuilder.append(" showUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "showWordEn";
        aVar.sKA.put("showWordEn", "TEXT");
        stringBuilder.append(" showWordEn TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "showWordCn";
        aVar.sKA.put("showWordCn", "TEXT");
        stringBuilder.append(" showWordCn TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "showWordTw";
        aVar.sKA.put("showWordTw", "TEXT");
        stringBuilder.append(" showWordTw TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "mac";
        aVar.sKA.put("mac", "TEXT");
        stringBuilder.append(" mac TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "verifyResult";
        aVar.sKA.put("verifyResult", "INTEGER default '1' ");
        stringBuilder.append(" verifyResult INTEGER default '1' ");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }
}
