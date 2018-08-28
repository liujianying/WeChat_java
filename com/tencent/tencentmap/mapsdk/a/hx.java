package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;
import com.tencent.map.lib.e;
import java.lang.ref.WeakReference;

public class hx extends ij {
    private gy a;
    private boolean b;
    private float c;
    private e d;
    private boolean e = false;
    private final float f;
    private WeakReference<hp> g;

    public hx(gy gyVar) {
        this.a = gyVar;
        this.g = gyVar.b();
        if (!(this.g == null || this.g.get() == null)) {
            ((hp) this.g.get()).a(this);
        }
        this.d = new e();
        this.f = gyVar.h() * 2.5f;
    }

    public void a(e eVar) {
        this.d = eVar;
        boolean a = eVar.a();
        if (this.g != null && this.g.get() == null) {
            if (a) {
                ((hp) this.g.get()).b(this);
            } else {
                ((hp) this.g.get()).a(this);
            }
        }
    }

    public boolean a(float f, float f2) {
        if (this.d.f()) {
            ht a = this.a.a();
            a.a(f, f2, new 1(this, a));
        }
        return false;
    }

    public boolean b(float f, float f2) {
        if (this.d.g()) {
            return m(f, f2);
        }
        return false;
    }

    public boolean c(float f, float f2) {
        if (this.d.b() && this.d.c()) {
            l(f, f2);
        }
        return false;
    }

    public boolean d(float f, float f2) {
        if (this.d.b()) {
            this.a.a().a(f, f2);
        }
        return false;
    }

    public boolean e(float f, float f2) {
        return false;
    }

    public boolean f(float f, float f2) {
        if (this.d.f()) {
            this.c = this.a.a().l();
        }
        return false;
    }

    public boolean g(float f, float f2) {
        if (this.d.f()) {
            this.a.a().j((double) (b((1.0f - (f2 / ((float) this.a.g().height()))) * 10.0f) * this.c));
        }
        return true;
    }

    private static float b(float f) {
        if (f < 5.0f) {
            return 0.2f + ((0.8f * f) / 5.0f);
        }
        return 1.0f + (((f - 5.0f) * 4.0f) / 5.0f);
    }

    public boolean h(float f, float f2) {
        return false;
    }

    public boolean a() {
        if (this.d.h()) {
            ht a = this.a.a();
            a.b(new 2(this, a));
        }
        return false;
    }

    public boolean b() {
        if (this.b) {
            this.a.a().A();
            this.b = false;
        }
        return false;
    }

    public boolean a(float f) {
        if (!this.d.d() || !this.a.a().B()) {
            return false;
        }
        this.a.a().i((double) ((f / 8.0f) * 2.0f));
        return true;
    }

    public boolean c() {
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, float f) {
        if (this.d.e()) {
            if (!this.a.a().B()) {
                return false;
            }
            this.a.a().a((double) f, (double) pointF.x, (double) pointF.y, (double) pointF2.x, (double) pointF2.y);
        }
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        if (this.d.i()) {
            double d3 = d2 / d;
            ht a = this.a.a();
            a.a(d3, (double) pointF.x, (double) pointF.y, (double) pointF2.x, (double) pointF2.y, new 3(this, a));
        }
        return false;
    }

    public boolean i(float f, float f2) {
        if (this.b) {
            this.a.a().A();
            this.b = false;
        }
        return false;
    }

    public boolean j(float f, float f2) {
        return false;
    }

    private void l(float f, float f2) {
        this.e = true;
        if (!this.b) {
            float f3 = f / 64.0f;
            float f4 = f2 / 64.0f;
            if (Math.abs(f3) >= this.f || Math.abs(f4) >= this.f) {
                long min = Math.min(250, ((long) Math.max(Math.abs(f), Math.abs(f2))) >> 3);
                PointF pointF = new PointF(f3, f4);
                long currentTimeMillis = System.currentTimeMillis();
                this.b = true;
                this.a.a().b(new 4(this, 3, new double[]{0.0d, 0.0d}, currentTimeMillis, min, pointF));
            }
        }
    }

    private boolean m(float f, float f2) {
        return this.a.c().a(this.a.d(), f, f2);
    }
}
