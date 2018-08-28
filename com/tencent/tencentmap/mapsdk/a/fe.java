package com.tencent.tencentmap.mapsdk.a;

import java.net.InetAddress;

public final class fe implements Runnable {
    private fd a;

    public fe(fd fdVar) {
        this.a = fdVar;
    }

    public final void run() {
        Object obj;
        try {
            if (!(this.a == null || this.a.x)) {
                this.a.v = InetAddress.getByName(this.a.c).getHostAddress();
                this.a.a = new ep(this.a.v, 80);
            }
            if (this.a.k < -9 && !ee.a("info.3g.qq.com", 80, 5000)) {
                this.a.k = -17;
            }
            if (this.a.k == 0) {
                fd fdVar = this.a;
                obj = (fdVar.a == null || !fdVar.a.a(fdVar.b)) ? null : 1;
                if (obj == null) {
                    fdVar = this.a;
                    if (fdVar != null) {
                        er.a().a(fdVar.c, fdVar.a);
                    }
                }
            }
        } catch (Exception e) {
        }
        try {
            if (this.a.B) {
                fd fdVar2 = this.a;
                du a = ed.a();
                if (a != null) {
                    fm a2 = a.a();
                    if (!(a2 == null || a2.a == null)) {
                        Byte b = (Byte) a2.a.get(Integer.valueOf(fdVar2.k));
                        if (b == null) {
                            b = Byte.valueOf((byte) a2.b);
                        }
                        if (fdVar2 != null) {
                            fdVar2.t = b.byteValue();
                        }
                        if (Math.random() * 100.0d > ((double) b.floatValue())) {
                            obj = null;
                            if (obj != null) {
                                fdVar2 = this.a;
                                fn fnVar = new fn();
                                fnVar.a = em.b();
                                fnVar.b = em.c();
                                fnVar.c = em.d();
                                fnVar.d = em.f();
                                fnVar.e = em.e();
                                fnVar.h = fw.c();
                                if (fnVar.h == 1) {
                                    fnVar.g = fw.a();
                                } else {
                                    fnVar.f = fw.a();
                                }
                                fnVar.i = fw.d();
                                fnVar.m = fw.e() ? 1 : 0;
                                if (fdVar2 != null) {
                                    fnVar.j = fdVar2.c;
                                    fnVar.k = fdVar2.a;
                                    fnVar.n = fdVar2.k;
                                    fnVar.o = fdVar2.r;
                                    fnVar.p = fdVar2.q;
                                    fnVar.q = fdVar2.g;
                                    fnVar.r = fdVar2.h;
                                    fnVar.s = fdVar2.i;
                                    fnVar.t = fdVar2.j;
                                    fnVar.w = fdVar2.l;
                                    fnVar.x = fdVar2.m;
                                    fnVar.u = fdVar2.n;
                                    fnVar.z = fdVar2.p;
                                    fnVar.A = fdVar2.d;
                                    fnVar.v = fdVar2.o;
                                    fnVar.G = fdVar2.f;
                                    fnVar.x = fdVar2.m;
                                    fnVar.J = fdVar2.w;
                                    fnVar.I = fdVar2.v;
                                    fnVar.K = fdVar2.C;
                                    fnVar.E = fdVar2.t;
                                    fnVar.y = fdVar2.s;
                                    fnVar.B = fdVar2.x ? 0 : 1;
                                    fnVar.C = fdVar2.z ? 0 : 1;
                                    fnVar.D = ed.a ? 1 : 0;
                                    fnVar.L = fdVar2.D ? 1 : 0;
                                    fnVar.M = fdVar2.A ? 1 : 0;
                                    fnVar.F = fdVar2.y;
                                    fnVar.l = fdVar2.b;
                                    fnVar.H = fdVar2.u;
                                }
                                if (eo.a() != null) {
                                    eo.a();
                                    eo.a(fnVar);
                                }
                                fx.b("ReportTask", "finish report");
                            }
                        }
                    }
                }
                int i = 1;
                if (obj != null) {
                    fdVar2 = this.a;
                    fn fnVar2 = new fn();
                    fnVar2.a = em.b();
                    fnVar2.b = em.c();
                    fnVar2.c = em.d();
                    fnVar2.d = em.f();
                    fnVar2.e = em.e();
                    fnVar2.h = fw.c();
                    if (fnVar2.h == 1) {
                        fnVar2.g = fw.a();
                    } else {
                        fnVar2.f = fw.a();
                    }
                    fnVar2.i = fw.d();
                    fnVar2.m = fw.e() ? 1 : 0;
                    if (fdVar2 != null) {
                        fnVar2.j = fdVar2.c;
                        fnVar2.k = fdVar2.a;
                        fnVar2.n = fdVar2.k;
                        fnVar2.o = fdVar2.r;
                        fnVar2.p = fdVar2.q;
                        fnVar2.q = fdVar2.g;
                        fnVar2.r = fdVar2.h;
                        fnVar2.s = fdVar2.i;
                        fnVar2.t = fdVar2.j;
                        fnVar2.w = fdVar2.l;
                        fnVar2.x = fdVar2.m;
                        fnVar2.u = fdVar2.n;
                        fnVar2.z = fdVar2.p;
                        fnVar2.A = fdVar2.d;
                        fnVar2.v = fdVar2.o;
                        fnVar2.G = fdVar2.f;
                        fnVar2.x = fdVar2.m;
                        fnVar2.J = fdVar2.w;
                        fnVar2.I = fdVar2.v;
                        fnVar2.K = fdVar2.C;
                        fnVar2.E = fdVar2.t;
                        fnVar2.y = fdVar2.s;
                        fnVar2.B = fdVar2.x ? 0 : 1;
                        fnVar2.C = fdVar2.z ? 0 : 1;
                        fnVar2.D = ed.a ? 1 : 0;
                        fnVar2.L = fdVar2.D ? 1 : 0;
                        fnVar2.M = fdVar2.A ? 1 : 0;
                        fnVar2.F = fdVar2.y;
                        fnVar2.l = fdVar2.b;
                        fnVar2.H = fdVar2.u;
                    }
                    if (eo.a() != null) {
                        eo.a();
                        eo.a(fnVar2);
                    }
                    fx.b("ReportTask", "finish report");
                }
            }
        } catch (Exception e2) {
        }
    }
}
