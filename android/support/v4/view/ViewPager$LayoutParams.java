package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class ViewPager$LayoutParams extends LayoutParams {
    public int gravity;
    int position;
    float wV = 0.0f;
    public boolean wX;
    boolean wY;
    int wZ;

    public ViewPager$LayoutParams() {
        super(-1, -1);
    }

    public ViewPager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.cl());
        this.gravity = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
