package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

public class gu extends gi {
    private static ThreadLocal<Object> b = new ThreadLocal();
    private static final ThreadLocal<ArrayList<gu>> h = new 1();
    private static final ThreadLocal<ArrayList<gu>> i = new 2();
    private static final ThreadLocal<ArrayList<gu>> j = new 3();
    private static final ThreadLocal<ArrayList<gu>> k = new 4();
    private static final ThreadLocal<ArrayList<gu>> l = new ThreadLocal<ArrayList<gu>>() {
        /* renamed from: a */
        protected final ArrayList<gu> initialValue() {
            return new ArrayList();
        }
    };
    private static final Interpolator m = new LinearInterpolator();
    private static long v = 10;
    long c = -1;
    int d = 0;
    gr[] e;
    HashMap<Integer, gr> f;
    protected gh g;
    private boolean n = false;
    private int o = 0;
    private float p = 0.0f;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private long t = 300;
    private long u = 0;
    private int w = 0;
    private int x = 1;
    private Interpolator y = m;
    private ArrayList<Object> z = null;

    public gu(gh ghVar) {
        this.g = ghVar;
    }

    public void a(double... dArr) {
        if (dArr != null && dArr.length != 0) {
            if (this.e == null || this.e.length == 0) {
                a(gr.a(0, dArr));
                return;
            }
            this.e[0].a(dArr);
        }
    }

    public void a(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            if (this.e == null || this.e.length == 0) {
                a(gr.a(0, null, objArr));
                return;
            }
            this.e[0].a(objArr);
        }
    }

    public void a(gr... grVarArr) {
        this.e = grVarArr;
        this.f = new HashMap(r1);
        for (gr grVar : grVarArr) {
            this.f.put(Integer.valueOf(grVar.b()), grVar);
        }
    }

    public static void a(long j) {
        v = j;
    }

    public void a(gt<?> gtVar) {
        if (gtVar != null && this.e != null && this.e.length > 0) {
            this.e[0].a(gtVar);
        }
    }

    /* renamed from: a */
    public gi clone() {
        int i = 0;
        gu guVar = (gu) super.a();
        if (this.z != null) {
            ArrayList arrayList = this.z;
            guVar.z = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                guVar.z.add(arrayList.get(i2));
            }
        }
        guVar.c = -1;
        guVar.n = false;
        guVar.o = 0;
        guVar.d = 0;
        guVar.q = false;
        gr[] grVarArr = this.e;
        if (grVarArr != null) {
            int length = grVarArr.length;
            guVar.e = new gr[length];
            guVar.f = new HashMap(length);
            while (i < length) {
                gr a = grVarArr[i].a();
                guVar.e[i] = a;
                guVar.f.put(Integer.valueOf(a.b()), a);
                i++;
            }
        }
        return guVar;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.e != null) {
            for (gr grVar : this.e) {
                str = str + "\n    " + grVar.toString();
            }
        }
        return str;
    }
}
