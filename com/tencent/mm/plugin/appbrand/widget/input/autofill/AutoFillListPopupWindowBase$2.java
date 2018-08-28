package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.a;

class AutoFillListPopupWindowBase$2 implements OnItemSelectedListener {
    final /* synthetic */ AutoFillListPopupWindowBase gKu;

    AutoFillListPopupWindowBase$2(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.gKu = autoFillListPopupWindowBase;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != -1) {
            a a = AutoFillListPopupWindowBase.a(this.gKu);
            if (a != null) {
                a.a(a, false);
            }
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
