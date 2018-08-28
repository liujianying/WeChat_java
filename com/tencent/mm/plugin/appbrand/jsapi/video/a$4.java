package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p$d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements e {
    final /* synthetic */ p fJO;
    final /* synthetic */ f fRJ;
    final /* synthetic */ p$d fRK;
    final /* synthetic */ AppBrandVideoView gbm;
    final /* synthetic */ a gbn;

    a$4(a aVar, AppBrandVideoView appBrandVideoView, p pVar, f fVar, p$d p_d) {
        this.gbn = aVar;
        this.gbm = appBrandVideoView;
        this.fJO = pVar;
        this.fRJ = fVar;
        this.fRK = p_d;
    }

    public final void onDestroy() {
        AppBrandVideoView appBrandVideoView = this.gbm;
        x.i("MicroMsg.AppBrandVideoView", "onUIDestroy");
        appBrandVideoView.clean();
        this.fJO.b(this.fRJ);
        this.fJO.b(this.fRK);
        this.fJO.b(this);
    }
}
