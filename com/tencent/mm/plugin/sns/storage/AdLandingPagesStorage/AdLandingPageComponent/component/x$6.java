package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class x$6 implements b {
    final /* synthetic */ x nFL;

    x$6(x xVar) {
        this.nFL = xVar;
    }

    public final void ajO() {
        if (x.a(this.nFL) != null) {
            x.a(this.nFL).bCm();
        }
    }

    public final void kV(int i) {
        x.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeek time " + i);
        if (this.nFL.nEO) {
            this.nFL.bzy();
        } else {
            this.nFL.bzC();
        }
        x.a(this.nFL).S(i, this.nFL.nEG.bPb);
    }
}
