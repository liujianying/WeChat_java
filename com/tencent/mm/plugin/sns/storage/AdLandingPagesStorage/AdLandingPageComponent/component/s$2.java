package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.model.app.g;

class s$2 implements Runnable {
    final /* synthetic */ Context ePr;
    final /* synthetic */ String fhQ;
    final /* synthetic */ s nFk;
    final /* synthetic */ Intent val$intent;

    s$2(s sVar, Context context, Intent intent, String str) {
        this.nFk = sVar;
        this.ePr = context;
        this.val$intent = intent;
        this.fhQ = str;
    }

    public final void run() {
        g.a(this.ePr, this.val$intent, this.fhQ);
    }
}
