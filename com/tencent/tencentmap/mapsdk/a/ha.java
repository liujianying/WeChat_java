package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;

public class ha implements hh {
    private ic a;
    private hq b;
    private hv c;

    public ha(ic icVar, gy gyVar) {
        this.a = icVar;
        this.b = gyVar.f();
        if (gyVar instanceof hv) {
            this.c = (hv) gyVar;
        }
    }

    public GeoPoint a(DoublePoint doublePoint) {
        if (doublePoint == null) {
            return null;
        }
        byte[] r = this.a.r();
        float f = (float) doublePoint.x;
        float f2 = (float) doublePoint.y;
        if (this.c != null) {
            Rect q = this.c.q();
            if (q != null) {
                f -= (float) q.left;
                f2 -= (float) q.top;
            }
        }
        return this.b.a(r, f, f2);
    }

    public DoublePoint b(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        double latitudeE6 = ((double) geoPoint.getLatitudeE6()) / 1000000.0d;
        double longitudeE6 = ((double) geoPoint.getLongitudeE6()) / 1000000.0d;
        PointF a = this.b.a(this.a.r(), latitudeE6, longitudeE6);
        float f = a.x;
        float f2 = a.y;
        if (this.c != null) {
            Rect q = this.c.q();
            if (q != null) {
                f += (float) q.left;
                f2 += (float) q.top;
            }
        }
        return new DoublePoint((double) f, (double) f2);
    }

    public static DoublePoint a(ic icVar, GeoPoint geoPoint) {
        if (icVar == null || geoPoint == null) {
            return null;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        int f = icVar.f() >> 1;
        double g = icVar.g();
        double h = icVar.h();
        if (geoPoint != null) {
            d2 = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
            d = ((double) f) + (g * (((double) geoPoint.getLongitudeE6()) / 1000000.0d));
            d2 = ((Math.log((1.0d + d2) / (1.0d - d2)) * h) * 0.5d) + ((double) f);
        }
        return new DoublePoint(d, d2);
    }

    public double a(double d) {
        return (4.0076E7d / (Math.pow(2.0d, (double) ((float) (((double) ((float) this.a.j())) + (Math.log((double) this.a.k()) / Math.log(2.0d))))) * 256.0d)) * Math.cos((3.141592653589793d * d) / 180.0d);
    }

    public double a(Point point, Point point2) {
        GeoPoint a = a(new DoublePoint((double) point.x, (double) point.y));
        GeoPoint a2 = a(new DoublePoint((double) point2.x, (double) point2.y));
        float[] fArr = new float[1];
        Location.distanceBetween(((double) a.getLatitudeE6()) / 1000000.0d, ((double) a.getLongitudeE6()) / 1000000.0d, ((double) a2.getLatitudeE6()) / 1000000.0d, ((double) a2.getLongitudeE6()) / 1000000.0d, fArr);
        return (double) (fArr[0] / ((float) ((int) Math.sqrt(Math.pow((double) (point.x - point2.x), 2.0d) + Math.pow((double) (point.y - point2.y), 2.0d)))));
    }
}
