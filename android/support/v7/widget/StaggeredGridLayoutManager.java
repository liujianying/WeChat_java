package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.BitSet;

public final class StaggeredGridLayoutManager extends h {
    private int OT;
    private int Ov;
    private boolean Ph;
    boolean Pi;
    private boolean Pk;
    int Pl;
    int Pm;
    private b[] UN;
    ab UO;
    ab UP;
    private int UQ;
    private final y UR;
    private BitSet US;
    LazySpanLookup UT;
    private int UU;
    private boolean UV;
    private boolean UW;
    private SavedState UX;
    private int UY;
    private final a UZ;
    private boolean Va;
    private final Runnable Vb;
    private final Rect ea;

    private class a {
        boolean Ps;
        final /* synthetic */ StaggeredGridLayoutManager Vc;
        boolean Vd;
        int mPosition;
        int tH;
    }

    private boolean gO() {
        if (getChildCount() == 0 || this.UU == 0 || !this.eC) {
            return false;
        }
        int gQ;
        int gR;
        if (this.Pi) {
            gQ = gQ();
            gR = gR();
        } else {
            gQ = gR();
            gR = gQ();
        }
        if (gQ == 0 && gP() != null) {
            this.UT.clear();
            this.Sc = true;
            requestLayout();
            return true;
        } else if (!this.Va) {
            return false;
        } else {
            int i = this.Pi ? -1 : 1;
            FullSpanItem q = this.UT.q(gQ, gR + 1, i);
            if (q == null) {
                this.Va = false;
                this.UT.bG(gR + 1);
                return false;
            }
            FullSpanItem q2 = this.UT.q(gQ, q.mPosition, i * -1);
            if (q2 == null) {
                this.UT.bG(q.mPosition);
            } else {
                this.UT.bG(q2.mPosition + 1);
            }
            this.Sc = true;
            requestLayout();
            return true;
        }
    }

    public final void br(int i) {
        if (i == 0) {
            gO();
        }
    }

    public final void a(RecyclerView recyclerView, m mVar) {
        removeCallbacks(this.Vb);
        for (int i = 0; i < this.Ov; i++) {
            this.UN[i].clear();
        }
    }

