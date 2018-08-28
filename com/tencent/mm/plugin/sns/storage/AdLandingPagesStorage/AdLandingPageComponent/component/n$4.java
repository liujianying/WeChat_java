package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.pluginsdk.model.app.g;

class n$4 implements Runnable {
    final /* synthetic */ n nDS;

    n$4(n nVar) {
        this.nDS = nVar;
    }

    public final void run() {
        g.a(this.nDS.context, this.nDS.context.getPackageManager().getLaunchIntentForPackage(n.b(this.nDS).rU), g.q(this.nDS.context, n.b(this.nDS).bPS), new 1(this));
    }
}
