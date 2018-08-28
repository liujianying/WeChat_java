package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.map.lib.mapstructure.TappedElement;

public class iy implements iw {
    protected iz a;
    protected GLIcon b;
    protected ja c;
    protected DoublePoint d;
    private gy e;
    private boolean f;
    private gf g;

    public iy() {
        this.d = new DoublePoint();
        this.g = null;
        this.f = true;
    }

    public iy(iz izVar) {
        this.d = new DoublePoint();
        this.g = null;
        this.a = izVar;
        this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
        this.b.setFixPos(izVar.n());
        this.b.setFastLoad(izVar.o());
        this.b.setRotateAngle(izVar.h());
        this.b.setAvoidAnno(izVar.j());
        this.b.setAlpha(izVar.e());
        this.f = true;
    }

    public void a(iz izVar) {
        if (izVar != null) {
            if (this.a == null) {
                this.a = izVar;
            } else {
                this.a.a(izVar.e());
                this.a.a(izVar.f(), izVar.g());
                this.a.b(izVar.d());
                this.a.a(izVar.h());
                this.a.b(izVar.m());
                this.a.c(izVar.j());
            }
            if (this.b == null) {
                this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
            }
            this.b.setAlpha(this.a.e());
            this.b.setAnchor(this.a.f(), this.a.g());
            this.b.setRotateAngle(izVar.h());
            this.b.setFixPos(izVar.n());
            this.b.setFastLoad(izVar.o());
            this.b.setAvoidAnno(izVar.j());
        }
    }

    public void b(hs hsVar, hh hhVar) {
        if (c()) {
            this.e = hsVar.b();
            if (this.g != null) {
                if (this.g.b()) {
                    this.g = null;
                } else {
                    this.g.a();
                }
            }
            if (this.b != null) {
                hsVar.a(this.a.a(), this.b, this.a.d(), this.a.h(), this.a.i(), this.a.p(), this.a.m());
            }
        } else if (this.b != null) {
            this.b.mDisplayId = -1;
        }
    }

