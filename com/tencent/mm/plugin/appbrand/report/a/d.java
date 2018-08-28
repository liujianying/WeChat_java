package com.tencent.mm.plugin.appbrand.report.a;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.a.g.a;
import com.tencent.mm.plugin.appbrand.report.a.g.b;
import com.tencent.mm.plugin.appbrand.report.a.g.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Deque;
import java.util.LinkedList;

final class d implements f, g {
    private final String grk;
    private final SparseArray<a> grl = new SparseArray();
    private final Deque<a> grm = new LinkedList();
    private boolean grn = true;
    private String gro;
    private a grp;

    d(String str) {
        this.grk = str;
    }

    private synchronized void b(p pVar, p pVar2) {
        boolean vr = vr(pVar2.ahc());
        this.grp = f(pVar2);
        this.grp.grs = new c(1, pVar.ahc());
        int hashCode = pVar.hashCode();
        while (!isEmpty() && amJ().grr != hashCode) {
            amI();
        }
        if (vr) {
            a(new a(pVar));
        }
        f(pVar).grt = new b(pVar2.ahc());
        f(pVar).grs = null;
    }

    private synchronized void e(p pVar) {
        this.gro = pVar.ahc();
        this.grn = false;
        a(new a(pVar));
        amJ().grt = bi.oW(this.grk) ? null : new b(this.grk);
    }

    private synchronized void amH() {
        this.grp = null;
        this.gro = null;
        this.grn = false;
    }

    public final void a(p pVar, p pVar2, aa aaVar) {
        synchronized (this) {
            if (this.grn) {
                e(pVar);
            } else if (aaVar == aa.gph) {
                b(pVar, pVar2);
            } else {
                if (this.grp != null) {
                    amH();
                }
                if (pVar2 != null) {
                    a f = f(pVar2);
                    if (f != null) {
                        f.grs = new c(2, pVar.ahc());
                    }
                }
                a aVar = new a(pVar);
                aVar.grt = pVar2 == null ? null : new b(pVar2.ahc());
                a(aVar);
            }
        }
    }

    public final void c(p pVar) {
        synchronized (this) {
            a f = f(pVar);
            if (f == null) {
                return;
            }
            Pair h = e.h(pVar);
            f.grs = new c(((Integer) h.first).intValue(), (String) h.second);
        }
    }

    private a f(p pVar) {
        a amJ = amJ();
        if (amJ == null) {
            return new a(pVar);
        }
        if (amJ.grr == pVar.hashCode()) {
            return amJ;
        }
        x.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
        return amJ;
    }

    public final synchronized void d(p pVar) {
        if (this.grn) {
            e(pVar);
        } else {
            amH();
        }
    }

    private synchronized void a(a aVar) {
        this.grm.offerFirst(aVar);
        this.grl.put(aVar.grr, aVar);
    }

    private synchronized a amI() {
        a aVar;
        aVar = (a) this.grm.pollFirst();
        if (aVar != null) {
            this.grl.remove(aVar.grr);
        }
        return aVar;
    }

    public final synchronized a amJ() {
        return (a) this.grm.peekFirst();
    }

    private synchronized boolean isEmpty() {
        return this.grm.isEmpty();
    }

    public final synchronized boolean vr(String str) {
        boolean z;
        z = !bi.oW(this.gro) && this.gro.equals(str);
        return z;
    }

    public final synchronized a g(p pVar) {
        a aVar;
        aVar = (a) this.grl.get(pVar.hashCode());
        if (aVar == null && this.grp != null && this.grp.grr == pVar.hashCode()) {
            aVar = this.grp;
        }
        return aVar;
    }
}
