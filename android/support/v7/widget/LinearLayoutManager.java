package android.support.v7.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.ab.1;
import android.support.v7.widget.ab.2;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.plugin.appbrand.s$l;
import java.util.List;

public class LinearLayoutManager extends h {
    int OT;
    private c Pe;
    ab Pf;
    private boolean Pg;
    private boolean Ph;
    boolean Pi;
    private boolean Pj;
    private boolean Pk;
    int Pl;
    int Pm;
    private boolean Pn;
    SavedState Po;
    final a Pp;

    class a {
        int Pr;
        boolean Ps;
        int mPosition;

        a() {
        }

        final void fk() {
            this.Pr = this.Ps ? LinearLayoutManager.this.Pf.ft() : LinearLayoutManager.this.Pf.fs();
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.Pr + ", mLayoutFromEnd=" + this.Ps + '}';
        }

        public final void aS(View view) {
            if (this.Ps) {
                this.Pr = LinearLayoutManager.this.Pf.aV(view) + LinearLayoutManager.this.Pf.fr();
            } else {
                this.Pr = LinearLayoutManager.this.Pf.aU(view);
            }
            this.mPosition = LinearLayoutManager.bd(view);
        }
    }

    protected static class b {
        public boolean Gu;
        public int Pt;
        public boolean Pu;
        public boolean mFinished;

        protected b() {
        }
    }

    public LinearLayoutManager() {
        this(1);
    }

    public LinearLayoutManager(int i) {
        this.Ph = false;
        this.Pi = false;
        this.Pj = false;
        this.Pk = true;
        this.Pl = -1;
        this.Pm = Integer.MIN_VALUE;
        this.Po = null;
        this.Pp = new a();
        setOrientation(i);
        O(null);
        if (this.Ph) {
            this.Ph = false;
            requestLayout();
        }
        this.Sd = true;
    }

    public LayoutParams eV() {
        return new LayoutParams(-2, -2);
    }

