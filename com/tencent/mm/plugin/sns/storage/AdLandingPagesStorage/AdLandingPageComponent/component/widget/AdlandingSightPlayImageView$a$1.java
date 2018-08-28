package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView.a;

class AdlandingSightPlayImageView$a$1 implements Runnable {
    final /* synthetic */ AdlandingSightPlayImageView nGK;
    final /* synthetic */ a nGL;
    final /* synthetic */ LayoutParams ndI;

    AdlandingSightPlayImageView$a$1(a aVar, AdlandingSightPlayImageView adlandingSightPlayImageView, LayoutParams layoutParams) {
        this.nGL = aVar;
        this.nGK = adlandingSightPlayImageView;
        this.ndI = layoutParams;
    }

    public final void run() {
        this.nGK.setLayoutParams(this.ndI);
    }
}
