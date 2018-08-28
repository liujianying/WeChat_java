package com.tencent.mm.plugin.appbrand.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class AppBrandDatePicker$1 implements OnValueChangeListener {
    final /* synthetic */ AppBrandDatePicker gMT;

    AppBrandDatePicker$1(AppBrandDatePicker appBrandDatePicker) {
        this.gMT = appBrandDatePicker;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        AppBrandDatePicker.a(this.gMT);
    }
}
