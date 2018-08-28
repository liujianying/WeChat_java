package com.tencent.mm.s;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.s.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static a dlr;
    public b dls = new b();
    ArrayList<WeakReference<a>> dlt = new ArrayList();
    private final int dlu = 0;
    private final int dlv = 1;
    private ag handler = new 1(this, Looper.getMainLooper());
    public boolean initialized = false;

    public final void init() {
        this.initialized = true;
        this.dls.dlG = g.Ei().DT();
    }

    public final void u(int i, boolean z) {
        a(i, 1, !z ? "0" : "1");
    }

    public final void a(com.tencent.mm.storage.aa.a aVar, boolean z) {
        a(aVar, 1, !z ? "0" : "1");
    }

    public final void v(int i, boolean z) {
        a(i, 2, !z ? "0" : "1");
    }

    public final void b(com.tencent.mm.storage.aa.a aVar, boolean z) {
        a(aVar, 2, !z ? "0" : "1");
    }

    private void a(int i, int i2, String str) {
        if (this.initialized) {
            b bVar = this.dls;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.s.b.a gq = bVar.gq(i);
            if (gq == null) {
                gq = bVar.a(i, i2, "", "");
                bVar.dlB.put(i, gq);
                bVar.a(gq);
            }
            gq.value = str;
            gq.type = i2;
            gq.bLe = bVar.Co();
            bVar.a(gq);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, i, i2, str)));
            return;
        }
        x.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    private void a(com.tencent.mm.storage.aa.a aVar, int i, String str) {
        if (this.initialized) {
            b bVar = this.dls;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[]{aVar, Integer.valueOf(i), str});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                f = bVar.a(aVar, i, "", "");
                bVar.dlC.put(aVar, f);
                bVar.a(f);
            }
            f.value = str;
            f.type = i;
            f.bLe = bVar.Co();
            bVar.a(f);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, aVar, i, str)));
            return;
        }
        x.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    public final boolean aT(int i, int i2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a x = this.dls.x(i, i2, 1);
            if (x == null || parseInt(x.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.aa.a aVar, com.tencent.mm.storage.aa.a aVar2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a a = this.dls.a(aVar, aVar2, 1);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean aU(int i, int i2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a x = this.dls.x(i, i2, 2);
            if (x == null || parseInt(x.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final boolean b(com.tencent.mm.storage.aa.a aVar, com.tencent.mm.storage.aa.a aVar2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a a = this.dls.a(aVar, aVar2, 2);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.aa.a aVar, int i) {
        if (this.initialized) {
            com.tencent.mm.s.b.a aVar2;
            b bVar = this.dls;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", new Object[]{aVar, Integer.valueOf(i), Integer.valueOf(2)});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
                aVar2 = null;
            } else if ((f.type & 2) == 0) {
                x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
                aVar2 = null;
            } else {
                b gr = bVar.gr(i);
                if (gr != null) {
                    String str = (String) gr.dlK.get(aVar.name());
                    if (str == null || !str.equals(f.bLe)) {
                        if (str == null) {
                            gr.dlK.put(aVar.name(), bVar.Co());
                            bVar.a(gr);
                        }
                        aVar2 = f;
                    } else {
                        aVar2 = null;
                    }
                } else {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
                    aVar2 = null;
                }
            }
            if (aVar2 == null) {
                return false;
            }
            if (parseInt(aVar2.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final void aV(int i, int i2) {
        if (this.initialized) {
            b bVar = this.dls;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            com.tencent.mm.s.b.a gq = bVar.gq(i);
            if (gq == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                b gr = bVar.gr(i2);
                if (gr == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    gr = bVar.gp(i2);
                    bVar.dlD.put(i2, gr);
                }
                gr.dlJ.put(i, gq.bLe);
                bVar.a(gr);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, i2, i)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final void c(com.tencent.mm.storage.aa.a aVar, com.tencent.mm.storage.aa.a aVar2) {
        if (this.initialized) {
            b bVar = this.dls;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[]{aVar, aVar2});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                b g = bVar.g(aVar2);
                if (g == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    g = bVar.e(aVar2);
                    bVar.dlE.put(aVar2, g);
                }
                g.dlK.put(aVar.name(), f.bLe);
                bVar.a(g);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, aVar2, aVar)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final void b(com.tencent.mm.storage.aa.a aVar, int i) {
        if (this.initialized) {
            b bVar = this.dls;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", new Object[]{aVar, Integer.valueOf(i)});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                b gr = bVar.gr(i);
                if (gr == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    gr = bVar.gp(i);
                    bVar.dlD.put(i, gr);
                }
                gr.dlK.put(aVar.name(), f.bLe);
                bVar.a(gr);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, i, aVar)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final boolean a(com.tencent.mm.storage.aa.a aVar) {
        if (this.initialized) {
            com.tencent.mm.s.b.a f = this.dls.f(aVar);
            if (f == null || parseInt(f.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
        return false;
    }

    public static int parseInt(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        return bi.WU(str);
    }

    public final void a(a aVar) {
        if (this.initialized) {
            this.dlt.add(new WeakReference(aVar));
        } else {
            x.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
        }
    }

    public final void b(a aVar) {
        if (this.initialized) {
            ArrayList arrayList = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dlt.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) this.dlt.get(i2);
                if (weakReference == null || weakReference.get() == null || weakReference.get() == aVar) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(weakReference);
                }
                i = i2 + 1;
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.dlt.remove((WeakReference) it.next());
                }
                arrayList.clear();
                return;
            }
            return;
        }
        x.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
    }
}
