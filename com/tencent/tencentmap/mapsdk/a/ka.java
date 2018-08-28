package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import android.graphics.Point;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.mapstructure.Polygon2D;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class ka extends ke {
    Polygon2D a;
    private GeoPoint b = new GeoPoint(39909230, 116397428);
    private double c = 1000.0d;
    private double d = -1.0d;
    private float e = 1.0f;
    private ks f = null;
    private List<GeoPoint> g = new ArrayList();
    private ot h;
    private os i;

    public ka(ks ksVar) {
        this.f = ksVar;
        this.a = new Polygon2D();
        this.a.polygonId = -1;
    }

    public void a(ot otVar) {
        if (otVar != null) {
            this.h = otVar;
            ox a = otVar.a();
            if (a != null) {
                a(kh.a(a));
            }
            a(otVar.b());
            d(otVar.c());
            b(otVar.d());
            c(otVar.e());
            c((float) otVar.f());
            a_(otVar.g());
            this.h = otVar;
            this.O = true;
        }
    }

    public void a(GeoPoint geoPoint) {
        if (geoPoint != null) {
            if (this.b == null) {
                this.b = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            } else {
                this.b.setLatitudeE6(geoPoint.getLatitudeE6());
                this.b.setLongitudeE6(geoPoint.getLongitudeE6());
            }
            this.O = true;
        }
    }

    public void a(double d) {
        if (d >= 0.0d) {
            if (d == 0.0d) {
                d = 1.0E-10d;
            }
            if (this.h != null && this.h.a() != null) {
                float a = (float) kh.a(d, this.h.a().a);
                if (this.d == -1.0d) {
                    this.d = (double) a;
                    this.e = 1.0f;
                } else {
                    if (this.d == 0.0d) {
                        this.d = 1.0E-10d;
                    }
                    this.e = (float) (((double) a) / this.d);
                }
                this.c = (double) a;
                this.O = true;
            }
        }
    }

    public void a(GL10 gl10) {
        if (a()) {
            c();
            return;
        }
        this.f.getMap().c(this.a.polygonId);
        this.a.polygonId = -1;
    }

    public boolean a(float f, float f2) {
        if (this.b == null) {
            return false;
        }
        GeoPoint a = this.f.getMap().s().a(new DoublePoint((double) f, (double) f2));
        if (Math.hypot((double) (a.getLatitudeE6() - this.b.getLatitudeE6()), (double) (a.getLongitudeE6() - this.b.getLongitudeE6())) <= this.c) {
            return true;
        }
        return false;
    }

    public boolean a() {
        return this.N;
    }

    public void a_(boolean z) {
        this.N = z;
    }

    public void b() {
    }

    public void c() {
        if (this.a.polygonId < 0 || this.O) {
            this.a.color = a(this.K);
            this.a.borderColor = a(this.L);
            this.a.borderWidth = this.J;
            this.a.pointsCount = 128;
            this.a.polygonMode = 1;
            this.a.originalRadius = (float) this.d;
            this.a.scale = this.e;
            this.a.zIndex = this.M;
            if (this.b != null) {
                this.a.centerX = this.b.getLatitudeE6();
                this.a.centerY = this.b.getLongitudeE6();
            }
            this.a.points = new Point[0];
            if (-1 == this.a.polygonId) {
                this.a.polygonId = this.f.getMap().a(this.a);
            } else if (this.O) {
                this.f.getMap().b(this.a);
            }
            this.O = false;
        }
    }

    private int[] a(int i) {
        return new int[]{Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i)};
    }

    public void d() {
        if (this.a != null) {
            this.f.getMap().c(this.a.polygonId);
        }
        this.d = -1.0d;
        this.b = null;
        this.i = null;
    }

    public void a(os osVar) {
        this.i = osVar;
    }
}
