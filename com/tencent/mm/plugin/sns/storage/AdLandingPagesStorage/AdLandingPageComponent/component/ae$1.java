package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.a;
import com.tencent.mm.sdk.platformtools.ag;

class ae$1 implements a {
    final /* synthetic */ ag hlG;
    final /* synthetic */ a nGn;
    final /* synthetic */ ae nGo;

    ae$1(ae aeVar, ag agVar, a aVar) {
        this.nGo = aeVar;
        this.hlG = agVar;
        this.nGn = aVar;
    }

    public final void cg(String str, int i) {
        this.hlG.post(new 1(this, str, i));
    }

    public final void MY(String str) {
        this.hlG.post(new 2(this, str));
    }

    public final void MZ(String str) {
        this.hlG.post(new 3(this, str));
    }
}
