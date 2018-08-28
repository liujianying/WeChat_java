package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class CustomDatePicker$1 implements OnValueChangeListener {
    final /* synthetic */ CustomDatePicker uLb;

    CustomDatePicker$1(CustomDatePicker customDatePicker) {
        this.uLb = customDatePicker;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        CustomDatePicker.a(this.uLb);
    }
}
