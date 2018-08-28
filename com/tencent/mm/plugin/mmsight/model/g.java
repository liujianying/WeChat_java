package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class g {
    public static b a(Parameters parameters, Point point, int i, boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        x.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[]{d.bA(arrayList)});
        float f = ((float) point.x) / ((float) point.y);
        x.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(0)});
        long fQ = bi.fQ(ad.getContext());
        x.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(fQ)});
        b bVar = new b();
        bVar.lgn = a(arrayList, point, z, i);
        if (bVar.lgn != null) {
            bVar.lgo = d.a(point, bVar.lgn, z);
            bVar.lgp = d.a(point, bVar.lgn, z, true);
            i2 = 0;
        } else {
            Point point2 = new Point();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x == point2.y) {
                    x.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", new Object[]{point2});
                } else {
                    Point a = d.a(point, point2, z);
                    if (a == null) {
                        x.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", new Object[]{point2});
                    } else {
                        x.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[]{point2, a});
                        bVar.lgr = new Point(a.x, a.y);
                        bVar.lgq = new Point(point2.x, point2.y);
                        bVar.lgs = d.a(point, point2, z, true);
                        if (Math.min(a.x, a.y) <= i) {
                            if (Math.min(a.x, a.y) < 0) {
                                return null;
                            }
                            bVar.lgn = new Point(point2.x, point2.y);
                            bVar.lgo = a;
                            bVar.lgp = d.a(point, bVar.lgn, z, true);
                            x.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[]{r5, a, Integer.valueOf(1)});
                            i2 = 1;
                        }
                    }
                }
            }
            i2 = 0;
        }
        x.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", new Object[]{bVar.lgn, bVar.lgo, Integer.valueOf(i2)});
        return bVar;
    }

    public static b b(Parameters parameters, Point point, int i, boolean z) {
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        x.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[]{d.bA(arrayList)});
        float f = ((float) point.x) / ((float) point.y);
        x.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i)});
        long fQ = bi.fQ(ad.getContext());
        x.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(fQ)});
        b bVar = new b();
        bVar.lgn = a(arrayList, point, z, i);
        if (bVar.lgn == null) {
            Point point2 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x != point2.y && Math.min(point2.x, point2.y) <= i && Math.max(point2.x, point2.y) <= 2000 && d.b(point, point2, z) != null) {
                    bVar.lgn = null;
                    break;
                }
            }
        } else {
            bVar.lgo = d.b(point, bVar.lgn, z);
            bVar.lgp = d.b(point, bVar.lgn, z, true);
        }
        x.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", new Object[]{bVar.lgn, bVar.lgo, Integer.valueOf(0)});
        return bVar;
    }

    private static Point a(ArrayList<Size> arrayList, Point point, boolean z, int i) {
        int i2 = point.x;
        int i3 = point.y;
        if ((i3 * i) % i2 != 0) {
            return null;
        }
        int i4;
        i2 = (i3 * i) / i2;
        if (z) {
            i3 = i ^ i2;
            i4 = i3 ^ i2;
            i3 ^= i4;
        } else {
            i3 = i;
            i4 = i2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.width == i3 && size.height == i4) {
                x.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                return new Point(i3, i4);
            } else if (Math.min(size.width, size.height) < i) {
                return null;
            }
        }
        return null;
    }
}
