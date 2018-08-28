package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class z$9 implements OnClickListener {
    final /* synthetic */ z nFO;

    z$9(z zVar) {
        this.nFO = zVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        if (this.nFO.djm) {
            this.nFO.nFH = true;
            if (this.nFO.nEG.getVisibility() == 0) {
                this.nFO.nEG.setVisibility(4);
                this.nFO.nEH.setVisibility(8);
                this.nFO.gFD.setVisibility(4);
            } else {
                this.nFO.nEG.setVisibility(0);
                this.nFO.nEH.setVisibility(0);
                this.nFO.gFD.setVisibility(0);
            }
            if (this.nFO.nFc != null) {
                ac acVar = this.nFO.nFc;
                if (this.nFO.nEG.getVisibility() != 0) {
                    z = false;
                }
                acVar.il(z);
            }
        }
    }
}
