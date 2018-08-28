package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class r$6 implements OnClickListener {
    final /* synthetic */ r nFh;

    r$6(r rVar) {
        this.nFh = rVar;
    }

    public final void onClick(View view) {
        r rVar = this.nFh;
        rVar.nFb++;
        if (this.nFh.nEO) {
            this.nFh.bzD();
            this.nFh.bzC();
        } else {
            this.nFh.bzy();
        }
        this.nFh.nEL = true;
    }
}
