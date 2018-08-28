package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class v {
    private static volatile v a;
    private SharedPreferences b;

    private v(Context context) {
        this.b = context.getSharedPreferences("com.tencent.tencentmap.vector.dynamic", 0);
    }

    public static v a(Context context) {
        if (a == null) {
            synchronized (v.class) {
                if (a == null) {
                    a = new v(context);
                }
            }
        }
        return a;
    }

    public boolean a(String[] strArr) {
        int i = 0;
        if (strArr == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i < strArr.length - 1) {
            stringBuffer.append(strArr[i] + ";");
            i++;
        }
        stringBuffer.append(strArr[strArr.length - 1]);
        return this.b.edit().putString("supportVectorOtaVersions", stringBuffer.toString()).commit();
    }

    public String[] a() {
        String string = this.b.getString("supportVectorOtaVersions", null);
        if (string == null) {
            return null;
        }
        return string.split(";");
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (this.b.getString("supportVectorOtaVersions", null) == null) {
            return this.b.edit().putString("supportVectorOtaVersions", str).commit();
        }
        Set linkedHashSet = new LinkedHashSet(Arrays.asList(a()));
        linkedHashSet.add(str);
        return a((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
    }

    public boolean b(String str) {
        return this.b.edit().putString("vectorMapConfigMd5", str).commit();
    }

    public String b() {
        return this.b.getString("vectorMapConfigMd5", null);
    }

    public boolean c(String str) {
        return this.b.edit().putString("vectorMapPoiIconMd5", str).commit();
    }

    public String c() {
        return this.b.getString("vectorMapPoiIconMd5", null);
    }

    public boolean a(long j) {
        return this.b.edit().putLong("lastDynamicLibCheckTime", j).commit();
    }

    public long d() {
        return this.b.getLong("lastDynamicLibCheckTime", 0);
    }

    public String e() {
        return this.b.getString("dynamicMapSdkVectorVersion", "");
    }

    public boolean d(String str) {
        return this.b.edit().putString("dynamicMapSdkVectorVersion", str).commit();
    }
}
