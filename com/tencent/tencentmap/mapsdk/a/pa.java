package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.tencentmap.mapsdk.a.ac.m;
import java.util.List;

public final class pa implements ou {
    private boolean a = false;
    private String b;
    private int c = -1;
    private boolean d = false;
    private pb e = null;
    private String f = "";
    private boolean g = false;
    private mr h = null;
    private boolean i = false;
    private int j = 0;
    private boolean k = false;
    private m l;
    private Object m;

    public pa(pb pbVar, mr mrVar, String str) {
        this.f = str;
        this.e = pbVar;
        this.h = mrVar;
        this.k = pbVar.p();
        this.j = pbVar.o();
        this.m = this.e.r();
    }

    public final String b() {
        return this.b;
    }

    public final boolean c() {
        return this.a;
    }

    public final void a(int i) {
        if (this.h != null) {
            this.c = i;
        }
    }

    public final int d() {
        return this.c;
    }

    public final boolean e() {
        return this.d;
    }

    public final void f() {
        if (this.h != null) {
            this.h.a(this.f);
        }
    }

    public final String g() {
        return this.f;
    }

    public final void a(ox oxVar) {
        if (this.h != null && oxVar != null) {
            this.h.a(this.f, oxVar);
            this.e.a(oxVar);
        }
    }

    public final boolean h() {
        return this.e.j();
    }

    public final ox i() {
        ox b = this.h.b(this.f);
        if (b == null) {
            return this.e.b();
        }
        return b;
    }

    public final void a(String str) {
        if (this.h != null) {
            this.e.a(str);
            this.h.b(this.f, str);
        }
    }

    public final String j() {
        return this.e.c();
    }

    public final void b(String str) {
        if (this.h != null) {
            this.e.b(str);
            this.h.a(this.f, str);
        }
    }

    public final String k() {
        return this.e.d();
    }

    public final float l() {
        return this.e.k();
    }

    public final void a(boolean z) {
        if (this.h != null) {
            this.h.a(this.f, z);
            mr mrVar = this.h;
            String str = this.f;
            boolean z2 = !z && s();
            mrVar.c(str, z2);
            this.e.a(z);
        }
    }

    public final boolean m() {
        return this.e.h();
    }

    public final void n() {
        if (this.h != null) {
            this.h.c(this.f);
        }
    }

    public final void o() {
        if (this.h != null) {
            this.h.d(this.f);
        }
    }

    public final boolean p() {
        if (this.h == null) {
            return false;
        }
        return this.h.e(this.f);
    }

    public final void a(float f, float f2) {
        if (this.h != null) {
            this.h.a(this.f, f, f2);
            this.e.a(f, f2);
        }
    }

    public final void b(boolean z) {
        if (this.h != null) {
            this.h.b(this.f, z);
            this.e.b(z);
        }
    }

    public final void a(on onVar) {
        if (this.h != null) {
            this.h.a(this.f, onVar);
            this.e.a(onVar);
        }
    }

    public final void a(float f) {
        if (this.h != null) {
            this.h.a(this.f, f);
            this.e.a(f);
        }
    }

    public final float q() {
        if (this.h == null) {
            return 0.0f;
        }
        return this.h.f(this.f);
    }

    public final boolean r() {
        if (this.h == null) {
            return false;
        }
        return this.e.i();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pa)) {
            return false;
        }
        return this.f.equals(((pa) obj).f);
    }

    public final void b(float f) {
        if (this.h != null) {
            this.h.b(this.f, f);
            this.e.b(f);
        }
    }

    final boolean s() {
        return this.h.g(this.f);
    }

    public final void c(float f) {
        this.h.c(this.f, f);
        this.e.c(f);
    }

    public final float t() {
        if (this.e != null) {
            return this.e.l();
        }
        return 0.0f;
    }

    public final int a(Context context) {
        on e = this.e.e();
        if (e == null) {
            return 0;
        }
        Bitmap a = e.a().a(context);
        if (a != null) {
            return a.getWidth();
        }
        return 0;
    }

    public final int b(Context context) {
        on e = this.e.e();
        if (e == null) {
            return 0;
        }
        Bitmap a = e.a().a(context);
        if (a != null) {
            return a.getHeight();
        }
        return 0;
    }

    public final float u() {
        return this.e.f();
    }

    public final float v() {
        return this.e.g();
    }

    public final int w() {
        return this.j;
    }

    public final boolean x() {
        return this.k;
    }

    public final m y() {
        return this.l;
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final List<iw> a() {
        return this.h.h(this.f);
    }

    public final void a(Object obj) {
        this.m = obj;
    }

    public final Object z() {
        return this.m;
    }
}
