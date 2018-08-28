package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dg {
    private di a;
    private Context b;
    private int c = 20000;
    private int d = 0;
    private Runnable e = new 1(this);

    public dg(Context context) {
        this.b = context;
        Map hashMap = new HashMap(2);
        boolean g = a.g(this.b);
        e.a(context);
        hashMap.put("A33", e.g(context));
        if (g) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        hashMap.put("A68", a.h(this.b));
        hashMap.put("A85", a.b ? "Y" : "N");
        this.a = e.a(this.b, "rqd_heartbeat", true, 0, 0, hashMap, false);
    }

    protected final void a() {
        if (e.m(this.b)) {
            ds f = dl.d().f();
            if (f != null) {
                List arrayList = new ArrayList(2);
                arrayList.add(this.a);
                f.a(new a(this.b, arrayList));
            }
            a(c() + 1);
            if (c() % 10 == 0) {
                b.a().a(108, this.e, 600000, (long) this.c);
                a(0);
            }
        }
    }

    public final void b() {
        if (e.g().equals(a.b(this.b, "HEART_DENGTA", ""))) {
            ct.a("heartbeat has been uploaded today!", new Object[0]);
        } else {
            b.a().a(108, this.e, 0, (long) this.c);
        }
    }

    private synchronized int c() {
        return this.d;
    }

    private synchronized void a(int i) {
        this.d = i;
    }
}
