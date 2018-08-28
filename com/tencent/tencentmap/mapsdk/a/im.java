package com.tencent.tencentmap.mapsdk.a;

public class im implements hg {
    private hv a = null;
    private il b = null;
    private jg c = null;

    public im(hv hvVar, jg jgVar) {
        this.a = hvVar;
        this.c = jgVar;
    }

    public void b() {
        if (this.a != null) {
            this.a.a().a(this);
            if (this.b == null) {
                this.b = new il(this.a, this.c);
            }
            try {
                this.b.start();
            } catch (Exception e) {
            }
        }
    }

    public void c() {
        if (this.b != null) {
            this.b.a();
        }
    }

    public void d() {
        if (this.b != null) {
            this.b.b();
            a();
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.a().b(this);
            if (this.b != null) {
                this.b.c();
                this.b = null;
            }
        }
    }

    public void a() {
        if (this.b != null) {
            synchronized (this.b) {
                this.b.notify();
            }
        }
    }

    public void f() {
        e();
    }
}
