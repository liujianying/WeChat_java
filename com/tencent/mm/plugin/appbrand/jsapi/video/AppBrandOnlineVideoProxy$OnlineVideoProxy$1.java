package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy.OnlineVideoProxy;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandOnlineVideoProxy$OnlineVideoProxy$1 implements c {
    final /* synthetic */ OnlineVideoProxy gai;

    AppBrandOnlineVideoProxy$OnlineVideoProxy$1(OnlineVideoProxy onlineVideoProxy) {
        this.gai = onlineVideoProxy;
    }

    public final void bB(int i, int i2) {
        this.gai.gae = i;
        this.gai.gaf = i2;
        this.gai.gac = 10;
        OnlineVideoProxy.a(this.gai);
    }

    public final void bC(int i, int i2) {
        this.gai.gae = i;
        this.gai.gaf = i2;
        this.gai.gac = 11;
        OnlineVideoProxy.b(this.gai);
    }

    public final void bD(int i, int i2) {
        this.gai.gae = i;
        this.gai.gaf = i2;
        this.gai.gac = 12;
        OnlineVideoProxy.c(this.gai);
    }

    public final void L(String str, int i) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "on finish [%s %d]", new Object[]{str, Integer.valueOf(i)});
        this.gai.gae = i;
        this.gai.gac = 13;
        e.abl().rr(this.gai.elz);
        OnlineVideoProxy.d(this.gai);
    }
}
