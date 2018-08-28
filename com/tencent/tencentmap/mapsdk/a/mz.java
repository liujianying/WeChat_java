package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class mz extends oe {
    private ks a = null;

    public mz(View view) {
        this.a = (ks) view;
    }

    public void a() {
        this.a = null;
    }

    pd a(pe peVar, my myVar) {
        if (this.a == null) {
            return null;
        }
        kf kfVar = new kf(this.a, peVar);
        kfVar.a(peVar);
        kfVar.c();
        if (!this.a.a(kfVar)) {
            return null;
        }
        this.a.getMap().a();
        return new pd(peVar, myVar, kfVar.v());
    }

    void a(String str) {
        if (this.a != null) {
            this.a.b(str, true);
            this.a.getMap().a();
        }
    }

    void a(String str, int i) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.c(i);
                this.a.getMap().a();
            }
        }
    }

    void a(String str, List<ox> list) {
        synchronized (this.a.e) {
            ke a = this.a.a(str);
            if (a == null) {
            } else if (a instanceof kf) {
                kf kfVar = (kf) a;
                kfVar.a(a((List) list));
                kfVar.c();
                this.a.getMap().a();
            }
        }
    }

    void b(String str, int i) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.b(i);
                this.a.getMap().a();
            }
        }
    }

    void a(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.d(f);
                this.a.getMap().a();
            }
        }
    }

    void a(String str, boolean z) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.a_(z);
                this.a.getMap().a();
            }
        }
    }

    void b(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.c(f);
                this.a.getMap().a();
            }
        }
    }

    private ArrayList<GeoPoint> a(List<ox> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size <= 0) {
            return null;
        }
        ArrayList<GeoPoint> arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            ox oxVar = (ox) list.get(i);
            if (oxVar != null) {
                GeoPoint a = kh.a(oxVar);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    void b() {
        if (this.a != null) {
            this.a.c(kf.class);
        }
    }
}
