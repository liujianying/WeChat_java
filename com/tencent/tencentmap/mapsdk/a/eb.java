package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.eq.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class eb {
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;
    private ArrayList h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;
    private ep n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(Set set) {
        this.h = new ArrayList();
        this.h.addAll(set);
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.j = i;
    }

    public void c(String str) {
        this.c = str;
    }

    public int d() {
        return this.d;
    }

    public void d(String str) {
        this.e = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.g = str;
    }

    public ArrayList f() {
        return this.h;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    public ec j() {
        long currentTimeMillis = System.currentTimeMillis();
        gd gdVar = new gd();
        fw.b();
        if (fw.e()) {
            this.f = fz.b(this.h.toString());
            Map hashMap = new HashMap();
            hashMap.put("imei", fz.c());
            hashMap.put("reqKey", this.f);
            fh fhVar = new fh(this.a, this.b, this.h, this.e, this.c, this.d, this.i, this.j, this.g, hashMap);
            gdVar.b("#halley-proxy.HalleyDispatchService");
            gdVar.a("srvDispatch");
            gdVar.a("request", fhVar);
            fp a = ee.a(gdVar);
            a.a(22);
            this.o = fw.e();
            this.n = a.d();
            this.p = a.g();
            this.q = a.e();
            this.r = a.h();
            this.s = a.f();
            if (a.b() != 0 || a.a() == null) {
                this.k = a.b();
                this.m = a.c();
                return null;
            }
            try {
                fi fiVar = (fi) a.a().b("response", new fi());
                if (fiVar == null) {
                    this.k = -8;
                    this.l = "Response is Null";
                    return null;
                }
                ec ecVar = new ec();
                String a2 = fw.a();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (a2.equals("unkonwn") || !a2.equals(this.g)) {
                    ecVar.a(null);
                    this.k = -9;
                    this.l = "req apn:" + this.g + ",current apn:" + a2;
                } else {
                    Map map = fiVar.a;
                    if (map != null && map.size() > 0) {
                        eq eqVar = new eq(this.g);
                        for (String a22 : map.keySet()) {
                            if (map.get(a22) != null) {
                                ArrayList arrayList = ((fj) map.get(a22)).a;
                                a aVar = new a(a22, currentTimeMillis2, ((fj) fiVar.a.get(a22)).b);
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    a22 = (String) it.next();
                                    ep epVar = new ep();
                                    if (epVar.a(a22)) {
                                        aVar.a(epVar);
                                    }
                                }
                                eqVar.a(aVar);
                            }
                        }
                        ecVar.a(eqVar);
                    }
                }
                if (fiVar.c != null) {
                    ecVar.a(new dz(fiVar.c));
                }
                if (fiVar.b != null) {
                    ecVar.a(new dy(fiVar.b));
                }
                this.t = (int) (System.currentTimeMillis() - currentTimeMillis);
                return ecVar;
            } catch (Throwable e) {
                fx.a("ScheduleRequestImpl", "wup decode fail.", e);
                this.k = -8;
                this.m = e.getClass().getSimpleName();
                this.l = fz.a(e);
                return null;
            }
        }
        this.k = -4;
        this.l = "Network fail before schedule";
        return null;
    }

    public ep k() {
        return this.n;
    }

    public boolean l() {
        return this.o;
    }

    public int m() {
        return this.k;
    }

    public String n() {
        return this.l;
    }

    public String o() {
        return this.m;
    }

    public int p() {
        return this.p;
    }

    public int q() {
        return this.q;
    }

    public int r() {
        return this.r;
    }

    public int s() {
        return this.s;
    }

    public int t() {
        return this.t;
    }

    public String u() {
        return this.f;
    }
}
