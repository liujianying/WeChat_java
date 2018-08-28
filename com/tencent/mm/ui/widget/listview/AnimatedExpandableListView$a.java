package com.tencent.mm.ui.widget.listview;

import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.d;

public abstract class AnimatedExpandableListView$a extends BaseExpandableListAdapter {
    private SparseArray<d> uKA = new SparseArray();
    private AnimatedExpandableListView uKB;

    public abstract View d(int i, int i2, View view);

    public abstract int xv(int i);

    static /* synthetic */ void a(AnimatedExpandableListView$a animatedExpandableListView$a, int i, int i2) {
        d Gy = animatedExpandableListView$a.Gy(i);
        Gy.jEL = true;
        Gy.uKM = i2;
        Gy.uKL = false;
    }

    final d Gy(int i) {
        d dVar = (d) this.uKA.get(i);
        if (dVar != null) {
            return dVar;
        }
        dVar = new d((byte) 0);
        this.uKA.put(i, dVar);
        return dVar;
    }

    public final int getChildType(int i, int i2) {
        if (Gy(i).jEL) {
            return 0;
        }
        return 1;
    }

    public final int getChildTypeCount() {
        return 2;
    }

    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        d Gy = Gy(i);
        if (!Gy.jEL) {
            return d(i, i2, view);
        }
        View view2;
        if (view instanceof AnimatedExpandableListView$b) {
            view2 = view;
        } else {
            view2 = new AnimatedExpandableListView$b(viewGroup.getContext(), (byte) 0);
            view2.setLayoutParams(new LayoutParams(-1, 0));
        }
        if (i2 < Gy.uKM) {
            view2.getLayoutParams().height = 0;
            return view2;
        }
        int i3;
        ExpandableListView expandableListView = (ExpandableListView) viewGroup;
        AnimatedExpandableListView$b animatedExpandableListView$b = (AnimatedExpandableListView$b) view2;
        animatedExpandableListView$b.uKG.clear();
        AnimatedExpandableListView$b.a(animatedExpandableListView$b, expandableListView.getDivider(), viewGroup.getMeasuredWidth(), expandableListView.getDividerHeight());
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int i4 = 0;
        int height = viewGroup.getHeight();
        int xv = xv(i);
        for (i3 = Gy.uKM; i3 < xv; i3++) {
            View d = d(i, i3, null);
            d.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 += d.getMeasuredHeight();
            if (i4 >= height) {
                animatedExpandableListView$b.dT(d);
                i4 += ((xv - i3) - 1) * (i4 / (i3 + 1));
                break;
            }
            animatedExpandableListView$b.dT(d);
        }
        Object tag = animatedExpandableListView$b.getTag();
        if (tag == null) {
            i3 = 0;
        } else {
            i3 = ((Integer) tag).intValue();
        }
        Animation animatedExpandableListView$c;
        if (Gy.uKL && r2 != 1) {
            animatedExpandableListView$c = new AnimatedExpandableListView$c(animatedExpandableListView$b, 0, i4, Gy);
            animatedExpandableListView$c.setDuration((long) AnimatedExpandableListView.a(this.uKB));
            animatedExpandableListView$c.setAnimationListener(new 1(this, i, animatedExpandableListView$b));
            animatedExpandableListView$b.startAnimation(animatedExpandableListView$c);
            animatedExpandableListView$b.setTag(Integer.valueOf(1));
            return view2;
        } else if (Gy.uKL || r2 == 2) {
            return view2;
        } else {
            if (Gy.uKN == -1) {
                Gy.uKN = i4;
            }
            animatedExpandableListView$c = new AnimatedExpandableListView$c(animatedExpandableListView$b, Gy.uKN, 0, Gy);
            animatedExpandableListView$c.setDuration((long) AnimatedExpandableListView.a(this.uKB));
            animatedExpandableListView$c.setAnimationListener(new 2(this, i, expandableListView, Gy, animatedExpandableListView$b));
            animatedExpandableListView$b.startAnimation(animatedExpandableListView$c);
            animatedExpandableListView$b.setTag(Integer.valueOf(2));
            return view2;
        }
    }

    public final int getChildrenCount(int i) {
        d Gy = Gy(i);
        if (Gy.jEL) {
            return Gy.uKM + 1;
        }
        return xv(i);
    }
}
