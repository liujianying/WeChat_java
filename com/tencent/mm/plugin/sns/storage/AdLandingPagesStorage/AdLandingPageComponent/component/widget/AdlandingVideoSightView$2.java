package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.f;
import com.tencent.mm.sdk.platformtools.x;

class AdlandingVideoSightView$2 implements f {
    final /* synthetic */ AdlandingVideoSightView nGO;

    AdlandingVideoSightView$2(AdlandingVideoSightView adlandingVideoSightView) {
        this.nGO = adlandingVideoSightView;
    }

    public final void eY(long j) {
        if (this.nGO.duration == 0) {
            this.nGO.duration = this.nGO.getDuration();
        }
        if (this.nGO.ndD != null) {
            x.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[]{Long.valueOf(j), Integer.valueOf(this.nGO.duration)});
            this.nGO.ndD.ck((int) j, this.nGO.duration);
        }
    }
}