    public boolean a(hh hhVar, float f, float f2) {
        if (!c() || this.a.a() == null || this.e == null) {
            return false;
        }
        boolean z;
        TappedElement a = this.e.f().a(f, f2);
        if (a == null || a.param1 != ((long) e())) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.b.setState(1);
        } else {
            this.b.setState(0);
        }
        if (!z || this.c == null) {
            return z;
        }
        this.c.a(this);
        return z;
    }

    public Rect a(hh hhVar) {
        if (this.b == null || this.a == null || this.a.a() == null) {
            return null;
        }
        DoublePoint doublePoint;
        if (d()) {
            GeoPoint a = a();
            doublePoint = new DoublePoint(0.0d, 0.0d);
            if (a != null) {
                doublePoint.x = (double) a.getLongitudeE6();
                doublePoint.y = (double) a.getLatitudeE6();
            }
            this.d = doublePoint;
        } else {
            this.d = hhVar.b(a());
        }
        DoublePoint doublePoint2 = new DoublePoint();
        doublePoint = new DoublePoint();
        Bitmap textureBm = this.b.getTextureBm(this.b.getState());
        int width = textureBm.getWidth();
        int height = textureBm.getHeight();
        doublePoint2.x = this.d.x;
        doublePoint.x = this.d.x + ((double) width);
        doublePoint2.y = this.d.y;
        doublePoint.y = this.d.y + ((double) height);
        width = (int) (((float) width) * this.a.f());
        height = (int) (((float) height) * this.a.g());
        doublePoint2.x -= (double) width;
        doublePoint.x -= (double) width;
        doublePoint2.y -= (double) height;
        doublePoint.y -= (double) height;
        height = this.a.k();
        width = this.a.l();
        doublePoint2.x += (double) height;
        doublePoint.x += (double) height;
        doublePoint2.y += (double) width;
        doublePoint.y = ((double) width) + doublePoint.y;
        GeoPoint a2 = hhVar.a(doublePoint2);
        GeoPoint a3 = hhVar.a(doublePoint);
        return new Rect(a2.getLongitudeE6(), a3.getLatitudeE6(), a3.getLongitudeE6(), a2.getLatitudeE6());
    }

    public Rect b(hh hhVar) {
        if (this.b == null || this.a == null || this.a.a() == null) {
            return null;
        }
        int width;
        int height;
        int i;
        if (d()) {
            GeoPoint a = a();
            DoublePoint doublePoint = new DoublePoint(0.0d, 0.0d);
            if (a != null) {
                doublePoint.x = (double) a.getLongitudeE6();
                doublePoint.y = (double) a.getLatitudeE6();
            }
            this.d = doublePoint;
        } else {
            this.d = hhVar.b(a());
        }
        DoublePoint doublePoint2 = new DoublePoint();
        DoublePoint doublePoint3 = new DoublePoint();
        Bitmap textureBm = this.b.getTextureBm(this.b.getState());
        if (textureBm != null) {
            width = textureBm.getWidth();
            height = textureBm.getHeight();
            i = width;
        } else {
            height = 0;
            i = 0;
        }
        doublePoint2.x = this.d.x;
        doublePoint3.x = this.d.x + ((double) i);
        doublePoint2.y = this.d.y;
        doublePoint3.y = this.d.y + ((double) height);
        width = (int) (this.a.f() * ((float) i));
        height = (int) (((float) height) * this.a.g());
        doublePoint2.x -= (double) width;
        doublePoint3.x -= (double) width;
        doublePoint2.y -= (double) height;
        doublePoint3.y -= (double) height;
        height = this.a.k();
        width = this.a.l();
        doublePoint2.x += (double) height;
        doublePoint3.x += (double) height;
        doublePoint2.y += (double) width;
        doublePoint3.y = ((double) width) + doublePoint3.y;
        return new Rect((int) doublePoint2.x, (int) doublePoint2.y, (int) doublePoint3.x, (int) doublePoint3.y);
    }

    public void a(String str, Bitmap... bitmapArr) {
        this.a = this.a.a(str, bitmapArr);
        if (this.b != null) {
            this.b.update(str, bitmapArr);
            this.b.setDirty(true);
        }
    }

    public void a(GeoPoint geoPoint) {
        this.a = this.a.a(geoPoint);
        if (this.b != null) {
            this.b.setPosition(geoPoint);
            this.b.setDirty(true);
        }
    }

    public GeoPoint a() {
        return this.a.a();
    }

    public void a(int i) {
        this.a = this.a.a(i);
        if (this.b != null) {
            this.b.setRotateAngle(i);
            this.b.setDirty(true);
        }
    }

    public void a(float f) {
        this.a = this.a.a(f);
        if (this.b != null) {
            this.b.setAlpha(f);
            this.b.setDirty(true);
        }
    }

    public void a(float f, float f2) {
        this.a = this.a.a(f, f2);
        if (this.b != null) {
            this.b.setAnchor(f, f2);
            this.b.setDirty(true);
        }
    }

    public float b() {
        return this.a.g();
    }

    public void b(int i) {
        this.a = this.a.b(i);
        if (this.b != null) {
            this.b.setDirty(true);
        }
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void b(boolean z) {
        if (this.b != null) {
            this.b.setFixPos(z);
            this.b.setDirty(true);
        }
    }

    public boolean d() {
        if (this.b != null) {
            return this.b.isFixPos();
        }
        return false;
    }

    public int e() {
        if (this.b != null) {
            return this.b.mDisplayId;
        }
        return -1;
    }

    public float f() {
        if (this.b != null) {
            return this.b.getLeft();
        }
        return 0.0f;
    }

    public float g() {
        if (this.b != null) {
            return this.b.getRight();
        }
        return 0.0f;
    }

    public float h() {
        if (this.b != null) {
            return this.b.getTop();
        }
        return 0.0f;
    }

    public float i() {
        if (this.b != null) {
            return this.b.getBottom();
        }
        return 0.0f;
    }

    public void j() {
        if (this.b != null) {
            this.b.mDisplayId = 0;
        }
    }
}
