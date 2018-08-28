package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;

class YADatePicker$c$1 implements OnValueChangeListener {
    final /* synthetic */ c uLX;

    YADatePicker$c$1(c cVar) {
        this.uLX = cVar;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        c.a(this.uLX);
        this.uLX.gMR.setTimeInMillis(this.uLX.uLV.getTimeInMillis());
        if (numberPicker == this.uLX.uLJ) {
            int actualMaximum = this.uLX.gMR.getActualMaximum(5);
            if (i == actualMaximum && i2 == 1) {
                this.uLX.gMR.add(5, 1);
            } else if (i == 1 && i2 == actualMaximum) {
                this.uLX.gMR.add(5, -1);
            } else {
                this.uLX.gMR.add(5, i2 - i);
            }
        } else if (numberPicker == this.uLX.uLK) {
            if (i == 11 && i2 == 0) {
                this.uLX.gMR.add(2, 1);
            } else if (i == 0 && i2 == 11) {
                this.uLX.gMR.add(2, -1);
            } else {
                this.uLX.gMR.add(2, i2 - i);
            }
        } else if (numberPicker == this.uLX.uLL) {
            this.uLX.gMR.set(1, i2);
        } else {
            throw new IllegalArgumentException();
        }
        this.uLX.ar(this.uLX.gMR.get(1), this.uLX.gMR.get(2), this.uLX.gMR.get(5));
        this.uLX.cAW();
        this.uLX.cAX();
        c.b(this.uLX);
    }
}
