package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public abstract class RecyclerView$h {
    s QQ;
    public RecyclerView Sa;
    p Sb;
    public boolean Sc = false;
    boolean Sd = false;
    boolean Se = true;
    int Sf;
    int Sg;
    boolean eC = false;
    int mHeight;
    int mWidth;

    public abstract LayoutParams eV();

    final void y(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.Sa = null;
            this.QQ = null;
            this.mWidth = 0;
            this.mHeight = 0;
        } else {
            this.Sa = recyclerView;
            this.QQ = recyclerView.QQ;
            this.mWidth = recyclerView.getWidth();
            this.mHeight = recyclerView.getHeight();
        }
        this.Sf = 1073741824;
        this.Sg = 1073741824;
    }

    final void ag(int i, int i2) {
        this.mWidth = MeasureSpec.getSize(i);
        this.Sf = MeasureSpec.getMode(i);
        if (this.Sf == 0 && !RecyclerView.QK) {
            this.mWidth = 0;
        }
        this.mHeight = MeasureSpec.getSize(i2);
        this.Sg = MeasureSpec.getMode(i2);
        if (this.Sg == 0 && !RecyclerView.QK) {
            this.mHeight = 0;
        }
    }

    final void ah(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            this.Sa.V(i, i2);
            return;
        }
        int i3 = 0;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MAX_VALUE;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int bh = bh(childAt) - layoutParams.leftMargin;
            int bj = layoutParams.rightMargin + bj(childAt);
            int bi = bi(childAt) - layoutParams.topMargin;
            int bk = layoutParams.bottomMargin + bk(childAt);
            if (bh >= i7) {
                bh = i7;
            }
            if (bj <= i5) {
                bj = i5;
            }
            if (bi >= i6) {
                bi = i6;
            }
            if (bk <= i4) {
                bk = i4;
            }
            i3++;
            i4 = bk;
            i5 = bj;
            i6 = bi;
            i7 = bh;
        }
        RecyclerView.v(this.Sa).set(i7, i6, i5, i4);
        a(RecyclerView.v(this.Sa), i, i2);
    }

    public void a(Rect rect, int i, int i2) {
        setMeasuredDimension(m(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), z.S(this.Sa)), m(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), z.T(this.Sa)));
    }

    public final void requestLayout() {
        if (this.Sa != null) {
            this.Sa.requestLayout();
        }
    }

    public static int m(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(size, Math.max(i2, i3));
            case 1073741824:
                return size;
            default:
                return Math.max(i2, i3);
        }
    }

    public void O(String str) {
        if (this.Sa != null) {
            this.Sa.O(str);
        }
    }

    public boolean eY() {
        return false;
    }

    final void b(RecyclerView recyclerView, RecyclerView$m recyclerView$m) {
        this.eC = false;
        a(recyclerView, recyclerView$m);
    }

    public final boolean removeCallbacks(Runnable runnable) {
        if (this.Sa != null) {
            return this.Sa.removeCallbacks(runnable);
        }
        return false;
    }

    public void a(RecyclerView recyclerView, RecyclerView$m recyclerView$m) {
    }

    public void c(RecyclerView$m recyclerView$m, q qVar) {
    }

    public boolean a(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public LayoutParams e(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int a(int i, RecyclerView$m recyclerView$m, q qVar) {
        return 0;
    }

    public int b(int i, RecyclerView$m recyclerView$m, q qVar) {
        return 0;
    }

    public boolean eZ() {
        return false;
    }

    public boolean fa() {
        return false;
    }

    public void bg(int i) {
    }

    public void a(RecyclerView recyclerView, int i) {
    }

    public final void a(p pVar) {
        if (!(this.Sb == null || pVar == this.Sb || !this.Sb.Sx)) {
            this.Sb.stop();
        }
        this.Sb = pVar;
        p pVar2 = this.Sb;
        pVar2.Sa = this.Sa;
        pVar2.QG = this;
        if (pVar2.Sv == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        pVar2.Sa.RB.Sv = pVar2.Sv;
        pVar2.Sx = true;
        pVar2.Sw = true;
        pVar2.Sy = pVar2.Sa.QV.be(pVar2.Sv);
        RecyclerView.x(pVar2.Sa).gi();
    }

    public final boolean gb() {
        return this.Sb != null && this.Sb.Sx;
    }

    final void b(View view, int i, boolean z) {
        t aY = RecyclerView.aY(view);
        if (z || aY.isRemoved()) {
            this.Sa.QR.D(aY);
        } else {
            this.Sa.QR.E(aY);
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (aY.gp() || aY.gn()) {
            if (aY.gn()) {
                aY.go();
            } else {
                aY.gq();
            }
            this.QQ.a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.Sa) {
            int indexOfChild = this.QQ.indexOfChild(view);
            if (i == -1) {
                i = this.QQ.getChildCount();
            }
            if (indexOfChild == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.Sa.indexOfChild(view));
            } else if (indexOfChild != i) {
                RecyclerView$h recyclerView$h = this.Sa.QV;
                View childAt = recyclerView$h.getChildAt(indexOfChild);
                if (childAt == null) {
                    throw new IllegalArgumentException("Cannot move a child from non-existing index:" + indexOfChild);
                }
                recyclerView$h.bo(indexOfChild);
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                t aY2 = RecyclerView.aY(childAt);
                if (aY2.isRemoved()) {
                    recyclerView$h.Sa.QR.D(aY2);
                } else {
                    recyclerView$h.Sa.QR.E(aY2);
                }
                recyclerView$h.QQ.a(childAt, i, layoutParams2, aY2.isRemoved());
            }
        } else {
            this.QQ.a(view, i, false);
            layoutParams.Si = true;
            if (this.Sb != null && this.Sb.Sx) {
                p pVar = this.Sb;
                if (RecyclerView.ba(view) == pVar.Sv) {
                    pVar.Sy = view;
                }
            }
        }
        if (layoutParams.Sj) {
            aY.SU.invalidate();
            layoutParams.Sj = false;
        }
    }

    private void removeViewAt(int i) {
        if (getChildAt(i) != null) {
            s sVar = this.QQ;
            int aV = sVar.aV(i);
            View childAt = sVar.NA.getChildAt(aV);
            if (childAt != null) {
                if (sVar.NB.aX(aV)) {
                    sVar.aN(childAt);
                }
                sVar.NA.removeViewAt(aV);
            }
        }
    }

    public static int bd(View view) {
        return ((LayoutParams) view.getLayoutParams()).Sh.gl();
    }

    public final View be(View view) {
        if (this.Sa == null) {
            return null;
        }
        RecyclerView recyclerView = this.Sa;
        ViewParent parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != recyclerView && (parent instanceof View)) {
            view2 = (View) parent;
            parent = view2.getParent();
        }
        if (parent != recyclerView) {
            view2 = null;
        }
        if (view2 == null) {
            return null;
        }
        if (this.QQ.aO(view2)) {
            return null;
        }
        return view2;
    }

    public View be(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            t aY = RecyclerView.aY(childAt);
            if (aY != null && aY.gl() == i && !aY.gk() && (this.Sa.RB.SL || !aY.isRemoved())) {
                return childAt;
            }
        }
        return null;
    }

    private void bo(int i) {
        getChildAt(i);
        this.QQ.detachViewFromParent(i);
    }

    public final void a(View view, RecyclerView$m recyclerView$m) {
        s sVar = this.QQ;
        int indexOfChild = sVar.NA.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (sVar.NB.aX(indexOfChild)) {
                sVar.aN(view);
            }
            sVar.NA.removeViewAt(indexOfChild);
        }
        recyclerView$m.bm(view);
    }

    public final void a(int i, RecyclerView$m recyclerView$m) {
        View childAt = getChildAt(i);
        removeViewAt(i);
        recyclerView$m.bm(childAt);
    }

    public final int getChildCount() {
        return this.QQ != null ? this.QQ.getChildCount() : 0;
    }

    public final View getChildAt(int i) {
        return this.QQ != null ? this.QQ.getChildAt(i) : null;
    }

    public final int getPaddingLeft() {
        return this.Sa != null ? this.Sa.getPaddingLeft() : 0;
    }

    public final int getPaddingTop() {
        return this.Sa != null ? this.Sa.getPaddingTop() : 0;
    }

    public final int getPaddingRight() {
        return this.Sa != null ? this.Sa.getPaddingRight() : 0;
    }

    public final int getPaddingBottom() {
        return this.Sa != null ? this.Sa.getPaddingBottom() : 0;
    }

    public void bp(int i) {
        if (this.Sa != null) {
            RecyclerView recyclerView = this.Sa;
            int childCount = recyclerView.QQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                recyclerView.QQ.getChildAt(i2).offsetLeftAndRight(i);
            }
        }
    }

    public void bq(int i) {
        if (this.Sa != null) {
            RecyclerView recyclerView = this.Sa;
            int childCount = recyclerView.QQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                recyclerView.QQ.getChildAt(i2).offsetTopAndBottom(i);
            }
        }
    }

    public final void b(RecyclerView$m recyclerView$m) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            t aY = RecyclerView.aY(childAt);
            if (!aY.gk()) {
                if (!aY.gs() || aY.isRemoved() || RecyclerView.h(this.Sa).RS) {
                    bo(childCount);
                    recyclerView$m.bo(childAt);
                    this.Sa.QR.E(aY);
                } else {
                    removeViewAt(childCount);
                    recyclerView$m.n(aY);
                }
            }
        }
    }

    final void c(RecyclerView$m recyclerView$m) {
        int size = recyclerView$m.Sn.size();
        for (int i = size - 1; i >= 0; i--) {
            View view = ((t) recyclerView$m.Sn.get(i)).SU;
            t aY = RecyclerView.aY(view);
            if (!aY.gk()) {
                aY.T(false);
                if (aY.gu()) {
                    this.Sa.removeDetachedView(view, false);
                }
                if (this.Sa.Rr != null) {
                    this.Sa.Rr.d(aY);
                }
                aY.T(true);
                recyclerView$m.bn(view);
            }
        }
        recyclerView$m.Sn.clear();
        if (recyclerView$m.So != null) {
            recyclerView$m.So.clear();
        }
        if (size > 0) {
            this.Sa.invalidate();
        }
    }

    final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && this.Se && n(view.getWidth(), i, layoutParams.width) && n(view.getHeight(), i2, layoutParams.height)) ? false : true;
    }

    static boolean n(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size >= i) {
                    return true;
                }
                return false;
            case 0:
                return true;
            case 1073741824:
                if (size == i) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static int d(int i, int i2, int i3, int i4, boolean z) {
        int max = Math.max(0, i - i3);
        if (z) {
            if (i4 >= 0) {
                i2 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                switch (i2) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        break;
                    default:
                        i2 = 0;
                        max = 0;
                        break;
                }
            } else {
                if (i4 == -2) {
                    max = 0;
                    i2 = 0;
                }
                i2 = 0;
                max = 0;
            }
        } else if (i4 >= 0) {
            i2 = 1073741824;
            max = i4;
        } else if (i4 != -1) {
            if (i4 == -2) {
                if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                    i2 = Integer.MIN_VALUE;
                }
                i2 = 0;
            }
            i2 = 0;
            max = 0;
        }
        return MeasureSpec.makeMeasureSpec(max, i2);
    }

    public static int bf(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).OB;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public static int bg(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).OB;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public static void g(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).OB;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public static int bh(View view) {
        return view.getLeft() - ((LayoutParams) view.getLayoutParams()).OB.left;
    }

    public static int bi(View view) {
        return view.getTop() - ((LayoutParams) view.getLayoutParams()).OB.top;
    }

    public static int bj(View view) {
        return ((LayoutParams) view.getLayoutParams()).OB.right + view.getRight();
    }

    public static int bk(View view) {
        return ((LayoutParams) view.getLayoutParams()).OB.bottom + view.getBottom();
    }

    public final void a(View view, Rect rect) {
        if (this.Sa == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.Sa.bb(view));
        }
    }

    public View a(View view, int i, RecyclerView$m recyclerView$m, q qVar) {
        return null;
    }

    public void eU() {
    }

    public void F(int i, int i2) {
    }

    public void G(int i, int i2) {
    }

    public void H(int i, int i2) {
    }

    public void I(int i, int i2) {
    }

    public int d(q qVar) {
        return 0;
    }

    public int b(q qVar) {
        return 0;
    }

    public int f(q qVar) {
        return 0;
    }

    public int e(q qVar) {
        return 0;
    }

    public int c(q qVar) {
        return 0;
    }

    public int g(q qVar) {
        return 0;
    }

    public final void ai(int i, int i2) {
        this.Sa.V(i, i2);
    }

    public final void setMeasuredDimension(int i, int i2) {
        RecyclerView.b(this.Sa, i, i2);
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    final void gd() {
        if (this.Sb != null) {
            this.Sb.stop();
        }
    }

    public void br(int i) {
    }

    public final void d(RecyclerView$m recyclerView$m) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (!RecyclerView.aY(getChildAt(childCount)).gk()) {
                a(childCount, recyclerView$m);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        RecyclerView$m recyclerView$m = this.Sa.QN;
        q qVar = this.Sa.RB;
        f a = a.a(accessibilityEvent);
        if (this.Sa != null) {
            if (!(z.h(this.Sa, 1) || z.h(this.Sa, -1) || z.g(this.Sa, -1) || z.g(this.Sa, 1))) {
                z = false;
            }
            a.setScrollable(z);
            if (RecyclerView.h(this.Sa) != null) {
                a.setItemCount(RecyclerView.h(this.Sa).getItemCount());
            }
        }
    }

    final void b(View view, b bVar) {
        t aY = RecyclerView.aY(view);
        if (aY != null && !aY.isRemoved() && !this.QQ.aO(aY.SU)) {
            a(this.Sa.QN, this.Sa.RB, view, bVar);
        }
    }

    public void a(RecyclerView$m recyclerView$m, q qVar, View view, b bVar) {
        int bd;
        int bd2 = fa() ? bd(view) : 0;
        if (eZ()) {
            bd = bd(view);
        } else {
            bd = 0;
        }
        bVar.l(l.c(bd2, 1, bd, 1, false));
    }

    public int a(RecyclerView$m recyclerView$m, q qVar) {
        if (this.Sa == null || RecyclerView.h(this.Sa) == null || !fa()) {
            return 1;
        }
        return RecyclerView.h(this.Sa).getItemCount();
    }

    public int b(RecyclerView$m recyclerView$m, q qVar) {
        if (this.Sa == null || RecyclerView.h(this.Sa) == null || !eZ()) {
            return 1;
        }
        return RecyclerView.h(this.Sa).getItemCount();
    }

    final void z(RecyclerView recyclerView) {
        ag(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    boolean ff() {
        return false;
    }
}
