package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.y;

class b$5 implements a {
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ b fRI;
    final /* synthetic */ y fRL;

    b$5(b bVar, p pVar, int i, y yVar) {
        this.fRI = bVar;
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
