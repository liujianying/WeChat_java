package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bp.a;

public class c extends YANumberPicker implements e<String> {
    private String[] gNb;
    private int gNd;

    public final /* synthetic */ Object aqq() {
        return (this.gNb == null || this.gNb.length <= 0) ? "" : this.gNb[getValue()];
    }

    public c(Context context) {
        super(context);
        setDividerHeight(a.fromDPToPix(context, 2));
        setDividerColor(Color.parseColor("#1AAD19"));
        setItemPaddingVertical(a.fromDPToPix(context, 8));
        setNormalTextColor(Color.parseColor("#A5A5A5"));
        setSelectedTextColor(-16777216);
    }

    public final void setOptionsArray(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            setEnabled(false);
            setVisibility(4);
            return;
        }
        setEnabled(true);
        setVisibility(0);
        this.gNb = strArr;
        int minValue = getMinValue();
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > (getMaxValue() - minValue) + 1) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    public final void setForceWidth(int i) {
        this.gNd = i;
    }

    protected final void onMeasure(int i, int i2) {
        if (this.gNd > 0) {
            i = MeasureSpec.makeMeasureSpec(this.gNd, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aqo() {
        aqA();
    }

    public final void b(d dVar) {
    }

    public final void aqp() {
    }
}
