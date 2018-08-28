package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

public abstract class kk {
    protected long a;
    protected long b;
    protected a c;
    protected b d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Interpolator h;

    protected abstract void a(float f, Interpolator interpolator);

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    private long f() {
        return SystemClock.uptimeMillis();
    }

    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (this.a <= 0) {
            return false;
        }
        this.f = true;
        this.b = f();
        this.e = true;
        if (this.c == null) {
            return true;
        }
        this.c.b();
        return true;
    }

    public void a() {
        this.e = false;
    }

    public boolean b() {
        return this.e;
    }

    public void c() {
        if (this.e) {
            float f = ((float) (f() - this.b)) / ((float) this.a);
            if (f > 1.0f) {
                this.e = false;
                a(1.0f, this.h);
                if (this.c != null) {
                    this.c.a();
                }
                this.g = true;
                return;
            }
            a(f, this.h);
        } else if (!this.g && this.c != null) {
            this.c.a();
        }
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.g;
    }
}
