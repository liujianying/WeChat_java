package com.tencent.tencentmap.mapsdk.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pg {
    private static String y = "color_texture_flat_style.png";
    private a A;
    private int B;
    private final List<ox> a;
    private float b;
    private float c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private float j;
    private boolean k;
    private ol l;
    private List<Integer> m;
    private int[] n;
    private int[] o;
    private int[] p;
    private int q;
    private String r;
    private boolean s;
    private int t;
    private boolean u;
    private List<ox> v;
    private boolean w;
    private on x;
    private boolean z;

    public int a() {
        return this.t;
    }

    public List<ox> b() {
        return this.v;
    }

    public pg() {
        this.n = null;
        this.o = new int[]{-16711936};
        this.p = null;
        this.q = 0;
        this.r = y;
        this.s = false;
        this.t = 0;
        this.u = true;
        this.w = false;
        this.x = null;
        this.A = a.a;
        this.B = 100;
        this.b = -1.0f;
        this.d = kh.l;
        this.f = true;
        this.g = false;
        this.a = new ArrayList();
        this.j = 1.0f;
        this.k = false;
        this.t = 0;
        this.e = 0;
        this.v = new ArrayList();
    }

    @Deprecated
    public void a(List<ox> list) {
        this.a.clear();
        if (list != null) {
            this.a.addAll(list);
        }
    }

    public pg a(ox oxVar, ox... oxVarArr) {
        this.a.add(oxVar);
        if (oxVarArr != null) {
            a(oxVarArr);
        }
        return this;
    }

    public pg a(ox[] oxVarArr) {
        if (oxVarArr != null) {
            this.a.addAll(Arrays.asList(oxVarArr));
        }
        return this;
    }

    public pg a(Iterable<ox> iterable) {
        if (iterable != null) {
            for (ox a : iterable) {
                a(a, new ox[0]);
            }
        }
        return this;
    }

    public pg a(float f) {
        if (f < 0.0f) {
            this.b = 1.0f;
        } else {
            this.b = f;
        }
        return this;
    }

    public pg b(float f) {
        if (f < 0.0f) {
            this.c = 1.0f;
        } else {
            this.c = f;
        }
        return this;
    }

    public a c() {
        return this.A;
    }

    public pg a(int i) {
        this.d = i;
        return this;
    }

    public pg b(int i) {
        this.o = new int[]{i};
        return this;
    }

    public pg c(int i) {
        this.e = Math.max(0, i);
        return this;
    }

    public pg a(boolean z) {
        this.f = z;
        return this;
    }

    public pg b(boolean z) {
        this.h = z;
        return this;
    }

    public List<ox> d() {
        return this.a;
    }

    public float e() {
        return this.b;
    }

    public int f() {
        return this.d;
    }

    public int[][] g() {
        if (this.n == null || this.p == null || this.n.length != this.p.length) {
            return null;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, this.n.length});
        iArr[0] = this.n;
        iArr[1] = this.p;
        return iArr;
    }

    public int h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.i;
    }

    public float l() {
        return this.j;
    }

    public boolean m() {
        return this.k;
    }

    public ol n() {
        return this.l;
    }

    public int o() {
        return this.q;
    }

    public String p() {
        return this.r;
    }

    public boolean q() {
        return this.u;
    }

    public pg a(on onVar) {
        this.x = onVar;
        return this;
    }

    public pg d(int i) {
        this.B = i;
        return this;
    }

    public on r() {
        return this.x;
    }

    public int s() {
        return this.B;
    }

    public boolean t() {
        return this.z;
    }

    public List<Integer> u() {
        return this.m;
    }

    public pg b(List<Integer> list) {
        this.m = list;
        return this;
    }

    public float v() {
        return this.c;
    }

    public int[] w() {
        return this.o;
    }
}
