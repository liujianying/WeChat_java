package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.jsapi.j.h.3;
import com.tencent.mm.plugin.appbrand.jsapi.j.h.4;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;

class h$2 implements Runnable {
    final /* synthetic */ h fXq;
    final /* synthetic */ String[] fXr;
    final /* synthetic */ int fXs;

    h$2(h hVar, String[] strArr, int i) {
        this.fXq = hVar;
        this.fXr = strArr;
        this.fXs = i;
    }

    public final void run() {
        h hVar = this.fXq;
        String[] strArr = this.fXr;
        int i = this.fXs;
        AppBrandOptionsPicker appBrandOptionsPicker = (AppBrandOptionsPicker) hVar.C(AppBrandOptionsPicker.class);
        if (appBrandOptionsPicker == null) {
            hVar.h("fail cant init view", null);
            return;
        }
        a aVar = hVar.gMI;
        aVar.post(new 3(hVar, aVar));
        appBrandOptionsPicker.setOptionsArray(strArr);
        appBrandOptionsPicker.setValue(i);
        aVar.setOnResultListener(new 4(hVar, aVar, appBrandOptionsPicker));
        aVar.show();
    }
}
