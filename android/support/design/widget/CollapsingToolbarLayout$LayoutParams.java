package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.i;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout$LayoutParams extends LayoutParams {
    int em = 0;
    float en = 0.5f;

    public CollapsingToolbarLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.CollapsingAppBarLayout_LayoutParams);
        this.em = obtainStyledAttributes.getInt(i.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
        this.en = obtainStyledAttributes.getFloat(i.CollapsingAppBarLayout_LayoutParams_layout_collapseParallaxMultiplier, 0.5f);
        obtainStyledAttributes.recycle();
    }

    public CollapsingToolbarLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public CollapsingToolbarLayout$LayoutParams(LayoutParams layoutParams) {
        super(layoutParams);
    }
}
