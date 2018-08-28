package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.listener.a;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class hu {
    private ArrayList<iw> a = new ArrayList();
    private ArrayList<iw> b = new ArrayList();
    private ArrayList<iw> c = new ArrayList();
    private gy d;
    private it e;
    private List<is> f;
    private ip g;
    private iv h;
    private a i;
    private ArrayList<Integer> j = new ArrayList();

    public hu(gy gyVar) {
        this.d = gyVar;
    }

    public void a(iw iwVar) {
        synchronized (this.a) {
            if (this.a.contains(iwVar)) {
                return;
            }
            this.a.add(iwVar);
            this.d.a().z();
        }
    }

    public void b(iw iwVar) {
        if (iwVar != null) {
            synchronized (this.a) {
                if (this.a.remove(iwVar)) {
                    this.d.a().z();
                }
                this.c.add(iwVar);
            }
        }
    }

    public boolean a(hs hsVar, hh hhVar) {
        a();
        this.b.clear();
        synchronized (this.a) {
            this.b.addAll(this.a);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            iw iwVar = (iw) it.next();
            if (iwVar instanceof in) {
                ((in) iwVar).a(hsVar, hhVar);
            } else {
                iwVar.b(hsVar, hhVar);
            }
        }
        return true;
    }

    private void a() {
        synchronized (this.a) {
            int i;
            int e;
            List arrayList = new ArrayList();
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                iw iwVar = (iw) this.c.get(i2);
                if (iwVar instanceof ix) {
                    ix ixVar = (ix) iwVar;
                    int c = ixVar.c();
                    for (i = 0; i < c; i++) {
                        iw a = ixVar.a(i);
                        if (a instanceof iy) {
                            e = ((iy) a).e();
                            if (e >= 0) {
                                arrayList.add(Integer.valueOf(e));
                            }
                        }
                    }
                } else if (iwVar instanceof iy) {
                    int e2 = ((iy) iwVar).e();
                    if (e2 >= 0) {
                        arrayList.add(Integer.valueOf(e2));
                    }
                }
            }
            i = arrayList.size();
            int[] iArr = new int[i];
            for (e = 0; e < i; e++) {
                iArr[e] = ((Integer) arrayList.get(e)).intValue();
            }
            this.d.f().a(iArr, i);
            this.c.clear();
        }
    }

    public boolean a(hh hhVar, float f, float f2) {
        synchronized (this.a) {
            int size = this.a.size() - 1;
            while (size >= 0) {
                iw iwVar = (iw) this.a.get(size);
                if (iwVar == null || !iwVar.a(hhVar, f, f2)) {
                    size--;
                } else {
                    return true;
                }
            }
            return b(f, f2);
        }
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(int i, int i2) {
    }

    private boolean b(float f, float f2) {
        TappedElement a = this.d.f().a(f, f2);
        if (a == null) {
            return false;
        }
        if (a.type == 1 && this.e != null) {
            this.e.a(new iu(a.name, d.a(a.pixelX, a.pixelY)));
            return true;
        } else if (a.type == 6 && this.f != null) {
            for (is isVar : this.f) {
                if (isVar != null) {
                    isVar.a();
                }
            }
            return true;
        } else if (a.type == 7 && this.g != null) {
            this.g.a(a.param2, a.nameLen);
            return true;
        } else if (this.h == null) {
            return false;
        } else {
            this.h.a();
            return false;
        }
    }

    public boolean a(float f, float f2) {
        TappedElement a = this.d.f().a(f, f2);
        if (a == null || a.type != 3) {
            return false;
        }
        if (this.i != null) {
            this.i.e();
        }
        return true;
    }
}
