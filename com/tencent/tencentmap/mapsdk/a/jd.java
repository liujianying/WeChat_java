package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class jd {
    public static int a(List<GeoPoint> list, int[] iArr, hh hhVar) {
        int i = 0;
        if (list == null) {
            return 0;
        }
        int size = list.size();
        if (size < 2) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= size - 1) {
                return i3;
            }
            double a = a(hhVar.b((GeoPoint) list.get(i2)), hhVar.b((GeoPoint) list.get(i2 + 1)));
            i = ((int) a) / Math.max(4, (((int) a) / 500) * 4);
            iArr[i2] = i;
            i3 += i;
            i = i2 + 1;
        }
    }

    public static List<GeoPoint> a(List<GeoPoint> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        List<GeoPoint> arrayList = new ArrayList(i);
        GeoPoint geoPoint = (GeoPoint) list.get(0);
        GeoPoint geoPoint2 = (GeoPoint) list.get(size - 1);
        int longitudeE6 = (geoPoint.getLongitudeE6() + geoPoint2.getLongitudeE6()) / 2;
        int latitudeE6 = (geoPoint.getLatitudeE6() + geoPoint2.getLatitudeE6()) / 2;
        for (int i2 = 0; i2 < size; i2++) {
            geoPoint = (GeoPoint) list.get(i2);
            geoPoint.setLongitudeE6(geoPoint.getLongitudeE6() - longitudeE6);
            geoPoint.setLatitudeE6(geoPoint.getLatitudeE6() - latitudeE6);
        }
        float f = 1.0f / ((float) (i + 1));
        float f2 = f;
        for (int i3 = 0; i3 < i; i3++) {
            GeoPoint a = a((List) list, f2);
            a.setLongitudeE6(a.getLongitudeE6() + longitudeE6);
            a.setLatitudeE6(a.getLatitudeE6() + latitudeE6);
            arrayList.add(a);
            f2 += f;
        }
        return arrayList;
    }

    private static GeoPoint a(List<GeoPoint> list, float f) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        if (size != 3 && size != 4) {
            return null;
        }
        GeoPoint geoPoint;
        GeoPoint geoPoint2;
        GeoPoint geoPoint3;
        if (size == 3) {
            geoPoint = (GeoPoint) list.get(0);
            geoPoint2 = (GeoPoint) list.get(1);
            geoPoint3 = (GeoPoint) list.get(2);
            if (geoPoint == null || geoPoint2 == null || geoPoint3 == null) {
                return null;
            }
            return new GeoPoint((int) a(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6(), geoPoint3.getLatitudeE6(), f), (int) a(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6(), geoPoint3.getLongitudeE6(), f));
        }
        geoPoint = (GeoPoint) list.get(0);
        geoPoint2 = (GeoPoint) list.get(1);
        geoPoint3 = (GeoPoint) list.get(2);
        GeoPoint geoPoint4 = (GeoPoint) list.get(3);
        if (geoPoint == null || geoPoint2 == null || geoPoint3 == null || geoPoint4 == null) {
            return null;
        }
        return new GeoPoint((int) a(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6(), geoPoint3.getLatitudeE6(), geoPoint4.getLatitudeE6(), f), (int) a(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6(), geoPoint3.getLongitudeE6(), geoPoint4.getLongitudeE6(), f));
    }

    private static double a(int i, int i2, int i3, float f) {
        return ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((double) i)) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((double) i2))) + ((double) ((f * f) * ((float) i3)));
    }

    private static float a(int i, int i2, int i3, int i4, float f) {
        float f2 = ((float) (i2 - i)) * 3.0f;
        float f3 = (((float) (i3 - i2)) * 3.0f) - f2;
        float f4 = f * f;
        return ((f2 * f) + ((f3 * f4) + (((((float) (i4 - i)) - f2) - f3) * (f4 * f)))) + ((float) i);
    }

    private static double a(DoublePoint doublePoint, DoublePoint doublePoint2) {
        double d = doublePoint2.x - doublePoint.x;
        double d2 = doublePoint2.y - doublePoint.y;
        return Math.sqrt((d * d) + (d2 * d2));
    }
}
