package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;

class x$11 implements OnClickListener {
    final /* synthetic */ x nFL;

    x$11(x xVar) {
        this.nFL = xVar;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (x.r(this.nFL)) {
            x xVar = this.nFL;
            xVar.nFF++;
            if (!x.s(this.nFL)) {
                x.t(this.nFL);
                if (this.nFL.nEG.getVisibility() == 0) {
                    this.nFL.nEG.setVisibility(4);
                    this.nFL.nEH.setVisibility(8);
                    x.j(this.nFL).setVisibility(4);
                } else {
                    this.nFL.nEG.setVisibility(4);
                    this.nFL.nEH.setVisibility(0);
                    x.j(this.nFL).setVisibility(0);
                }
                if (this.nFL.nFc != null) {
                    ac acVar = this.nFL.nFc;
                    if (this.nFL.nEG.getVisibility() == 0) {
                        z = true;
                    }
                    acVar.il(z);
                }
            }
        }
    }
}