    public final void a(RecyclerView recyclerView, m mVar) {
        super.a(recyclerView, mVar);
        if (this.Pn) {
            d(mVar);
            mVar.clear();
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setFromIndex(fi());
            a.setToIndex(fj());
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.Po != null) {
            return new SavedState(this.Po);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            fd();
            boolean z = this.Pg ^ this.Pi;
            savedState.PC = z;
            View fh;
            if (z) {
                fh = fh();
                savedState.PB = this.Pf.ft() - this.Pf.aV(fh);
                savedState.PA = bd(fh);
                return savedState;
            }
            fh = fg();
            savedState.PA = bd(fh);
            savedState.PB = this.Pf.aU(fh) - this.Pf.fs();
            return savedState;
        }
        savedState.PA = -1;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.Po = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final boolean eZ() {
        return this.OT == 0;
    }

    public final boolean fa() {
        return this.OT == 1;
    }

    public final void setOrientation(int i) {
        if (i == 0 || i == 1) {
            O(null);
            if (i != this.OT) {
                this.OT = i;
                this.Pf = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void fb() {
        boolean z = true;
        if (this.OT == 1 || !fc()) {
            z = this.Ph;
        } else if (this.Ph) {
            z = false;
        }
        this.Pi = z;
    }

    public final View be(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int bd = i - bd(getChildAt(0));
        if (bd >= 0 && bd < childCount) {
            View childAt = getChildAt(bd);
            if (bd(childAt) == i) {
                return childAt;
            }
        }
        return super.be(i);
    }

    public int a(RecyclerView$q recyclerView$q) {
        int i;
        if (recyclerView$q.Sv != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.Pf.fu();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, int i) {
        AnonymousClass1 anonymousClass1 = new z(recyclerView.getContext()) {
            public final PointF bf(int i) {
                return LinearLayoutManager.this.bf(i);
            }
        };
        anonymousClass1.Sv = i;
        a(anonymousClass1);
    }

    public final PointF bf(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < bd(getChildAt(0))) {
            z = true;
        }
        if (z != this.Pi) {
            i2 = -1;
        }
        if (this.OT == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void c(m mVar, RecyclerView$q recyclerView$q) {
        if (!(this.Po == null && this.Pl == -1) && recyclerView$q.getItemCount() == 0) {
            d(mVar);
            return;
        }
        Object obj;
        View be;
        int fr;
        int aW;
        int fs;
        int min;
        int i;
        if (this.Po != null && this.Po.fl()) {
            this.Pl = this.Po.PA;
        }
        fd();
        this.Pe.OG = false;
        fb();
        a aVar = this.Pp;
        aVar.mPosition = -1;
        aVar.Pr = Integer.MIN_VALUE;
        aVar.Ps = false;
        this.Pp.Ps = this.Pi ^ this.Pj;
        a aVar2 = this.Pp;
        if (recyclerView$q.SL || this.Pl == -1) {
            obj = null;
        } else if (this.Pl < 0 || this.Pl >= recyclerView$q.getItemCount()) {
            this.Pl = -1;
            this.Pm = Integer.MIN_VALUE;
            obj = null;
        } else {
            aVar2.mPosition = this.Pl;
            if (this.Po == null || !this.Po.fl()) {
                if (this.Pm == Integer.MIN_VALUE) {
                    be = be(this.Pl);
                    if (be == null) {
                        if (getChildCount() > 0) {
                            aVar2.Ps = (this.Pl < bd(getChildAt(0))) == this.Pi;
                        }
                        aVar2.fk();
                    } else if (this.Pf.aW(be) > this.Pf.fu()) {
                        aVar2.fk();
                    } else if (this.Pf.aU(be) - this.Pf.fs() < 0) {
                        aVar2.Pr = this.Pf.fs();
                        aVar2.Ps = false;
                    } else if (this.Pf.ft() - this.Pf.aV(be) < 0) {
                        aVar2.Pr = this.Pf.ft();
                        aVar2.Ps = true;
                    } else {
                        aVar2.Pr = aVar2.Ps ? this.Pf.aV(be) + this.Pf.fr() : this.Pf.aU(be);
                    }
                    obj = 1;
                } else {
                    aVar2.Ps = this.Pi;
                    if (this.Pi) {
                        aVar2.Pr = this.Pf.ft() - this.Pm;
                    } else {
                        aVar2.Pr = this.Pf.fs() + this.Pm;
                    }
                }
                obj = 1;
            } else {
                aVar2.Ps = this.Po.PC;
                if (aVar2.Ps) {
                    aVar2.Pr = this.Pf.ft() - this.Po.PB;
                } else {
                    aVar2.Pr = this.Pf.fs() + this.Po.PB;
                }
                obj = 1;
            }
        }
        if (obj == null) {
            if (getChildCount() != 0) {
                View view;
                if (this.Sa == null) {
                    view = null;
                } else {
                    be = this.Sa.getFocusedChild();
                    view = (be == null || this.QQ.aO(be)) ? null : be;
                }
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.Sh.isRemoved() || layoutParams.Sh.gl() < 0 || layoutParams.Sh.gl() >= recyclerView$q.getItemCount()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        fr = aVar2.Pq.Pf.fr();
                        if (fr >= 0) {
                            aVar2.aS(view);
                        } else {
                            aVar2.mPosition = bd(view);
                            if (aVar2.Ps) {
                                fr = (aVar2.Pq.Pf.ft() - fr) - aVar2.Pq.Pf.aV(view);
                                aVar2.Pr = aVar2.Pq.Pf.ft() - fr;
                                if (fr > 0) {
                                    aW = aVar2.Pr - aVar2.Pq.Pf.aW(view);
                                    fs = aVar2.Pq.Pf.fs();
                                    min = aW - (Math.min(aVar2.Pq.Pf.aU(view) - fs, 0) + fs);
                                    if (min < 0) {
                                        aVar2.Pr = Math.min(fr, -min) + aVar2.Pr;
                                    }
                                }
                            } else {
                                aW = aVar2.Pq.Pf.aU(view);
                                fs = aW - aVar2.Pq.Pf.fs();
                                aVar2.Pr = aW;
                                if (fs > 0) {
                                    fr = (aVar2.Pq.Pf.ft() - Math.min(0, (aVar2.Pq.Pf.ft() - fr) - aVar2.Pq.Pf.aV(view))) - (aW + aVar2.Pq.Pf.aW(view));
                                    if (fr < 0) {
                                        aVar2.Pr -= Math.min(fs, -fr);
                                    }
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fk();
                            if (this.Pj) {
                                fr = recyclerView$q.getItemCount() - 1;
                            } else {
                                fr = 0;
                            }
                            aVar2.mPosition = fr;
                        }
                    }
                }
                if (this.Pg == this.Pj) {
                    be = aVar2.Ps ? d(mVar, recyclerView$q) : e(mVar, recyclerView$q);
                    if (be != null) {
                        aVar2.aS(be);
                        if (!recyclerView$q.SL && eY()) {
                            obj = (this.Pf.aU(be) >= this.Pf.ft() || this.Pf.aV(be) < this.Pf.fs()) ? 1 : null;
                            if (obj != null) {
                                aVar2.Pr = aVar2.Ps ? this.Pf.ft() : this.Pf.fs();
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fk();
                            if (this.Pj) {
                                fr = recyclerView$q.getItemCount() - 1;
                            } else {
                                fr = 0;
                            }
                            aVar2.mPosition = fr;
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                aVar2.fk();
                if (this.Pj) {
                    fr = recyclerView$q.getItemCount() - 1;
                } else {
                    fr = 0;
                }
                aVar2.mPosition = fr;
            }
        }
        min = a(recyclerView$q);
        if (this.Pe.Py >= 0) {
            i = 0;
            fr = min;
        } else {
            fr = 0;
            i = min;
        }
        min = this.Pf.fs() + i;
        fr += this.Pf.getEndPadding();
        if (!(!recyclerView$q.SL || this.Pl == -1 || this.Pm == Integer.MIN_VALUE)) {
            View be2 = be(this.Pl);
            if (be2 != null) {
                if (this.Pi) {
                    i = (this.Pf.ft() - this.Pf.aV(be2)) - this.Pm;
                } else {
                    i = this.Pm - (this.Pf.aU(be2) - this.Pf.fs());
                }
                if (i > 0) {
                    min += i;
                } else {
                    fr -= i;
                }
            }
        }
        i = this.Pp.Ps ? this.Pi ? 1 : -1 : this.Pi ? -1 : 1;
        a(mVar, recyclerView$q, this.Pp, i);
        b(mVar);
        this.Pe.OP = fe();
        this.Pe.Px = recyclerView$q.SL;
        if (this.Pp.Ps) {
            b(this.Pp);
            this.Pe.Pw = min;
            a(mVar, this.Pe, recyclerView$q, false);
            min = this.Pe.tH;
            aW = this.Pe.OI;
            if (this.Pe.OH > 0) {
                fr += this.Pe.OH;
            }
            a(this.Pp);
            this.Pe.Pw = fr;
            c cVar = this.Pe;
            cVar.OI += this.Pe.OJ;
            a(mVar, this.Pe, recyclerView$q, false);
            i = this.Pe.tH;
            if (this.Pe.OH > 0) {
                fr = this.Pe.OH;
                P(aW, min);
                this.Pe.Pw = fr;
                a(mVar, this.Pe, recyclerView$q, false);
                fr = this.Pe.tH;
            } else {
                fr = min;
            }
            min = i;
            aW = fr;
        } else {
            a(this.Pp);
            this.Pe.Pw = fr;
            a(mVar, this.Pe, recyclerView$q, false);
            fr = this.Pe.tH;
            aW = this.Pe.OI;
            if (this.Pe.OH > 0) {
                min += this.Pe.OH;
            }
            b(this.Pp);
            this.Pe.Pw = min;
            c cVar2 = this.Pe;
            cVar2.OI += this.Pe.OJ;
            a(mVar, this.Pe, recyclerView$q, false);
            i = this.Pe.tH;
            if (this.Pe.OH > 0) {
                min = this.Pe.OH;
                O(aW, fr);
                this.Pe.Pw = min;
                a(mVar, this.Pe, recyclerView$q, false);
                min = this.Pe.tH;
                aW = i;
            } else {
                min = fr;
                aW = i;
            }
        }
        if (getChildCount() > 0) {
            if ((this.Pi ^ this.Pj) != 0) {
                fr = a(min, mVar, recyclerView$q, true);
                i = aW + fr;
                fr += min;
                min = b(i, mVar, recyclerView$q, false);
                aW = i + min;
                min += fr;
            } else {
                fr = b(aW, mVar, recyclerView$q, true);
                i = aW + fr;
                fr += min;
                min = a(fr, mVar, recyclerView$q, false);
                aW = i + min;
                min += fr;
            }
        }
        if (recyclerView$q.SN && getChildCount() != 0 && !recyclerView$q.SL && eY()) {
            int i2 = 0;
            fs = 0;
            List list = mVar.Sq;
            int size = list.size();
            int bd = bd(getChildAt(0));
            int i3 = 0;
            while (i3 < size) {
                RecyclerView$t recyclerView$t = (RecyclerView$t) list.get(i3);
                if (recyclerView$t.isRemoved()) {
                    fr = fs;
                    i = i2;
                } else {
                    if (((recyclerView$t.gl() < bd) != this.Pi ? -1 : 1) == -1) {
                        i = i2 + this.Pf.aW(recyclerView$t.SU);
                        fr = fs;
                    } else {
                        fr = this.Pf.aW(recyclerView$t.SU) + fs;
                        i = i2;
                    }
                }
                i3++;
                fs = fr;
                i2 = i;
            }
            this.Pe.Pz = list;
            if (i2 > 0) {
                P(bd(fg()), aW);
                this.Pe.Pw = i2;
                this.Pe.OH = 0;
                this.Pe.aT(null);
                a(mVar, this.Pe, recyclerView$q, false);
            }
            if (fs > 0) {
                O(bd(fh()), min);
                this.Pe.Pw = fs;
                this.Pe.OH = 0;
                this.Pe.aT(null);
                a(mVar, this.Pe, recyclerView$q, false);
            }
            this.Pe.Pz = null;
        }
        if (!recyclerView$q.SL) {
            this.Pl = -1;
            this.Pm = Integer.MIN_VALUE;
            ab abVar = this.Pf;
            abVar.QH = abVar.fu();
        }
        this.Pg = this.Pj;
        this.Po = null;
    }

    void a(m mVar, RecyclerView$q recyclerView$q, a aVar, int i) {
    }

    private int a(int i, m mVar, RecyclerView$q recyclerView$q, boolean z) {
        int ft = this.Pf.ft() - i;
        if (ft <= 0) {
            return 0;
        }
        ft = -c(-ft, mVar, recyclerView$q);
        int i2 = i + ft;
        if (!z) {
            return ft;
        }
        i2 = this.Pf.ft() - i2;
        if (i2 <= 0) {
            return ft;
        }
        this.Pf.bj(i2);
        return ft + i2;
    }

    private int b(int i, m mVar, RecyclerView$q recyclerView$q, boolean z) {
        int fs = i - this.Pf.fs();
        if (fs <= 0) {
            return 0;
        }
        fs = -c(fs, mVar, recyclerView$q);
        int i2 = i + fs;
        if (!z) {
            return fs;
        }
        i2 -= this.Pf.fs();
        if (i2 <= 0) {
            return fs;
        }
        this.Pf.bj(-i2);
        return fs - i2;
    }

    private void a(a aVar) {
        O(aVar.mPosition, aVar.Pr);
    }

    private void O(int i, int i2) {
        this.Pe.OH = this.Pf.ft() - i2;
        this.Pe.OJ = this.Pi ? -1 : 1;
        this.Pe.OI = i;
        this.Pe.OK = 1;
        this.Pe.tH = i2;
        this.Pe.Pv = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        P(aVar.mPosition, aVar.Pr);
    }

    private void P(int i, int i2) {
        this.Pe.OH = i2 - this.Pf.fs();
        this.Pe.OI = i;
        this.Pe.OJ = this.Pi ? 1 : -1;
        this.Pe.OK = -1;
        this.Pe.tH = i2;
        this.Pe.Pv = Integer.MIN_VALUE;
    }

    protected final boolean fc() {
        return z.I(this.Sa) == 1;
    }

    final void fd() {
        if (this.Pe == null) {
            this.Pe = new c();
        }
        if (this.Pf == null) {
            ab 1;
            switch (this.OT) {
                case 0:
                    1 = new 1(this);
                    break;
                case 1:
                    1 = new 2(this);
                    break;
                default:
                    throw new IllegalArgumentException("invalid orientation");
            }
            this.Pf = 1;
        }
    }

    public final void bg(int i) {
        this.Pl = i;
        this.Pm = Integer.MIN_VALUE;
        if (this.Po != null) {
            this.Po.PA = -1;
        }
        requestLayout();
    }

    public final void Q(int i, int i2) {
        this.Pl = i;
        this.Pm = i2;
        if (this.Po != null) {
            this.Po.PA = -1;
        }
        requestLayout();
    }

    public int a(int i, m mVar, RecyclerView$q recyclerView$q) {
        if (this.OT == 1) {
            return 0;
        }
        return c(i, mVar, recyclerView$q);
    }

    public int b(int i, m mVar, RecyclerView$q recyclerView$q) {
        if (this.OT == 0) {
            return 0;
        }
        return c(i, mVar, recyclerView$q);
    }

    public final int b(RecyclerView$q recyclerView$q) {
        return h(recyclerView$q);
    }

    public final int c(RecyclerView$q recyclerView$q) {
        return h(recyclerView$q);
    }

    public final int d(RecyclerView$q recyclerView$q) {
        return i(recyclerView$q);
    }

    public final int e(RecyclerView$q recyclerView$q) {
        return i(recyclerView$q);
    }

    public final int f(RecyclerView$q recyclerView$q) {
        return j(recyclerView$q);
    }

    public final int g(RecyclerView$q recyclerView$q) {
        return j(recyclerView$q);
    }

    private int h(RecyclerView$q recyclerView$q) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        fd();
        ab abVar = this.Pf;
        View P = P(!this.Pk);
        if (this.Pk) {
            z = false;
        }
        return ah.a(recyclerView$q, abVar, P, Q(z), this, this.Pk, this.Pi);
    }

    private int i(RecyclerView$q recyclerView$q) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        fd();
        ab abVar = this.Pf;
        View P = P(!this.Pk);
        if (this.Pk) {
            z = false;
        }
        return ah.a(recyclerView$q, abVar, P, Q(z), this, this.Pk);
    }

    private int j(RecyclerView$q recyclerView$q) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        fd();
        ab abVar = this.Pf;
        View P = P(!this.Pk);
        if (this.Pk) {
            z = false;
        }
        return ah.b(recyclerView$q, abVar, P, Q(z), this, this.Pk);
    }

    private void a(int i, int i2, boolean z, RecyclerView$q recyclerView$q) {
        int i3 = -1;
        int i4 = 1;
        this.Pe.OP = fe();
        this.Pe.Pw = a(recyclerView$q);
        this.Pe.OK = i;
        View fh;
        c cVar;
        if (i == 1) {
            c cVar2 = this.Pe;
            cVar2.Pw += this.Pf.getEndPadding();
            fh = fh();
            cVar = this.Pe;
            if (!this.Pi) {
                i3 = 1;
            }
            cVar.OJ = i3;
            this.Pe.OI = bd(fh) + this.Pe.OJ;
            this.Pe.tH = this.Pf.aV(fh);
            i3 = this.Pf.aV(fh) - this.Pf.ft();
        } else {
            fh = fg();
            cVar = this.Pe;
            cVar.Pw += this.Pf.fs();
            cVar = this.Pe;
            if (!this.Pi) {
                i4 = -1;
            }
            cVar.OJ = i4;
            this.Pe.OI = bd(fh) + this.Pe.OJ;
            this.Pe.tH = this.Pf.aU(fh);
            i3 = (-this.Pf.aU(fh)) + this.Pf.fs();
        }
        this.Pe.OH = i2;
        if (z) {
            c cVar3 = this.Pe;
            cVar3.OH -= i3;
        }
        this.Pe.Pv = i3;
    }

    private boolean fe() {
        return this.Pf.getMode() == 0 && this.Pf.getEnd() == 0;
    }

    private int c(int i, m mVar, RecyclerView$q recyclerView$q) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.Pe.OG = true;
        fd();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, recyclerView$q);
        int a = this.Pe.Pv + a(mVar, this.Pe, recyclerView$q, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.Pf.bj(-i);
        this.Pe.Py = i;
        return i;
    }

    public final void O(String str) {
        if (this.Po == null) {
            super.O(str);
        }
    }

    private void a(m mVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, mVar);
                }
                return;
            }
            while (i > i2) {
                a(i, mVar);
                i--;
            }
        }
    }

    private void a(m mVar, c cVar) {
        if (cVar.OG && !cVar.OP) {
            int i;
            int childCount;
            int end;
            if (cVar.OK == -1) {
                i = cVar.Pv;
                childCount = getChildCount();
                if (i >= 0) {
                    end = this.Pf.getEnd() - i;
                    if (this.Pi) {
                        for (i = 0; i < childCount; i++) {
                            if (this.Pf.aU(getChildAt(i)) < end) {
                                a(mVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = childCount - 1; i >= 0; i--) {
                        if (this.Pf.aU(getChildAt(i)) < end) {
                            a(mVar, childCount - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            childCount = cVar.Pv;
            if (childCount >= 0) {
                end = getChildCount();
                if (this.Pi) {
                    for (i = end - 1; i >= 0; i--) {
                        if (this.Pf.aV(getChildAt(i)) > childCount) {
                            a(mVar, end - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < end; i++) {
                    if (this.Pf.aV(getChildAt(i)) > childCount) {
                        a(mVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int a(m mVar, c cVar, RecyclerView$q recyclerView$q, boolean z) {
        int i = cVar.OH;
        if (cVar.Pv != Integer.MIN_VALUE) {
            if (cVar.OH < 0) {
                cVar.Pv += cVar.OH;
            }
            a(mVar, cVar);
        }
        int i2 = cVar.OH + cVar.Pw;
        b bVar = new b();
        while (true) {
            if ((!cVar.OP && i2 <= 0) || !cVar.k(recyclerView$q)) {
                break;
            }
            bVar.Pt = 0;
            bVar.mFinished = false;
            bVar.Pu = false;
            bVar.Gu = false;
            a(mVar, recyclerView$q, cVar, bVar);
            if (!bVar.mFinished) {
                cVar.tH += bVar.Pt * cVar.OK;
                if (!(bVar.Pu && this.Pe.Pz == null && recyclerView$q.SL)) {
                    cVar.OH -= bVar.Pt;
                    i2 -= bVar.Pt;
                }
                if (cVar.Pv != Integer.MIN_VALUE) {
                    cVar.Pv += bVar.Pt;
                    if (cVar.OH < 0) {
                        cVar.Pv += cVar.OH;
                    }
                    a(mVar, cVar);
                }
                if (z && bVar.Gu) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.OH;
    }

    void a(m mVar, RecyclerView$q recyclerView$q, c cVar, b bVar) {
        View a = cVar.a(mVar);
        if (a == null) {
            bVar.mFinished = true;
            return;
        }
        int i;
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (cVar.Pz == null) {
            if (this.Pi == (cVar.OK == -1)) {
                super.b(a, -1, false);
            } else {
                super.b(a, 0, false);
            }
        } else {
            boolean z;
            boolean z2 = this.Pi;
            if (cVar.OK == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                super.b(a, -1, true);
            } else {
                super.b(a, 0, true);
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
        Rect bb = this.Sa.bb(a);
        int i4 = (bb.left + bb.right) + 0;
        int i5 = (bb.bottom + bb.top) + 0;
        i4 = h.d(this.mWidth, this.Sf, i4 + (((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin), layoutParams2.width, eZ());
        i5 = h.d(this.mHeight, this.Sg, i5 + (((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin), layoutParams2.height, fa());
        if (a(a, i4, i5, layoutParams2)) {
            a.measure(i4, i5);
        }
        bVar.Pt = this.Pf.aW(a);
        int paddingRight;
        if (this.OT == 1) {
            if (fc()) {
                paddingRight = this.mWidth - getPaddingRight();
                i5 = paddingRight - this.Pf.aX(a);
            } else {
                i5 = getPaddingLeft();
                paddingRight = this.Pf.aX(a) + i5;
            }
            if (cVar.OK == -1) {
                i4 = cVar.tH;
                i = cVar.tH - bVar.Pt;
                i2 = paddingRight;
                i3 = i5;
            } else {
                i = cVar.tH;
                i4 = cVar.tH + bVar.Pt;
                i2 = paddingRight;
                i3 = i5;
            }
        } else {
            i = getPaddingTop();
            paddingRight = this.Pf.aX(a) + i;
            if (cVar.OK == -1) {
                i3 = cVar.tH - bVar.Pt;
                i4 = paddingRight;
                i2 = cVar.tH;
            } else {
                i3 = cVar.tH;
                i4 = paddingRight;
                i2 = cVar.tH + bVar.Pt;
            }
        }
        g(a, layoutParams.leftMargin + i3, layoutParams.topMargin + i, i2 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
        if (layoutParams.Sh.isRemoved() || layoutParams.Sh.gz()) {
            bVar.Pu = true;
        }
        bVar.Gu = a.isFocusable();
    }

    final boolean ff() {
        if (!(this.Sg == 1073741824 || this.Sf == 1073741824)) {
            boolean z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final int bh(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (this.OT != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case s$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                if (this.OT != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case s$l.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                return this.OT == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.OT == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View fg() {
        return getChildAt(this.Pi ? getChildCount() - 1 : 0);
    }

    private View fh() {
        return getChildAt(this.Pi ? 0 : getChildCount() - 1);
    }

    private View P(boolean z) {
        if (this.Pi) {
            return b(getChildCount() - 1, -1, z, true);
        }
        return b(0, getChildCount(), z, true);
    }

    private View Q(boolean z) {
        if (this.Pi) {
            return b(0, getChildCount(), z, true);
        }
        return b(getChildCount() - 1, -1, z, true);
    }

    private View d(m mVar, RecyclerView$q recyclerView$q) {
        return this.Pi ? f(mVar, recyclerView$q) : g(mVar, recyclerView$q);
    }

    private View e(m mVar, RecyclerView$q recyclerView$q) {
        return this.Pi ? g(mVar, recyclerView$q) : f(mVar, recyclerView$q);
    }

    private View f(m mVar, RecyclerView$q recyclerView$q) {
        return a(mVar, recyclerView$q, 0, getChildCount(), recyclerView$q.getItemCount());
    }

    private View g(m mVar, RecyclerView$q recyclerView$q) {
        return a(mVar, recyclerView$q, getChildCount() - 1, -1, recyclerView$q.getItemCount());
    }

    View a(m mVar, RecyclerView$q recyclerView$q, int i, int i2, int i3) {
        fd();
        int fs = this.Pf.fs();
        int ft = this.Pf.ft();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bd = bd(childAt);
            if (bd >= 0 && bd < i3) {
                if (((LayoutParams) childAt.getLayoutParams()).Sh.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        view2 = childAt;
                        i += i4;
                        view = view3;
                    }
                } else if (this.Pf.aU(childAt) < ft && this.Pf.aV(childAt) >= fs) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        i += i4;
                        view = view3;
                    }
                }
            }
            view3 = view;
            i += i4;
            view = view3;
        }
        return view != null ? view : view2;
    }

    public final int fi() {
        View b = b(0, getChildCount(), false, true);
        return b == null ? -1 : bd(b);
    }

    public final int fj() {
        View b = b(getChildCount() - 1, -1, false, true);
        if (b == null) {
            return -1;
        }
        return bd(b);
    }

    public final View b(int i, int i2, boolean z, boolean z2) {
        fd();
        int fs = this.Pf.fs();
        int ft = this.Pf.ft();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int aU = this.Pf.aU(childAt);
            int aV = this.Pf.aV(childAt);
            if (aU < ft && aV > fs) {
                if (!z) {
                    return childAt;
                }
                if (aU >= fs && aV <= ft) {
                    return childAt;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
    }

    public View a(View view, int i, m mVar, RecyclerView$q recyclerView$q) {
        fb();
        if (getChildCount() == 0) {
            return null;
        }
        int bh = bh(i);
        if (bh == Integer.MIN_VALUE) {
            return null;
        }
        View e;
        fd();
        if (bh == -1) {
            e = e(mVar, recyclerView$q);
        } else {
            e = d(mVar, recyclerView$q);
        }
        if (e == null) {
            return null;
        }
        View fg;
        fd();
        a(bh, (int) (0.33333334f * ((float) this.Pf.fu())), false, recyclerView$q);
        this.Pe.Pv = Integer.MIN_VALUE;
        this.Pe.OG = false;
        a(mVar, this.Pe, recyclerView$q, true);
        if (bh == -1) {
            fg = fg();
        } else {
            fg = fh();
        }
        if (fg == e || !fg.isFocusable()) {
            return null;
        }
        return fg;
    }

    public boolean eY() {
        return this.Po == null && this.Pg == this.Pj;
    }
}
