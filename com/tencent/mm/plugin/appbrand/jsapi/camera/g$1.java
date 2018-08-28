package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.page.p;

class g$1 extends b {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ AppBrandCameraView fOG;
    final /* synthetic */ g fOH;

    g$1(g gVar, p pVar, AppBrandCameraView appBrandCameraView, int i) {
        this.fOH = gVar;
        this.fJO = pVar;
        this.fOG = appBrandCameraView;
        this.fKG = i;
    }

    public final void onDestroy() {
        this.fJO.b(this.fOG);
        this.fJO.b(this.fOG);
        this.fJO.b(this.fOG);
        a$a.fNY.h(Integer.valueOf(this.fKG));
        e.b(this.fJO.mAppId, this);
    }
}
