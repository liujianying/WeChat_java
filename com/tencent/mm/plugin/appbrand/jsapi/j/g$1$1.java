package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.jsapi.j.g.1;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.sdk.platformtools.bi;

class g$1$1 implements Runnable {
    final /* synthetic */ int fXn;
    final /* synthetic */ a fXo;
    final /* synthetic */ 1 fXp;

    g$1$1(1 1, int i, a aVar) {
        this.fXp = 1;
        this.fXn = i;
        this.fXo = aVar;
    }

    public final void run() {
        AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) 1.a(this.fXp, AppBrandMultiOptionsPicker.class);
        if (appBrandMultiOptionsPicker == null) {
            this.fXp.h("fail picker not exists", null);
            return;
        }
        int i = this.fXn;
        a aVar = this.fXo;
        if (i >= 0 && i < appBrandMultiOptionsPicker.getPickersCount() && aVar != null) {
            appBrandMultiOptionsPicker.setLayoutFrozen(true);
            appBrandMultiOptionsPicker.ml(i).setOptionsArray(aVar.gMZ);
            if (!bi.G(aVar.gMZ)) {
                appBrandMultiOptionsPicker.ml(i).setValue(aVar.gNa);
            }
            appBrandMultiOptionsPicker.setLayoutFrozen(false);
        }
        this.fXp.h("ok", null);
    }
}
