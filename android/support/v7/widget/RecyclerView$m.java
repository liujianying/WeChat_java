package android.support.v7.widget;

import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$m {
    final /* synthetic */ RecyclerView RQ;
    final ArrayList<t> Sn = new ArrayList();
    ArrayList<t> So = null;
    final ArrayList<t> Sp = new ArrayList();
    final List<t> Sq = Collections.unmodifiableList(this.Sn);
    int Sr = 2;
    l Ss;
    r St;

    public RecyclerView$m(RecyclerView recyclerView) {
        this.RQ = recyclerView;
    }

    public final void clear() {
        this.Sn.clear();
        gf();
    }

    public final int bs(int i) {
        if (i >= 0 && i < this.RQ.RB.getItemCount()) {
            return !this.RQ.RB.SL ? i : this.RQ.QP.aR(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.RQ.RB.getItemCount());
        }
    }

    public final View bt(int i) {
        boolean z = true;
        if (i < 0 || i >= this.RQ.RB.getItemCount()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.RQ.RB.getItemCount());
        }
        t bv;
        boolean z2;
        t bw;
        boolean z3;
        t d;
        LayoutParams layoutParams;
        if (this.RQ.RB.SL) {
            bv = bv(i);
            z2 = bv != null;
        } else {
            bv = null;
            z2 = false;
        }
        if (bv == null) {
            bw = bw(i);
            if (bw != null) {
                if (bw.isRemoved()) {
                    z3 = this.RQ.RB.SL;
                } else if (bw.mPosition < 0 || bw.mPosition >= RecyclerView.h(this.RQ).getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + bw);
                } else {
                    z3 = (this.RQ.RB.SL || RecyclerView.h(this.RQ).getItemViewType(bw.mPosition) == bw.SX) ? !RecyclerView.h(this.RQ).RS || bw.SW == RecyclerView.h(this.RQ).getItemId(bw.mPosition) : false;
                }
                if (z3) {
                    z2 = true;
                } else {
                    bw.addFlags(4);
                    if (bw.gn()) {
                        this.RQ.removeDetachedView(bw.SU, false);
                        bw.go();
                    } else if (bw.gp()) {
                        bw.gq();
                    }
                    n(bw);
                    bw = null;
                }
            }
        } else {
            bw = bv;
        }
        if (bw == null) {
            int aR = this.RQ.QP.aR(i);
            if (aR < 0 || aR >= RecyclerView.h(this.RQ).getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + aR + ").state:" + this.RQ.RB.getItemCount());
            }
            View gh;
            int itemViewType = RecyclerView.h(this.RQ).getItemViewType(aR);
            if (RecyclerView.h(this.RQ).RS) {
                bw = b(RecyclerView.h(this.RQ).getItemId(aR), itemViewType);
                if (bw != null) {
                    bw.mPosition = aR;
                    z3 = true;
                    if (bw == null && this.St != null) {
                        gh = this.St.gh();
                        if (gh != null) {
                            bw = this.RQ.aP(gh);
                            if (bw == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (bw.gk()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (bw == null) {
                        t tVar;
                        ArrayList arrayList = (ArrayList) getRecycledViewPool().Sk.get(itemViewType);
                        if (arrayList == null || arrayList.isEmpty()) {
                            tVar = null;
                        } else {
                            int size = arrayList.size() - 1;
                            tVar = (t) arrayList.get(size);
                            arrayList.remove(size);
                        }
                        if (tVar != null) {
                            tVar.gx();
                            if (RecyclerView.fW() && (tVar.SU instanceof ViewGroup)) {
                                a((ViewGroup) tVar.SU, false);
                            }
                        }
                        bw = tVar;
                    }
                    d = bw != null ? RecyclerView.h(this.RQ).d(this.RQ, itemViewType) : bw;
                }
            }
            z3 = z2;
            gh = this.St.gh();
            if (gh != null) {
                bw = this.RQ.aP(gh);
                if (bw == null) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                } else if (bw.gk()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                }
            }
            if (bw == null) {
                t tVar2;
                ArrayList arrayList2 = (ArrayList) getRecycledViewPool().Sk.get(itemViewType);
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    tVar2 = null;
                } else {
                    int size2 = arrayList2.size() - 1;
                    tVar2 = (t) arrayList2.get(size2);
                    arrayList2.remove(size2);
                }
                if (tVar2 != null) {
                    tVar2.gx();
                    if (RecyclerView.fW() && (tVar2.SU instanceof ViewGroup)) {
                        a((ViewGroup) tVar2.SU, false);
                    }
                }
                bw = tVar2;
            }
            if (bw != null) {
            }
        } else {
            d = bw;
            z3 = z2;
        }
        if (z3 && !this.RQ.RB.SL && d.by(8192)) {
            d.setFlags(0, 8192);
            if (this.RQ.RB.SM) {
                RecyclerView.a(this.RQ, d, this.RQ.Rr.a(this.RQ.RB, d, e.j(d) | 4096, d.gw()));
            }
        }
        if (this.RQ.RB.SL && d.isBound()) {
            d.SY = i;
            z2 = false;
        } else if (!d.isBound() || d.gt() || d.gs()) {
            int aR2 = this.RQ.QP.aR(i);
            d.Ti = this.RQ;
            a h = RecyclerView.h(this.RQ);
            d.mPosition = aR2;
            if (h.RS) {
                d.SW = h.getItemId(aR2);
            }
            d.setFlags(1, 519);
            android.support.v4.os.e.beginSection("RV OnBindView");
            h.a(d, aR2, d.gw());
            d.gv();
            android.support.v4.os.e.endSection();
            View view = d.SU;
            if (this.RQ.fJ()) {
                if (z.F(view) == 0) {
                    z.i(view, 1);
                }
                if (!z.C(view)) {
                    z.a(view, RecyclerView.t(this.RQ).Tj);
                }
            }
            if (this.RQ.RB.SL) {
                d.SY = i;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        ViewGroup.LayoutParams layoutParams2 = d.SU.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = (LayoutParams) this.RQ.generateDefaultLayoutParams();
            d.SU.setLayoutParams(layoutParams);
        } else if (this.RQ.checkLayoutParams(layoutParams2)) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = (LayoutParams) this.RQ.generateLayoutParams(layoutParams2);
            d.SU.setLayoutParams(layoutParams);
        }
        layoutParams.Sh = d;
        if (!(z3 && r1)) {
            z = false;
        }
        layoutParams.Sj = z;
        return d.SU;
    }

    private void a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    public final void bm(View view) {
        t aY = RecyclerView.aY(view);
        if (aY.gu()) {
            this.RQ.removeDetachedView(view, false);
        }
        if (aY.gn()) {
            aY.go();
        } else if (aY.gp()) {
            aY.gq();
        }
        n(aY);
    }

    final void gf() {
        for (int size = this.Sp.size() - 1; size >= 0; size--) {
            bu(size);
        }
        this.Sp.clear();
    }

    final void bu(int i) {
        o((t) this.Sp.get(i));
        this.Sp.remove(i);
    }

    final void n(t tVar) {
        boolean z = true;
        if (tVar.gn() || tVar.SU.getParent() != null) {
            StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(tVar.gn()).append(" isAttached:");
            if (tVar.SU.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (tVar.gu()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + tVar);
        } else if (tVar.gk()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            boolean z2;
            boolean s = t.s(tVar);
            if (RecyclerView.h(this.RQ) != null && s) {
                RecyclerView.h(this.RQ);
            }
            if (tVar.gy()) {
                if (!tVar.by(14)) {
                    int size = this.Sp.size();
                    if (size == this.Sr && size > 0) {
                        bu(0);
                    }
                    if (size < this.Sr) {
                        this.Sp.add(tVar);
                        z2 = true;
                        if (z2) {
                            o(tVar);
                        } else {
                            z = false;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z = false;
                } else {
                    o(tVar);
                }
            } else {
                z = false;
                z2 = false;
            }
            this.RQ.QR.F(tVar);
            if (!z2 && !z && s) {
                tVar.Ti = null;
            }
        }
    }

    private void o(t tVar) {
        z.a(tVar.SU, null);
        if (RecyclerView.u(this.RQ) != null) {
            RecyclerView.u(this.RQ);
        }
        if (RecyclerView.h(this.RQ) != null) {
            RecyclerView.h(this.RQ).a(tVar);
        }
        if (this.RQ.RB != null) {
            this.RQ.QR.F(tVar);
        }
        tVar.Ti = null;
        l recycledViewPool = getRecycledViewPool();
        int i = tVar.SX;
        ArrayList arrayList = (ArrayList) recycledViewPool.Sk.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            recycledViewPool.Sk.put(i, arrayList);
            if (recycledViewPool.Sl.indexOfKey(i) < 0) {
                recycledViewPool.Sl.put(i, 5);
            }
        }
        if (recycledViewPool.Sl.get(i) > arrayList.size()) {
            tVar.gx();
            arrayList.add(tVar);
        }
    }

    final void bn(View view) {
        t aY = RecyclerView.aY(view);
        t.t(aY);
        t.u(aY);
        aY.gq();
        n(aY);
    }

    final void bo(View view) {
        t aY = RecyclerView.aY(view);
        if (!aY.by(12) && aY.gz() && !RecyclerView.a(this.RQ, aY)) {
            if (this.So == null) {
                this.So = new ArrayList();
            }
            aY.a(this, true);
            this.So.add(aY);
        } else if (!aY.gs() || aY.isRemoved() || RecyclerView.h(this.RQ).RS) {
            aY.a(this, false);
            this.Sn.add(aY);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    final void p(t tVar) {
        if (t.v(tVar)) {
            this.So.remove(tVar);
        } else {
            this.Sn.remove(tVar);
        }
        t.t(tVar);
        t.u(tVar);
        tVar.gq();
    }

    private t bv(int i) {
        int i2 = 0;
        if (this.So != null) {
            int size = this.So.size();
            if (size != 0) {
                t tVar;
                int i3 = 0;
                while (i3 < size) {
                    tVar = (t) this.So.get(i3);
                    if (tVar.gp() || tVar.gl() != i) {
                        i3++;
                    } else {
                        tVar.addFlags(32);
                        return tVar;
                    }
                }
                if (RecyclerView.h(this.RQ).RS) {
                    int z = this.RQ.QP.z(i, 0);
                    if (z > 0 && z < RecyclerView.h(this.RQ).getItemCount()) {
                        long itemId = RecyclerView.h(this.RQ).getItemId(z);
                        while (i2 < size) {
                            tVar = (t) this.So.get(i2);
                            if (tVar.gp() || tVar.SW != itemId) {
                                i2++;
                            } else {
                                tVar.addFlags(32);
                                return tVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    private t bw(int i) {
        t tVar;
        View view;
        int i2 = 0;
        int size = this.Sn.size();
        int i3 = 0;
        while (i3 < size) {
            tVar = (t) this.Sn.get(i3);
            if (tVar.gp() || tVar.gl() != i || tVar.gs() || (!this.RQ.RB.SL && tVar.isRemoved())) {
                i3++;
            } else {
                tVar.addFlags(32);
                return tVar;
            }
        }
        s sVar = this.RQ.QQ;
        int size2 = sVar.NC.size();
        for (i3 = 0; i3 < size2; i3++) {
            View view2 = (View) sVar.NC.get(i3);
            t aP = sVar.NA.aP(view2);
            if (aP.gl() == i && !aP.gs() && !aP.isRemoved()) {
                view = view2;
                break;
            }
        }
        view = null;
        if (view != null) {
            tVar = RecyclerView.aY(view);
            s sVar2 = this.RQ.QQ;
            i2 = sVar2.NA.indexOfChild(view);
            if (i2 < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            } else if (sVar2.NB.get(i2)) {
                sVar2.NB.clear(i2);
                sVar2.aN(view);
                int indexOfChild = this.RQ.QQ.indexOfChild(view);
                if (indexOfChild == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + tVar);
                }
                this.RQ.QQ.detachViewFromParent(indexOfChild);
                bo(view);
                tVar.addFlags(8224);
                return tVar;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        i3 = this.Sp.size();
        while (i2 < i3) {
            tVar = (t) this.Sp.get(i2);
            if (tVar.gs() || tVar.gl() != i) {
                i2++;
            } else {
                this.Sp.remove(i2);
                return tVar;
            }
        }
        return null;
    }

    private t b(long j, int i) {
        int size;
        t tVar;
        for (size = this.Sn.size() - 1; size >= 0; size--) {
            tVar = (t) this.Sn.get(size);
            if (tVar.SW == j && !tVar.gp()) {
                if (i == tVar.SX) {
                    tVar.addFlags(32);
                    if (!tVar.isRemoved() || this.RQ.RB.SL) {
                        return tVar;
                    }
                    tVar.setFlags(2, 14);
                    return tVar;
                }
                this.Sn.remove(size);
                this.RQ.removeDetachedView(tVar.SU, false);
                bn(tVar.SU);
            }
        }
        for (size = this.Sp.size() - 1; size >= 0; size--) {
            tVar = (t) this.Sp.get(size);
            if (tVar.SW == j) {
                if (i == tVar.SX) {
                    this.Sp.remove(size);
                    return tVar;
                }
                bu(size);
            }
        }
        return null;
    }

    final l getRecycledViewPool() {
        if (this.Ss == null) {
            this.Ss = new l();
        }
        return this.Ss;
    }
}
