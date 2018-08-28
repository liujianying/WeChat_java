package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.s.b;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class RecyclerView$5 implements b {
    final /* synthetic */ RecyclerView RQ;

    RecyclerView$5(RecyclerView recyclerView) {
        this.RQ = recyclerView;
    }

    public final int getChildCount() {
        return this.RQ.getChildCount();
    }

    public final void addView(View view, int i) {
        this.RQ.addView(view, i);
        RecyclerView.a(this.RQ, view);
    }

    public final int indexOfChild(View view) {
        return this.RQ.indexOfChild(view);
    }

    public final void removeViewAt(int i) {
        View childAt = this.RQ.getChildAt(i);
        if (childAt != null) {
            RecyclerView.b(this.RQ, childAt);
        }
        this.RQ.removeViewAt(i);
    }

    public final View getChildAt(int i) {
        return this.RQ.getChildAt(i);
    }

    public final void removeAllViews() {
        int childCount = this.RQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView.b(this.RQ, getChildAt(i));
        }
        this.RQ.removeAllViews();
    }

    public final t aP(View view) {
        return RecyclerView.aY(view);
    }

    public final void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        t aY = RecyclerView.aY(view);
        if (aY != null) {
            if (aY.gu() || aY.gk()) {
                aY.gr();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + aY);
            }
        }
        RecyclerView.a(this.RQ, view, i, layoutParams);
    }

    public final void detachViewFromParent(int i) {
        View childAt = getChildAt(i);
        if (childAt != null) {
            t aY = RecyclerView.aY(childAt);
            if (aY != null) {
                if (!aY.gu() || aY.gk()) {
                    aY.addFlags(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + aY);
                }
            }
        }
        RecyclerView.b(this.RQ, i);
    }

    public final void aQ(View view) {
        t aY = RecyclerView.aY(view);
        if (aY != null) {
            t.q(aY);
        }
    }

    public final void aR(View view) {
        t aY = RecyclerView.aY(view);
        if (aY != null) {
            t.r(aY);
        }
    }
}
