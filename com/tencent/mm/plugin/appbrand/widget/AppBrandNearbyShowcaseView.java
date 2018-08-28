package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;

public final class AppBrandNearbyShowcaseView extends FrameLayout {
    private int bi = a.fromDPToPix(getContext(), 25);
    private int gEf = a.fromDPToPix(getContext(), 19);

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setIconSize(int i) {
        if (i > 0 && i != this.bi) {
            this.bi = i;
            aoS();
        }
    }

    public final void setIconGap(int i) {
        if (i >= 0 && this.gEf != i) {
            this.gEf = i;
            aoS();
        }
    }

    private void aoS() {
        if (getChildCount() > 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = childAt.getLayoutParams();
                LayoutParams layoutParams2 = childAt.getLayoutParams();
                int i = this.bi;
                layoutParams2.height = i;
                layoutParams.width = i;
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams3.gravity |= 5;
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin = this.gEf * childCount;
            }
            requestLayout();
            invalidate();
        }
    }

    public final void setIconLayerCount(int i) {
        if (i >= 0 && i != getChildCount()) {
            if (i > getChildCount()) {
                int childCount = i - getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View imageView = new ImageView(getContext());
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bi, this.bi);
                    layoutParams.gravity = 16;
                    addViewInLayout(imageView, 0, layoutParams, true);
                }
            } else if (i < getChildCount()) {
                removeViewsInLayout(0, getChildCount() - i);
            }
            aoS();
        }
    }

    public final ImageView lT(int i) {
        return (ImageView) getChildAt((getChildCount() - 1) - i);
    }

    public final void aoT() {
        if (getChildCount() > 1) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                childAt.setTranslationX((float) ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin);
            }
        }
    }

    public final void aoU() {
        int i = 1;
        if (getChildCount() > 1) {
            int i2 = m.CTRL_INDEX;
            while (i < getChildCount()) {
                getChildAt(i).animate().setDuration((long) i2).translationX(0.0f).start();
                i2 += 50;
                i++;
            }
        }
    }

    public final int getExpandDuration() {
        if (getChildCount() <= 1) {
            return 0;
        }
        return ((getChildCount() - 2) * 50) + m.CTRL_INDEX;
    }
}
