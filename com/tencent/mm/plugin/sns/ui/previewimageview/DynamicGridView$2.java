package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.sns.i.f;

class DynamicGridView$2 implements OnScrollListener {
    private int hMs;
    private int omA = -1;
    private int omB = -1;
    private int omC;
    private int omD;
    final /* synthetic */ DynamicGridView omz;

    DynamicGridView$2(DynamicGridView dynamicGridView) {
        this.omz = dynamicGridView;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.omC = i;
        this.omD = i2;
        this.omA = this.omA == -1 ? this.omC : this.omA;
        this.omB = this.omB == -1 ? this.omD : this.omB;
        if (!(this.omC == this.omA || !DynamicGridView.k(this.omz) || DynamicGridView.h(this.omz) == -1)) {
            DynamicGridView.a(this.omz, DynamicGridView.h(this.omz));
            DynamicGridView.p(this.omz);
        }
        if (!(this.omC + this.omD == this.omA + this.omB || !DynamicGridView.k(this.omz) || DynamicGridView.h(this.omz) == -1)) {
            DynamicGridView.a(this.omz, DynamicGridView.h(this.omz));
            DynamicGridView.p(this.omz);
        }
        this.omA = this.omC;
        this.omB = this.omD;
        if (DynamicGridView.bEW() && DynamicGridView.i(this.omz)) {
            for (int i4 = 0; i4 < i2; i4++) {
                View childAt = this.omz.getChildAt(i4);
                if (childAt != null) {
                    if (DynamicGridView.h(this.omz) != -1 && Boolean.TRUE != childAt.getTag(f.dgv_wobble_tag)) {
                        if (i4 % 2 == 0) {
                            DynamicGridView.c(this.omz, childAt);
                        } else {
                            DynamicGridView.d(this.omz, childAt);
                        }
                        childAt.setTag(f.dgv_wobble_tag, Boolean.valueOf(true));
                    } else if (DynamicGridView.h(this.omz) == -1 && childAt.getRotation() != 0.0f) {
                        childAt.setRotation(0.0f);
                        childAt.setTag(f.dgv_wobble_tag, Boolean.valueOf(false));
                    }
                }
            }
        }
        if (DynamicGridView.j(this.omz) != null) {
            DynamicGridView.j(this.omz).onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        this.hMs = i;
        DynamicGridView.c(this.omz, i);
        if (this.omD > 0 && this.hMs == 0) {
            if (DynamicGridView.k(this.omz) && DynamicGridView.l(this.omz)) {
                DynamicGridView.m(this.omz);
            } else if (DynamicGridView.n(this.omz)) {
                DynamicGridView.o(this.omz);
            }
        }
        if (DynamicGridView.j(this.omz) != null) {
            DynamicGridView.j(this.omz).onScrollStateChanged(absListView, i);
        }
    }
}
