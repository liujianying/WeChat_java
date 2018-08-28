package com.tencent.map.lib.util;

import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.math.BigDecimal;

public class MathUtil {
    public static double getDoubleByDecimalNum(double d, int i) {
        try {
            return new BigDecimal(d).setScale(i, 4).doubleValue();
        } catch (Exception e) {
            return d;
        }
    }

    public static float getFloatByDecimalNum(float f, int i) {
        try {
            return new BigDecimal((double) f).setScale(i, 4).floatValue();
        } catch (Exception e) {
            return f;
        }
    }

    public static PointF getPoiWith2Line(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        if (pointF2.x == pointF.x || pointF4.x == pointF3.x) {
            return null;
        }
        float f = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
        float f2 = (pointF4.y - pointF3.y) / (pointF4.x - pointF3.x);
        if (f == f2) {
            return null;
        }
        float f3 = ((pointF3.y * pointF4.x) - (pointF4.y * pointF3.x)) / (pointF4.x - pointF3.x);
        f = (f3 - (((pointF.y * pointF2.x) - (pointF2.y * pointF.x)) / (pointF2.x - pointF.x))) / (f - f2);
        return new PointF(f, (f2 * f) + f3);
    }

    public static double calShortestAngleDistance(double d) {
        double d2 = d % 360.0d;
        if (d2 > 180.0d) {
            return d2 - 360.0d;
        }
        if (d2 < -180.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    public static Rect getExtendedBound(GeoPoint geoPoint, Rect rect) {
        int max = Math.max(Math.abs(rect.left - geoPoint.getLongitudeE6()), Math.abs(rect.right - geoPoint.getLongitudeE6()));
        int max2 = Math.max(Math.abs(rect.top - geoPoint.getLatitudeE6()), Math.abs(rect.bottom - geoPoint.getLatitudeE6()));
        return new Rect(geoPoint.getLongitudeE6() - max2, geoPoint.getLatitudeE6() - max, max2 + geoPoint.getLongitudeE6(), max + geoPoint.getLatitudeE6());
    }

    public static Rect getBound(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null || geoPoint.equals(geoPoint2)) {
            return null;
        }
        int abs = Math.abs(geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6());
        int abs2 = Math.abs(geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6());
        return new Rect(geoPoint.getLongitudeE6() - abs, geoPoint.getLatitudeE6() - abs2, abs + geoPoint.getLongitudeE6(), abs2 + geoPoint.getLatitudeE6());
    }

    public static GeoPoint findClosetPoint(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        int latitudeE6 = geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint2.getLongitudeE6() - geoPoint.getLongitudeE6();
        if (latitudeE6 == 0 && longitudeE6 == 0) {
            return null;
        }
        double latitudeE62 = ((double) (((geoPoint3.getLatitudeE6() - geoPoint.getLatitudeE6()) * latitudeE6) + ((geoPoint3.getLongitudeE6() - geoPoint.getLongitudeE6()) * longitudeE6))) / ((double) ((latitudeE6 * latitudeE6) + (longitudeE6 * longitudeE6)));
        if (latitudeE62 < 0.0d) {
            return new GeoPoint(geoPoint);
        }
        if (latitudeE62 > 1.0d) {
            return new GeoPoint(geoPoint2);
        }
        return new GeoPoint(((int) (((double) latitudeE6) * latitudeE62)) + geoPoint.getLatitudeE6(), ((int) (latitudeE62 * ((double) longitudeE6))) + geoPoint.getLongitudeE6());
    }

    public static double angle2Radian(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    public static double radian2Angle(double d) {
        return (180.0d * d) / 3.141592653589793d;
    }
}
