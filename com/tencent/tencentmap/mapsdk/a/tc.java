package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class tc {
    private sl a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private PointF g;
    private a h = a.a;
    private List<td> i = new ArrayList();
    private List<td> j = new ArrayList();

    /* renamed from: com.tencent.tencentmap.mapsdk.a.tc$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[a.values().length];

        static {
            try {
                a[a.a.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[a.b.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public tc(sl slVar, int i, int i2, int i3, int i4, a aVar, List<su> list) {
        int a;
        this.a = slVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        if (!slVar.r() || aVar != a.a) {
            switch (AnonymousClass1.a[aVar.ordinal()]) {
                case 1:
                    a = sn.a();
                    break;
                case 2:
                    a = sn.e();
                    break;
                default:
                    a = BaseReportManager.MAX_READ_COUNT;
                    break;
            }
        }
        a = 7;
        this.f = a;
        this.h = aVar;
        td tdVar = new td(ti.a(this.a, aVar), this.b, this.c, this.d, this.f, this.e, aVar);
        if (this.i.size() > 0) {
            this.i.set(0, tdVar);
            this.j.set(0, tdVar);
        } else {
            this.i.add(tdVar);
            this.j.add(tdVar);
        }
        if (list != null && !list.isEmpty()) {
            for (su a2 : list) {
                a(a2);
            }
        }
    }

    public final int a() {
        return this.d;
    }

    public final void a(PointF pointF) {
        this.g = pointF;
    }

    public final void a(su suVar) {
        this.i.size();
        td tdVar = new td(suVar, this.b, this.c, this.d);
        this.i.add(tdVar);
        this.j.add(tdVar);
    }

    public final boolean a(Canvas canvas) {
        boolean z = true;
        if (this.i == null || this.i.size() <= 0) {
            return true;
        }
        Collections.sort(this.j, td.k());
        canvas.save();
        canvas.translate(this.g.x, this.g.y);
        Iterator it = this.j.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                z = ((td) it.next()).a(canvas) & z2;
            } else {
                canvas.restore();
                return z2;
            }
        }
    }

    public final boolean a(List<td> list) {
        for (td a : list) {
            if (a.a() != null) {
                return true;
            }
        }
        this.i.clear();
        this.i.addAll(list);
        this.j.clear();
        this.j.addAll(list);
        for (td a2 : this.i) {
            if (a2.f() == null) {
                return true;
            }
        }
        return false;
    }

    public final List<td> b() {
        return new ArrayList(this.i);
    }

    public final void b(su suVar) {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            td tdVar = (td) it.next();
            if (tdVar.a(suVar)) {
                tdVar.h();
                it.remove();
                return;
            }
        }
    }

    public final void c() {
        for (td h : this.i) {
            h.h();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tc)) {
            return false;
        }
        tc tcVar = (tc) obj;
        return this.b == tcVar.b && this.c == tcVar.c && this.d == tcVar.d && this.e == tcVar.e && this.f == tcVar.f;
    }

    public final int hashCode() {
        return ((this.b * 7) + (this.c * 11)) + (this.d * 13);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("MapTile(");
        stringBuilder.append(this.b);
        stringBuilder.append(",");
        stringBuilder.append(this.c);
        stringBuilder.append(",");
        stringBuilder.append(this.d);
        stringBuilder.append(",");
        stringBuilder.append(this.h);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
