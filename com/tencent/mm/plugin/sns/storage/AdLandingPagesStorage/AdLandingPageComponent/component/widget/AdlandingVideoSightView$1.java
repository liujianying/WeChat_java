package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.e;

class AdlandingVideoSightView$1 implements e {
    final /* synthetic */ AdlandingVideoSightView nGO;

    AdlandingVideoSightView$1(AdlandingVideoSightView adlandingVideoSightView) {
        this.nGO = adlandingVideoSightView;
    }

    public final void wS(int i) {
        if (-1 == i) {
            if (this.nGO.ndD != null) {
                this.nGO.ndD.onError(0, 0);
            }
        } else if (i == 0 && this.nGO.ndD != null) {
            this.nGO.ndD.wd();
        }
    }
}
