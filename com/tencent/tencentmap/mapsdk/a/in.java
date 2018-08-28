package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import java.util.ArrayList;

public abstract class in<T extends jb<E>, E extends iw> implements iw {
    private T a;
    private ArrayList<E> b;
    private a<E> c;
    private int d = -1;
    private int e = -1;

    public interface a<T extends iw> {
        void a(jb<T> jbVar, T t, int i);
    }

    public synchronized void a(hs hsVar, hh hhVar) {
        int a = a();
        int c = c();
        for (int i = 0; i < c; i++) {
            if (a != i) {
                iw a2 = a(i);
                if (a2 != null && (a2 instanceof iq)) {
                    a2.b(hsVar, hhVar);
                }
            }
        }
        iw b = b();
        if (b != null && (b instanceof iq)) {
            b.b(hsVar, hhVar);
        }
    }

    public synchronized void b(hs hsVar, hh hhVar) {
        int a = a();
        int c = c();
        for (int i = 0; i < c; i++) {
            if (a != i) {
                iw a2 = a(i);
                if (!(a2 == null || (a2 instanceof iq))) {
                    a2.b(hsVar, hhVar);
                }
            }
        }
        iw b = b();
        if (!(b == null || (b instanceof iq))) {
            b.b(hsVar, hhVar);
        }
    }

    public boolean a(hh hhVar, float f, float f2) {
        if (this.b == null) {
            return false;
        }
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.b.size());
            arrayList.addAll(this.b);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int i2 = ((this.d + i) + 1) % size;
            iw iwVar = (iw) arrayList.get(i2);
            if (iwVar.a(hhVar, f, f2)) {
                this.d = i2;
                if (this.c != null) {
                    this.c.a(this.a, iwVar, i2);
                }
                return true;
            }
        }
        return false;
    }

    public synchronized Rect a(hh hhVar) {
        Rect rect = null;
        synchronized (this) {
            if (!(this.b == null || this.b.size() == 0)) {
                int size = this.b.size();
                int i = 0;
                while (i < size) {
                    Rect a = ((iw) this.b.get(i)).a(hhVar);
                    if (a != null) {
                        if (rect == null) {
                            i++;
                            rect = a;
                        } else {
                            rect.left = Math.min(rect.left, a.left);
                            rect.top = Math.max(rect.top, a.top);
                            rect.right = Math.max(rect.right, a.right);
                            rect.bottom = Math.min(rect.bottom, a.bottom);
                        }
                    }
                    a = rect;
                    i++;
                    rect = a;
                }
            }
        }
        return rect;
    }

    public int a() {
        return this.e;
    }

    public synchronized E b() {
        E e;
        if (this.b == null || this.e < 0 || this.b.size() <= this.e) {
            e = null;
        } else {
            e = (iw) this.b.get(this.e);
        }
        return e;
    }

    public synchronized int c() {
        int i;
        if (this.b == null) {
            i = 0;
        } else {
            i = this.b.size();
        }
        return i;
    }

    public synchronized E a(int i) {
        E e;
        if (this.b == null || i < 0 || this.b.size() <= i) {
            e = null;
        } else {
            iw e2 = (iw) this.b.get(i);
        }
        return e2;
    }

    public synchronized void a(E e) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(e);
    }

    public synchronized boolean b(E e) {
        boolean remove;
        if (this.b != null) {
            remove = this.b.remove(e);
        } else {
            remove = false;
        }
        return remove;
    }

    public synchronized void d() {
        if (this.b != null) {
            this.b.clear();
        }
    }
}
