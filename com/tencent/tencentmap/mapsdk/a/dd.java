package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.HashMap;

public final class dd {
    private static dd a = null;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";

    public static synchronized dd a(Context context) {
        dd ddVar;
        synchronized (dd.class) {
            if (a == null) {
                a = new dd(context);
            }
            ddVar = a;
        }
        return ddVar;
    }

    public final synchronized String a() {
        return this.b;
    }

    public final synchronized String b() {
        return this.c;
    }

    public final synchronized String c() {
        return this.d;
    }

    public final synchronized String d() {
        return this.e;
    }

    public final synchronized String e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    private dd(Context context) {
        if (context == null) {
            ct.d(" DetailUserInfo context == null? pls check!", new Object[0]);
        }
        ct.b(" start to create DetailUserInfo", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        e.a(context);
        this.b = e.b(context);
        ct.b(" imei:" + this.b, new Object[0]);
        if (!"".equals(this.b)) {
            try {
                if ("".equals(a.b(context, "IMEI_DENGTA", ""))) {
                    a.a(context, "IMEI_DENGTA", this.b);
                }
            } catch (Exception e) {
            }
        }
        this.e = e.d(context);
        this.f = a.b(context, "QIMEI_DENGTA", "");
        if ("".equals(this.f)) {
            this.f = this.b.equals("") ? this.e : this.b;
        }
        if (da.a == null) {
            da.a = new HashMap();
        }
        da.a.put("A3", this.f);
        this.c = e.e(context);
        if ("".equals(this.c)) {
            StringBuilder stringBuilder = new StringBuilder();
            String e2 = e.e("/sys/class/net/eth0/address");
            e2 = (e2.trim().equals("") || e2.length() < 17) ? "" : e2.toLowerCase().substring(0, 17);
            this.c = stringBuilder.append(e2).toString();
        }
        this.d = e.c(context);
        new StringBuilder().append(e.d());
        new StringBuilder().append(e.e()).append("m");
        this.g = e.f();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ct.b(" detail create cost: %d  values:\n %s", new Object[]{Long.valueOf(currentTimeMillis2), toString()});
    }
}
