package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.bw.a$e;
import com.tencent.mm.ui.ap;

public class OptionPicker extends NumberPicker {
    private int HB;
    private String[] gNb;
    private int gNc;
    private int gg;
    private Context mContext;

    public OptionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public OptionPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.HB = ap.fromDPToPix(this.mContext, 120);
        this.gNc = ap.fromDPToPix(this.mContext, 20);
        e.a(this, getResources().getDrawable(a$e.picker_divider));
        setDescendantFocusability(393216);
    }

    public void setOptionsArray(String[] strArr) {
        if (strArr != null) {
            this.gNb = strArr;
            setDisplayedValues(null);
            setMinValue(0);
            setMaxValue(Math.max(strArr.length - 1, 0));
            setWrapSelectorWheel(false);
            if (strArr.length <= 0) {
                strArr = null;
            }
            super.setDisplayedValues(strArr);
        }
    }

    public final String aqr() {
        return (this.gNb == null || this.gNb.length <= 0) ? "" : this.gNb[getValue()];
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
    }
}
