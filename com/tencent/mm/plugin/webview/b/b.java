package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class b {
    private static long pNr = 2592000;
    private static b pNs;
    private c pNt;
    private Map<String, Long> pNu = new HashMap();
    private long pNv = 0;

    static /* synthetic */ long Qd(String str) {
        long j = bi.getLong(str, 604800);
        return j > pNr ? pNr : j;
    }

    static /* synthetic */ void b(b bVar) {
        c bTC = bVar.bTC();
        String format = String.format("delete from %s where %s<%s", new Object[]{"WebViewData", "expireTime", Long.valueOf(System.currentTimeMillis() / 1000)});
        x.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: " + format);
        x.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: " + bTC.fV("WebViewData", format));
    }

    public static b bTB() {
        if (pNs == null) {
            pNs = new b();
        }
        return pNs;
    }

    public final c bTC() {
        if (this.pNt == null) {
            g.Ek();
            this.pNt = new c(g.Ei().dqq);
        }
        return this.pNt;
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, boolean z) {
        long j;
        long j2;
        Cursor rawQuery = bTC().rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", c.fl(str, str2)}), new String[0]);
        if (rawQuery == null) {
            j = 0;
        } else {
            j2 = 0;
            if (rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            rawQuery.close();
            j = j2;
        }
        long length = ((long) (str2.getBytes().length + str3.getBytes().length)) - j;
        if (this.pNu.containsKey(str)) {
            j2 = ((Long) this.pNu.get(str)).longValue();
        } else {
            c bTC = bTC();
            String format = String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", c.aj(str, "###@@@@TOTAL@@@###SIZE####", "_")});
            x.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + format);
            j2 = 0;
            rawQuery = bTC.rawQuery(format, new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    j2 = rawQuery.getLong(0);
                }
                rawQuery.close();
            }
            x.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + j2);
        }
        final long j3 = j2 + length;
        final long j4 = str.equals("wx62d9035fd4fd2059") ? j3 - 52428800 : j3 - 10485760;
        x.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", new Object[]{Long.valueOf(j), Long.valueOf(r10), Long.valueOf(length), Long.valueOf(j3), Long.valueOf(j4)});
        if (j4 > 0 && !z) {
            return false;
        }
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        au.Em().H(new Runnable() {
            public final void run() {
                long j;
                if (j4 > 0) {
                    c bTC = b.this.bTC();
                    String str = str6;
                    long j2 = j4;
                    str = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[]{"WebViewData", str});
                    x.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: " + str);
                    Cursor rawQuery = bTC.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        j = 0;
                    } else {
                        List<String> linkedList = new LinkedList();
                        long j3 = j2;
                        while (rawQuery.moveToFirst() && j3 > 0) {
                            str = rawQuery.getString(1);
                            long j4 = rawQuery.getLong(6);
                            linkedList.add(str);
                            j3 -= j4;
                        }
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("(");
                            for (String str2 : linkedList) {
                                stringBuilder.append("\"" + str2 + "\",");
                            }
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            stringBuilder.append(")");
                            str2 = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
                            x.d("MicroMsg.WebViewDataStorage", "deleteSize deleteSql: " + str2);
                            x.d("MicroMsg.WebViewDataStorage", "deleteSize: " + bTC.fV("WebViewData", str2));
                        }
                        j = j2 - j3;
                    }
                    b.this.pNu.put(str6, Long.valueOf(j3 - j));
                } else {
                    b.this.pNu.put(str6, Long.valueOf(j3));
                }
                c bTC2 = b.this.bTC();
                String str3 = str6;
                String str4 = str7;
                String str5 = str8;
                String aG = bi.aG(str9, "1");
                long Qd = b.Qd(str10);
                a aVar = new a();
                aVar.field_appId = str3;
                aVar.field_appIdKey = c.fl(str3, str4);
                aVar.field_value = str5;
                aVar.field_weight = aG;
                aVar.field_expireTime = Qd + (System.currentTimeMillis() / 1000);
                aVar.field_size = (long) (str4.getBytes().length + str5.getBytes().length);
                aVar.field_timeStamp = System.currentTimeMillis() / 1000;
                x.d("MicroMsg.WebViewDataStorage", "setData: " + bTC2.a(aVar));
                c bTC3 = b.this.bTC();
                str5 = str6;
                j = b.this.pNu.get(str6) == null ? 0 : ((Long) b.this.pNu.get(str6)).longValue();
                a aVar2 = new a();
                aVar2.field_appId = str5;
                aVar2.field_appIdKey = c.aj(str5, "###@@@@TOTAL@@@###SIZE####", "_");
                aVar2.field_expireTime = Long.MAX_VALUE;
                aVar2.field_size = j;
                boolean a = bTC3.a(aVar2);
                x.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", new Object[]{Boolean.valueOf(a), Long.valueOf(j)});
                b.b(b.this);
            }
        });
        return true;
    }

    public final a fk(String str, String str2) {
        c bTC = bTC();
        String format = String.format("select * from %s where %s=\"%s\"", new Object[]{"WebViewData", "appIdKey", c.fl(str, str2)});
        x.d("MicroMsg.WebViewDataStorage", "getData: " + format);
        Cursor rawQuery = bTC.rawQuery(format, new String[0]);
        a aVar = new a();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                aVar.d(rawQuery);
            }
            rawQuery.close();
        }
        return aVar;
    }

    public final void b(String str, JSONArray jSONArray) {
        c bTC = bTC();
        if (jSONArray != null && jSONArray.length() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    stringBuilder.append("\"" + c.fl(str, jSONArray.getString(i)) + "\",");
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewDataStorage", "clearData: " + e.getMessage());
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(")");
            String format = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
            x.d("MicroMsg.WebViewDataStorage", "deleteData: " + format);
            x.d("MicroMsg.WebViewDataStorage", "clearData: " + bTC.fV("WebViewData", format));
        }
    }

    public final void Qc(String str) {
        c bTC = bTC();
        String format = String.format("delete from %s where %s=\"%s\"", new Object[]{"WebViewData", "appId", str});
        x.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + format);
        x.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + bTC.fV("WebViewData", format));
    }
}
