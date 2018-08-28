package com.tencent.tencentmap.mapsdk.a;

public class hl implements ho {
    private ho a;

    public hl(hv hvVar, jg jgVar) {
        if (hvVar != null && jgVar != null) {
            this.a = new hm(hvVar, jgVar);
        }
    }

    public void a(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public boolean a() {
        if (this.a == null) {
            return false;
        }
        return this.a.a();
    }

    public void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.c();
        }
    }

    public void d() {
        if (this.a != null) {
            this.a.d();
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.e();
            this.a = null;
        }
    }
}
