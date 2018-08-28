package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.g;

public final class a extends d {
    private static final int fDq = g.app_brand_picker_panel;

    public static a ci(View view) {
        return (a) view.getRootView().findViewById(fDq);
    }

    public a(Context context) {
        super(context);
        super.setId(fDq);
        setBackgroundResource(d.half_alpha_black);
        setOnClickListener(new 1(this));
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int i3;
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i3 = 0;
            } else {
                i3 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i3 > 0) {
                bZ(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setId(int i) {
    }

    public final void show() {
        super.show();
    }

    public final void hide() {
        super.hide();
    }
}
