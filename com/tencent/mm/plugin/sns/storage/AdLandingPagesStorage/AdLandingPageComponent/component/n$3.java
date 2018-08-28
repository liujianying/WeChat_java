package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import com.tencent.mm.pluginsdk.model.app.g;

class n$3 implements Runnable {
    final /* synthetic */ n nDS;
    final /* synthetic */ Intent val$intent;

    n$3(n nVar, Intent intent) {
        this.nDS = nVar;
        this.val$intent = intent;
    }

    public final void run() {
        g.a(this.nDS.context, this.val$intent, g.q(this.nDS.context, n.b(this.nDS).bPS), new 1(this));
    }
}
