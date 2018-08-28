package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.ac.o;
import java.util.ArrayList;
import java.util.List;

public final class nb extends of implements od {
    private ks a = null;
    private o b = null;

    public nb(View view) {
        this.a = (ks) view;
        if (this.a.a(kg.class) == null) {
            this.a.a(kg.class, this);
        }
    }

    public final void a() {
        this.a.b(kg.class);
        this.a = null;
    }

    final pf a(pg pgVar, na naVar) {
        if (this.a == null) {
            return null;
        }
        kg kgVar = new kg(this.a);
        kgVar.a(pgVar);
        kgVar.c();
        if (!this.a.a(kgVar)) {
            return null;
        }
        this.a.getMap().a();
        pf pfVar = new pf(pgVar, naVar, kgVar.v());
        kgVar.a(pfVar);
        return pfVar;
    }

    final void a(String str) {
        if (this.a != null) {
            this.a.b(str, true);
            this.a.getMap().a();
        }
    }

    final void a(String str, int i) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.b(i);
                a.c();
                this.a.getMap().a();
            }
        }
    }

    final void a(String str, List<ox> list) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof kg) {
                    kg kgVar = (kg) a;
                    try {
                        kgVar.a(list);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    kgVar.c();
                    this.a.getMap().a();
                }
            }
        }
    }

    final void a(String str, boolean z) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.a_(z);
                a.c();
                this.a.getMap().a();
            }
        }
    }

    final void a(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof kg) {
                    kg kgVar = (kg) a;
                    kgVar.d(f);
                    kgVar.c();
                    this.a.getMap().a();
                }
            }
        }
    }

    final void b(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof kg) {
                    kg kgVar = (kg) a;
                    kgVar.c(f);
                    kgVar.c();
                    this.a.getMap().a();
                }
            }
        }
    }

    final void b() {
        if (this.a != null) {
            this.a.c(kg.class);
        }
    }

    public final boolean a(ke keVar, boolean z, GeoPoint geoPoint) {
        kg kgVar = (kg) keVar;
        boolean i = kgVar.f().i();
        if (this.b == null || !i) {
            return false;
        }
        this.b.a(kgVar.f(), kh.a(geoPoint));
        return true;
    }

    final List<iw> b(String str) {
        synchronized (this.a.e) {
            ke a = this.a.a(str);
            if (a == null || !(a instanceof kg)) {
                return null;
            }
            kg kgVar = (kg) a;
            List<iw> arrayList = new ArrayList(1);
            arrayList.add(kgVar.g());
            return arrayList;
        }
    }
}
