package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$q;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.e.a;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class k extends v {
    boolean gAA = false;
    boolean gAB = true;
    private final a gAC = new 1(this);
    final Set<a> gAD = new HashSet();
    private final Interpolator gAE = new AccelerateDecelerateInterpolator();
    private final ArrayList<b> gAF = new ArrayList();
    final ArrayList<RecyclerView$t> gAG = new ArrayList();
    private final ArrayList<d> gAH = new ArrayList();
    final ArrayList<RecyclerView$t> gAI = new ArrayList();
    private final ArrayList<d> gAJ = new ArrayList();
    final ArrayList<d> gAK = new ArrayList();
    private final ArrayList<d> gAL = new ArrayList();
    final ArrayList<d> gAM = new ArrayList();
    private final ArrayList<f> gAN = new ArrayList();
    final ArrayList<d> gAO = new ArrayList();
    private final ArrayList<RecyclerView$t> gAP = new ArrayList();
    private final ArrayList<d> gAQ = new ArrayList();
    final ArrayList<d> gAR = new ArrayList();
    final ArrayList<d> gAS = new ArrayList();
    boolean gAT = false;

    k() {
    }

    static /* synthetic */ void a(k kVar) {
        if (!kVar.isRunning()) {
            kVar.fZ();
        }
    }

    final void b(a aVar) {
        if (aVar != null) {
            this.gAD.add(aVar);
        }
    }

    final void c(a aVar) {
        if (aVar != null) {
            this.gAD.remove(aVar);
        }
    }

    private void e(RecyclerView$t recyclerView$t) {
        android.support.v4.a.a.v(recyclerView$t.SU);
        d(recyclerView$t);
        z.c(recyclerView$t.SU, 0.0f);
        z.d(recyclerView$t.SU, 1.0f);
    }

    public final boolean isRunning() {
        return (this.gAF.isEmpty() && this.gAG.isEmpty() && this.gAH.isEmpty() && this.gAI.isEmpty() && this.gAJ.isEmpty() && this.gAK.isEmpty() && this.gAL.isEmpty() && this.gAM.isEmpty() && this.gAN.isEmpty() && this.gAO.isEmpty() && this.gAQ.isEmpty() && this.gAR.isEmpty() && this.gAS.isEmpty() && !super.isRunning()) ? false : true;
    }

    public final void eR() {
        Iterator it;
        ai U;
        d dVar;
        ai U2;
        a(this.gAC);
        if (!this.gAF.isEmpty()) {
            it = this.gAF.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                this.gAG.add(bVar.gAW);
                d dVar2 = bVar.gAW;
                View view = bVar.gAW.SU;
                bVar.gAW.gzj.setVisibility(0);
                z.c(view, 0.0f);
                U = z.U(view);
                U.h(Math.max(this.RX, Math.min(Math.round((((double) bVar.On) / ((double) bVar.gAW.SU.getHeight())) * ((double) this.RX)) + this.RX, 400)));
                U.c(this.gAE);
                U.a(new 2(this, dVar2, U));
                U.v((float) ((-bVar.On) - view.getHeight())).start();
            }
            this.gAF.clear();
        }
        if (!this.gAH.isEmpty()) {
            Iterator it2 = this.gAH.iterator();
            while (it2.hasNext()) {
                d dVar3 = (d) it2.next();
                this.gAI.add(dVar3.gAW);
                d dVar4 = dVar3.gAW;
                View view2 = dVar3.gAW.SU;
                RecentsRecyclerView recentsRecyclerView = (RecentsRecyclerView) view2.getParent();
                dVar3.gAW.gzj.setVisibility(8);
                z.c(view2, 0.0f);
                U = z.U(view2);
                U.h(this.RX);
                U.a(new 3(this, dVar4, U));
                U.v((float) (recentsRecyclerView.getHeight() - dVar3.On)).start();
            }
            this.gAH.clear();
        }
        if (!this.gAJ.isEmpty()) {
            it = this.gAJ.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                this.gAK.add(dVar);
                z.e(dVar.gzj, 0.1f);
                z.f(dVar.gzj, 0.1f);
                z.d(dVar.gzj, 0.0f);
                dVar.gzj.setVisibility(0);
                U2 = z.U(dVar.gzj);
                U2.h(this.RY);
                U2.a(new 4(this, dVar, U2));
                U2.t(1.0f).w(1.0f).x(1.0f).start();
            }
            this.gAJ.clear();
        }
        if (!this.gAL.isEmpty()) {
            it = this.gAL.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                this.gAM.add(dVar);
                z.e(dVar.gzj, 1.0f);
                z.f(dVar.gzj, 1.0f);
                z.d(dVar.gzj, 1.0f);
                dVar.gzj.setVisibility(0);
                U2 = z.U(dVar.gzj);
                U2.h(this.RY);
                U2.a(new 5(this, dVar));
                U2.t(0.0f).w(0.1f).x(0.1f).start();
            }
            this.gAL.clear();
        }
        if (!this.gAN.isEmpty()) {
            it = this.gAN.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                this.gAO.add(fVar.gAW);
                View view3 = fVar.gAW.SU;
                z.c(view3, 0.0f);
                z.d(view3, 1.0f);
                dVar = fVar.gAW;
                ai U3 = z.U(view3);
                U3.h(this.RX);
                U3.a(new 6(this, dVar));
                U3.t(0.0f).v((float) (-view3.getHeight())).start();
            }
            this.gAN.clear();
        }
        super.eR();
        if (!this.gAQ.isEmpty()) {
            this.gAR.addAll(this.gAQ);
            7 7 = new 7(this);
            this.gAQ.clear();
            if (this.gAT) {
                z.a(((d) this.gAR.get(0)).SU, 7, this.RW);
            } else {
                7.run();
            }
        }
    }

    public final void z(RecyclerView$t recyclerView$t) {
        super.z(recyclerView$t);
        if (!this.gAO.contains(recyclerView$t)) {
            this.gAT = true;
        }
    }

    public final boolean a(RecyclerView$t recyclerView$t, int i, int i2, int i3, int i4) {
        if ((recyclerView$t instanceof d) && this.gAB) {
            return super.a(recyclerView$t, i, i2, i3, i4);
        }
        e(recyclerView$t);
        y(recyclerView$t);
        return false;
    }

    public final boolean c(RecyclerView$t recyclerView$t) {
        e(recyclerView$t);
        k(recyclerView$t);
        return false;
    }

    public final void d(RecyclerView$t recyclerView$t) {
        if ((recyclerView$t instanceof d) && this.gAQ.remove(recyclerView$t)) {
            z.c(recyclerView$t.SU, 0.0f);
            k(recyclerView$t);
        }
        super.d(recyclerView$t);
    }

    public final boolean e(RecyclerView$t recyclerView$t, c cVar, c cVar2) {
        if (!this.gAB) {
            return c(recyclerView$t);
        }
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            if (this.gAA && (recyclerView$t.SU.getParent() instanceof RecyclerView) && (recyclerView$t instanceof d)) {
                RecyclerView recyclerView = (RecyclerView) recyclerView$t.SU.getParent();
                if (recyclerView.getHeight() > 0) {
                    d dVar;
                    if (cVar2.bottom >= recyclerView.getHeight()) {
                        dVar = (d) recyclerView$t;
                        z.c(dVar.SU, (float) dVar.SU.getHeight());
                        this.gAQ.add(dVar);
                        return true;
                    } else if (cVar2.top <= 0) {
                        dVar = (d) recyclerView$t;
                        z.c(dVar.SU, (float) (-dVar.SU.getHeight()));
                        this.gAQ.add(dVar);
                        return true;
                    }
                }
            }
            return c(recyclerView$t);
        }
        return super.a(recyclerView$t, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public final boolean d(RecyclerView$t recyclerView$t, c cVar, c cVar2) {
        if (!this.gAB) {
            e(recyclerView$t);
            k(recyclerView$t);
            return false;
        } else if (cVar instanceof c) {
            e(recyclerView$t);
            this.gAF.add(new b((d) recyclerView$t, cVar.left, cVar.top));
            return true;
        } else if (cVar instanceof e) {
            e(recyclerView$t);
            this.gAH.add(new d((d) recyclerView$t, cVar.left, cVar.top));
            return true;
        } else {
            if ((cVar.RZ & 2048) > 0 && (recyclerView$t instanceof d) && cVar2 == null) {
                boolean z;
                try {
                    z = ((d) recyclerView$t).aof().fmd;
                } catch (Exception e) {
                    z = false;
                }
                if (!z) {
                    e(recyclerView$t);
                    this.gAN.add(new f((d) recyclerView$t, cVar.left, cVar.top, (byte) 0));
                    return true;
                }
            }
            return super.d(recyclerView$t, cVar, cVar2);
        }
    }

    public final boolean b(RecyclerView$t recyclerView$t) {
        if (this.gAB) {
            return super.b(recyclerView$t);
        }
        e(recyclerView$t);
        k(recyclerView$t);
        return false;
    }

    public final boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2, int i, int i2, int i3, int i4) {
        if (z.U(recyclerView$t.SU) == null) {
            z.d(recyclerView$t.SU, 1.0f);
            z.c(recyclerView$t.SU, 0.0f);
        }
        if (z.U(recyclerView$t2.SU) == null) {
            z.d(recyclerView$t2.SU, 1.0f);
            z.c(recyclerView$t2.SU, 0.0f);
        }
        k(recyclerView$t);
        k(recyclerView$t2);
        return false;
    }

    public final boolean f(RecyclerView$t recyclerView$t, c cVar, c cVar2) {
        if (this.gAB) {
            return super.f(recyclerView$t, cVar, cVar2);
        }
        e(recyclerView$t);
        y(recyclerView$t);
        return false;
    }

    public final void l(RecyclerView$t recyclerView$t) {
        super.l(recyclerView$t);
        ViewParent parent = recyclerView$t.SU.getParent();
        if (parent instanceof RecentsRecyclerView) {
            ((RecentsRecyclerView) parent).bQ(recyclerView$t.SU);
        }
    }

    public final void A(RecyclerView$t recyclerView$t) {
        super.A(recyclerView$t);
        if (this.gAP.contains(recyclerView$t)) {
            ((RecentsRecyclerView) recyclerView$t.SU.getParent()).bP(recyclerView$t.SU);
        }
    }

    public final void B(RecyclerView$t recyclerView$t) {
        super.B(recyclerView$t);
        if (this.gAP.contains(recyclerView$t)) {
            this.gAP.remove(recyclerView$t);
            ((RecentsRecyclerView) recyclerView$t.SU.getParent()).bQ(recyclerView$t.SU);
        }
    }

    public final c a(RecyclerView$q recyclerView$q, RecyclerView$t recyclerView$t, int i, List<Object> list) {
        if ((i & 2) > 0) {
            for (Object next : list) {
                if (next instanceof Bundle) {
                    Boolean bool = (Boolean) ((Bundle) next).get("star");
                    if (bool != null && bool.booleanValue()) {
                        return new c((byte) 0).b(recyclerView$t, i);
                    }
                    if (!(bool == null || bool.booleanValue())) {
                        return new e((byte) 0).b(recyclerView$t, i);
                    }
                }
            }
        }
        c a = super.a(recyclerView$q, recyclerView$t, i, list);
        a.RZ = i;
        return a;
    }

    public final boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2, c cVar, c cVar2) {
        if (!this.gAB) {
            k(recyclerView$t);
            k(recyclerView$t2);
            return false;
        } else if (cVar instanceof c) {
            if (((c) cVar).aop()) {
                ((d) recyclerView$t2).gzj.setVisibility(0);
                ((d) recyclerView$t2).gzj.invalidate();
                ((RecentsRecyclerView) recyclerView$t2.SU.getParent()).bP(recyclerView$t2.SU);
                this.gAP.add(recyclerView$t2);
                return super.a(recyclerView$t2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(recyclerView$t2);
            this.gAJ.add((d) recyclerView$t2);
            return true;
        } else if (!(cVar instanceof e)) {
            return super.a(recyclerView$t, recyclerView$t2, cVar, cVar2);
        } else {
            if (((e) cVar).aop()) {
                ((d) recyclerView$t2).gzj.setVisibility(8);
                return super.a(recyclerView$t2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(recyclerView$t2);
            this.gAL.add((d) recyclerView$t2);
            return true;
        }
    }

    public final boolean a(RecyclerView$t recyclerView$t, List<Object> list) {
        return (recyclerView$t instanceof d) || super.a(recyclerView$t, list);
    }
}
