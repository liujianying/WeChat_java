package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class ir {
    ArrayList<GeoPoint> a;
    ArrayList<GeoPoint> b;
    int[] c;
    int[] d;
    int[] e;
    int[] f;
    float g;
    boolean h;
    boolean i;
    float j = 9.0f;
    String k = "";
    boolean l = true;
    float m = 1.0f;
    boolean n = true;
    int o = 0;
    boolean p = false;
    List<GeoPoint> q;
    int r = 0;
    boolean s = false;
    Rect t = new Rect();
    int u = 0;
    String v = "";
    float w = -1.0f;
    int x = -1;
    int y = -15248742;
    List<Integer> z = null;

    private class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.b = i;
            this.a = i2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            if (aVar.a == this.a && aVar.b == this.b) {
                return true;
            }
            return false;
        }
    }

    public ir a(List<GeoPoint> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("参数points不能小于2!");
        }
        this.b = new ArrayList(list.size());
        for (GeoPoint geoPoint : list) {
            if (geoPoint != null) {
                this.b.add(geoPoint);
            }
        }
        if (this.b.size() < 2) {
            throw new IllegalArgumentException("参数points存在null值");
        }
        this.a = new ArrayList(list.size());
        this.a.addAll(this.b);
        return this;
    }

    public ir a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            throw new IllegalArgumentException("参数startIndexes不能为空!");
        }
        this.c = iArr;
        return this;
    }

    @Deprecated
    public void a(String str) {
        this.k = str;
    }

    @Deprecated
    public void a(boolean z) {
        this.l = z;
    }

    @Deprecated
    public void a(float f) {
        this.m = f;
    }

    public ir b(int[] iArr) {
        int i = 0;
        if (iArr == null || iArr.length <= 0) {
            throw new IllegalArgumentException("参数colors不能为空!");
        }
        if (this.h) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (!arrayList.contains(Integer.valueOf(iArr[i2]))) {
                    arrayList.add(Integer.valueOf(iArr[i2]));
                }
                iArr[i2] = arrayList.indexOf(Integer.valueOf(iArr[i2]));
            }
            this.d = iArr;
            int size = arrayList.size();
            this.e = new int[size];
            while (i < size) {
                this.e[i] = ((Integer) arrayList.get(i)).intValue();
                i++;
            }
        } else {
            this.d = iArr;
        }
        return this;
    }

    public ir a(int[] iArr, int[] iArr2) {
        int i = 0;
        if (iArr == null || iArr.length <= 0 || iArr2 == null || iArr2.length <= 0) {
            throw new IllegalArgumentException("参数colors 、borderColors为空，或者两者长度不同");
        }
        if (this.h) {
            int i2;
            if (iArr2.length < iArr.length) {
                int[] iArr3 = new int[iArr.length];
                for (i2 = 0; i2 < iArr.length; i2++) {
                    if (i2 < iArr2.length) {
                        iArr3[i2] = iArr2[i2];
                    } else {
                        iArr3[i2] = iArr2[iArr2.length - 1];
                    }
                }
                iArr2 = iArr3;
            }
            List arrayList = new ArrayList();
            this.d = new int[iArr.length];
            for (i2 = 0; i2 < iArr.length; i2++) {
                a aVar = new a(iArr[i2], iArr2[i2]);
                if (!arrayList.contains(aVar)) {
                    arrayList.add(aVar);
                }
                this.d[i2] = arrayList.indexOf(aVar);
            }
            int size = arrayList.size();
            this.e = new int[size];
            this.f = new int[size];
            while (i < size) {
                this.e[i] = ((a) arrayList.get(i)).b;
                this.f[i] = ((a) arrayList.get(i)).a;
                i++;
            }
        } else {
            this.d = iArr;
        }
        return this;
    }

    public ir b(boolean z) {
        this.h = z;
        return this;
    }

    public ir c(boolean z) {
        this.i = z;
        return this;
    }

    public ir b(float f) {
        this.j = f;
        return this;
    }

    public ir c(float f) {
        this.g = f;
        return this;
    }

    public ir d(boolean z) {
        this.n = z;
        return this;
    }

    public ir a(int i) {
        this.o = i;
        return this;
    }

    public int a() {
        return this.o;
    }

    public ir a(int i, List<GeoPoint> list) {
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalArgumentException("bezier曲线阶数为1，2，3");
        } else if (i == 1 && list != null && (list == null || list.size() != 0)) {
            throw new IllegalArgumentException("bezier曲线控制点数目错误");
        } else if (i == 2 && (list == null || (list != null && list.size() != 1))) {
            throw new IllegalArgumentException("bezier曲线控制点数目错误");
        } else if (i != 3 || (list != null && (list == null || list.size() == 2))) {
            this.r = i;
            this.q = list;
            return this;
        } else {
            throw new IllegalArgumentException("bezier曲线控制点数目错误");
        }
    }

    public ir e(boolean z) {
        this.p = z;
        return this;
    }

    public ir f(boolean z) {
        this.s = z;
        return this;
    }

    public ir b(int i) {
        this.u = i;
        return this;
    }

    public ir b(String str) {
        this.v = str;
        return this;
    }

    public ir d(float f) {
        this.w = f;
        return this;
    }

    public ir b(List<Integer> list) {
        if (!(list == null || list.size() % 2 == 0)) {
            list.add(list.get(list.size() - 1));
        }
        this.z = list;
        return this;
    }

    public float b() {
        return this.w;
    }
}
