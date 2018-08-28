package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.widget.NumberPicker;
import com.tencent.mm.plugin.appbrand.jsapi.j.a.2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;

class a$1 implements Runnable {
    final /* synthetic */ a fXa;

    a$1(a aVar) {
        this.fXa = aVar;
    }

    public final void run() {
        boolean z = true;
        int i = 0;
        a aVar = this.fXa;
        AppBrandDatePicker appBrandDatePicker = (AppBrandDatePicker) aVar.C(AppBrandDatePicker.class);
        if (appBrandDatePicker == null) {
            aVar.h("fail cant init view", null);
            return;
        }
        a aVar2 = aVar.gMI;
        aVar2.setOnResultListener(new 2(aVar));
        if (aVar.fWV != null) {
            appBrandDatePicker.setMinDate(aVar.fWV.longValue());
        }
        if (aVar.fWW != null) {
            appBrandDatePicker.setMaxDate(aVar.fWW.longValue());
        }
        appBrandDatePicker.a(aVar.fWX, aVar.fWY, aVar.fWZ, null);
        boolean z2 = aVar.fWU.ordinal() >= a$a.YEAR.ordinal();
        boolean z3 = aVar.fWU.ordinal() >= a$a.MONTH.ordinal();
        if (aVar.fWU.ordinal() < a$a.DAY.ordinal()) {
            z = false;
        }
        appBrandDatePicker.gMJ = z2;
        appBrandDatePicker.gMK = z3;
        appBrandDatePicker.gML = z;
        if (appBrandDatePicker.gMM != null) {
            appBrandDatePicker.gMM.setEnabled(z2);
            appBrandDatePicker.gMM.setVisibility(z2 ? 0 : 8);
        }
        if (appBrandDatePicker.gMN != null) {
            appBrandDatePicker.gMN.setEnabled(z3);
            appBrandDatePicker.gMN.setVisibility(z3 ? 0 : 8);
        }
        if (appBrandDatePicker.gMO != null) {
            appBrandDatePicker.gMO.setEnabled(z);
            NumberPicker numberPicker = appBrandDatePicker.gMO;
            if (!z) {
                i = 8;
            }
            numberPicker.setVisibility(i);
        }
        aVar2.show();
    }
}
