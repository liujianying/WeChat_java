package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class x$8 implements OnClickListener {
    final /* synthetic */ x nFL;

    x$8(x xVar) {
        this.nFL = xVar;
    }

    public final void onClick(View view) {
        x xVar = this.nFL;
        xVar.nFb++;
        if (this.nFL.nEO) {
            this.nFL.bzD();
            this.nFL.bzC();
            x.d(this.nFL);
        } else {
            this.nFL.bzy();
        }
        x.g(this.nFL);
    }
}
