package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class f extends i<e> {
    public static final String[] diD = new String[]{i.a(e.dhO, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> jlO = new 1();

    public f(e eVar) {
        super(eVar, e.dhO, "FreeWifiLog", null);
    }

    public final LinkedList<xm> aPo() {
        Cursor rawQuery = rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
        LinkedList<xm> linkedList = new LinkedList();
        while (rawQuery != null && rawQuery.moveToNext()) {
            xm xmVar = new xm();
            xmVar.id = rawQuery.getString(0);
            xmVar.jkI = rawQuery.getInt(1);
            xmVar.rDq = rawQuery.getString(2);
            xmVar.rDr = rawQuery.getLong(3);
            linkedList.add(xmVar);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, String str2, long j) {
        x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j)});
        if (m.isEmpty(str)) {
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        boolean b;
        try {
            e eVar = new e();
            eVar.field_id = str;
            eVar.field_protocolNumber = i;
            eVar.field_logContent = str2;
            eVar.field_createTime = j;
            if (rawQuery.getCount() == 0) {
                b = b(eVar);
                x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret" + b);
                return b;
            }
            b = c(eVar, new String[0]);
            x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret" + b);
            rawQuery.close();
            return b;
        } catch (Exception e) {
            b = e;
            b = m.h(b);
            x.e("MicroMsg.FreeWifi.FreeWifiLogStorage", b);
            return false;
        } finally {
            rawQuery.close();
        }
    }
}
