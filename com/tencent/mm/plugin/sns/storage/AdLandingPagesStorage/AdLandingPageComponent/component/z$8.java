package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView$a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ah;

class z$8 implements OfflineVideoView$a {
    final /* synthetic */ z nFO;

    z$8(z zVar) {
        this.nFO = zVar;
    }

    public final boolean a(PString pString) {
        String str = "adId";
        String str2 = z.a(this.nFO).nAP;
        String eI = d.eI(str, str2);
        if (FileOp.cn(eI)) {
            pString.value = eI;
            this.nFO.nFI = true;
            return true;
        }
        d.a(str, str2, false, 62, new 1(this));
        return false;
    }

    public final void wd() {
        boolean z = false;
        z zVar = this.nFO;
        zVar.nEZ++;
        this.nFO.nEG.setVisibility(0);
        this.nFO.nEH.setVisibility(0);
        this.nFO.gFD.setVisibility(0);
        if (this.nFO.nFc != null) {
            ac acVar = this.nFO.nFc;
            if (this.nFO.nEG.getVisibility() == 0) {
                z = true;
            }
            acVar.il(z);
        }
        this.nFO.dvh.post(new 2(this));
        if (this.nFO.lxh != 0) {
            this.nFO.nEX = (int) (((long) this.nFO.nEX) + (System.currentTimeMillis() - this.nFO.lxh));
            this.nFO.lxh = 0;
        }
        this.nFO.nEW = 5;
    }

    public final void onStart(int i) {
        boolean z = false;
        this.nFO.djm = true;
        this.nFO.nFC = i;
        if (this.nFO.nEG.getVideoTotalTime() != i) {
            this.nFO.nEG.setVideoTotalTime(this.nFO.nFC);
        }
        this.nFO.nEG.setVisibility(0);
        this.nFO.nEH.setVisibility(0);
        if (this.nFO.nFc != null) {
            ac acVar = this.nFO.nFc;
            if (this.nFO.nEG.getVisibility() == 0) {
                z = true;
            }
            acVar.il(z);
        }
        z zVar = this.nFO;
        if (zVar.nFA != null && zVar.nEG != null && Math.abs(zVar.nFA.getCurrentPosition() - zVar.nEG.getmPosition()) > 1) {
            zVar.nFA.R(zVar.nEG.getmPosition(), true);
        }
    }

    public final void wQ(int i) {
        ah.A(new 3(this, i));
    }
}
