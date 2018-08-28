package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.ga;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$26 extends c<ga> {
    final /* synthetic */ e ffn;

    e$26(e eVar) {
        this.ffn = eVar;
        super(0);
        this.sFo = ga.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ga gaVar = (ga) bVar;
        x.i("MicroMsg.SubCoreAppBrand", "FetchAppBrandInfoForMusicEvent callback");
        gaVar.bPf.appId = a.ala().ghU;
        gaVar.bPf.bPg = a.ala().bPg;
        gaVar.bPf.bKC = a.ala().bKC;
        gaVar.bPf.bPh = a.ala().bPh;
        return true;
    }
}
