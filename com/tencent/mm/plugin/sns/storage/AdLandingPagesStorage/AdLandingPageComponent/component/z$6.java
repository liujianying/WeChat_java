package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class z$6 implements OnClickListener {
    final /* synthetic */ z nFO;

    z$6(z zVar) {
        this.nFO = zVar;
    }

    public final void onClick(View view) {
        z zVar = this.nFO;
        zVar.nFb++;
        if (this.nFO.nEO) {
            this.nFO.bzD();
            this.nFO.bzC();
            this.nFO.nFK = true;
        } else {
            this.nFO.bzy();
        }
        this.nFO.nEL = true;
    }
}
