package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class nr extends ix {
    private static int d = 0;
    private CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList();
    private Drawable[] b = new Drawable[4];
    private Context c;
    private op e;

    public nr(Context context) {
        this.c = context;
        a(context);
    }

    public synchronized int a(oq oqVar, np npVar) {
        int i;
        if (oqVar == null) {
            i = -1;
        } else {
            i = g();
            if (this.e == null) {
                this.e = new op(npVar);
            }
            a aVar = new a(this, oqVar, i);
            this.a.add(aVar);
            a(aVar.d());
        }
        return i;
    }

    public synchronized boolean b(int i) {
        boolean z;
        if (e(i) == null) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public synchronized boolean c(int i) {
        boolean z = true;
        synchronized (this) {
            if (i >= 0) {
                a e = e(i);
                if (e != null) {
                    this.a.remove(e);
                    z = b(e.d());
                }
            }
        }
        return z;
    }

    public synchronized void e() {
        this.a.clear();
        d();
    }

    public synchronized void f() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null && aVar.b()) {
                this.a.remove(aVar);
                b(aVar.d());
            }
        }
    }

    public synchronized void b(hs hsVar, hh hhVar) {
        b(hhVar);
        super.b(hsVar, hhVar);
    }

    public synchronized boolean a(hh hhVar, float f, float f2) {
        boolean z;
        int c = c();
        int i = 0;
        while (i < c) {
            iy iyVar = (iy) a(i);
            if (iyVar.a(hhVar, f, f2)) {
                if (i < c - 1 && b(iyVar)) {
                    a(iyVar);
                }
                z = true;
            } else {
                i++;
            }
        }
        z = false;
        return z;
    }

    private void b(hh hhVar) {
        if (this.a != null && !this.a.isEmpty()) {
            int size = this.a.size();
            int ordinal = b.d.ordinal();
            b[] bVarArr = new b[size];
            for (int i = 0; i < size; i++) {
                bVarArr[i] = b.a;
            }
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.a.get(i2);
                iy d = aVar.d();
                aVar.a(hhVar, bVarArr[i2]);
                for (int i3 = i2 + 1; i3 < size; i3++) {
                    a aVar2 = (a) this.a.get(i3);
                    iy d2 = aVar2.d();
                    aVar2.a(hhVar, bVarArr[i3]);
                    int ordinal2;
                    b d3;
                    if (aVar.c() > aVar2.c()) {
                        for (ordinal2 = bVarArr[i2].ordinal() - 1; ordinal2 < ordinal; ordinal2++) {
                            d3 = d(ordinal2);
                            aVar2.a(hhVar, d3);
                            bVarArr[i2] = d3;
                            if (!a(hhVar, d, d2)) {
                                break;
                            }
                        }
                    } else {
                        for (ordinal2 = bVarArr[i3].ordinal(); ordinal2 <= ordinal; ordinal2++) {
                            d3 = d(ordinal2);
                            aVar2.a(hhVar, d3);
                            bVarArr[i3] = d3;
                            if (!a(hhVar, d, d2)) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(hh hhVar, iy iyVar, iy iyVar2) {
        Rect a = iyVar.a(hhVar);
        Rect a2 = iyVar2.a(hhVar);
        if (a == null || a2 == null) {
            return false;
        }
        return Rect.intersects(a, a2);
    }

    private b d(int i) {
        switch (i) {
            case 0:
                return b.a;
            case 1:
                return b.b;
            case 2:
                return b.c;
            default:
                return b.d;
        }
    }

    private a e(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null && aVar.a() == i) {
                return aVar;
            }
        }
        return null;
    }

    private GeoPoint a(ox oxVar) {
        if (oxVar == null) {
            return null;
        }
        return new GeoPoint((int) (oxVar.a * 1000000.0d), (int) (oxVar.b * 1000000.0d));
    }

    private void a(Context context) {
        Bitmap b = kh.b(context, "bubble_station_lt.9.png");
        Bitmap b2 = kh.b(context, "bubble_station_rt.9.png");
        Bitmap b3 = kh.b(context, "bubble_station_rb.9.png");
        Bitmap b4 = kh.b(context, "bubble_station_lb.9.png");
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), new Rect(), null);
        NinePatchDrawable ninePatchDrawable2 = new NinePatchDrawable(context.getResources(), b2, b2.getNinePatchChunk(), new Rect(), null);
        Bitmap bitmap = b3;
        NinePatchDrawable ninePatchDrawable3 = new NinePatchDrawable(context.getResources(), bitmap, b3.getNinePatchChunk(), new Rect(), null);
        Bitmap bitmap2 = b4;
        NinePatchDrawable ninePatchDrawable4 = new NinePatchDrawable(context.getResources(), bitmap2, b4.getNinePatchChunk(), new Rect(), null);
        this.b[0] = ninePatchDrawable;
        this.b[1] = ninePatchDrawable2;
        this.b[2] = ninePatchDrawable3;
        this.b[3] = ninePatchDrawable4;
    }

    private int g() {
        int i = d;
        d = i + 1;
        return i;
    }
}
