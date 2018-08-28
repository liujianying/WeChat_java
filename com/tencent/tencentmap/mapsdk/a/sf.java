package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class sf {
    private static int e = 0;
    private sl a;
    private CopyOnWriteArrayList<sv> b = new CopyOnWriteArrayList();
    private SortedMap<String, sr> c = new TreeMap();
    private a d = new a(this, (byte) 0);
    private int f = 0;

    class a implements Comparator<Object> {
        private a(sf sfVar) {
        }

        /* synthetic */ a(sf sfVar, byte b) {
            this(sfVar);
        }

        public final int compare(Object obj, Object obj2) {
            sv svVar = (sv) obj;
            sv svVar2 = (sv) obj2;
            if (!(svVar == null || svVar2 == null)) {
                try {
                    if (svVar.k() > svVar2.k()) {
                        return 1;
                    }
                    if (svVar.k() < svVar2.k()) {
                        return -1;
                    }
                } catch (Exception e) {
                }
            }
            return 0;
        }
    }

    public sf(sl slVar) {
        this.a = slVar;
    }

    public static String a(String str) {
        e++;
        return str + e;
    }

    public final so a(qu quVar) {
        sv soVar = new so(this.a, quVar);
        a(soVar);
        return soVar;
    }

    public final sr a(qz qzVar) {
        sr srVar = new sr(this.a, qzVar);
        this.c.put(srVar.m(), srVar);
        return srVar;
    }

    public final sw a(rb rbVar) {
        sv swVar = new sw(this.a, rbVar);
        a(swVar);
        return swVar;
    }

    public final sx a(rd rdVar) {
        sv ssVar = new ss(this.a, rdVar);
        a(ssVar);
        return ssVar;
    }

    public final void a() {
        try {
            for (Entry value : this.c.entrySet()) {
                ((sr) value.getValue()).c();
            }
            this.c.clear();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((sv) it.next()).n();
            }
            this.b.clear();
            sz.a(this.a.c(), 2);
        } catch (Exception e) {
        }
    }

    public final void a(Canvas canvas) {
        int size = this.b.size();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            sv svVar = (sv) it.next();
            if (svVar.l() && (size <= 20 || svVar.h())) {
                svVar.a(canvas);
            }
        }
    }

    public final void a(sv svVar) {
        b(svVar.j());
        this.b.add(svVar);
        if (!(svVar instanceof so)) {
            int i = this.f + 1;
            this.f = i;
            if (i > 0) {
                sz.a(this.a.c(), 1);
            }
        }
        if (this.f > 0) {
            this.a.f(false);
        }
        c();
        this.a.a(false, false);
    }

    public final boolean a(MotionEvent motionEvent) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            sv svVar = (sv) it.next();
            if (svVar instanceof tx) {
                ((tx) svVar).a(motionEvent, this.a.d());
            }
        }
        return false;
    }

    public final boolean a(qv qvVar) {
        sv svVar;
        boolean z = false;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            svVar = (sv) it.next();
            if ((svVar instanceof tx) && ((tx) svVar).a(qvVar, this.a.d())) {
                z = true;
                break;
            }
        }
        if (!z) {
            it = this.b.iterator();
            while (it.hasNext()) {
                svVar = (sv) it.next();
                if (svVar instanceof tx) {
                    ((tx) svVar).a(qvVar);
                }
            }
        }
        return z;
    }

    public final boolean a(qv qvVar, MotionEvent motionEvent) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            sv svVar = (sv) it.next();
            if ((svVar instanceof tx) && ((tx) svVar).a(qvVar, motionEvent, this.a.d())) {
                return true;
            }
        }
        return false;
    }

    protected final void b() {
        a();
    }

    public final boolean b(String str) {
        Object obj;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            sv svVar = (sv) it.next();
            if (svVar != null && svVar.j().equals(str)) {
                obj = svVar;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        boolean remove = this.b.remove(obj);
        if (remove && !(obj instanceof so)) {
            int i = this.f - 1;
            this.f = i;
            if (i == 0) {
                sz.a(this.a.c(), 2);
            }
        }
        if (this.f <= 0) {
            this.a.f(true);
        }
        this.a.a(false, false);
        return remove;
    }

    public final void c() {
        Object[] toArray = this.b.toArray();
        Arrays.sort(toArray, this.d);
        this.b.clear();
        for (Object obj : toArray) {
            this.b.add((sv) obj);
        }
    }

    public final boolean c(String str) {
        sr srVar = (sr) this.c.remove(str);
        if (srVar == null) {
            return false;
        }
        srVar.c();
        return true;
    }
}
