package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class AdLandingViewPager$LayoutParams extends LayoutParams {
    public int gravity;
    int position;
    float wV = 0.0f;
    public boolean wX;
    boolean wY;
    int wZ;

    public AdLandingViewPager$LayoutParams() {
        super(-1, -1);
    }

    public AdLandingViewPager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AdLandingViewPager.cl());
        this.gravity = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
