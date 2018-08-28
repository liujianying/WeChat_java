package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.ui.widget.picker.e;

public class AppBrandOptionsPicker extends NumberPicker implements e<String> {
    private int HB;
    private String[] gNb;
    private int gNc;
    private int gg;

    @Keep
    public AppBrandOptionsPicker(Context context) {
        super(new ContextThemeWrapper(context, k.Widget_AppBrand_Picker));
        e.a(this, getResources().getDrawable(f.appbrand_picker_divider));
        e.c(this);
        e.e(this);
        f.a(this);
        this.HB = a.fromDPToPix(context, 100);
        this.gNc = a.fromDPToPix(context, 20);
    }

    public void setOptionsArray(String[] strArr) {
        if (strArr != null) {
            this.gNb = strArr;
            setDisplayedValues(null);
            setMinValue(0);
            setMaxValue(Math.max(strArr.length - 1, 0));
            if (strArr.length <= 0) {
                strArr = null;
            }
            super.setDisplayedValues(strArr);
        }
    }

    public final void setExtraPadding(int i) {
        this.gNc = Math.max(i, 0);
    }

    public final void setMinWidth(int i) {
        this.HB = i;
    }

    public final void setMaxWidth(int i) {
        this.gg = i;
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        super.setDisplayedValues(strArr);
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE || MeasureSpec.getMode(i) == 1073741824) {
            this.gg = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.HB || (this.gg > 0 && this.HB > this.gg)) {
            int measuredWidth = getMeasuredWidth() + (this.gNc * 2);
            if (this.gg > 0 && this.gg <= measuredWidth) {
                measuredWidth = this.gg;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            return;
        }
        setMeasuredDimension(this.HB, getMeasuredHeight());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.d(this);
    }

    /* renamed from: aqr */
    public final String aqq() {
        return (this.gNb == null || this.gNb.length <= 0) ? "" : this.gNb[getValue()];
    }

    public View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aqo() {
    }

    public final void b(d dVar) {
    }

    public final void aqp() {
    }
}
