package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.z;
import android.support.v7.widget.LinearLayoutManager.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public final class GridLayoutManager extends LinearLayoutManager {
    public b OA = new a();
    final Rect OB = new Rect();
    boolean Ou = false;
    public int Ov = -1;
    int[] Ow;
    View[] Ox;
    final SparseIntArray Oy = new SparseIntArray();
    final SparseIntArray Oz = new SparseIntArray();

    public GridLayoutManager(int i) {
        bb(i);
    }

    public GridLayoutManager() {
        super(1);
        bb(4);
    }

    public final int a(m mVar, RecyclerView$q recyclerView$q) {
        if (this.OT == 0) {
            return this.Ov;
        }
        if (recyclerView$q.getItemCount() <= 0) {
            return 0;
        }
        return a(mVar, recyclerView$q, recyclerView$q.getItemCount() - 1) + 1;
    }

    public final int b(m mVar, RecyclerView$q recyclerView$q) {
        if (this.OT == 1) {
            return this.Ov;
        }
        if (recyclerView$q.getItemCount() <= 0) {
            return 0;
        }
        return a(mVar, recyclerView$q, recyclerView$q.getItemCount() - 1) + 1;
    }

    public final void a(m mVar, RecyclerView$q recyclerView$q, View view, b bVar) {
        boolean z = false;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(mVar, recyclerView$q, layoutParams2.Sh.gl());
            int i;
            int i2;
            if (this.OT == 0) {
                i = layoutParams2.OC;
                i2 = layoutParams2.OD;
                boolean z2 = this.Ov > 1 && layoutParams2.OD == this.Ov;
                bVar.l(l.c(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.OC;
            i2 = layoutParams2.OD;
            if (this.Ov > 1 && layoutParams2.OD == this.Ov) {
                z = true;
            }
            bVar.l(l.c(a, 1, i, i2, z));
            return;
        }
        super.b(view, bVar);
    }

    public final void c(m mVar, RecyclerView$q recyclerView$q) {
        if (recyclerView$q.SL) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int gl = layoutParams.Sh.gl();
                this.Oy.put(gl, layoutParams.OD);
                this.Oz.put(gl, layoutParams.OC);
            }
        }
        super.c(mVar, recyclerView$q);
        this.Oy.clear();
        this.Oz.clear();
        if (!recyclerView$q.SL) {
            this.Ou = false;
        }
    }

    public final void F(int i, int i2) {
        this.OA.OE.clear();
    }

    public final void eU() {
        this.OA.OE.clear();
    }

    public final void G(int i, int i2) {
        this.OA.OE.clear();
    }

    public final void H(int i, int i2) {
        this.OA.OE.clear();
    }

    public final void I(int i, int i2) {
        this.OA.OE.clear();
    }

    public final RecyclerView.LayoutParams eV() {
        if (this.OT == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final RecyclerView.LayoutParams e(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private void eW() {
        int paddingRight;
        if (this.OT == 1) {
            paddingRight = (this.mWidth - getPaddingRight()) - getPaddingLeft();
        } else {
            paddingRight = (this.mHeight - getPaddingBottom()) - getPaddingTop();
        }
        ba(paddingRight);
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.Ow == null) {
            super.a(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.OT == 1) {
            paddingTop = m(i2, paddingTop + rect.height(), z.T(this.Sa));
            paddingRight = m(i, paddingRight + this.Ow[this.Ow.length - 1], z.S(this.Sa));
        } else {
            paddingRight = m(i, paddingRight + rect.width(), z.S(this.Sa));
            paddingTop = m(i2, paddingTop + this.Ow[this.Ow.length - 1], z.T(this.Sa));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    private void ba(int i) {
        int[] iArr = this.Ow;
        int i2 = this.Ov;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i2 + 1)];
        }
        iArr[0] = 0;
        int i3 = i / i2;
        int i4 = i % i2;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (i5 <= i2) {
            int i8;
            i6 += i4;
            if (i6 <= 0 || i2 - i6 >= i4) {
                i8 = i3;
            } else {
                i8 = i3 + 1;
                i6 -= i2;
            }
            int i9 = i7 + i8;
            iArr[i5] = i9;
            i5++;
            i7 = i9;
        }
        this.Ow = iArr;
    }

    final void a(m mVar, RecyclerView$q recyclerView$q, a aVar, int i) {
        Object obj = 1;
        super.a(mVar, recyclerView$q, aVar, i);
        eW();
        if (recyclerView$q.getItemCount() > 0 && !recyclerView$q.SL) {
            if (i != 1) {
                obj = null;
            }
            int b = b(mVar, recyclerView$q, aVar.mPosition);
            if (obj != null) {
                while (b > 0 && aVar.mPosition > 0) {
                    aVar.mPosition--;
                    b = b(mVar, recyclerView$q, aVar.mPosition);
                }
            } else {
                int itemCount = recyclerView$q.getItemCount() - 1;
                int i2 = aVar.mPosition;
                while (i2 < itemCount) {
                    int b2 = b(mVar, recyclerView$q, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                aVar.mPosition = i2;
            }
        }
        eX();
    }

    private void eX() {
        if (this.Ox == null || this.Ox.length != this.Ov) {
            this.Ox = new View[this.Ov];
        }
    }

    public final int a(int i, m mVar, RecyclerView$q recyclerView$q) {
        eW();
        eX();
        return super.a(i, mVar, recyclerView$q);
    }

    public final int b(int i, m mVar, RecyclerView$q recyclerView$q) {
        eW();
        eX();
        return super.b(i, mVar, recyclerView$q);
    }

    final View a(m mVar, RecyclerView$q recyclerView$q, int i, int i2, int i3) {
        int i4;
        fd();
        int fs = this.Pf.fs();
        int ft = this.Pf.ft();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view = null;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bd = bd(childAt);
            if (bd >= 0 && bd < i3 && b(mVar, recyclerView$q, bd) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).Sh.isRemoved()) {
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

    private int a(m mVar, RecyclerView$q recyclerView$q, int i) {
        if (!recyclerView$q.SL) {
            return this.OA.L(i, this.Ov);
        }
        int bs = mVar.bs(i);
        if (bs == -1) {
            return 0;
        }
        return this.OA.L(bs, this.Ov);
    }

    private int b(m mVar, RecyclerView$q recyclerView$q, int i) {
        if (!recyclerView$q.SL) {
            return this.OA.K(i, this.Ov);
        }
        int i2 = this.Oz.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = mVar.bs(i);
        if (i2 == -1) {
            return 0;
        }
        return this.OA.K(i2, this.Ov);
    }

    private int c(m mVar, RecyclerView$q recyclerView$q, int i) {
        if (!recyclerView$q.SL) {
            return this.OA.bc(i);
        }
        int i2 = this.Oy.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = mVar.bs(i);
        if (i2 == -1) {
            return 1;
        }
        return this.OA.bc(i2);
    }

    final void a(m mVar, RecyclerView$q recyclerView$q, c cVar, b bVar) {
        boolean z;
        int i;
        int c;
        View a;
        int fv = this.Pf.fv();
        Object obj = fv != 1073741824 ? 1 : null;
        int i2 = getChildCount() > 0 ? this.Ow[this.Ov] : 0;
        if (obj != null) {
            eW();
        }
        if (cVar.OJ == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = 0;
        int i4 = this.Ov;
        if (!z) {
            i4 = b(mVar, recyclerView$q, cVar.OI) + c(mVar, recyclerView$q, cVar.OI);
        }
        while (true) {
            i = i3;
            if (i >= this.Ov || !cVar.k(recyclerView$q) || i4 <= 0) {
                break;
            }
            i3 = cVar.OI;
            c = c(mVar, recyclerView$q, i3);
            if (c <= this.Ov) {
                i4 -= c;
                if (i4 < 0) {
                    break;
                }
                a = cVar.a(mVar);
                if (a == null) {
                    break;
                }
                this.Ox[i] = a;
                i3 = i + 1;
            } else {
                throw new IllegalArgumentException("Item at position " + i3 + " requires " + c + " spans but GridLayoutManager has only " + this.Ov + " spans.");
            }
        }
        if (i == 0) {
            bVar.mFinished = true;
            return;
        }
        int d;
        int i5;
        int i6;
        LayoutParams layoutParams;
        float f = 0.0f;
        a(mVar, recyclerView$q, i, z);
        i4 = 0;
        while (true) {
            int i7 = i4;
            if (i7 >= i) {
                break;
            }
            a = this.Ox[i7];
            if (cVar.Pz == null) {
                if (z) {
                    super.b(a, -1, false);
                } else {
                    super.b(a, 0, false);
                }
            } else if (z) {
                super.b(a, -1, true);
            } else {
                super.b(a, 0, true);
            }
            LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
            c = d(this.Ow[LayoutParams.a(layoutParams2) + LayoutParams.b(layoutParams2)] - this.Ow[LayoutParams.a(layoutParams2)], fv, 0, this.OT == 0 ? layoutParams2.height : layoutParams2.width, false);
            d = d(this.Pf.fu(), this.Pf.getMode(), 0, this.OT == 1 ? layoutParams2.height : layoutParams2.width, true);
            if (this.OT == 1) {
                a(a, c, d, layoutParams2.height == -1, false);
            } else {
                a(a, d, c, layoutParams2.width == -1, false);
            }
            i4 = this.Pf.aW(a);
            if (i4 <= 0) {
                i4 = 0;
            }
            float aX = (((float) this.Pf.aX(a)) * 1.0f) / ((float) LayoutParams.b(layoutParams2));
            if (aX <= f) {
                aX = f;
            }
            i7++;
            f = aX;
        }
        if (obj != null) {
            ba(Math.max(Math.round(((float) this.Ov) * f), i2));
            i5 = 0;
            i4 = 0;
            while (true) {
                i6 = i4;
                if (i6 >= i) {
                    break;
                }
                a = this.Ox[i6];
                layoutParams = (LayoutParams) a.getLayoutParams();
                c = d(this.Ow[LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams)] - this.Ow[LayoutParams.a(layoutParams)], 1073741824, 0, this.OT == 0 ? layoutParams.height : layoutParams.width, false);
                d = d(this.Pf.fu(), this.Pf.getMode(), 0, this.OT == 1 ? layoutParams.height : layoutParams.width, true);
                if (this.OT == 1) {
                    a(a, c, d, false, true);
                } else {
                    a(a, d, c, false, true);
                }
                i4 = this.Pf.aW(a);
                if (i4 <= 0) {
                    i4 = 0;
                }
                i6++;
            }
        } else {
            i5 = 0;
        }
        d = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        i4 = 0;
        while (true) {
            i6 = i4;
            if (i6 >= i) {
                break;
            }
            a = this.Ox[i6];
            if (this.Pf.aW(a) != i5) {
                layoutParams = (LayoutParams) a.getLayoutParams();
                c = d(this.Ow[LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams)] - this.Ow[LayoutParams.a(layoutParams)], 1073741824, 0, this.OT == 0 ? layoutParams.height : layoutParams.width, false);
                if (this.OT == 1) {
                    a(a, c, d, true, true);
                } else {
                    a(a, d, c, true, true);
                }
            }
            i4 = i6 + 1;
        }
        bVar.Pt = i5;
        d = 0;
        c = 0;
        i3 = 0;
        i4 = 0;
        if (this.OT == 1) {
            if (cVar.OK == -1) {
                i4 = cVar.tH;
                i3 = i4 - i5;
            } else {
                i3 = cVar.tH;
                i4 = i3 + i5;
            }
        } else if (cVar.OK == -1) {
            c = cVar.tH;
            d = c - i5;
        } else {
            d = cVar.tH;
            c = d + i5;
        }
        while (true) {
            int i8 = i4;
            int i9 = i3;
            int i10 = c;
            int i11 = d;
            if (0 < i) {
                View view = this.Ox[0];
                layoutParams = (LayoutParams) view.getLayoutParams();
                if (this.OT != 1) {
                    c = this.Ow[LayoutParams.a(layoutParams)] + getPaddingTop();
                    i3 = this.Pf.aX(view) + c;
                    d = i10;
                } else if (fc()) {
                    d = getPaddingLeft() + this.Ow[LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams)];
                    i3 = i8;
                    c = i9;
                    i11 = d - this.Pf.aX(view);
                } else {
                    i10 = getPaddingLeft() + this.Ow[LayoutParams.a(layoutParams)];
                    d = i10 + this.Pf.aX(view);
                    i3 = i8;
                    c = i9;
                    i11 = i10;
                }
                g(view, layoutParams.leftMargin + i11, layoutParams.topMargin + c, d - layoutParams.rightMargin, i3 - layoutParams.bottomMargin);
                if (layoutParams.Sh.isRemoved() || layoutParams.Sh.gz()) {
                    bVar.Pu = true;
                }
                bVar.Gu |= view.isFocusable();
                i4 = 0 + 1;
            } else {
                Arrays.fill(this.Ox, null);
                return;
            }
        }
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        a(view, this.OB);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.OT == 1) {
            i = l(i, layoutParams.leftMargin + this.OB.left, layoutParams.rightMargin + this.OB.right);
        }
        if (z || this.OT == 0) {
            i2 = l(i2, layoutParams.topMargin + this.OB.top, layoutParams.bottomMargin + this.OB.bottom);
        }
        boolean a = z2 ? (this.Se && h.n(view.getMeasuredWidth(), i, layoutParams.width) && h.n(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true : a(view, i, i2, layoutParams);
        if (a) {
            view.measure(i, i2);
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

    private void a(m mVar, RecyclerView$q recyclerView$q, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        if (this.OT == 1 && fc()) {
            i6 = this.Ov - 1;
            i4 = i3;
            i5 = -1;
        } else {
            i4 = i3;
            i5 = 1;
        }
        while (i4 != i) {
            View view = this.Ox[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams.a(layoutParams, c(mVar, recyclerView$q, bd(view)));
            if (i5 != -1 || LayoutParams.b(layoutParams) <= 1) {
                LayoutParams.b(layoutParams, i6);
            } else {
                LayoutParams.b(layoutParams, i6 - (LayoutParams.b(layoutParams) - 1));
            }
            i6 += LayoutParams.b(layoutParams) * i5;
            i4 += i2;
        }
    }

    public final void bb(int i) {
        if (i != this.Ov) {
            this.Ou = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.Ov = i;
            this.OA.OE.clear();
        }
    }

    public final View a(View view, int i, m mVar, RecyclerView$q recyclerView$q) {
        View be = be(view);
        if (be == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) be.getLayoutParams();
        int a = LayoutParams.a(layoutParams);
        int a2 = LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams);
        if (super.a(view, i, mVar, recyclerView$q) == null) {
            return null;
        }
        int childCount;
        int i2;
        int i3;
        Object obj;
        if (((bh(i) == 1) != this.Pi ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            childCount = 0;
            i2 = 1;
            i3 = getChildCount();
        }
        if (this.OT == 1 && fc()) {
            obj = 1;
        } else {
            obj = null;
        }
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        for (int i6 = childCount; i6 != i3; i6 += i2) {
            View childAt = getChildAt(i6);
            if (childAt == be) {
                break;
            }
            int min;
            if (childAt.isFocusable()) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a3 = LayoutParams.a(layoutParams);
                int a4 = LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams);
                if (a3 == a && a4 == a2) {
                    return childAt;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min2 = Math.min(a4, a2) - Math.max(a3, a);
                    if (min2 > i5) {
                        obj2 = 1;
                    } else if (min2 == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    childCount = LayoutParams.a(layoutParams);
                    min = Math.min(a4, a2) - Math.max(a3, a);
                    i5 = min;
                    i4 = childCount;
                    view2 = childAt;
                }
            }
            min = i5;
            childCount = i4;
            childAt = view2;
            i5 = min;
            i4 = childCount;
            view2 = childAt;
        }
        return view2;
    }

    public final boolean eY() {
        return this.Po == null && !this.Ou;
    }
}
