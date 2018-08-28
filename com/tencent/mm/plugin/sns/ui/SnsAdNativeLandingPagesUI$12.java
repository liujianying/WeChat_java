package com.tencent.mm.plugin.sns.ui;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a;

class SnsAdNativeLandingPagesUI$12 implements a {
    final /* synthetic */ SnsAdNativeLandingPagesUI nSR;

    SnsAdNativeLandingPagesUI$12(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.nSR = snsAdNativeLandingPagesUI;
    }

    public final void p(b bVar) {
        RecyclerView bAt = bVar.bAt();
        if (bAt != null) {
            bAt.getViewTreeObserver().addOnPreDrawListener(new 1(this, bAt));
        }
    }
}
