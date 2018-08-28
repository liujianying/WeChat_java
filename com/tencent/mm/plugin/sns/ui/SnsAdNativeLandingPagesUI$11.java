package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesUI$11 implements a {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;
    final /* synthetic */ View nSV;

    SnsAdNativeLandingPagesUI$11(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, View view) {
        this.nSR = snsAdNativeLandingPagesUI;
        this.nSV = view;
    }

    public final void bzX() {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
        bCT();
    }

    public final void bzY() {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
        bCT();
    }

    private void bCT() {
        if (!(this.nSV == null || this.nSV.getParent() == null)) {
            ((ViewGroup) this.nSV.getParent()).removeView(this.nSV);
        }
        SnsAdNativeLandingPagesUI.Z(this.nSR);
    }
}
