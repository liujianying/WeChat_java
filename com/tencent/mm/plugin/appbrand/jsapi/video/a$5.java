package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.y;

class a$5 implements a {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ y fRL;
    final /* synthetic */ a gbn;

    a$5(a aVar, p pVar, int i, y yVar) {
        this.gbn = aVar;
        this.fJO = pVar;
        this.fKG = i;
        this.fRL = yVar;
    }

    public final void kM(int i) {
        this.fJO.agU().a(this.fKG, this.fRL, i);
    }

    public final void ajc() {
        this.fJO.agU().lA(this.fKG);
    }

    public final boolean isFullScreen() {
        return this.fJO.agU().lz(this.fKG);
    }
}
