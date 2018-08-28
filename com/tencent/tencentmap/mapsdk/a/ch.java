package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.Base64;
import android.util.SparseArray;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class ch {
    private static ch a = null;
    private String b;
    private int c;
    private int d;
    private SparseArray<a> e;
    private Map<String, String> f;
    private byte g;
    private byte h;
    private String i;
    private String j;
    private String k;

    private ch() {
        this.b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
        this.c = 360;
        this.d = 100;
        this.e = null;
        this.f = null;
        this.g = (byte) 3;
        this.h = (byte) 2;
        this.i = "";
        this.j = "";
        this.k = "";
        this.e = new SparseArray(3);
        this.e.put(1, new a(1));
        this.e.put(2, new a(2));
        this.e.put(3, new a(3));
    }

    public static ch a() {
        if (a == null) {
            synchronized (ch.class) {
                if (a == null) {
                    a = new ch();
                }
            }
        }
        return a;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int c() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final Map<String, String> d() {
        return this.f;
    }

    public final void a(Map<String, String> map) {
        this.f = map;
    }

    public final synchronized SparseArray<a> e() {
        SparseArray<a> a;
        if (this.e != null) {
            cu cuVar = new cu();
            a = cu.a(this.e);
        } else {
            a = null;
        }
        return a;
    }

    public final synchronized a b(int i) {
        a aVar;
        if (this.e != null) {
            aVar = (a) this.e.get(i);
        } else {
            aVar = null;
        }
        return aVar;
    }

    public final int f() {
        if (this.f != null) {
            String str = (String) this.f.get("maxStrategyQueryOneDay");
            if (!(str == null || str.trim().equals(""))) {
                try {
                    return Integer.valueOf(str).intValue();
                } catch (Exception e) {
                    return this.d;
                }
            }
        }
        return this.d;
    }

    public final synchronized boolean g() {
        boolean z;
        if (this.f != null) {
            String str = (String) this.f.get("zeroPeak");
            if (str != null && "y".equalsIgnoreCase(str) && Calendar.getInstance().get(11) == 0) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public final synchronized byte h() {
        return this.g;
    }

    public final synchronized byte i() {
        return this.h;
    }

    public final synchronized String j() {
        return this.i;
    }

    private synchronized void b(String str) {
        this.j = str;
        this.i = Base64.encodeToString(e.a(str), 2);
    }

    public final synchronized String k() {
        return this.j;
    }

    private synchronized void c(String str) {
        this.k = str;
    }

    public final synchronized String l() {
        return this.k;
    }

    public final synchronized void a(Context context, String str, String str2) {
        this.k = str;
        b.a().a(new 1(this, str, str2, context));
    }

    final synchronized void a(Context context) {
        Object[] a = e.a(context, "sid");
        if (a != null && a.length == 3) {
            long longValue;
            long time = new Date().getTime() / 1000;
            try {
                longValue = ((Long) a[2]).longValue();
            } catch (Exception e) {
                longValue = 0;
            }
            if (longValue > time) {
                c((String) a[1]);
            }
        }
        b(e.k(context));
    }
}
