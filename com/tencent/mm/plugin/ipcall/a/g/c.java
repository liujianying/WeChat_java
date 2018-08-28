package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.g.c.cc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class c extends cc {
    public static a dhO;
    public ArrayList<String> ksy;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wechatUsername";
        aVar.sKA.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "systemAddressBookUsername";
        aVar.sKA.put("systemAddressBookUsername", "TEXT");
        stringBuilder.append(" systemAddressBookUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactId";
        aVar.sKA.put("contactId", "TEXT");
        stringBuilder.append(" contactId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sortKey";
        aVar.sKA.put("sortKey", "TEXT");
        stringBuilder.append(" sortKey TEXT");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public static boolean dq(String str, String str2) {
        if (str == null && str2 != null) {
            return false;
        }
        if (str == null || str.equals(str2)) {
            return true;
        }
        return false;
    }
}
