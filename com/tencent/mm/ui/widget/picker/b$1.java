package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class b$1 implements OnValueChangeListener {
    final /* synthetic */ b uLm;

    b$1(b bVar) {
        this.uLm = bVar;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        b.a(this.uLm).setOptionsArray(b.a(this.uLm, i2));
    }
}
