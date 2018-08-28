package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import java.util.HashMap;
import java.util.Map;

class d$1 implements m {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ d fPM;

    d$1(d dVar, p pVar, int i) {
        this.fPM = dVar;
        this.fJO = pVar;
        this.fKG = i;
    }

    public final void h(View view, int i, int i2) {
        if (view instanceof WxaScrollView) {
            u$b E = this.fJO.agU().E(this.fKG, false);
            if (E != null) {
                String string = E.getString("data", null);
                if (string != null) {
                    View targetView = ((WxaScrollView) view).getTargetView();
                    Map hashMap = new HashMap();
                    hashMap.put("data", string);
                    hashMap.put("scrollLeft", Integer.valueOf(f.lO(i)));
                    hashMap.put("scrollTop", Integer.valueOf(f.lO(i2)));
                    hashMap.put("scrollWidth", Integer.valueOf(f.lO(targetView.getWidth())));
                    hashMap.put("scrollHeight", Integer.valueOf(f.lO(targetView.getHeight())));
                    new l().a(this.fJO).x(hashMap).ahM();
                }
            }
        }
    }
}
