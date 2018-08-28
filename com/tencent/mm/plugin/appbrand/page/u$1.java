package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.u.b;

class u$1 extends x {
    final /* synthetic */ u goS;

    u$1(u uVar) {
        this.goS = uVar;
    }

    public final void ajd() {
        u uVar = this.goS;
        b lv = uVar.lv(uVar.goR);
        float[] fArr = uVar.goO;
        if (!(lv == null || lv.gpb == null || fArr == null)) {
            View view = (View) lv.gpb.get();
            if (view != null) {
                if (uVar.goR != uVar.goN) {
                    b lv2 = uVar.lv(uVar.goN);
                    if (!(lv2 == null || lv2.gpb == null)) {
                        View view2 = (View) lv2.gpb.get();
                        if (view2 != null) {
                            uVar.b(uVar.goN, fArr, view2.getVisibility(), Boolean.valueOf(lv.gpd));
                        }
                    }
                }
                int i = uVar.goR;
                uVar.goN = -1;
                uVar.goR = -1;
                uVar.b(i, fArr, view.getVisibility(), Boolean.valueOf(lv.gpd));
            }
        }
        if (this.goS.goQ != null) {
            this.goS.goQ.ajd();
            this.goS.goQ = null;
        }
    }
}
