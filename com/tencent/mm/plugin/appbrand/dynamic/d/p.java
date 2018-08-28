package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.u.c.d;

public class p {
    private static volatile d fwp;
    private static volatile d fwq;

    public static d kc(int i) {
        if (i == 1) {
            return afk();
        }
        return afj();
    }

    private static d afj() {
        if (fwp == null) {
            synchronized (p.class) {
                if (fwp == null) {
                    d dVar = new d();
                    dVar.a(new l(312));
                    dVar.a(new d(306));
                    dVar.a(new e(306));
                    dVar.a(new b(305));
                    dVar.a(new c(307));
                    dVar.a(new k(309));
                    dVar.a(new j(310));
                    dVar.a(new f(311));
                    dVar.a(new o());
                    fwp = dVar;
                }
            }
        }
        return fwp;
    }

    private static d afk() {
        if (fwq == null) {
            synchronized (p.class) {
                if (fwq == null) {
                    d dVar = new d();
                    dVar.a(new l(289));
                    dVar.a(new d(266));
                    dVar.a(new e(266));
                    dVar.a(new b(265));
                    dVar.a(new c(267));
                    dVar.a(new k(281));
                    dVar.a(new j(282));
                    dVar.a(new f(287));
                    dVar.a(new h());
                    dVar.a(new i());
                    dVar.a(new n());
                    dVar.a(new m());
                    dVar.a(new o());
                    dVar.a(new h());
                    dVar.a(new g());
                    dVar.a(new a());
                    fwq = dVar;
                }
            }
        }
        return fwq;
    }
}
