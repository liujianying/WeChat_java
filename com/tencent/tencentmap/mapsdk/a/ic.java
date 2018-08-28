package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;

public class ic implements Cloneable {
    private int a = -1;
    private a b = new a();
    private Rect c = new Rect();
    private int d;
    private double e;
    private double f;
    private double g = 0.0d;
    private double h = 1.0d;
    private double i = 0.0d;
    private double j = 1.0d;
    private double k = 0.0d;
    private double l = 1.0d;
    private GeoPoint m = new GeoPoint();
    private Rect n;
    private hv o;
    private hq p;
    private Integer q = Integer.valueOf(0);
    private DoublePoint r = new DoublePoint();
    private b s;

    public ic(hv hvVar) {
        this.o = hvVar;
        this.p = hvVar.f();
    }

    public void a(ic icVar) {
        this.a = icVar.a;
        this.b.a(icVar.b);
        this.c.set(icVar.c);
        this.d = icVar.d;
        this.e = icVar.e;
        this.f = icVar.f;
        this.g = icVar.g;
        this.h = icVar.h;
        this.i = icVar.i;
        this.j = icVar.j;
        this.k = icVar.k;
        this.l = icVar.l;
        this.m.setGeoPoint(icVar.m);
        this.r.set(icVar.r.x, icVar.r.y);
        this.n = icVar.n;
    }

    public void a(Rect rect, int i, int i2, int i3) {
        this.n = rect;
        this.c = hr.a(2);
        b(i3);
        a(0);
        a(i, i2, false);
    }

    public void a() {
        if (this.o != null) {
            this.m = this.p.q();
            int s = this.p.s();
            float r = this.p.r();
            if (s != j()) {
                this.o.a().a(c.c);
            } else if (r != i()) {
                this.o.a().a(c.b);
            }
            if (this.b != null) {
                this.b.a(s, r);
            }
            this.a = this.p.y();
        }
    }

    public boolean a(int i) {
        if (this.p == null) {
            return false;
        }
        int y = this.p.y();
        if (y == i) {
            return false;
        }
        if (y == 2) {
            this.o.d(false);
        }
        if (i == 2) {
            this.o.d(true);
        }
        this.a = i;
        this.p.b(i, b(y, i));
        return true;
    }

    public int b() {
        if (this.p == null) {
            return this.a;
        }
        return this.p.y();
    }

    public float a(float f) {
        if (this.p.x() == f) {
            return f;
        }
        float f2 = f % 360.0f;
        double toRadians = Math.toRadians((double) f);
        this.g = Math.sin(toRadians);
        this.h = Math.cos(toRadians);
        if (this.p != null) {
            this.p.a(f2);
        }
        return f2;
    }

    public float c() {
        return this.p.x();
    }

    public float b(float f) {
        if (this.p.w() == f) {
            return f;
        }
        float max = Math.max(0.0f, Math.min(40.0f, f));
        double toRadians = Math.toRadians((double) f);
        this.i = Math.sin(toRadians);
        this.j = Math.cos(toRadians);
        toRadians = 1.5707963267948966d - toRadians;
        this.l = Math.cos(toRadians);
        this.k = Math.sin(toRadians);
        if (this.p != null) {
            this.p.b(max);
        }
        return max;
    }

    public float d() {
        return this.p.w();
    }

    public c c(float f) {
        float r;
        int s;
        c cVar;
        c cVar2 = c.a;
        float a = this.b.a();
        int b = this.b.b();
        if (this.p != null) {
            this.p.a((double) f, false);
            r = this.p.r();
            s = this.p.s();
        } else {
            s = b;
            r = a;
        }
        this.b.a(s, r);
        if (s != b) {
            cVar = c.c;
        } else if (r != a) {
            cVar = c.b;
        } else {
            cVar = cVar2;
        }
        switch (1.a[cVar.ordinal()]) {
            case 1:
                c(this.b.b());
                break;
        }
        DoublePoint a2 = ha.a(this, p());
        this.r.set(a2.x, a2.y);
        return cVar;
    }

    public void e() {
        c(this.b.b());
        DoublePoint a = ha.a(this, p());
        this.r.set(a.x, a.y);
    }

    public c d(float f) {
        if (this.p != null) {
            this.p.a((double) f);
        }
        this.b.a(f);
        return c.c;
    }

    private void c(int i) {
        double d = (double) ((1 << i) * ab.CTRL_BYTE);
        this.d = (int) d;
        this.e = d / 360.0d;
        this.f = d / 6.283185307179586d;
    }

