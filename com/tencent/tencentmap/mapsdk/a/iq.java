package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class iq implements iw {
    private gy a;
    private ir b;
    private int[] c;
    private int[] d;
    private int e;
    private GeoPoint f;
    private boolean g = true;
    private int h = -1;
    private a i;
    private float j = -1.0f;
    private int k = -1;

    public iq(ir irVar) {
        a(irVar);
    }

    public synchronized void b(hs hsVar, hh hhVar) {
        if (hsVar != null) {
            this.a = hsVar.b();
            float d = hsVar.d();
            if (this.j == -1.0f || this.j != d) {
                this.j = d;
                a(hsVar, hhVar);
            }
            hsVar.a(this);
        }
    }

    public synchronized boolean a(hh hhVar, float f, float f2) {
        boolean z = false;
        synchronized (this) {
            if (this.a != null) {
                TappedElement a = this.a.f().a(f, f2);
                if (a != null && a.param1 == ((long) x())) {
                    z = true;
                }
            }
        }
        return z;
    }

    public Rect a(hh hhVar) {
        int i = Integer.MIN_VALUE;
        if (this.b == null || this.b.b == null) {
            return null;
        }
        Iterator it = this.b.b.iterator();
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        while (true) {
            int i5 = i;
            if (!it.hasNext()) {
                return new Rect(i2, i3, i4, i5);
            }
            GeoPoint geoPoint = (GeoPoint) it.next();
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            if (latitudeE6 > i5) {
                i = latitudeE6;
            } else {
                i = i5;
            }
            if (latitudeE6 < i3) {
                i3 = latitudeE6;
            }
            if (longitudeE6 > i4) {
                i4 = longitudeE6;
            }
            if (longitudeE6 >= i2) {
                longitudeE6 = i2;
            }
            i2 = longitudeE6;
        }
    }

    public ArrayList<GeoPoint> a() {
        return this.b.b;
    }

    public int[] b() {
        return this.c;
    }

    public int[] c() {
        return this.d;
    }

    public boolean d() {
        return this.b.h;
    }

    public int[] e() {
        return this.b.e;
    }

    public int[] f() {
        return this.b.f;
    }

    public float g() {
        return this.b.g;
    }

    public GeoPoint h() {
        return this.f;
    }

    public int i() {
        return this.e;
    }

    public boolean j() {
        return this.b.i;
    }

    public boolean k() {
        return this.b.l;
    }

    public boolean l() {
        return this.b.n;
    }

    public int m() {
        return this.b.a();
    }

    public float n() {
        return this.b.j;
    }

    public void a(float f) {
        this.b.j = f;
    }

    public float o() {
        if (this.b == null) {
            return 1.0f;
        }
        return this.b.m;
    }

    public synchronized a p() {
        return this.i;
    }

    public String q() {
        if (this.b.d != null && this.b.d.length > 0) {
            if (this.b.d[0] == 33) {
                return "color_point_texture.png";
            }
            if (this.b.d[0] == 20) {
                return "color_texture_line_v2.png";
            }
        }
        if (StringUtil.isEmpty(this.b.k)) {
            return "color_texture_flat_style.png";
        }
        return this.b.k;
    }

    public final int r() {
        return this.h;
    }

    public final void a(int i) {
        this.h = i;
    }

    public synchronized void a(ir irVar) {
        if (irVar == null) {
            throw new IllegalArgumentException("LineOptions不能为空！");
        } else if (irVar.b == null || irVar.b.size() < 2) {
            throw new IllegalArgumentException("LineOptions中点的个数不能小于2");
        } else if (irVar.c == null || irVar.c.length <= 0) {
            throw new IllegalArgumentException("参数startIndexes不能为空!");
        } else if (irVar.d == null || irVar.d.length <= 0) {
            throw new IllegalArgumentException("参数colors不能为空!");
        } else {
            this.b = irVar;
            this.c = irVar.c;
            this.d = irVar.d;
            this.h = -1;
        }
    }

    public boolean s() {
        return this.b.s;
    }

    public int t() {
        return this.b.u;
    }

    public String u() {
        return this.b.v;
    }

    public float v() {
        return this.b.b();
    }

    public int[] w() {
        return new int[]{this.b.x, this.b.y};
    }

    public void b(int i) {
        this.k = i;
    }

    public int x() {
        return this.k;
    }

    public List<Integer> y() {
        return this.b.z;
    }

    private void a(hs hsVar, hh hhVar) {
        if (this.b != null) {
            if (this.b.r == 2 || this.b.r == 3) {
                List list = this.b.q;
                if (list != null && !list.isEmpty()) {
                    List list2 = this.b.a;
                    if (list2 != null && list2.size() >= 2) {
                        int i;
                        int size = list2.size();
                        int[] iArr = new int[(size - 1)];
                        for (i = 0; i < size - 1; i++) {
                            iArr[i] = 0;
                        }
                        i = jd.a(list2, iArr, hhVar);
                        if (i > 0) {
                            ArrayList arrayList = new ArrayList(i + size);
                            int i2;
                            GeoPoint geoPoint;
                            GeoPoint geoPoint2;
                            Collection a;
                            if (this.b.r == 2) {
                                List arrayList2 = new ArrayList(3);
                                i = 0;
                                int size2 = list.size();
                                while (true) {
                                    i2 = i;
                                    if (i2 >= size - 1 || i2 >= size2) {
                                        arrayList.add(list2.get(size - 1));
                                    } else {
                                        GeoPoint geoPoint3 = new GeoPoint((GeoPoint) list2.get(i2));
                                        geoPoint = new GeoPoint((GeoPoint) list.get(i2));
                                        geoPoint2 = new GeoPoint((GeoPoint) list2.get(i2 + 1));
                                        arrayList.add(list2.get(i2));
                                        arrayList2.clear();
                                        arrayList2.add(geoPoint3);
                                        arrayList2.add(geoPoint);
                                        arrayList2.add(geoPoint2);
                                        if (iArr[i2] > 0) {
                                            a = jd.a(arrayList2, iArr[i2]);
                                            if (!(a == null || a.isEmpty())) {
                                                arrayList.addAll(a);
                                            }
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                arrayList.add(list2.get(size - 1));
                            } else {
                                List arrayList3 = new ArrayList(4);
                                int i3 = 0;
                                i = 0;
                                int size3 = list.size();
                                while (true) {
                                    i2 = i;
                                    if (i3 >= size - 1 || i2 >= size3) {
                                        arrayList.add(list2.get(size - 1));
                                    } else {
                                        geoPoint = new GeoPoint((GeoPoint) list2.get(i3));
                                        geoPoint2 = new GeoPoint((GeoPoint) list.get(i2));
                                        GeoPoint geoPoint4 = new GeoPoint((GeoPoint) list.get(i2 + 1));
                                        GeoPoint geoPoint5 = new GeoPoint((GeoPoint) list2.get(i3 + 1));
                                        arrayList.add(list2.get(i3));
                                        arrayList3.clear();
                                        arrayList3.add(geoPoint);
                                        arrayList3.add(geoPoint2);
                                        arrayList3.add(geoPoint4);
                                        arrayList3.add(geoPoint5);
                                        if (iArr[i3] > 0) {
                                            a = jd.a(arrayList3, iArr[i3]);
                                            if (!(a == null || a.isEmpty())) {
                                                arrayList.addAll(a);
                                            }
                                        }
                                        i3++;
                                        i = i2 + 2;
                                    }
                                }
                                arrayList.add(list2.get(size - 1));
                            }
                            if (this.h != -1) {
                                hsVar.a(this.h);
                            }
                            this.b.b = arrayList;
                        }
                    }
                }
            }
        }
    }

    public void z() {
        this.k = -1;
    }
}
