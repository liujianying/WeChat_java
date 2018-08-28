package com.tencent.tencentmap.mapsdk.a;

import java.util.List;

public final class pd {
    private pe a = null;
    private String b = "";
    private my c = null;

    public pd(pe peVar, my myVar, String str) {
        this.b = str;
        this.a = peVar;
        this.c = myVar;
    }

    public final void a() {
        if (this.c != null) {
            this.c.a(this.b);
        }
    }

    public final String b() {
        return this.b;
    }

    public final void a(List<ox> list) {
        if (this.c != null) {
            this.c.a(this.b, list);
            this.a.a(list);
        }
    }

    public final List<ox> c() {
        return this.a.a();
    }

    public final void a(float f) {
        this.c.a(this.b, f);
        this.a.a(f);
    }

    public final float d() {
        return this.a.b();
    }

    public final void a(int i) {
        this.c.b(this.b, i);
        this.a.a(i);
    }

    public final int e() {
        return this.a.c();
    }

    public final void b(int i) {
        this.c.a(this.b, i);
        this.a.b(i);
    }

    public final int f() {
        return this.a.d();
    }

    public final void c(int i) {
        this.c.b(this.b, (float) i);
        this.a.c(i);
    }

    public final float g() {
        return this.a.e();
    }

    public final void a(boolean z) {
        this.c.a(this.b, z);
        this.a.a(z);
    }

    public final boolean h() {
        return this.a.f();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pd)) {
            return false;
        }
        return this.b.equals(((pd) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final boolean a(ox oxVar) {
        List c = c();
        if (c == null || c.size() < 3 || oxVar == null) {
            return false;
        }
        int size = c.size() - 1;
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c.size()) {
                while (true) {
                    boolean z2 = z;
                    if (0 >= c.size()) {
                        return z2;
                    }
                    if (((((ox) c.get(0)).a < oxVar.a && ((ox) c.get(size)).a >= oxVar.a) || (((ox) c.get(size)).a < oxVar.a && ((ox) c.get(0)).a >= oxVar.a)) && (((ox) c.get(0)).b <= oxVar.b || ((ox) c.get(size)).b <= oxVar.b)) {
                        if (((((ox) c.get(size)).b - ((ox) c.get(0)).b) * ((oxVar.a - ((ox) c.get(0)).a) / (((ox) c.get(size)).a - ((ox) c.get(0)).a))) + ((ox) c.get(0)).b <= oxVar.b) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        z2 ^= i;
                    }
                    z = 0 + 1;
                    z2 = z2;
                    size = 0;
                }
            } else if (((ox) c.get(i2)).equals(oxVar)) {
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }
}
