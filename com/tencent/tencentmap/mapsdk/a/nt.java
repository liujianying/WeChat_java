package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;

public final class nt extends nx implements od {
    private ks a = null;

    public nt(View view) {
        this.a = (ks) view;
        if (this.a.a(ka.class) == null) {
            this.a.a(ka.class, this);
        }
    }

    public final void a() {
        this.a.b(ka.class);
        this.a = null;
    }

    final os a(ot otVar, ns nsVar) {
        if (this.a == null) {
            return null;
        }
        ka kaVar = new ka(this.a);
        kaVar.a(otVar);
        kaVar.c();
        if (!this.a.a(kaVar)) {
            return null;
        }
        this.a.getMap().a();
        os osVar = new os(otVar, nsVar, kaVar.v());
        kaVar.a(osVar);
        return osVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(java.lang.String r4) {
        /*
        r3 = this;
        r0 = r3.a;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r3.a;
        r1 = r0.e;
        monitor-enter(r1);
        r0 = r3.a;	 Catch:{ all -> 0x0019 }
        r2 = 0;
        r0 = r0.b(r4, r2);	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0017;
    L_0x0013:
        r2 = r0 instanceof com.tencent.tencentmap.mapsdk.a.ka;	 Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x001c;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x0004;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r0;
    L_0x001c:
        r0.d();	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r0 = r3.a;
        r0 = r0.getMap();
        r0.a();
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.nt.a(java.lang.String):void");
    }

    final void a(String str, ox oxVar) {
        if (this.a != null && oxVar != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof ka) {
                    ((ka) a).a(kh.a(oxVar));
                    this.a.getMap().a();
                }
            }
        }
    }

    final void a(String str, int i) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof ka) {
                    ((ka) a).c(i);
                    this.a.getMap().a();
                }
            }
        }
    }

    final void a(String str, double d) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof ka) {
                    ((ka) a).a(d);
                    this.a.getMap().a();
                }
            }
        }
    }

    final void b(String str, int i) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof ka) {
                    ((ka) a).b(i);
                    this.a.getMap().a();
                }
            }
        }
    }

    final void a(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof ka) {
                    ((ka) a).d(f);
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
                } else if (a instanceof ka) {
                    ((ka) a).a_(z);
                    this.a.getMap().a();
                }
            }
        }
    }

    final void b(String str, float f) {
        if (this.a != null) {
            ke a = this.a.a(str);
            if (a != null) {
                a.c(f);
            }
            this.a.a(str, f);
            this.a.getMap().a();
        }
    }

    final void b() {
        if (this.a != null) {
            this.a.c(ka.class);
        }
    }

    public final boolean a(ke keVar, boolean z, GeoPoint geoPoint) {
        return false;
    }
}
