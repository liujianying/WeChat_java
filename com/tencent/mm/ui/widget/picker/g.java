package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import java.util.Locale;

final class g implements Formatter {
    final StringBuilder mBuilder = new StringBuilder();
    final Object[] uLB = new Object[1];
    char uLC;
    java.util.Formatter uLD;

    g() {
        d(Locale.getDefault());
    }

    private void d(Locale locale) {
        this.uLD = new java.util.Formatter(this.mBuilder, locale);
        this.uLC = '0';
    }

    public final String format(int i) {
        Locale locale = Locale.getDefault();
        if (this.uLC != '0') {
            d(locale);
        }
        this.uLB[0] = Integer.valueOf(i);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.uLD.format("%02d", this.uLB);
        return this.uLD.toString();
    }
}
