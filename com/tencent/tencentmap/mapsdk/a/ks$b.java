package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.e;
import java.lang.ref.WeakReference;

class ks$b extends e {
    private WeakReference<ks> a;

    public ks$b(ks ksVar) {
        this.a = new WeakReference(ksVar);
    }

    public boolean a() {
        return super.a();
    }

    public boolean b() {
        if (this.a == null || this.a.get() == null) {
            return super.b();
        }
        return ks.a((ks) this.a.get());
    }

    public boolean c() {
        if (this.a == null || this.a.get() == null) {
            return super.c();
        }
        return ks.b((ks) this.a.get());
    }

    public boolean d() {
        if (this.a == null || this.a.get() == null) {
            return super.d();
        }
        return ks.c((ks) this.a.get());
    }

    public boolean e() {
        if (this.a == null || this.a.get() == null) {
            return super.e();
        }
        return ks.d((ks) this.a.get());
    }

    public boolean f() {
        if (this.a == null || this.a.get() == null) {
            return super.f();
        }
        return ks.e((ks) this.a.get());
    }

    public boolean g() {
        return super.g();
    }

    public boolean h() {
        if (this.a == null || this.a.get() == null) {
            return super.h();
        }
        return ks.e((ks) this.a.get());
    }

    public boolean i() {
        if (this.a == null || this.a.get() == null) {
            return super.i();
        }
        return ks.e((ks) this.a.get());
    }
}
