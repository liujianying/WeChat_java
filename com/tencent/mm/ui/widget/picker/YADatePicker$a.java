package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import com.tencent.mm.ui.widget.picker.YADatePicker.b;
import com.tencent.mm.ui.widget.picker.YADatePicker.e;
import java.util.Locale;

abstract class YADatePicker$a implements b {
    protected Context mContext;
    protected YADatePicker uLF;
    protected Locale uLG;
    protected YADatePicker$d uLH;
    protected e uLI;

    protected YADatePicker$a(YADatePicker yADatePicker, Context context) {
        this.uLF = yADatePicker;
        this.mContext = context;
        e(Locale.getDefault());
    }

    protected void e(Locale locale) {
        if (!locale.equals(this.uLG)) {
            this.uLG = locale;
        }
    }

    public void setValidationCallback(e eVar) {
        this.uLI = eVar;
    }
}
