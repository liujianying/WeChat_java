package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class qa implements Projection {
    private ty a;

    public qa(ty tyVar) {
        this.a = tyVar;
    }

    public LatLng fromScreenLocation(Point point) {
        if (this.a != null) {
            return qc.a(this.a.a(point));
        }
        return null;
    }

    public Point toScreenLocation(LatLng latLng) {
        if (this.a != null) {
            return this.a.a(qc.a(latLng));
        }
        return null;
    }

    public VisibleRegion getVisibleRegion() {
        if (this.a != null) {
            return qc.a(this.a.a());
        }
        return null;
    }

    public double distanceBetween(LatLng latLng, LatLng latLng2) {
        if (this.a != null) {
            return this.a.a(qc.a(latLng), qc.a(latLng2));
        }
        return -1.0d;
    }

    public float metersToEquatorPixels(float f) {
        if (this.a != null) {
            return this.a.a(f);
        }
        return -1.0f;
    }

    public float metersToPixels(double d, double d2) {
        if (this.a != null) {
            return this.a.a(d, d2);
        }
        return -1.0f;
    }

    public double getLatitudeSpan() {
        if (this.a != null) {
            return ((double) this.a.b()) / 1000000.0d;
        }
        return -1.0d;
    }

    public double getLongitudeSpan() {
        if (this.a != null) {
            return ((double) this.a.c()) / 1000000.0d;
        }
        return -1.0d;
    }

    public float getScalePerPixel() {
        if (this.a != null) {
            return this.a.d();
        }
        return -1.0f;
    }

    public Point toPixels(GeoPoint geoPoint, Point point) {
        LatLng g2l = GeoPoint.g2l(geoPoint);
        if (g2l == null) {
            return null;
        }
        return toScreenLocation(g2l);
    }
}
