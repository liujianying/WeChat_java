package com.tencent.tencentmap.mapsdk.a;

import java.util.List;

public class rc {
    private final sx a;

    public rc(sx sxVar) {
        this.a = sxVar;
    }

    public void a() {
        this.a.i();
    }

    public void a(float f) {
        this.a.a(f);
    }

    public void a(int i) {
        this.a.a(i);
    }

    public void a(List<qw> list) {
        this.a.a(list);
    }

    public void a(boolean z) {
        this.a.b(z);
    }

    public String b() {
        return this.a.j();
    }

    public void b(float f) {
        this.a.b(f);
    }

    public void b(boolean z) {
        if (this.a.d() != z) {
            List c = c();
            this.a.c(z);
            a(c);
        }
    }

    public List<qw> c() {
        return this.a.a();
    }

    public void c(boolean z) {
        this.a.a(z);
    }

    public float d() {
        return this.a.b();
    }

    public int e() {
        return this.a.e();
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof rc) ? false : this.a.a(((rc) obj).a);
    }

    public float f() {
        return this.a.k();
    }

    public boolean g() {
        return this.a.l();
    }

    public boolean h() {
        return this.a.d();
    }

    public final int hashCode() {
        return this.a.m();
    }

    public boolean i() {
        return this.a.c();
    }
}
