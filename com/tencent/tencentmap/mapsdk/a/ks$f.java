package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;

class ks$f implements ac$f {
    private final WeakReference<ks> a;

    public ks$f(ks ksVar) {
        this.a = new WeakReference(ksVar);
    }

    private boolean c() {
        return this.a == null || this.a.get() == null;
    }

    public boolean a() {
        if (c()) {
            return false;
        }
        ks ksVar = (ks) this.a.get();
        if (ks.o(ksVar) != null) {
            ks.o(ksVar).a();
        }
        le p = ks.p(ksVar);
        if (p != null) {
            p.a(true);
        }
        return true;
    }

    public boolean a(ov ovVar) {
        if (c()) {
            return false;
        }
        ks ksVar = (ks) this.a.get();
        if (ks.o(ksVar) != null) {
            ks.o(ksVar).a(ovVar);
        }
        le p = ks.p(ksVar);
        if (p != null && p.b() && ksVar.getMap().h() >= 16) {
            p.a(ovVar);
        }
        return true;
    }

    public boolean b() {
        if (c()) {
            return false;
        }
        ks ksVar = (ks) this.a.get();
        if (ks.o(ksVar) != null) {
            ks.o(ksVar).b();
        }
        le p = ks.p(ksVar);
        if (p != null) {
            p.a(false);
        }
        return true;
    }
}
