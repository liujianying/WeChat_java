package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class pq implements pm {
    private static final String[] a = new String[]{jy.a(), "sdksso.map.qq.com", "tafrtt.map.qq.com", "diditaf.map.qq.com"};
    private static List<String> b;

    private static List<String> a() {
        if (b == null) {
            b = Arrays.asList(a);
        }
        return b;
    }

    public void a(Context context) {
        try {
            dv.a(context, jy.c(), kh.a, kh.a(), a());
            dv.a(new 1(this));
            dv.a(false);
        } catch (Exception e) {
        }
    }

    public po a(String str) {
        return a(str, "QQ Map Mobile");
    }

    public po a(String str, String str2) {
        return a(str, str2, 3);
    }

    public po a(String str, String str2, int i) {
        return a(str, str2, i, null);
    }

    public po a(String str, String str2, int i, ls lsVar) {
        return a(str, str2, i, null, lsVar);
    }

    public po a(String str, String str2, int i, HashMap<String, String> hashMap, ls lsVar) {
        ew a = dv.a().a(str);
        a.a(b());
        if (!StringUtil.isEmpty(str2)) {
            a.a("User-Agent", str2);
        }
        if (!(hashMap == null || hashMap.isEmpty())) {
            a.a(hashMap);
        }
        if (i >= 0) {
            a.d(i);
        }
        if (lsVar != null) {
            lsVar.a(a);
        }
        ex a2 = dv.a().a(a);
        if (a2 != null) {
            int a3 = a2.a();
            switch (a3) {
                case -8:
                    throw new pt("Net local exception(outOfMemory), respCode is: " + a3);
                case -4:
                    throw new pu("HttpGetRequest net unavailable, respCode is: " + a3);
                case -2:
                    throw new ps("Respond data is empty, respCode is: " + a3);
                case 0:
                    po poVar = new po();
                    poVar.a = a2.c();
                    poVar.b = b(a2.a("Content-Type"));
                    return poVar;
                default:
                    if (a2.b() != null) {
                        throw new pr(a2.b().getMessage(), a2.b(), a3);
                    }
                    throw new Exception("HttpGetRequest error:" + a3);
            }
        }
        throw new Exception("HttpGetRequest return null");
    }

    public po a(String str, String str2, byte[] bArr) {
        return a(str, str2, bArr, 3);
    }

    public po a(String str, String str2, byte[] bArr, int i) {
        return a(str, str2, bArr, i, null);
    }

    public po a(String str, String str2, byte[] bArr, int i, ls lsVar) {
        return a(str, str2, bArr, i, null, lsVar);
    }

    public po a(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, ls lsVar) {
        return a(str, str2, bArr, i, hashMap, lsVar, 0);
    }

    public po a(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, ls lsVar, int i2) {
        ew a = dv.a().a(str, bArr);
        a.a(b());
        if (!StringUtil.isEmpty(str2)) {
            a.a("User-Agent", str2);
        }
        if (!(hashMap == null || hashMap.isEmpty())) {
            a.a(hashMap);
        }
        if (i >= 0) {
            a.d(i);
        }
        if (lsVar != null) {
            lsVar.a(a);
        }
        if (i2 > 0) {
            a.b(i2);
            a.c(i2);
        }
        ex a2 = dv.a().a(a);
        if (a2 != null) {
            switch (a2.a()) {
                case -4:
                    throw new pu("HttpGetRequest net unavailable, respCode is: " + a2.a());
                case -2:
                    throw new ps("Respond data is empty, respCode is: " + a2.a());
                case 0:
                    po poVar = new po();
                    poVar.a = a2.c();
                    poVar.b = b(a2.a("Content-Type"));
                    return poVar;
                default:
                    if (a2.b() != null) {
                        throw new pr(a2.b().getMessage(), a2.b(), a2.a());
                    }
                    throw new Exception("HttpGetRequest error:" + a2.a());
            }
        }
        throw new Exception("HttpGetRequest return null");
    }

    private static String b(String str) {
        String str2 = "GBK";
        if (str == null) {
            return str2;
        }
        for (String str3 : str.split(";")) {
            if (str3.contains("charset")) {
                String[] split = str3.split("=");
                if (split.length > 1) {
                    return split[1].trim();
                }
                return str2;
            }
        }
        return str2;
    }

    private static int b() {
        return SQLiteGlobal.journalSizeLimit;
    }
}