    private View gP() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.Ov);
        bitSet.set(0, this.Ov, true);
        boolean z = (this.OT == 1 && fc()) ? true : true;
        if (this.Pi) {
            i = -1;
        } else {
            i2 = childCount + 1;
            childCount = 0;
            i = i2;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = childCount;
        while (i3 != i) {
            boolean z2;
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.Ve.mIndex)) {
                b bVar = layoutParams.Ve;
                if (this.Pi) {
                    if (bVar.gW() < this.UO.ft()) {
                        z2 = !((LayoutParams) ((View) bVar.Vp.get(bVar.Vp.size() + -1)).getLayoutParams()).Vf;
                    }
                    z2 = false;
                } else {
                    if (bVar.gU() > this.UO.fs()) {
                        z2 = !((LayoutParams) ((View) bVar.Vp.get(0)).getLayoutParams()).Vf;
                    }
                    z2 = false;
                }
                if (z2) {
                    return childAt;
                }
                bitSet.clear(layoutParams.Ve.mIndex);
            }
            if (!(layoutParams.Vf || i3 + i2 == i)) {
                View childAt2 = getChildAt(i3 + i2);
                int aV;
                if (this.Pi) {
                    childCount = this.UO.aV(childAt);
                    aV = this.UO.aV(childAt2);
                    if (childCount < aV) {
                        return childAt;
                    }
                    if (childCount == aV) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.UO.aU(childAt);
                    aV = this.UO.aU(childAt2);
                    if (childCount > aV) {
                        return childAt;
                    }
                    if (childCount == aV) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.Ve.mIndex - ((LayoutParams) childAt2.getLayoutParams()).Ve.mIndex < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z >= false) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public final void O(String str) {
        if (this.UX == null) {
            super.O(str);
        }
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

    private boolean fc() {
        return z.I(this.Sa) == 1;
    }

    public final void a(Rect rect, int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.OT == 1) {
            paddingTop = m(i2, paddingTop + rect.height(), z.T(this.Sa));
            paddingRight = m(i, paddingRight + (this.UQ * this.Ov), z.S(this.Sa));
        } else {
            paddingRight = m(i, paddingRight + rect.width(), z.S(this.Sa));
            paddingTop = m(i2, paddingTop + (this.UQ * this.Ov), z.T(this.Sa));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public final void c(m mVar, q qVar) {
        Object obj = 1;
        while (true) {
            Object obj2 = obj;
            a aVar = this.UZ;
            aVar.mPosition = -1;
            aVar.tH = Integer.MIN_VALUE;
            aVar.Ps = false;
            aVar.Vd = false;
            if (!(this.UX == null && this.Pl == -1) && qVar.getItemCount() == 0) {
                d(mVar);
                return;
            }
            int i;
            int i2;
            int childCount;
            int i3;
            if (this.UX != null) {
                if (this.UX.Vl > 0) {
                    if (this.UX.Vl == this.Ov) {
                        for (i = 0; i < this.Ov; i++) {
                            this.UN[i].clear();
                            i2 = this.UX.Vm[i];
                            if (i2 != Integer.MIN_VALUE) {
                                i2 = this.UX.PC ? i2 + this.UO.ft() : i2 + this.UO.fs();
                            }
                            this.UN[i].bN(i2);
                        }
                    } else {
                        SavedState savedState = this.UX;
                        savedState.Vm = null;
                        savedState.Vl = 0;
                        savedState.Vn = 0;
                        savedState.Vo = null;
                        savedState.Vg = null;
                        this.UX.PA = this.UX.Vk;
                    }
                }
                this.UW = this.UX.UW;
                boolean z = this.UX.Ph;
                O(null);
                if (!(this.UX == null || this.UX.Ph == z)) {
                    this.UX.Ph = z;
                }
                this.Ph = z;
                requestLayout();
                fb();
                if (this.UX.PA != -1) {
                    this.Pl = this.UX.PA;
                    aVar.Ps = this.UX.PC;
                } else {
                    aVar.Ps = this.Pi;
                }
                if (this.UX.Vn > 1) {
                    this.UT.mData = this.UX.Vo;
                    this.UT.Vg = this.UX.Vg;
                }
            } else {
                fb();
                aVar.Ps = this.Pi;
            }
            if (qVar.SL || this.Pl == -1) {
                obj = null;
            } else if (this.Pl < 0 || this.Pl >= qVar.getItemCount()) {
                this.Pl = -1;
                this.Pm = Integer.MIN_VALUE;
                obj = null;
            } else {
                if (this.UX == null || this.UX.PA == -1 || this.UX.Vl <= 0) {
                    View be = be(this.Pl);
                    if (be != null) {
                        aVar.mPosition = this.Pi ? gQ() : gR();
                        if (this.Pm != Integer.MIN_VALUE) {
                            if (aVar.Ps) {
                                aVar.tH = (this.UO.ft() - this.Pm) - this.UO.aV(be);
                            } else {
                                aVar.tH = (this.UO.fs() + this.Pm) - this.UO.aU(be);
                            }
                            obj = 1;
                        } else if (this.UO.aW(be) > this.UO.fu()) {
                            aVar.tH = aVar.Ps ? this.UO.ft() : this.UO.fs();
                        } else {
                            i = this.UO.aU(be) - this.UO.fs();
                            if (i < 0) {
                                aVar.tH = -i;
                            } else {
                                i = this.UO.ft() - this.UO.aV(be);
                                if (i < 0) {
                                    aVar.tH = i;
                                } else {
                                    aVar.tH = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        aVar.mPosition = this.Pl;
                        if (this.Pm == Integer.MIN_VALUE) {
                            aVar.Ps = bF(aVar.mPosition) == 1;
                            aVar.tH = aVar.Ps ? aVar.Vc.UO.ft() : aVar.Vc.UO.fs();
                        } else {
                            i = this.Pm;
                            if (aVar.Ps) {
                                aVar.tH = aVar.Vc.UO.ft() - i;
                            } else {
                                aVar.tH = i + aVar.Vc.UO.fs();
                            }
                        }
                        aVar.Vd = true;
                    }
                } else {
                    aVar.tH = Integer.MIN_VALUE;
                    aVar.mPosition = this.Pl;
                }
                obj = 1;
            }
            if (obj == null) {
                int itemCount;
                if (this.UV) {
                    itemCount = qVar.getItemCount();
                    for (i2 = getChildCount() - 1; i2 >= 0; i2--) {
                        i = bd(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                } else {
                    itemCount = qVar.getItemCount();
                    childCount = getChildCount();
                    for (i2 = 0; i2 < childCount; i2++) {
                        i = bd(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                }
                aVar.mPosition = i;
                aVar.tH = Integer.MIN_VALUE;
            }
            if (this.UX == null && !(aVar.Ps == this.UV && fc() == this.UW)) {
                this.UT.clear();
                aVar.Vd = true;
            }
            if (getChildCount() > 0 && (this.UX == null || this.UX.Vl <= 0)) {
                if (!aVar.Vd) {
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= this.Ov) {
                            break;
                        }
                        b bVar = this.UN[i2];
                        boolean z2 = this.Pi;
                        i3 = aVar.tH;
                        i = z2 ? bVar.bM(Integer.MIN_VALUE) : bVar.bL(Integer.MIN_VALUE);
                        bVar.clear();
                        if (i != Integer.MIN_VALUE && ((!z2 || i >= bVar.Vc.UO.ft()) && (z2 || i <= bVar.Vc.UO.fs()))) {
                            if (i3 != Integer.MIN_VALUE) {
                                i += i3;
                            }
                            bVar.Vr = i;
                            bVar.Vq = i;
                        }
                        i = i2 + 1;
                    }
                } else {
                    for (i = 0; i < this.Ov; i++) {
                        this.UN[i].clear();
                        if (aVar.tH != Integer.MIN_VALUE) {
                            this.UN[i].bN(aVar.tH);
                        }
                    }
                }
            }
            b(mVar);
            this.UR.OG = false;
            this.Va = false;
            bA(this.UP.fu());
            a(aVar.mPosition, qVar);
            if (aVar.Ps) {
                bB(-1);
                a(mVar, this.UR, qVar);
                bB(1);
                this.UR.OI = aVar.mPosition + this.UR.OJ;
                a(mVar, this.UR, qVar);
            } else {
                bB(1);
                a(mVar, this.UR, qVar);
                bB(-1);
                this.UR.OI = aVar.mPosition + this.UR.OJ;
                a(mVar, this.UR, qVar);
            }
            if (this.UP.getMode() != 1073741824) {
                float f = 0.0f;
                i3 = getChildCount();
                childCount = 0;
                while (childCount < i3) {
                    float max;
                    View childAt = getChildAt(childCount);
                    float aW = (float) this.UP.aW(childAt);
                    if (aW >= f) {
                        max = Math.max(f, ((LayoutParams) childAt.getLayoutParams()).Vf ? (1.0f * aW) / ((float) this.Ov) : aW);
                    } else {
                        max = f;
                    }
                    childCount++;
                    f = max;
                }
                childCount = this.UQ;
                i = Math.round(((float) this.Ov) * f);
                if (this.UP.getMode() == Integer.MIN_VALUE) {
                    i = Math.min(i, this.UP.fu());
                }
                bA(i);
                if (this.UQ != childCount) {
                    for (i2 = 0; i2 < i3; i2++) {
                        View childAt2 = getChildAt(i2);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.Vf) {
                            if (fc() && this.OT == 1) {
                                childAt2.offsetLeftAndRight(((-((this.Ov - 1) - layoutParams.Ve.mIndex)) * this.UQ) - ((-((this.Ov - 1) - layoutParams.Ve.mIndex)) * childCount));
                            } else {
                                int i4 = layoutParams.Ve.mIndex * this.UQ;
                                i = layoutParams.Ve.mIndex * childCount;
                                if (this.OT == 1) {
                                    childAt2.offsetLeftAndRight(i4 - i);
                                } else {
                                    childAt2.offsetTopAndBottom(i4 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (getChildCount() > 0) {
                if (this.Pi) {
                    a(mVar, qVar, true);
                    b(mVar, qVar, false);
                } else {
                    b(mVar, qVar, true);
                    a(mVar, qVar, false);
                }
            }
            obj = null;
            if (!(obj2 == null || qVar.SL)) {
                obj2 = (this.UU == 0 || getChildCount() <= 0 || (!this.Va && gP() == null)) ? null : 1;
                if (obj2 != null) {
                    removeCallbacks(this.Vb);
                    if (gO()) {
                        obj = 1;
                    }
                }
                this.Pl = -1;
                this.Pm = Integer.MIN_VALUE;
            }
            this.UV = aVar.Ps;
            this.UW = fc();
            this.UX = null;
            if (obj != null) {
                obj = null;
            } else {
                return;
            }
        }
    }

    private void bA(int i) {
        this.UQ = i / this.Ov;
        this.UY = MeasureSpec.makeMeasureSpec(i, this.UP.getMode());
    }

    public final boolean eY() {
        return this.UX == null;
    }

    public final int b(q qVar) {
        return h(qVar);
    }

    private int h(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.UO;
        View Y = Y(!this.Pk);
        if (this.Pk) {
            z = false;
        }
        return ah.a(qVar, abVar, Y, Z(z), this, this.Pk, this.Pi);
    }

    public final int c(q qVar) {
        return h(qVar);
    }

    public final int d(q qVar) {
        return i(qVar);
    }

    private int i(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.UO;
        View Y = Y(!this.Pk);
        if (this.Pk) {
            z = false;
        }
        return ah.a(qVar, abVar, Y, Z(z), this, this.Pk);
    }

    public final int e(q qVar) {
        return i(qVar);
    }

    public final int f(q qVar) {
        return j(qVar);
    }

    private int j(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.UO;
        View Y = Y(!this.Pk);
        if (this.Pk) {
            z = false;
        }
        return ah.b(qVar, abVar, Y, Z(z), this, this.Pk);
    }

    public final int g(q qVar) {
        return j(qVar);
    }

    private void g(View view, int i, int i2) {
        a(view, this.ea);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int l = l(i, layoutParams.leftMargin + this.ea.left, layoutParams.rightMargin + this.ea.right);
        int l2 = l(i2, layoutParams.topMargin + this.ea.top, layoutParams.bottomMargin + this.ea.bottom);
        if (a(view, l, l2, layoutParams)) {
            view.measure(l, l2);
        }
    }

    private static int l(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.UX = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.UX != null) {
            return new SavedState(this.UX);
        }
        SavedState savedState = new SavedState();
        savedState.Ph = this.Ph;
        savedState.PC = this.UV;
        savedState.UW = this.UW;
        if (this.UT == null || this.UT.mData == null) {
            savedState.Vn = 0;
        } else {
            savedState.Vo = this.UT.mData;
            savedState.Vn = savedState.Vo.length;
            savedState.Vg = this.UT.Vg;
        }
        if (getChildCount() > 0) {
            int i;
            savedState.PA = this.UV ? gQ() : gR();
            View Z = this.Pi ? Z(true) : Y(true);
            if (Z == null) {
                i = -1;
            } else {
                i = bd(Z);
            }
            savedState.Vk = i;
            savedState.Vl = this.Ov;
            savedState.Vm = new int[this.Ov];
            for (i = 0; i < this.Ov; i++) {
                int bM;
                if (this.UV) {
                    bM = this.UN[i].bM(Integer.MIN_VALUE);
                    if (bM != Integer.MIN_VALUE) {
                        bM -= this.UO.ft();
                    }
                } else {
                    bM = this.UN[i].bL(Integer.MIN_VALUE);
                    if (bM != Integer.MIN_VALUE) {
                        bM -= this.UO.fs();
                    }
                }
                savedState.Vm[i] = bM;
            }
        } else {
            savedState.PA = -1;
            savedState.Vk = -1;
            savedState.Vl = 0;
        }
        return savedState;
    }

    public final void a(m mVar, q qVar, View view, b bVar) {
        int i = 1;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int gS;
            int i2;
            int i3;
            int i4;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.OT == 0) {
                gS = layoutParams2.gS();
                if (layoutParams2.Vf) {
                    i = this.Ov;
                }
                i2 = -1;
                i3 = -1;
                i4 = i;
            } else {
                i3 = layoutParams2.gS();
                if (layoutParams2.Vf) {
                    i2 = this.Ov;
                    i4 = -1;
                    gS = -1;
                } else {
                    i2 = 1;
                    i4 = -1;
                    gS = -1;
                }
            }
            bVar.l(l.c(gS, i4, i3, i2, layoutParams2.Vf));
            return;
        }
        super.b(view, bVar);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            View Y = Y(false);
            View Z = Z(false);
            if (Y != null && Z != null) {
                int bd = bd(Y);
                int bd2 = bd(Z);
                if (bd < bd2) {
                    a.setFromIndex(bd);
                    a.setToIndex(bd2);
                    return;
                }
                a.setFromIndex(bd2);
                a.setToIndex(bd);
            }
        }
    }

    public final int a(m mVar, q qVar) {
        if (this.OT == 0) {
            return this.Ov;
        }
        return super.a(mVar, qVar);
    }

    public final int b(m mVar, q qVar) {
        if (this.OT == 1) {
            return this.Ov;
        }
        return super.b(mVar, qVar);
    }

    private View Y(boolean z) {
        int fs = this.UO.fs();
        int ft = this.UO.ft();
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            int aU = this.UO.aU(childAt);
            if (this.UO.aV(childAt) > fs && aU < ft) {
                if (aU >= fs || !z) {
                    return childAt;
                }
                if (view == null) {
                    i++;
                    view = childAt;
                }
            }
            childAt = view;
            i++;
            view = childAt;
        }
        return view;
    }

    private View Z(boolean z) {
        int fs = this.UO.fs();
        int ft = this.UO.ft();
        View view = null;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            int aU = this.UO.aU(childAt);
            int aV = this.UO.aV(childAt);
            if (aV > fs && aU < ft) {
                if (aV <= ft || !z) {
                    return childAt;
                }
                if (view == null) {
                    childCount--;
                    view = childAt;
                }
            }
            childAt = view;
            childCount--;
            view = childAt;
        }
        return view;
    }

    private void a(m mVar, q qVar, boolean z) {
        int bD = bD(Integer.MIN_VALUE);
        if (bD != Integer.MIN_VALUE) {
            bD = this.UO.ft() - bD;
            if (bD > 0) {
                bD -= -c(-bD, mVar, qVar);
                if (z && bD > 0) {
                    this.UO.bj(bD);
                }
            }
        }
    }

    private void b(m mVar, q qVar, boolean z) {
        int bC = bC(Integer.MAX_VALUE);
        if (bC != Integer.MAX_VALUE) {
            bC -= this.UO.fs();
            if (bC > 0) {
                bC -= c(bC, mVar, qVar);
                if (z && bC > 0) {
                    this.UO.bj(-bC);
                }
            }
        }
    }

    private void a(int i, q qVar) {
        int i2;
        int i3;
        boolean z;
        y yVar;
        boolean z2 = false;
        this.UR.OH = 0;
        this.UR.OI = i;
        if (gb()) {
            i2 = qVar.Sv;
            if (i2 != -1) {
                if (this.Pi == (i2 < i)) {
                    i2 = this.UO.fu();
                    i3 = 0;
                } else {
                    i3 = this.UO.fu();
                    i2 = 0;
                }
                if (this.Sa == null && RecyclerView.w(this.Sa)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.UR.OM = i2 + this.UO.getEnd();
                    this.UR.OL = -i3;
                } else {
                    this.UR.OL = this.UO.fs() - i3;
                    this.UR.OM = i2 + this.UO.ft();
                }
                this.UR.OO = false;
                this.UR.OG = true;
                yVar = this.UR;
                if (this.UO.getMode() == 0 && this.UO.getEnd() == 0) {
                    z2 = true;
                }
                yVar.OP = z2;
            }
        }
        i2 = 0;
        i3 = 0;
        if (this.Sa == null) {
        }
        z = false;
        if (z) {
            this.UR.OM = i2 + this.UO.getEnd();
            this.UR.OL = -i3;
        } else {
            this.UR.OL = this.UO.fs() - i3;
            this.UR.OM = i2 + this.UO.ft();
        }
        this.UR.OO = false;
        this.UR.OG = true;
        yVar = this.UR;
        z2 = true;
        yVar.OP = z2;
    }

    private void bB(int i) {
        int i2 = 1;
        this.UR.OK = i;
        y yVar = this.UR;
        if (this.Pi != (i == -1)) {
            i2 = -1;
        }
        yVar.OJ = i2;
    }

    public final void bp(int i) {
        super.bp(i);
        for (int i2 = 0; i2 < this.Ov; i2++) {
            this.UN[i2].bO(i);
        }
    }

    public final void bq(int i) {
        super.bq(i);
        for (int i2 = 0; i2 < this.Ov; i2++) {
            this.UN[i2].bO(i);
        }
    }

    public final void G(int i, int i2) {
        p(i, i2, 2);
    }

    public final void F(int i, int i2) {
        p(i, i2, 1);
    }

    public final void eU() {
        this.UT.clear();
        requestLayout();
    }

    public final void I(int i, int i2) {
        p(i, i2, 8);
    }

    public final void H(int i, int i2) {
        p(i, i2, 4);
    }

    private void p(int i, int i2, int i3) {
        int i4;
        int i5;
        int gQ = this.Pi ? gQ() : gR();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.UT.bH(i5);
        switch (i3) {
            case 1:
                this.UT.am(i, i2);
                break;
            case 2:
                this.UT.al(i, i2);
                break;
            case 8:
                this.UT.al(i, 1);
                this.UT.am(i2, 1);
                break;
        }
        if (i4 > gQ) {
            if (i5 <= (this.Pi ? gR() : gQ())) {
                requestLayout();
            }
        }
    }

    private int a(m mVar, y yVar, q qVar) {
        int i;
        int fs;
        this.US.set(0, this.Ov, true);
        if (this.UR.OP) {
            if (yVar.OK == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (yVar.OK == 1) {
            i = yVar.OM + yVar.OH;
        } else {
            i = yVar.OL - yVar.OH;
        }
        ak(yVar.OK, i);
        int ft = this.Pi ? this.UO.ft() : this.UO.fs();
        Object obj = null;
        while (true) {
            Object obj2 = (yVar.OI < 0 || yVar.OI >= qVar.getItemCount()) ? null : 1;
            if (obj2 != null && (this.UR.OP || !this.US.isEmpty())) {
                b bVar;
                int i2;
                int i3;
                int i4;
                int bM;
                View bt = mVar.bt(yVar.OI);
                yVar.OI += yVar.OJ;
                LayoutParams layoutParams = (LayoutParams) bt.getLayoutParams();
                int gl = layoutParams.Sh.gl();
                LazySpanLookup lazySpanLookup = this.UT;
                int i5 = (lazySpanLookup.mData == null || gl >= lazySpanLookup.mData.length) ? -1 : lazySpanLookup.mData[gl];
                Object obj3 = i5 == -1 ? 1 : null;
                if (obj3 != null) {
                    if (layoutParams.Vf) {
                        bVar = this.UN[0];
                    } else {
                        if (bE(yVar.OK)) {
                            i5 = this.Ov - 1;
                            i2 = -1;
                            i3 = -1;
                        } else {
                            i5 = 0;
                            i2 = this.Ov;
                            i3 = 1;
                        }
                        int fs2;
                        int i6;
                        b bVar2;
                        if (yVar.OK == 1) {
                            bVar = null;
                            i4 = Integer.MAX_VALUE;
                            fs2 = this.UO.fs();
                            i6 = i5;
                            while (i6 != i2) {
                                bVar2 = this.UN[i6];
                                bM = bVar2.bM(fs2);
                                if (bM >= i4) {
                                    bVar2 = bVar;
                                    bM = i4;
                                }
                                i6 += i3;
                                bVar = bVar2;
                                i4 = bM;
                            }
                        } else {
                            bVar = null;
                            i4 = Integer.MIN_VALUE;
                            fs2 = this.UO.ft();
                            i6 = i5;
                            while (i6 != i2) {
                                bVar2 = this.UN[i6];
                                bM = bVar2.bL(fs2);
                                if (bM <= i4) {
                                    bVar2 = bVar;
                                    bM = i4;
                                }
                                i6 += i3;
                                bVar = bVar2;
                                i4 = bM;
                            }
                        }
                    }
                    lazySpanLookup = this.UT;
                    lazySpanLookup.bI(gl);
                    lazySpanLookup.mData[gl] = bVar.mIndex;
                } else {
                    bVar = this.UN[i5];
                }
                layoutParams.Ve = bVar;
                if (yVar.OK == 1) {
                    super.b(bt, -1, false);
                } else {
                    super.b(bt, 0, false);
                }
                if (layoutParams.Vf) {
                    if (this.OT == 1) {
                        g(bt, this.UY, d(this.mHeight, this.Sg, 0, layoutParams.height, true));
                    } else {
                        g(bt, d(this.mWidth, this.Sf, 0, layoutParams.width, true), this.UY);
                    }
                } else if (this.OT == 1) {
                    g(bt, d(this.UQ, this.Sf, 0, layoutParams.width, false), d(this.mHeight, this.Sg, 0, layoutParams.height, true));
                } else {
                    g(bt, d(this.mWidth, this.Sf, 0, layoutParams.width, true), d(this.UQ, this.Sg, 0, layoutParams.height, false));
                }
                FullSpanItem fullSpanItem;
                if (yVar.OK == 1) {
                    i3 = layoutParams.Vf ? bD(ft) : bVar.bM(ft);
                    i2 = i3 + this.UO.aW(bt);
                    if (obj3 == null || !layoutParams.Vf) {
                        i5 = i2;
                        bM = i3;
                    } else {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.Vi = new int[this.Ov];
                        for (i5 = 0; i5 < this.Ov; i5++) {
                            fullSpanItem.Vi[i5] = i3 - this.UN[i5].bM(i3);
                        }
                        fullSpanItem.Vh = -1;
                        fullSpanItem.mPosition = gl;
                        this.UT.a(fullSpanItem);
                        i5 = i2;
                        bM = i3;
                    }
                } else {
                    i3 = layoutParams.Vf ? bC(ft) : bVar.bL(ft);
                    i2 = i3 - this.UO.aW(bt);
                    if (obj3 != null && layoutParams.Vf) {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.Vi = new int[this.Ov];
                        for (i5 = 0; i5 < this.Ov; i5++) {
                            fullSpanItem.Vi[i5] = this.UN[i5].bL(i3) - i3;
                        }
                        fullSpanItem.Vh = 1;
                        fullSpanItem.mPosition = gl;
                        this.UT.a(fullSpanItem);
                    }
                    i5 = i3;
                    bM = i2;
                }
                if (layoutParams.Vf && yVar.OJ == -1) {
                    if (obj3 == null) {
                        if (yVar.OK == 1) {
                            i2 = this.UN[0].bM(Integer.MIN_VALUE);
                            for (i3 = 1; i3 < this.Ov; i3++) {
                                if (this.UN[i3].bM(Integer.MIN_VALUE) != i2) {
                                    obj2 = null;
                                    break;
                                }
                            }
                            obj2 = 1;
                            obj2 = obj2 == null ? 1 : null;
                        } else {
                            i2 = this.UN[0].bL(Integer.MIN_VALUE);
                            for (i3 = 1; i3 < this.Ov; i3++) {
                                if (this.UN[i3].bL(Integer.MIN_VALUE) != i2) {
                                    obj2 = null;
                                    break;
                                }
                            }
                            obj2 = 1;
                            obj2 = obj2 == null ? 1 : null;
                        }
                        if (obj2 != null) {
                            FullSpanItem bJ = this.UT.bJ(gl);
                            if (bJ != null) {
                                bJ.Vj = true;
                            }
                        }
                    }
                    this.Va = true;
                }
                if (yVar.OK == 1) {
                    if (layoutParams.Vf) {
                        for (i3 = this.Ov - 1; i3 >= 0; i3--) {
                            this.UN[i3].bq(bt);
                        }
                    } else {
                        layoutParams.Ve.bq(bt);
                    }
                } else if (layoutParams.Vf) {
                    for (i3 = this.Ov - 1; i3 >= 0; i3--) {
                        this.UN[i3].bp(bt);
                    }
                } else {
                    layoutParams.Ve.bp(bt);
                }
                if (fc() && this.OT == 1) {
                    i3 = layoutParams.Vf ? this.UP.ft() : this.UP.ft() - (((this.Ov - 1) - bVar.mIndex) * this.UQ);
                    i2 = i3 - this.UP.aW(bt);
                    i4 = i3;
                } else {
                    i3 = layoutParams.Vf ? this.UP.fs() : (bVar.mIndex * this.UQ) + this.UP.fs();
                    i4 = i3 + this.UP.aW(bt);
                    i2 = i3;
                }
                if (this.OT == 1) {
                    h(bt, i2, bM, i4, i5);
                } else {
                    h(bt, bM, i2, i5, i4);
                }
                if (layoutParams.Vf) {
                    ak(this.UR.OK, i);
                } else {
                    a(bVar, this.UR.OK, i);
                }
                a(mVar, this.UR);
                if (this.UR.OO && bt.isFocusable()) {
                    if (layoutParams.Vf) {
                        this.US.clear();
                    } else {
                        this.US.set(bVar.mIndex, false);
                    }
                }
                obj = 1;
            } else if (obj == null) {
                a(mVar, this.UR);
            }
        }
        if (obj == null) {
            a(mVar, this.UR);
        }
        if (this.UR.OK == -1) {
            fs = this.UO.fs() - bC(this.UO.fs());
        } else {
            fs = bD(this.UO.ft()) - this.UO.ft();
        }
        return fs > 0 ? Math.min(yVar.OH, fs) : 0;
    }

    private void a(m mVar, y yVar) {
        int i = 1;
        if (yVar.OG && !yVar.OP) {
            int i2;
            int bL;
            int bL2;
            if (yVar.OH == 0) {
                if (yVar.OK == -1) {
                    b(mVar, yVar.OM);
                } else {
                    a(mVar, yVar.OL);
                }
            } else if (yVar.OK == -1) {
                i2 = yVar.OL;
                int i3 = yVar.OL;
                bL = this.UN[0].bL(i3);
                while (i < this.Ov) {
                    bL2 = this.UN[i].bL(i3);
                    if (bL2 > bL) {
                        bL = bL2;
                    }
                    i++;
                }
                i = i2 - bL;
                if (i < 0) {
                    i = yVar.OM;
                } else {
                    i = yVar.OM - Math.min(i, yVar.OH);
                }
                b(mVar, i);
            } else {
                i2 = yVar.OM;
                bL = this.UN[0].bM(i2);
                while (i < this.Ov) {
                    bL2 = this.UN[i].bM(i2);
                    if (bL2 < bL) {
                        bL = bL2;
                    }
                    i++;
                }
                i = bL - yVar.OM;
                if (i < 0) {
                    i = yVar.OL;
                } else {
                    i = Math.min(i, yVar.OH) + yVar.OL;
                }
                a(mVar, i);
            }
        }
    }

    private static void h(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        g(view, layoutParams.leftMargin + i, layoutParams.topMargin + i2, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void ak(int i, int i2) {
        for (int i3 = 0; i3 < this.Ov; i3++) {
            if (!this.UN[i3].Vp.isEmpty()) {
                a(this.UN[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int i3 = bVar.Vs;
        if (i == -1) {
            if (i3 + bVar.gU() <= i2) {
                this.US.set(bVar.mIndex, false);
            }
        } else if (bVar.gW() - i3 >= i2) {
            this.US.set(bVar.mIndex, false);
        }
    }

    private int bC(int i) {
        int bL = this.UN[0].bL(i);
        for (int i2 = 1; i2 < this.Ov; i2++) {
            int bL2 = this.UN[i2].bL(i);
            if (bL2 < bL) {
                bL = bL2;
            }
        }
        return bL;
    }

    private int bD(int i) {
        int bM = this.UN[0].bM(i);
        for (int i2 = 1; i2 < this.Ov; i2++) {
            int bM2 = this.UN[i2].bM(i);
            if (bM2 > bM) {
                bM = bM2;
            }
        }
        return bM;
    }

    private void a(m mVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.UO.aV(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.Vf) {
                    int i2 = 0;
                    while (i2 < this.Ov) {
                        if (this.UN[i2].Vp.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.Ov; i2++) {
                        this.UN[i2].gY();
                    }
                } else if (layoutParams.Ve.Vp.size() != 1) {
                    layoutParams.Ve.gY();
                } else {
                    return;
                }
                a(childAt, mVar);
            } else {
                return;
            }
        }
    }

    private void b(m mVar, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.UO.aU(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.Vf) {
                    int i2 = 0;
                    while (i2 < this.Ov) {
                        if (this.UN[i2].Vp.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.Ov; i2++) {
                        this.UN[i2].gX();
                    }
                } else if (layoutParams.Ve.Vp.size() != 1) {
                    layoutParams.Ve.gX();
                } else {
                    return;
                }
                a(childAt, mVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean bE(int i) {
        if (this.OT == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.Pi) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.Pi) != fc()) {
            return false;
        }
        return true;
    }

    public final boolean fa() {
        return this.OT == 1;
    }

    public final boolean eZ() {
        return this.OT == 0;
    }

    public final int a(int i, m mVar, q qVar) {
        return c(i, mVar, qVar);
    }

    public final int b(int i, m mVar, q qVar) {
        return c(i, mVar, qVar);
    }

    private int bF(int i) {
        if (getChildCount() != 0) {
            if ((i < gR()) != this.Pi) {
                return -1;
            }
            return 1;
        } else if (this.Pi) {
            return 1;
        } else {
            return -1;
        }
    }

    public final void a(RecyclerView recyclerView, int i) {
        AnonymousClass1 anonymousClass1 = new z(recyclerView.getContext()) {
            public final PointF bf(int i) {
                int a = StaggeredGridLayoutManager.this.bF(i);
                if (a == 0) {
                    return null;
                }
                if (StaggeredGridLayoutManager.this.OT == 0) {
                    return new PointF((float) a, 0.0f);
                }
                return new PointF(0.0f, (float) a);
            }
        };
        anonymousClass1.Sv = i;
        a(anonymousClass1);
    }

    public final void bg(int i) {
        if (!(this.UX == null || this.UX.PA == i)) {
            SavedState savedState = this.UX;
            savedState.Vm = null;
            savedState.Vl = 0;
            savedState.PA = -1;
            savedState.Vk = -1;
        }
        this.Pl = i;
        this.Pm = Integer.MIN_VALUE;
        requestLayout();
    }

    private int c(int i, m mVar, q qVar) {
        int gQ;
        int i2;
        if (i > 0) {
            gQ = gQ();
            i2 = 1;
        } else {
            i2 = -1;
            gQ = gR();
        }
        this.UR.OG = true;
        a(gQ, qVar);
        bB(i2);
        this.UR.OI = this.UR.OJ + gQ;
        int abs = Math.abs(i);
        this.UR.OH = abs;
        i2 = a(mVar, this.UR, qVar);
        if (abs >= i2) {
            if (i < 0) {
                i = -i2;
            } else {
                i = i2;
            }
        }
        this.UO.bj(-i);
        this.UV = this.Pi;
        return i;
    }

    private int gQ() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : bd(getChildAt(childCount - 1));
    }

    private int gR() {
        if (getChildCount() == 0) {
            return 0;
        }
        return bd(getChildAt(0));
    }

    public final RecyclerView$LayoutParams eV() {
        if (this.OT == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final RecyclerView$LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final RecyclerView$LayoutParams e(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams instanceof LayoutParams;
    }

    public final View a(View view, int i, m mVar, q qVar) {
        int i2 = 0;
        if (getChildCount() == 0) {
            return null;
        }
        View be = be(view);
        if (be == null) {
            return null;
        }
        int i3;
        fb();
        switch (i) {
            case 1:
                i3 = -1;
                break;
            case 2:
                i3 = 1;
                break;
            case 17:
                if (this.OT != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 33:
                if (this.OT != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 66:
                if (this.OT != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            case 130:
                if (this.OT != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            default:
                i3 = Integer.MIN_VALUE;
                break;
        }
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        int gQ;
        View an;
        LayoutParams layoutParams = (LayoutParams) be.getLayoutParams();
        boolean z = layoutParams.Vf;
        b bVar = layoutParams.Ve;
        if (i3 == 1) {
            gQ = gQ();
        } else {
            gQ = gR();
        }
        a(gQ, qVar);
        bB(i3);
        this.UR.OI = this.UR.OJ + gQ;
        this.UR.OH = (int) (0.33333334f * ((float) this.UO.fu()));
        this.UR.OO = true;
        this.UR.OG = false;
        a(mVar, this.UR, qVar);
        this.UV = this.Pi;
        if (!z) {
            an = bVar.an(gQ, i3);
            if (!(an == null || an == be)) {
                return an;
            }
        }
        if (bE(i3)) {
            for (int i4 = this.Ov - 1; i4 >= 0; i4--) {
                View an2 = this.UN[i4].an(gQ, i3);
                if (an2 != null && an2 != be) {
                    return an2;
                }
            }
        } else {
            while (i2 < this.Ov) {
                an = this.UN[i2].an(gQ, i3);
                if (an != null && an != be) {
                    return an;
                }
                i2++;
            }
        }
        return null;
    }
}
