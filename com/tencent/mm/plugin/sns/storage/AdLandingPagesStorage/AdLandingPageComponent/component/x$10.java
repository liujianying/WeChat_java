package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ah;

class x$10 implements a {
    final /* synthetic */ x nFL;

    x$10(x xVar) {
        this.nFL = xVar;
    }

    public final boolean a(PString pString) {
        String str = "adId";
        String str2 = x.l(this.nFL).nAN;
        String eI = d.eI(str, str2);
        if (FileOp.cn(eI)) {
            pString.value = eI;
            x.m(this.nFL);
            return true;
        }
        d.c(str, str2, false, 62, new 1(this));
        return false;
    }

    public final void wd() {
        x.n(this.nFL);
        x.o(this.nFL);
    }

    public final void onStart(int i) {
        boolean z = false;
        x.p(this.nFL);
        x.b(this.nFL, i);
        if (this.nFL.nEG.getVideoTotalTime() != i) {
            this.nFL.nEG.setVideoTotalTime(x.q(this.nFL));
        }
        this.nFL.nEG.setVisibility(4);
        this.nFL.nEH.setVisibility(0);
        if (this.nFL.nFc != null) {
            ac acVar = this.nFL.nFc;
            if (this.nFL.nEG.getVisibility() == 0) {
                z = true;
            }
            acVar.il(z);
        }
        this.nFL.bAk();
    }

    public final void wQ(int i) {
        ah.A(new 2(this, i));
    }
}