    public boolean b(int i) {
        return c(this.b.a(i)) == c.c;
    }

    public int f() {
        return this.d;
    }

    public double g() {
        return this.e;
    }

    public double h() {
        return this.f;
    }

    public float i() {
        return this.b.a();
    }

    public int j() {
        return this.b.b();
    }

    public float k() {
        return this.b.c();
    }

    public int l() {
        return this.b.d();
    }

    public int m() {
        return this.b.e();
    }

    public int n() {
        return this.b.f();
    }

    public float o() {
        return this.b.g();
    }

    public void e(float f) {
        this.b.b(f);
    }

    public void a(Rect rect) {
        this.c.set(rect);
    }

    public boolean a(GeoPoint geoPoint) {
        return a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
    }

    public boolean a(int i, int i2, boolean z) {
        int i3;
        int width;
        boolean z2 = false;
        if ((1 << (a.b - j())) < 0) {
            i3 = 0;
        } else {
            i3 = a.b - j();
        }
        int i4 = 1 << (a.b - a.d);
        if (i4 > i3) {
            width = ((this.n.width() * i4) - (this.n.width() * i3)) / 2;
            i3 = ((i4 * this.n.height()) - (i3 * this.n.height())) / 2;
        } else {
            i3 = 0;
            width = 0;
        }
        i4 = this.c.left - width;
        width += this.c.right;
        int i5 = this.c.top - i3;
        i3 += this.c.bottom;
        if (i >= i5) {
            i5 = i;
        }
        if (i5 > i3) {
            i5 = i3;
        }
        if (i2 < i4) {
            i3 = i4;
        } else {
            i3 = i2;
        }
        if (i3 > width) {
            i3 = width;
        }
        if (!(i5 == this.m.getLatitudeE6() && i3 == this.m.getLongitudeE6())) {
            z2 = true;
        }
        this.m.setLatitudeE6(i5);
        this.m.setLongitudeE6(i3);
        DoublePoint a = ha.a(this, this.m);
        a(a.x, a.y);
        this.p.a(this.m, z);
        return z2;
    }

    public boolean a(int i, int i2) {
        int width;
        int j = 1 << (a.b - j());
        int i3 = 1 << (a.b - a.d);
        if (i3 > j) {
            width = ((this.n.width() * i3) - (this.n.width() * j)) / 2;
            j = ((i3 * this.n.height()) - (j * this.n.height())) / 2;
            i3 = width;
        } else {
            j = 0;
            i3 = 0;
        }
        int i4 = this.c.left - i3;
        width = this.c.right + i3;
        i3 = this.c.top - j;
        j += this.c.bottom;
        if (i >= i3) {
            i3 = i;
        }
        if (i3 > j) {
            i3 = j;
        }
        if (i2 < i4) {
            j = i4;
        } else {
            j = i2;
        }
        if (j > width) {
            j = width;
        }
        this.p.c(new GeoPoint(i3, j));
        return true;
    }

    public void a(double d, double d2) {
        this.r.set(d, d2);
    }

    public GeoPoint p() {
        return this.m;
    }

    public boolean a(float f, float f2, boolean z) {
        if (this.s == null) {
            this.s = new b(f, f2);
        } else {
            this.s.a(f, f2);
        }
        this.o.a(f, f2, z);
        return true;
    }

    public b q() {
        return this.s;
    }

    public byte[] r() {
        return null;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ic)) {
            return false;
        }
        ic icVar = (ic) obj;
        if (icVar.m.equals(this.m) && icVar.b.equals(this.b) && icVar.a == this.a) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        GeoPoint p = p();
        stringBuilder.append("mapParam: ");
        stringBuilder.append("center:" + p.toString() + " ");
        stringBuilder.append("mode:" + this.a + " ");
        stringBuilder.append("mapScale:" + this.b.toString() + " ");
        stringBuilder.append("screenRect:" + this.n.toString() + " ");
        return stringBuilder.toString();
    }

    public Object clone() {
        ic icVar = (ic) super.clone();
        icVar.c = new Rect(this.c);
        icVar.b = (a) this.b.clone();
        icVar.m = new GeoPoint(this.m);
        icVar.r = new DoublePoint(this.r.x, this.r.y);
        return icVar;
    }

    private boolean b(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i == 2 && i2 != 8) {
            return false;
        }
        if (i == 8 && i2 != 2) {
            return false;
        }
        if (i2 == 2 && i != 8) {
            return false;
        }
        if (i2 != 8 || i == 2) {
            return true;
        }
        return false;
    }
}
