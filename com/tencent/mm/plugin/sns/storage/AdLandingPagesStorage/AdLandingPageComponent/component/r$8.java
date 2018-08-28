package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class r$8 implements OnClickListener {
    final /* synthetic */ r nFh;

    r$8(r rVar) {
        this.nFh = rVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        if (this.nFh.nEF.getVideoDurationSec() > 0) {
            if (this.nFh.nEG.getVisibility() == 0) {
                z = false;
            }
            this.nFh.nEN = z;
            this.nFh.ik(z);
        }
    }
}
