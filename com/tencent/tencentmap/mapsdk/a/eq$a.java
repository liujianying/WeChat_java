package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;

public class eq$a {
    private String a;
    private String b;
    private List c;
    private ep d;
    private long e;

    public eq$a(String str, long j, String str2) {
        this.a = str;
        this.e = j;
        this.b = str2;
        this.c = new ArrayList();
    }

    public eq$a(String str, long j, String str2, String str3, String str4) {
        ep epVar;
        this.a = str;
        this.e = j;
        this.b = str3;
        this.c = a(str2);
        if (!TextUtils.isEmpty(str4)) {
            String[] split = str4.split(":");
            if (split != null && split.length > 0) {
                epVar = new ep(split[0], Integer.parseInt(split[1]));
                this.d = epVar;
            }
        }
        epVar = null;
        this.d = epVar;
    }

    private static ArrayList a(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                for (String split2 : split) {
                    String[] split3 = split2.split(":");
                    if (split3 != null && split3.length > 0) {
                        arrayList.add(new ep(split3[0], Integer.parseInt(split3[1])));
                    }
                }
            }
        }
        return arrayList;
    }

    public final String a() {
        return this.a;
    }

    public final void a(ep epVar) {
        this.c.add(epVar);
    }

    public final long b() {
        return this.e;
    }

    public final List c() {
        return this.c;
    }

    public final String d() {
        List<ep> list = this.c;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ep c : list) {
            stringBuilder.append(c.c());
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public final String e() {
        return this.b;
    }

    public final ep f() {
        return this.d;
    }

    public final boolean g() {
        return System.currentTimeMillis() - this.e > ((long) ((dx.a().b.e * 60) * TbsLog.TBSLOG_CODE_SDK_BASE));
    }
}
