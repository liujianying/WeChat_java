package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.k;
import com.tencent.mm.sdk.platformtools.x;

class a$k$3 implements Runnable {
    final /* synthetic */ View eHJ;
    final /* synthetic */ k nGI;

    a$k$3(k kVar, View view) {
        this.nGI = kVar;
        this.eHJ = view;
    }

    public final void run() {
        x.v("MicroMsg.SightPlayController", "set background drawable null");
        this.eHJ.setBackgroundDrawable(null);
    }
}
