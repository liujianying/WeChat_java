package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import b.c.b.e;

public final class RadarSpecialGridView extends RadarSpecialSmoothScrollView {
    private a mlo;
    public RadarSpecialTableLayout mlp;
    private int mlq;
    private int mlr;

    public final a getOnItemClickListener() {
        return this.mlo;
    }

    public final void setOnItemClickListener(a aVar) {
        this.mlo = aVar;
    }

    public final RadarSpecialTableLayout getMTable() {
        RadarSpecialTableLayout radarSpecialTableLayout = this.mlp;
        if (radarSpecialTableLayout == null) {
            e.adK("mTable");
        }
        return radarSpecialTableLayout;
    }

    public final void setMTable(RadarSpecialTableLayout radarSpecialTableLayout) {
        e.i(radarSpecialTableLayout, "<set-?>");
        this.mlp = radarSpecialTableLayout;
    }

    public RadarSpecialGridView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
        Context context2 = getContext();
        e.h(context2, "context");
        this.mlp = new RadarSpecialTableLayout(context2);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        RadarSpecialTableLayout radarSpecialTableLayout = this.mlp;
        if (radarSpecialTableLayout == null) {
            e.adK("mTable");
        }
        radarSpecialTableLayout.setLayoutParams(layoutParams);
        RadarSpecialTableLayout radarSpecialTableLayout2 = this.mlp;
        if (radarSpecialTableLayout2 == null) {
            e.adK("mTable");
        }
        radarSpecialTableLayout2.setStretchAllColumns(true);
        radarSpecialTableLayout2 = this.mlp;
        if (radarSpecialTableLayout2 == null) {
            e.adK("mTable");
        }
        radarSpecialTableLayout2.setShrinkAllColumns(true);
        radarSpecialTableLayout2 = this.mlp;
        if (radarSpecialTableLayout2 == null) {
            e.adK("mTable");
        }
        radarSpecialTableLayout2.setGravity(80);
        radarSpecialTableLayout2 = this.mlp;
        if (radarSpecialTableLayout2 == null) {
            e.adK("mTable");
        }
        addView((View) radarSpecialTableLayout2);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int scrollX;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            scrollX = getScrollX();
            e.h(childAt, "child");
            scrollX = (scrollX + childAt.getWidth()) - this.mlr;
            this.mlr = childAt.getWidth();
            if (scrollX <= 0) {
                scrollX = 0;
            }
        } else {
            scrollX = getScrollX();
        }
        if (getChildCount() > 0) {
            View childAt2 = getChildAt(0);
            int scrollY = getScrollY();
            e.h(childAt2, "child");
            scrollY = (scrollY + childAt2.getHeight()) - this.mlq;
            this.mlq = childAt2.getHeight();
            if (scrollY > 0) {
                i5 = scrollY;
            }
        } else {
            i5 = getScrollY();
        }
        scrollTo(scrollX, i5);
    }
}
