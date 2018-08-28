package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class qm implements Projection {
    private ab a;
    private ac b;

    public qm(ac acVar) {
        this.a = acVar.m();
        this.b = acVar;
    }

    public LatLng fromScreenLocation(Point point) {
        return qo.a(this.a.a(point));
    }

    public Point toScreenLocation(LatLng latLng) {
        return this.a.a(qo.a(latLng));
    }

    public VisibleRegion getVisibleRegion() {
        return qo.a(this.a.b());
    }

    public double distanceBetween(LatLng latLng, LatLng latLng2) {
        return qg.a(latLng, latLng2);
    }

    public float metersToEquatorPixels(float f) {
        qf.a("call metersToEquatorPixels");
        return metersToPixels(0.0d, (double) f);
    }

    public float metersToPixels(double d, double d2) {
        qf.a("call metersToPixels");
        return (float) (d2 / this.a.a(d));
    }

    public double getLatitudeSpan() {
        pj b = this.a.b();
        if (b == null) {
            return -1.0d;
        }
        return b.e.a.a - b.e.b.a;
    }

    public double getLongitudeSpan() {
        pj b = this.a.b();
        if (b == null) {
            return -1.0d;
        }
        return b.e.a.b - b.e.b.b;
    }

    public float getScalePerPixel() {
        return (float) this.a.a(this.b.d().a.a);
    }

    @Deprecated
    public Point toPixels(GeoPoint geoPoint, Point point) {
        LatLng g2l = GeoPoint.g2l(geoPoint);
        if (g2l == null) {
            return null;
        }
        return toScreenLocation(g2l);
    }
}
